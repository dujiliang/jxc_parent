package com.jxc.user_center.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jxc.common.annotation.Tenantry;
import com.jxc.common.annotation.TenantryUser;
import com.jxc.common.bean.AuthorizationUser;
import com.jxc.common.bean.R;
import com.jxc.common.constants.CommonErrCodeConstants;
import com.jxc.user_center.entity.Confirm;
import com.jxc.user_center.service.TenantryService;

/**
 * 用户中心 登录模块相关接口
 *
 */
@RestController
@RequestMapping("/user_center/tenantry")
public class TenantryController {

	@Autowired
	private TenantryService tenantryService;
	
	/**
	 * 查询承租方用户信息
	 */
	@Tenantry
	@RequestMapping("/getTenantryInfo")
	public R getTenantryInfo(@TenantryUser AuthorizationUser user) {
		return tenantryService.getTenantryInfo(user);
	}
	
	
	public R updateTenantryInfo(@TenantryUser AuthorizationUser user,@RequestBody com.jxc.user_center.entity.Tenantry tenantry) {
		return tenantryService.updateTenantryInfo(user,tenantry);
	}
	
	
	/**
	 * 个人认证
	 * @param tenantry
	 * @return
	 */
	@Tenantry
	@RequestMapping("/personalConfirm")
	public R personalApprove(@TenantryUser AuthorizationUser user,@RequestBody Confirm personalConfirm) {
		
       return tenantryService.personalApprove(user,personalConfirm);	
		
	}
	

	/**
	 * 企业认证
	 * @param tenantry
	 * @return
	 */
	@Tenantry
	@RequestMapping("/companyConfirm")
	public R companyApprove(@TenantryUser AuthorizationUser user,@RequestBody Confirm companyConfirm) {
		
		return tenantryService.companyApprove(user,companyConfirm);
		
	}
	
	/**
	 * 发送认证短信
	 * @param phone
	 * @return
	 */
	@PostMapping("sendConfirmMsg")
	public R sendConfirmMsg(String phone) {
		return null;
	}
	
	
	/**
	 * 发送短信（承租方创建管理员账号）  ---   管理员手机收到短信
	 * @param user
	 * @param phone
	 * @return
	 */
	@Tenantry
    @RequestMapping("/sendMsgForTenantryAddAdmin")
    public R sendMsgForTenantryAddAdmin(@TenantryUser AuthorizationUser user,String phone) {
    	
    	try {
    		return tenantryService.sendMsgForTenantryAddAdmin(user,phone);
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
	@Tenantry
    @RequestMapping("/addAdmin")
    public R addAdmin(@TenantryUser AuthorizationUser user, String phone, String password,String code){
		
		try {
			return tenantryService.addAdmin(user,phone,password,code);
		} catch (Exception e) {
			return R.error(CommonErrCodeConstants.SERVICE_EXCEPTION_ERROR, "添加子账号异常");
		}
    }
	
	
	/**
	 * 查看承租方列表
	 * @param user
	 * @param phone
	 * @param password
	 * @return
	 */
	@Tenantry
    @RequestMapping("/getAdminList")
    public R getAdminList(@TenantryUser AuthorizationUser user){
		return tenantryService.getAdminList(user);
    }

	
}
