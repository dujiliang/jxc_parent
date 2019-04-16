package com.jxc.user_center.service;

import com.jxc.common.bean.AuthorizationUser;
import com.jxc.common.bean.R;
import com.jxc.user_center.entity.Confirm;

/**
 *
 */

public interface TenantryService {

	
	R getTenantryInfo(AuthorizationUser user);
	//个人认证
	
	R personalApprove(AuthorizationUser user, Confirm personalConfirm);

	//修改承租方信息
	R updateTenantryInfo(AuthorizationUser user, com.jxc.user_center.entity.Tenantry tenantry);
	
	//企业认证
	R companyApprove(AuthorizationUser user, Confirm companyConfirm);
	
	R sendMsgForTenantryAddAdmin(AuthorizationUser user, String phone)  throws Exception;

	R addAdmin(AuthorizationUser user, String phone, String password, String code)  throws Exception;

	R getAdminList(AuthorizationUser user);

}
