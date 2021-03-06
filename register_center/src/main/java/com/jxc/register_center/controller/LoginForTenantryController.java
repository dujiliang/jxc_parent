package com.jxc.register_center.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jxc.common.bean.R;
import com.jxc.common.constants.ActionCodeConstants;
import com.jxc.common.constants.ClientConstants;
import com.jxc.common.constants.CommonErrCodeConstants;
import com.jxc.register_center.service.LoginService;

/**
 * 用户中心 登录模块相关接口（承租方版）
 *
 */
@RestController
@RequestMapping("/register_center/login")
public class LoginForTenantryController {

	@Autowired
	private LoginService loginService;
	
	/**
	 * 注册发送短信（承租方版）
	 */
	@PostMapping("sendMsgForTenantryRegister")
	public R sendMsgForTenantryRegister(String phone) {
		
		try {
			return loginService.sendMsg(phone,ActionCodeConstants.REGISTER,ClientConstants.TENANTRY_CLIENT);
		} catch (Exception e) {
			return R.error(CommonErrCodeConstants.SERVICE_EXCEPTION_ERROR, "承租方板注册发短信异常");
		}
		
	}
	
	/**
	 * 忘记密码发送短信（承租方版）
	 */
	@PostMapping("sendMsgForTenantryForget")
	public R sendMsgForTenantryForget(String phone) {
		try {
			return loginService.sendMsg(phone,ActionCodeConstants.FORGET,ClientConstants.TENANTRY_CLIENT);
		} catch (Exception e) {
			return R.error(CommonErrCodeConstants.SERVICE_EXCEPTION_ERROR, "承租方板忘记密码发短信异常");
		}
		
	}
	
	/**
	 * 注册（承租方版）
	 * 
	 */
	@PostMapping("registerForTenantry")
	public R registerForTenantry(String phone,String password,String code) throws Exception {
		return loginService.register(phone,password,code,ClientConstants.TENANTRY_CLIENT);
	}

	/**
	 * 登录（承租方版）
	 * 
	 */
	@PostMapping("doLoginForTenantry")
	public R doLoginForTenantry(String phone,String password) {
		return loginService.doLogin(phone,password,ClientConstants.TENANTRY_CLIENT);
	}
	
	/**
	 * 校验手机号是否可以使用（承租方版）
	 * 
	 */
	@PostMapping("checkPhoneForTenantry")
	public R checkPhoneForTenantry(String phone) {
		return loginService.checkPhone(phone);
	}
	
	/**
	 * 忘记密码，修改密码（承租方版）
	 * 
	 */
	@PostMapping("forgetResetPasswordForTenantry")
	public R forgetResetPasswordForTenantry(String phone,String password,String code) {
		return loginService.forgetResetPassword(phone,password,code,ClientConstants.TENANTRY_CLIENT);
	}
	
	
}
