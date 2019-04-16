package com.jxc.user_center.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.jxc.common.annotation.AllPermission;
import com.jxc.common.annotation.AllPermissionUser;
import com.jxc.common.annotation.DriverOrOwner;
import com.jxc.common.annotation.DriverOrOwnerUser;
import com.jxc.common.bean.AuthorizationUser;
import com.jxc.common.bean.R;
import com.jxc.user_center.service.AllPermissionUserService;

/**
 * allPermission相关
 *
 */
@RestController
@RequestMapping("/user_center/allPermission")
public class AllPermissionUserController {
	
	@Autowired
	private AllPermissionUserService allPermissionUserService;

	
	/**
	 * 获取角色信息
	 * @param user   user为拦截器鉴权注入     userId 和  roleType
	 * @return
	 */
	@AllPermission
    @RequestMapping("/getAllPermissionUserInfo")
	public R getAllPermissionUserInfo(@AllPermissionUser AuthorizationUser user) {
    	return allPermissionUserService.getAllPermissionUserInfo(user);
	}
	
	/**
	 * 上传头像
	 * @param user
	 * @param img
	 * @return
	 */
	@AllPermission
	@RequestMapping("/uploadHeadImage")
	public R uploadHeadImage(@AllPermissionUser AuthorizationUser user,@RequestParam("img")MultipartFile img){
		return 	allPermissionUserService.uploadHeadImage(user,img);
	}
	
	
	/**
	 * 获取角色信息
	 * @param user   user为拦截器鉴权注入     userId 和  roleType
	 * @return
	 */
	@DriverOrOwner
    @RequestMapping("/test")
	public R test(@DriverOrOwnerUser AuthorizationUser user) {
		System.out.println(user.getUserId());
		System.out.println(user.getRoleType());
		return null;
	}
	

}
