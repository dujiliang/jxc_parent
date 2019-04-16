package com.jxc.common.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface DLock {
 
    String lockName() default ""; // 锁名
    int retryTimes() default 0; // 重试次数
    long retryWait() default 0; // 重试等待时间,单位 : ms
 

}