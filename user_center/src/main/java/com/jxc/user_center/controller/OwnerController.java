package com.jxc.user_center.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jxc.common.annotation.Login;
import com.jxc.common.annotation.LoginUser;
import com.jxc.common.annotation.Owner;
import com.jxc.common.annotation.OwnerUser;
import com.jxc.common.bean.AuthorizationUser;
import com.jxc.common.bean.R;
import com.jxc.common.constants.CommonErrCodeConstants;
import com.jxc.user_center.service.OwnerService;

/**
 * 机主板个人信息和选择角色相关
 *
 */
@RestController
@RequestMapping("/user_center/owner")
public class OwnerController {
	
	@Autowired
	private OwnerService ownerService;

	/**
	 * 用户选择角色（机主板）
	 * @param user   user为拦截器鉴权注入     userId 和  roleType
	 * @param roleType    
	 * @return
	 * @throws Exception
	 */
	@Login
    @RequestMapping("/applyRole")
	public R setRole(@LoginUser AuthorizationUser user,int roleType) {
		try {
			return ownerService.applyRole(user,roleType);
		} catch (Exception e) {
			return R.error(CommonErrCodeConstants.SERVICE_EXCEPTION_ERROR, "选择角色异常");
		}
	}
	
	/**
	 * 发送短信（机主创建子账号）  ---   子账号手机收到短信
	 * @param user
	 * @param phone
	 * @return
	 */
	@Owner
    @RequestMapping("/sendMsgForOwnerAddChildAccount")
    public R sendMsgForOwnerAddChildAccount(@OwnerUser AuthorizationUser user,String phone) {
    	
    	try {
    		return ownerService.sendMsgForOwnerAddChildAccount(user,phone);
		} catch (Exception e) {
			return R.error(CommonErrCodeConstants.SERVICE_EXCEPTION_ERROR, "发送短信（机主创建子账号）异常");
		}
    	
    }
	
	/**
	 * 机主添加子账号
	 * @param user
	 * @param phone
	 * @param password
	 * @return
	 */
	@Owner
    @RequestMapping("/addChild")
    public R addChild(@OwnerUser AuthorizationUser user, String phone, String password,String code){
		
		try {
			return ownerService.addChild(user,phone,password,code);
		} catch (Exception e) {
			return R.error(CommonErrCodeConstants.SERVICE_EXCEPTION_ERROR, "添加子账号异常");
		}
    }

	/**
	 * 查看机主子账号列表
	 * @param user
	 * @param phone
	 * @param password
	 * @return
	 */
	@Owner
    @RequestMapping("/getChildList")
    public R getChildList(@OwnerUser AuthorizationUser user){
		return ownerService.getChildList(user);
    }

}
