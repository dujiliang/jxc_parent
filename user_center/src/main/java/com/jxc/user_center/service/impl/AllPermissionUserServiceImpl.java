package com.jxc.user_center.service.impl;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jxc.common.bean.AuthorizationUser;
import com.jxc.common.bean.R;
import com.jxc.common.constants.CommonErrCodeConstants;
import com.jxc.common.constants.RoleTyleConstants;
import com.jxc.common.util.FtpUtil;
import com.jxc.common.util.S;
import com.jxc.user_center.dao.ChildAccountDao;
import com.jxc.user_center.dao.DriverDao;
import com.jxc.user_center.dao.OwnerDao;
import com.jxc.user_center.dao.TenantryAccountDao;
import com.jxc.user_center.dao.TenantryDao;
import com.jxc.user_center.dao.UserDao;
import com.jxc.user_center.entity.ChildAccount;
import com.jxc.user_center.entity.Driver;
import com.jxc.user_center.entity.Owner;
import com.jxc.user_center.entity.Tenantry;
import com.jxc.user_center.entity.TenantryUser;
import com.jxc.user_center.entity.User;
import com.jxc.user_center.service.AllPermissionUserService;

import ch.qos.logback.core.joran.conditional.IfAction;

@Service("allPermissionUserService")
public class AllPermissionUserServiceImpl implements AllPermissionUserService {

	@Autowired
	private OwnerDao ownerDao;

	@Autowired
	private DriverDao driverDao;

	@Autowired
	private UserDao userDao;

	@Autowired
	private TenantryDao tenantryDao;

	@Autowired
	private TenantryAccountDao tenantryAccountDao;

	@Autowired
	private ChildAccountDao childAccountDao;

	@Override
	public R getAllPermissionUserInfo(AuthorizationUser user) {
		R r = R.ok();
		Map<String, Object> condition = new HashMap<String, Object>();
		Integer roleType = user.getRoleType();
		Long userId = user.getUserId();

		switch (roleType) {
		// 普通会员
		case (RoleTyleConstants.USER_ROLE_TYPE):
			r = dealUser(r, condition, userId);
			break;

		// 机主
		case (RoleTyleConstants.OWNER_ROLE_TYPE):
			r = dealOwner(r, condition, userId);
			break;

		// 承租方
		case (RoleTyleConstants.TENANTRY_ROLE_TYPE):
			r = dealTenantry(r, condition, userId);
			break;

		// 承租方管理员
		case (RoleTyleConstants.TENANTRY_ADMIN_ROLE_TYPE):
			r = dealTenantryAdmin(r, condition, userId);
			break;

		// 司机
		case (RoleTyleConstants.DRIVER_ROLE_TYPE):
			r = dealDriver(r, condition, userId);
			break;

		// 机主子帐号
		case (RoleTyleConstants.CHILD_ROLE_TYPE):
			r = dealChild(r, condition, userId);
			break;

		default:
			r = R.error(1010, "用户不存在");
			break;
		};

		return r;
	}

	// 机主子帐号
	private R dealChild(R r, Map<String, Object> condition, Long userId) {
		condition.put("childId", userId);
		List<ChildAccount> childAccountList = childAccountDao.queryChildAccountListByCondition(condition);
		if (childAccountList != null && childAccountList.size() != 0) {
			if (childAccountList.size() == 1) {
				ChildAccount currChild = childAccountList.get(0);
				Map<String, Object> childAccounts = new HashMap<String, Object>();
				childAccounts.put("childAccount", currChild);
				r = R.ok(childAccounts);
			} else {
				r = R.error(CommonErrCodeConstants.MANY_ROLE_USER_FIND, "该用户绑定的角色信息存在多个");
			}
		}
		return r;
	}

	// 司机
	private R dealDriver(R r, Map<String, Object> condition, Long userId) {
		condition.put("driverId", userId);
		List<Driver> driverList = driverDao.queryDriverListByCondition(condition);
		if (driverList != null && driverList.size() != 0) {
			if (driverList.size() == 1) {
				Driver currDriver = driverList.get(0);	
					Map<String, Object> tenDrivers = new HashMap<String, Object>();
					tenDrivers.put("driver", currDriver);
					r = R.ok(tenDrivers);		

			} else {
				r = R.error(CommonErrCodeConstants.MANY_ROLE_USER_FIND, "该用户绑定的角色信息存在多个");
			}
		}
		return r;
	}

	// 承租方管理员
	private R dealTenantryAdmin(R r, Map<String, Object> condition, Long userId) {
		condition.put("tenantryUserId", userId);
		List<TenantryUser> tenAdmin = tenantryAccountDao.queryTenantryAdminByCondition(condition);
		if (tenAdmin != null && tenAdmin.size() != 0) {
			if (tenAdmin.size() == 1) {
				TenantryUser currTenUser = tenAdmin.get(0);
				Map<String, Object> tenUsers = new HashMap<String, Object>();
				tenUsers.put("tenantryUser", currTenUser);
				r = R.ok(tenUsers);
			} else {
				r = R.error(CommonErrCodeConstants.MANY_ROLE_USER_FIND, "该用户绑定的角色信息存在多个");
			}
		}
		return r;
	}

	// 承租方
	private R dealTenantry(R r, Map<String, Object> condition, Long userId) {
		condition.put("tenantryId", userId);
		List<Tenantry> tenList = tenantryDao.queryTenantryListByCondition(condition);
		Map<String, Object> tens = new HashMap<String, Object>();
		if (tenList != null && tenList.size() != 0) {
			if (tenList.size() == 1) {
				Tenantry currTen = tenList.get(0);			
				    tens .put("tenantry", currTen);			
	    			r = R.ok(tens);
			   }
						
			} else {
				r = R.error(CommonErrCodeConstants.MANY_ROLE_USER_FIND, "该用户绑定的角色信息存在多个");
			}
		return r;
	}

	// 机主
	private R dealOwner(R r, Map<String, Object> condition, Long userId) {
		condition.put("ownerId", userId);
		List<Owner> ownerList = ownerDao.queryOwnerListByCondition(condition);
		Map<String, Object> owns = new HashMap<String, Object>();
		if (ownerList != null && ownerList.size() != 0) {
			if (ownerList.size() == 1) {
				Owner currOwner = ownerList.get(0);
				owns.put("owner", currOwner);			
				r = R.ok(owns);
				
			} else {
				r = R.error(CommonErrCodeConstants.MANY_ROLE_USER_FIND, "该用户绑定的角色信息存在多个");
			}
		}
		return r;
	}

	// 普通会员
	private R dealUser(R r, Map<String, Object> condition, Long userId) {
		condition.put("userId", userId);
		// condition.put("roleType", roleType);
		List<User> userList = userDao.queryUserListByCondition(condition);
		if (userList != null && userList.size() != 0) {
			if (userList.size() == 1) {
				User curruser = userList.get(0);
				Map<String, Object> users = new HashMap<String, Object>();
				users.put("user", curruser);
				r = R.ok(users);
			} else {
				r = R.error(CommonErrCodeConstants.MANY_ROLE_USER_FIND, "该用户绑定的角色信息存在多个");
			}
		}
		return r;
	}

	
	/**
	 * 上传图片
	 */
	@Override
	public R uploadHeadImage(AuthorizationUser user, MultipartFile img) {
		
		
		if(img == null){
			return R.error(1, "请上传图片");
		}
		
		if(img.getSize() == 0){
			return R.error(2, "禁止上传空图片文件");
		}
		
		try {
			InputStream is = img.getInputStream();
			
			String imgName = img.getOriginalFilename();
			String imgTail = imgName.substring(imgName.lastIndexOf(".") + 1 );
			
			String url = FtpUtil.doUploadAndReturnUrl(FtpUtil.RELATIVE_PATH_IMG, imgTail, is);
			
			if(S.isEmpty(url)){
				return R.error(-1, "图片上传失败");
			}
			
			userDao.updateHeadImg(url, user.getUserId());
			
			
			return R.ok(new HashMap<String,Object>(){{
				put("imgUrl", url);
			}});
			
		} catch (Exception e) {
		
			return R.error(-1, "图片上传失败");
		}
		
	}

}
