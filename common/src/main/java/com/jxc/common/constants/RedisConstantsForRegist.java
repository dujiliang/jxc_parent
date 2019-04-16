package com.jxc.common.constants;

/**
 * 登录相关参数
 *
 */
public class RedisConstantsForRegist {
	
	//----------------------------登录token相关参数-------------------------------------
	/**
	 * token前缀
	 */
	public final static String REDIS_TOKEN_LOGIN_PREFIX = "jxc_token_login.";
	
	/**
	 * 登录token有效时间   单位 秒
	 */
	public final static int TOKEN_AVAIL_TIME = 365 * 24 * 60 * 60;
	
	
	
	//----------------------------验证码短信发送公共参数-------------------------------------
	/**
	 * 手机短信频繁度间隔时间    2分钟
	 */
	public final static int LIMIT_TIME_OUT = 2 * 60  ;
	
	/**
	 * 手机短信有效时间    2分钟
	 */
	public final static int LIMIT_TIME = 2 * 60 ;
	
	/**
	 * 短信验证码有效时间 单位   2分钟
	 */
	public final static int MOBILE_CODE_EXPIRE = 60 * 2;
	
	/**
	 * 短信当天count数   有效时间    24小时
	 */
	public final static int MOBILE_COUNT_EXPIRE = 24 * 60 * 60;
	
	/**
	 * 短信中心url
	 */
	public final static String SHORT_MESSAGE_URL = "http://127.0.0.1:8081/doSendShortMsg";
	
	
	//----------------------------注册验证码短信发送相关参数-------------------------------------
	/**
	 * 注册短信注册验证码前缀
	 */
	public final static String REGISTER_MOBILE_CODE_PREFIX = "mobileMessageCode.register.";
	
	/**
	 * 注册短信验证码条数前缀
	 */
	public final static String REGISTER_MOBILE_COUNT_PREFIX = "mobileCount.register.";
	
	/**
	 * 手机注册短信验证码每天上限条数    
	 */
	public final static int REGISTER_MOBILE_CODE_COUNT_LIMIT = 10;
	
	
	//----------------------------忘记密码验证码短信发送相关参数-------------------------------------
	/**
	 * 忘记密码验证码前缀
	 */
	public final static String FORGET_MOBILE_CODE_PREFIX = "mobileMessageCode.forget.";
	
	/**
	 * 忘记密码短信验证码条数前缀
	 */
	public final static String FORGET_MOBILE_COUNT_PREFIX = "mobileCount.forget";
	
	/**
	 * 忘记密码短信验证码每天上限条数    
	 */
	public final static int FORGET_MOBILE_CODE_COUNT_LIMIT = 10;
	
	
	
	
	
}
