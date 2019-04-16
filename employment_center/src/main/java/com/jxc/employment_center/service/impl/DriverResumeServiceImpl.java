package com.jxc.employment_center.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jxc.common.annotation.DLock;
import com.jxc.common.bean.AuthorizationUser;
import com.jxc.common.bean.R;
import com.jxc.common.constants.CommonErrCodeConstants;
import com.jxc.common.constants.RedisConstantsForEmploy;
import com.jxc.common.util.RedisUtil;
import com.jxc.employment_center.dao.ShortJobDao;
import com.jxc.employment_center.dao.ShortJobUserDao;
import com.jxc.employment_center.entity.DriverResume;
import com.jxc.employment_center.entity.ShortJob;
import com.jxc.employment_center.service.DriverResumeService;

/**
 * 发布长期司机招聘
 * 
 * @author Administrator
 *
 */
@Service("driverResumeService")
public class DriverResumeServiceImpl implements DriverResumeService {

	@Autowired
	private RedisUtil redisUtil;
	
	@Autowired
	private ShortJobUserDao shortJobUserDao;
	
	@Autowired
	private ShortJobDao shortJobDao;
	
	@Override
	public R addResume(AuthorizationUser user, DriverResume resume) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public R getDriverResumeListForDriver(AuthorizationUser user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public R resumeInfo(int resumeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public R updateResume(AuthorizationUser user, DriverResume resume) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public R deleteResume(AuthorizationUser user, DriverResume resume) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Transactional(rollbackFor = Exception.class)
	@Override
	@DLock(lockName = RedisConstantsForEmploy.REDIS_TOKEN_JOB_LOCK_PREFIX , 
			retryTimes = RedisConstantsForEmploy.REDIS_TOKEN_JOB_LOCK_RETRY_TIMES,
			retryWait = RedisConstantsForEmploy.REDIS_TOKEN_JOB_LOCK_RETRY_WAIT)
	public R sendShortJob(AuthorizationUser user, String shortJobId) throws Exception {
		
		String reidsKey = RedisConstantsForEmploy.REDIS_TOKEN_JOB_COUNT_PREFIX + shortJobId;
		if(!redisUtil.hasKey(reidsKey)){
			return R.error(CommonErrCodeConstants.NO_RES_FIND, "岗位下架");
		}
		
		int count = Integer.valueOf(redisUtil.get(reidsKey));
		
		if(count <= 0){
			redisUtil.expire(reidsKey,0);
			return R.error(CommonErrCodeConstants.NO_RES_FIND, "岗位下架");
		}
		
		Map<String,Object> condition = new HashMap<String,Object>();
		condition.put("userId", user.getUserId());
		condition.put("shortJobId", shortJobId);
		
		List<ShortJob> shortJobList = shortJobDao.getShortJobListForOwner(condition);
		
		if(shortJobList == null || shortJobList.size() == 0 ){
			return R.error(CommonErrCodeConstants.NO_RES_FIND, "未找到岗位");
		}
		
		if(shortJobList.size() > 1){
			return R.error(CommonErrCodeConstants.MANY_RES_FIND, "多个岗位找到");
		}
		
		ShortJob shortJob = shortJobList.get(0);
		
		long effectiveDateLong = shortJob.getEffectiveDate().getTime();
		
		long current = System.currentTimeMillis();
		if(current - effectiveDateLong > 0){
			return R.error(999, "岗位发布结束");
		}
		if(shortJob.getStatus() != 0){
			return R.error(999, "岗位发布结束");
		}
		
		List<Map<String,Object>> list = shortJobUserDao.queryListByCondition();
		
		if(list != null && list.size() != 0){
			return R.error(9999, "该用户已经抢到该职位");
		}
		
		System.out.println("insert user");
		shortJobUserDao.insertShortJobUser(condition);
	   
		redisUtil.set(reidsKey,(count-1)+"");
		
		long availTime = (effectiveDateLong - current <= 0) ? 0 : (effectiveDateLong - current);
		
		redisUtil.expire(reidsKey, (int)(availTime/1000));
		
		if(count - 1 <= 0){
			redisUtil.expire(reidsKey,0);
			ShortJob job = new ShortJob();
			job.setJobId(shortJobId);
 			job.setStatus(1);
			shortJobDao.closeJob(job);
		}
		
		//看shortJob的redis count是否存在
		//存在则在可抢时间内---
			//看有没有资源锁
				//有，就等待
				//没有就创建
					//插入   driver和job的关联
					//count -1
		//没有则返回资源完了
		
		return R.ok();
	}

	
	

	
}
