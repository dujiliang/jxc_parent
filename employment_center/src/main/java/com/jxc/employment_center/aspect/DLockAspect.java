package com.jxc.employment_center.aspect;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.jxc.common.annotation.DLock;
import com.jxc.common.exception.RRException;
import com.jxc.common.util.RedisUtil;
import com.jxc.employment_center.utils.CommonRedisHelper;

/**
 * Description: 分布式锁
 * <p>
 *     先获取锁, 获取不到则继续等待(指定时间), 失败次数(指定)次后跳出, 消费降级(抛出,系统繁忙稍后再试)
 *     如果没有重试次数,方法返回null 记得捕获NP
 *     当重试次数有, 但是重试间隔时间没写, 默认200ms 间隔
 * </p>
 */
@Aspect
@Component
public class DLockAspect {
 
    private static final String LOCK_NAME = "lockName";
    private static final String RETRY_TIMES = "retryTimes";
    private static final String RETRY_WAIT = "retryWait";
 
 
    @Autowired
    private CommonRedisHelper redisHelper;
    
    @Autowired
    private RedisUtil redisUtil;
   
    
 
    @Pointcut("@annotation(com.jxc.common.annotation.DLock)")
    public void dLockAspect() {
    }
 
    @Around("dLockAspect()")
    public Object lockAroundAction(ProceedingJoinPoint proceeding) throws Throwable {
        //获取注解中的参数
        Map<String, Object> annotationArgs = this.getAnnotationArgs(proceeding);
        String lockName = (String) annotationArgs.get(LOCK_NAME);
        Assert.notNull(lockName, "分布式,锁名不能为空");
        int retryTimes = (int) annotationArgs.get(RETRY_TIMES);
        long retryWait = (long) annotationArgs.get(RETRY_WAIT);
 
        // 获取锁
        boolean lock = redisHelper.lock(lockName);
        if (lock) {
            // 执行主逻辑
            return execut(proceeding, lockName);
        } else {
            // 如果重试次数为零, 则不重试
            if (retryTimes <= 0) {
            	throw new RRException("已经被锁，不重试",8888);
//                throw new RuntimeException(String.format("{%s}已经被锁, 不重试", lockName));
            }
 
            if (retryWait == 0) {
                retryWait = 200;
            }
            // 设置失败次数计数器, 当到达指定次数时, 返回失败
            int failCount = 1;
            while (failCount <= retryTimes) {
                // 等待指定时间ms
                try {
                    Thread.sleep(retryWait);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (redisHelper.lock(lockName)) {
                    // 执行主逻辑
                    return execut(proceeding, lockName);
                } else {
                    
                    failCount++;
                }
            }
            throw new RRException("系统繁忙, 请稍等再试",9999);
        }
 
    }
 
    private Object execut(ProceedingJoinPoint proceeding, String lockName) throws Throwable {
        try {
            // 执行主逻辑
            Object proceed = proceeding.proceed();
            return proceed;
        } catch (Throwable throwable) {
            throw throwable;
        } finally {
        	redisUtil.expire(lockName, 0);
        	
        }
    }
 
    /**
     * 获取锁参数
     *
     * @param proceeding
     * @return
     */
    @SuppressWarnings("rawtypes")
	private Map<String, Object> getAnnotationArgs(ProceedingJoinPoint proceeding) {
        Class target = proceeding.getTarget().getClass();
        Method[] methods = target.getMethods();
        String methodName = proceeding.getSignature().getName();
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Map<String, Object> result = new HashMap<String, Object>();
                DLock redisLock = method.getAnnotation(DLock.class);
                String firstArg = getFirstArg(proceeding);
                result.put(LOCK_NAME, redisLock.lockName().concat("_").concat(firstArg));
                result.put(RETRY_TIMES, redisLock.retryTimes());
                result.put(RETRY_WAIT, redisLock.retryWait());
                return result;
            }
        }
        return null;
    }
 
    /**
     * 获取第一个String类型的参数为锁的业务参数
     *
     * @param proceeding
     * @return
     */
    public String getFirstArg(ProceedingJoinPoint proceeding) {
        Object[] args = proceeding.getArgs();
        if (args != null && args.length > 0) {
            for (Object object : args) {
                String type = object.getClass().getName();
                if ("java.lang.String".equals(type)) {
                    return (String) object;
                }
            }
        }
        return null;
    }
 

}