package com.jxc.user_center.service;

import org.springframework.web.multipart.MultipartFile;

import com.jxc.common.bean.AuthorizationUser;
import com.jxc.common.bean.R;

/**
 * 个人信息
 * @author Administrator
 *
 */

public interface AllPermissionUserService {
	


	R getAllPermissionUserInfo(AuthorizationUser user);

	//上传头像
	R uploadHeadImage(AuthorizationUser user, MultipartFile file);
	

}
