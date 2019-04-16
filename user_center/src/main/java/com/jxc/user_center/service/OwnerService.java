package com.jxc.user_center.service;

import com.jxc.common.bean.AuthorizationUser;
import com.jxc.common.bean.R;

/**
 *
 */

public interface OwnerService {

	R applyRole(AuthorizationUser user, int roleType) throws Exception;

	R sendMsgForOwnerAddChildAccount(AuthorizationUser user, String phone) throws Exception;

	R addChild(AuthorizationUser user, String phone, String password, String code) throws Exception;

	R getChildList(AuthorizationUser user);


	

}
