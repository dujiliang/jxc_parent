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
 * 用户中心 登录模块相关接口（机主版）
 *
 */
@RestController
@RequestMapping("/register_center/login")
public class LoginForOwnerController {

	@Autowired
	private LoginService loginService;
	
	/**
	 * 注册发送短信（机主板）
	 */
	@PostMapping("sendMsgForOwnerRegister")
	public R sendMsgForOwnerRegister(String phone) {
		try {
			return loginService.sendMsg(phone,ActionCodeConstants.REGISTER,ClientConstants.OWNER_CLIENT);
		} catch (Exception e) {
			return R.error(CommonErrCodeConstants.SERVICE_EXCEPTION_ERROR, "机主板注册发短信异常");
		}
	}
	
	/**
	 * 忘记密码发送短信（机主板）
	 */
	@PostMapping("sendMsgForOwnerForget")
	public R sendMsgForOwnerForget(String phone) {
		
		try {
			return loginService.sendMsg(phone,ActionCodeConstants.FORGET,ClientConstants.OWNER_CLIENT);
		} catch (Exception e) {
			return R.error(CommonErrCodeConstants.SERVICE_EXCEPTION_ERROR, "机主板忘记密码发短信异常");
		}
		
	}
	
	/**
	 * 注册（机主板）
	 * 
	 */
	@PostMapping("registerForOwner")
	public R registerForOwner(String phone,String password,String code) throws Exception {
		return loginService.register(phone,password,code,ClientConstants.OWNER_CLIENT);
	}

	/**
	 * 登录（机主板）
	 * 
	 */
	@PostMapping("doLoginForOwner")
	public R doLoginForOwner(String phone,String password) {
		return loginService.doLogin(phone,password,ClientConstants.OWNER_CLIENT);
	}
	
	/**
	 * 校验手机号是否可以使用（机主板）
	 * 
	 */
	@PostMapping("checkPhoneForOwner")
	public R checkPhoneForOwner(String phone) {
		return loginService.checkPhone(phone);
	}
	
	/**
	 * 忘记密码，修改密码（机主板）
	 * 
	 */
	@PostMapping("forgetResetPasswordForOwner")
	public R forgetResetPasswordForOwner(String phone,String password,String code) {
		return loginService.forgetResetPassword(phone,password,code,ClientConstants.OWNER_CLIENT);
	}
	
	
}
