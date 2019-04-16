package com.jxc.common.constants;

public final class SessionConstants {

	/**
	 * 用于拦截器中对鉴权信息提取出来的userId的常量key
	 */
	public static final String USER_KEY = "userId";

	/**
	 * 用于拦截器中对鉴权信息提取出来的roleType的常量key
	 */
	public static final String ROLE_TYPE = "roleType";
	
	/**
	 * 鉴权时    login会员标记     userId注入到request中的key
	 */
	public static final String USER_ID_lOGIN = "userIdLogin";
	
	/**
	 * 鉴权时    login会员标记    roleType注入到request中的key
	 */
	public static final String ROLE_TYPE_LOGIN = "roleTypeLogin";
	
	/**
	 * 鉴权时    owner机主标记     userId注入到request中的key
	 */
	public static final String USER_ID_OWNER = "userIdOwner";
	
	/**
	 * 鉴权时    owner机主标记    roleType注入到request中的key
	 */
	public static final String ROLE_TYPE_OWNER = "roleTypeOwner";
	
	/**
	 * 鉴权时    driver司机标记     userId注入到request中的key
	 */
	public static final String USER_ID_DRIVER = "userIdDriver";
	
	/**
	 * 鉴权时    driver司机标记    roleType注入到request中的key
	 */
	public static final String ROLE_TYPE_DRIVER = "roleTypeDriver";
	
	/**
	 * 鉴权时    Tenantry承租方标记     userId注入到request中的key
	 */
	public static final String USER_ID_TENANTRY = "userIdTenantry";
	
	/**
	 * 鉴权时    Tenantry承租方标记    roleType注入到request中的key
	 */
	public static final String ROLE_TYPE_TENANTRY = "roleTypeTenantry";
	
	/**
	 * 鉴权时    TenantryAdmin承租方管理员标记     userId注入到request中的key
	 */
	public static final String USER_ID_TENANTRY_ADMIN = "userIdTenantryAdmin";
	
	/**
	 * 鉴权时    TenantryAdmin承租方管理员标记    roleType注入到request中的key
	 */
	public static final String ROLE_TYPE_TENANTRY_ADMIN = "roleTypeTenantryAdmin";
	
	/**
	 * 鉴权时    child子账号标记     userId注入到request中的key
	 */
	public static final String USER_ID_CHILD = "userIdChild";
	
	/**
	 * 鉴权时    child子账号标记    roleType注入到request中的key
	 */
	public static final String ROLE_TYPE_CHILD = "roleTypeChild";
	
	
	
	/**
	 * 鉴权时    AllPermission账号标记     userId注入到request中的key
	 */
	public static final String USER_ID_ALL_PERMISSION = "userIdAllPermission";
	
	/**
	 * 鉴权时    AllPermission账号标记    roleType注入到request中的key
	 */
	public static final String ROLE_TYPE_ALL_PERMISSION = "roleTypeAllPermission";
	
	/**
	 * 鉴权时    AllPermission账号标记     userId注入到request中的key
	 */
	public static final String USER_ID_DRIVER_OR_OWNER = "userIdDriverOrOwner";
	
	/**
	 * 鉴权时    AllPermission账号标记    roleType注入到request中的key
	 */
	public static final String ROLE_TYPE_DRIVER_OR_OWNER = "roleTypeDriverOrOwner";
}
