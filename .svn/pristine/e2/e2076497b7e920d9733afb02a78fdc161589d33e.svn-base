package com.jxc.user_center.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.jxc.common.bean.AuthorizationUser;
import com.jxc.common.bean.R;
import com.jxc.common.constants.ActionCodeConstants;
import com.jxc.common.constants.CommonErrCodeConstants;
import com.jxc.common.constants.ConfirmStateConstants;
import com.jxc.common.constants.RedisConstantsForRegist;
import com.jxc.common.constants.RoleTyleConstants;
import com.jxc.common.util.AccountValidatorUtil;
import com.jxc.common.util.ConfirmCodeUtil;
import com.jxc.common.util.DateUtils;
import com.jxc.common.util.HttpClientManager;
import com.jxc.common.util.MD5Util;
import com.jxc.common.util.RedisUtil;
import com.jxc.common.util.S;
import com.jxc.common.util.httpclient.request.Request;
import com.jxc.common.util.httpclient.response.Response;
import com.jxc.user_center.dao.ChildAccountDao;
import com.jxc.user_center.dao.DriverDao;
import com.jxc.user_center.dao.OwnerDao;
import com.jxc.user_center.dao.ShortMsgRecordDao;
import com.jxc.user_center.dao.UserDao;
import com.jxc.user_center.entity.ChildAccount;
import com.jxc.user_center.entity.Driver;
import com.jxc.user_center.entity.Owner;
import com.jxc.user_center.entity.ShortMsgRecord;
import com.jxc.user_center.entity.User;
import com.jxc.user_center.service.OwnerService;

@Service("ownerService")
public class OwnerServiceImpl implements OwnerService {

	@Autowired
	private OwnerDao ownerDao;

	@Autowired
	private DriverDao driverDao;

	@Autowired
	private ChildAccountDao childAccountDao;

	@Autowired
	private RedisUtil redisUtil;

	@Autowired
	private ShortMsgRecordDao shortMsgRecordDao;

	@Autowired
	private UserDao userDao;

	@Transactional(rollbackFor = Exception.class)
	@Override
	public R applyRole(AuthorizationUser user, int selectRoleType) throws Exception {
		R r = R.ok();

		String uuid = UUID.randomUUID().toString().replaceAll("-", "");

		if (selectRoleType != RoleTyleConstants.OWNER_ROLE_TYPE
				&& selectRoleType != RoleTyleConstants.DRIVER_ROLE_TYPE) {
			return R.error(CommonErrCodeConstants.APPLY_ROLE_TYPE_NO_EXIST, "选择的角色不合要求");
		}

		Long userId = user.getUserId();
		Integer roleType = user.getRoleType();
		if (userId != null && roleType != null) {

			switch (roleType) {
			case RoleTyleConstants.OWNER_ROLE_TYPE:
				// 添加机主
				// 修改user
				// 处理token的缓存 反出来token
				r = dealOwner(user, uuid, userId);

				break;
			case RoleTyleConstants.DRIVER_ROLE_TYPE:
				// 添加司机
				// 修改user
				// 处理token的缓存 反出来token
				r = dealDriver(user, uuid, userId);

				break;
			default:
				return R.error(CommonErrCodeConstants.APPLY_ROLE_TYPE_NO_EXIST, "选择的角色不合要求");
			}

		} else {
			r = R.error(CommonErrCodeConstants.TOKEN_PARAM_ERROR, "token解析信息异常");
		}

		return r;
	}

	private R dealDriver(AuthorizationUser user, String uuid, Long userId) throws Exception {
		R r;
		Driver driver = new Driver();
		driver.setDriverId(userId);
		driver.setConfirmState(ConfirmStateConstants.CONFIRM_UNAUDITED);
		driverDao.insertDriverInfo(driver);

		User currUser = new User();
		currUser.setUserId(user.getUserId());
		currUser.setRoleType(RoleTyleConstants.DRIVER_ROLE_TYPE);
		userDao.updateUser(currUser);

		String reidsKey = RedisConstantsForRegist.REDIS_TOKEN_LOGIN_PREFIX + uuid;
		redisUtil.hSet(reidsKey, "userId", String.valueOf(user.getUserId()));
		redisUtil.hSet(reidsKey, "roleType", RoleTyleConstants.DRIVER_ROLE_TYPE + "");
		redisUtil.expire(reidsKey, RedisConstantsForRegist.TOKEN_AVAIL_TIME);
		Map<String, Object> res = new HashMap<String, Object>();
		res.put("token", uuid);
		r = R.ok(res);
		return r;
	}

	private R dealOwner(AuthorizationUser user, String uuid, Long userId) throws Exception {
		R r;
		Owner owner = new Owner();
		owner.setOwnerId(userId);
		owner.setConfirmState(ConfirmStateConstants.CONFIRM_UNAUDITED);
		ownerDao.insertOwnerInfo(owner);

		User currUser = new User();
		currUser.setUserId(user.getUserId());
		currUser.setRoleType(RoleTyleConstants.OWNER_ROLE_TYPE);
		userDao.updateUser(currUser);

		String reidsKey = RedisConstantsForRegist.REDIS_TOKEN_LOGIN_PREFIX + uuid;
		redisUtil.hSet(reidsKey, "userId", String.valueOf(user.getUserId()));
		redisUtil.hSet(reidsKey, "roleType", RoleTyleConstants.OWNER_ROLE_TYPE + "");
		redisUtil.expire(reidsKey, RedisConstantsForRegist.TOKEN_AVAIL_TIME);
		Map<String, Object> res = new HashMap<String, Object>();
		res.put("token", uuid);
		r = R.ok(res);
		return r;
	}

	@Override
	public R sendMsgForOwnerAddChildAccount(AuthorizationUser user, String phone) throws Exception {
		if (phone == null || phone.trim().length() == 0) {
			return R.error(CommonErrCodeConstants.PARAM_HAS_EMPTY, "有参数为空");
		}

		if (!AccountValidatorUtil.isMobile(phone)) {
			return R.error(CommonErrCodeConstants.PHONE_REGEX_ERROR, "电话号码格式错误");
		}

		String mobileCodePrefix = "";
		String mobileCountPrefix = "";
		String desc = "";

		String now = new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + ".";

		mobileCodePrefix = RedisConstantsForRegist.REGISTER_MOBILE_CODE_PREFIX;
		mobileCountPrefix = RedisConstantsForRegist.REGISTER_MOBILE_COUNT_PREFIX;
		desc = "注册用户";
		// 处理注册时候的发短信
		return dealRegister(phone, 1, 1, mobileCodePrefix, mobileCountPrefix, now, desc);

	}

	private R dealRegister(String phone, int client, int actionCode, String mobileCodePrefix, String mobileCountPrefix,
			String now, String desc) throws Exception{
		// 记录缓存的信息条数
		int redisCount = 0;
		// 先直接生成一个6位的验证码
		String confirmCode = ConfirmCodeUtil.getNumberCode(6);

		String redisMobileCountKey = mobileCountPrefix + now + phone;

		String redisMobileCodeKey = mobileCodePrefix + phone;

		// 如果缓存中还有之前的注册短信残留，说明过于频繁
		if (redisUtil.hasKey(redisMobileCodeKey)) {
			return R.error(CommonErrCodeConstants.TOO_OFTEN_MOBILE_MSG, "该手机号当日" + desc + "发送短信过于频繁");
		}

		// 从redis中获取手机号发送count数
		// 如果有当天的count数
		if (redisUtil.hasKey(redisMobileCountKey)) {
			redisCount = Integer.valueOf(redisUtil.get(redisMobileCountKey));
			if (redisCount > RedisConstantsForRegist.REGISTER_MOBILE_CODE_COUNT_LIMIT) {
				return R.error(CommonErrCodeConstants.TOO_MUCH_MOBILE_MSG, "该手机号当日" + desc + "发送短信过多");
			}
		} else {
			// 创建该手机当天count 有效期24小时
			redisUtil.set(redisMobileCountKey, "0");
			redisUtil.expire(redisMobileCountKey, RedisConstantsForRegist.MOBILE_COUNT_EXPIRE);
		}

		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("phone", phone);

		// 查询手机号使用的用户
		List<User> userList = userDao.queryUserListByCondition(condition);

		// 如果已经有人使用
		if (userList != null && userList.size() != 0) {
			return R.error(CommonErrCodeConstants.PHONE_IS_USED, desc + "电话号码已经被占用");
		}

		Date current = new Date();
		Date nowZero = DateUtils.getNowZero(current);
		Date nextZero = DateUtils.getNextZero(current);

		condition.put("actionCode", actionCode);
		condition.put("client", client);
		condition.put("beforeCreateTime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(nowZero));
		condition.put("afterCreateTime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(nextZero));

		// 根据手机号 日期 查询当天该手机的短信记录列表
		List<ShortMsgRecord> msgList = shortMsgRecordDao.queryShortMsgRecordListByCondition(condition);

		if (msgList != null && msgList.size() != 0) {

			// 有短信记录
			// 拿到最新的短信记录 对时间进行校验
			if (redisCount != msgList.size()) {
				redisCount = msgList.size();
				redisUtil.set(redisMobileCountKey, msgList.size() + "");
				redisUtil.expire(redisMobileCountKey, RedisConstantsForRegist.MOBILE_COUNT_EXPIRE);
			}

			// 有发送记录，满足条数限制 ，超过2分钟 可以调用短信发送服务
			return dealSendMsg(phone, client, actionCode, redisCount, confirmCode, redisMobileCountKey,
					redisMobileCodeKey);

		} else {
			// 没有短信记录，说明可以直接调用发送短信服务
			return dealSendMsg(phone, client, actionCode, redisCount, confirmCode, redisMobileCountKey,
					redisMobileCodeKey);

		}
	}

	@SuppressWarnings("unchecked")
	private R dealSendMsg(String phone, int client, int actionCode, int redisCount, String confirmCode,
			String redisMobileCount, String redisMobileCodeKey) {
		R r = R.ok();
		try {
			String response = sendMsg(RedisConstantsForRegist.SHORT_MESSAGE_URL, phone, actionCode, client,
					RedisConstantsForRegist.LIMIT_TIME, confirmCode);

			if (response != null && response.trim().length() != 0) {
				JSONObject js = JSONObject.parseObject(response);
				int code = (int) js.get("code");
				// code不为1代表失败
				if (Integer.valueOf(code) != 1) {
//					Map<String, Object> data = (Map<String, Object>) js.get("data");
					String msg = (String) js.get("msg");
					int error_code = (int) js.get("error_code");
					r = R.error(error_code + CommonErrCodeConstants.SHORT_MSG_CENTER_ERROR_PREFIX, msg);
				} else {
					// 这里就是短信服务中心返回正确时，将生成的验证码存入缓存
					try {
						redisUtil.set(redisMobileCodeKey, confirmCode);
						redisUtil.expire(redisMobileCodeKey, RedisConstantsForRegist.MOBILE_CODE_EXPIRE);
						redisCount++;
						redisUtil.set(redisMobileCount, String.valueOf(redisCount));
						redisUtil.expire(redisMobileCount, RedisConstantsForRegist.MOBILE_COUNT_EXPIRE);
						Map<String, Object> res = new HashMap<String, Object>();
						res.put("val_code", confirmCode);
						r = R.ok(res);
					} catch (Exception e) {
						r = R.error(999, "redis保存短信验证码异常");
					}
				}
			} else {
				r = R.error(CommonErrCodeConstants.SHORT_MSG_CENTER_NO_RESEPONSE, "短信中心没返回");
			}
		} catch (Exception e) {
			r = R.error(9999, "短信中心服务异常");
		}
		return r;
	}
	
	private static String sendMsg(String url, String phone, int actionCode, int client, int expir, String confirmCode)
			throws Exception {
		Request request = new Request(url).addUrlParam("phone", phone).addUrlParam("actionCode", actionCode)
				.addUrlParam("client", client).addUrlParam("expir", expir).addUrlParam("confirmCode", confirmCode);
		Response response = HttpClientManager.getInstance().doRequest(request);

		return response.getResponseText();
	}
	
	@Transactional
	@Override
	public R addChild(AuthorizationUser user, String phone, String password, String code) throws Exception {

		R r = R.ok();

		String uuid = UUID.randomUUID().toString().replaceAll("-", "");

		String now = new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + ".";

		String redisMobileCountKey = RedisConstantsForRegist.REGISTER_MOBILE_COUNT_PREFIX + now + phone;

		String redisMobileCodeKey = RedisConstantsForRegist.REGISTER_MOBILE_CODE_PREFIX + phone;

		int redisCount = 0;

		if (S.isEmpty(phone) || S.isEmpty(password) || S.isEmpty(code)) {
			return R.error(CommonErrCodeConstants.PARAM_HAS_EMPTY, "有参数为空");
		}

		if (password.length() < 6 || password.length() > 20) {
			return R.error(CommonErrCodeConstants.PASSWORD_REGEX_ERROR, "输入的密码不合要求");
		} else {
			// 正则校验密码 数字和字母混合
			if (!AccountValidatorUtil.isPassword(password)) {
				return R.error(CommonErrCodeConstants.PASSWORD_REGEX_ERROR, "输入的密码不合要求");
			}
		}

		if (!AccountValidatorUtil.isMobile(phone)) {
			return R.error(CommonErrCodeConstants.PHONE_REGEX_ERROR, "手机号格式不合要求");
		}

		// 从redis中查看 手机当天短信发送情况 如果没有记录 要处理 后续完善
		// code校验 处理
		if (redisUtil.hasKey(redisMobileCountKey)) {
			redisCount = Integer.valueOf(redisUtil.get(redisMobileCountKey));
			if (redisCount > RedisConstantsForRegist.REGISTER_MOBILE_CODE_COUNT_LIMIT) {
				return R.error(CommonErrCodeConstants.TOO_MUCH_MOBILE_MSG, "该手机号当天验证码过多");
			}
			if (redisUtil.hasKey(redisMobileCodeKey)) {
				String confirmCode = redisUtil.get(redisMobileCodeKey);
				if (!code.equals(confirmCode)) {
					return R.error(CommonErrCodeConstants.CODE_NOT_EQUAL, "验证码不正确");
				}
			} else {
				return R.error(CommonErrCodeConstants.CODE_NO_AVAIL, "该手机的验证码已失效");
			}
		} else {
			return R.error(CommonErrCodeConstants.NO_PHONE_SEND, "该手机号当天未发送短信验证码");
		}

		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("phone", phone);

		// 查询手机号使用的用户
		List<User> userList = userDao.queryUserListByCondition(condition);

		// 如果已经有人使用
		if (userList != null && userList.size() != 0) {
			r = R.error(CommonErrCodeConstants.PHONE_IS_USED, "电话号码已经被注册");
		}

		Date current = new Date();
		Date nowZero = DateUtils.getNowZero(current);
		Date nextZero = DateUtils.getNextZero(current);
		condition.put("actionCode", ActionCodeConstants.REGISTER);
		condition.put("beforeCreateTime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(nowZero));
		condition.put("afterCreateTime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(nextZero));

		// 根据手机号 日期 查询当天该手机的短信记录列表
		List<ShortMsgRecord> msgList = shortMsgRecordDao.queryShortMsgRecordListByCondition(condition);

		if (msgList == null || msgList.size() == 0) {
			return R.error(CommonErrCodeConstants.MANY_USER_FIND, "该手机号当天没有发送短信");
		}

		if (redisCount != msgList.size()) {
			redisCount = msgList.size();
			redisUtil.set(RedisConstantsForRegist.REGISTER_MOBILE_COUNT_PREFIX + phone, String.valueOf(msgList.size()));
			redisUtil.expire(redisMobileCountKey, RedisConstantsForRegist.MOBILE_COUNT_EXPIRE);

		}

		if (redisCount > RedisConstantsForRegist.REGISTER_MOBILE_CODE_COUNT_LIMIT) {
			return R.error(CommonErrCodeConstants.TOO_MUCH_MOBILE_MSG, "该手机号当天验证码过多");
		}

		User childUser = new User();
		childUser.setPhone(phone);
		childUser.setPassword(password);
		childUser.setThirdId(MD5Util.get32MD5(phone));
		// 如果是承租方板注册默认创建就是承租方角色 为了区分初次创建 roleId不做设置
		// 如果是机主板注册默认创建就是普通会员角色 登陆后进行角色选择
		int roleType = RoleTyleConstants.CHILD_ROLE_TYPE;
		user.setRoleType(roleType);
		userDao.insert(childUser);

		List<User> tmpUserList = userDao.queryUserListByCondition(condition);

		if (tmpUserList != null && tmpUserList.size() == 1) {

			childUser = tmpUserList.get(0);

			ChildAccount child = new ChildAccount();
			child.setChildId(childUser.getUserId());
			child.setOwnerId(user.getUserId());
			child.setPhone(phone);

			childAccountDao.insertChildAccount(phone, String.valueOf(user.getUserId()));
			// 创建成功
			// 生成token
			String reidsKey = RedisConstantsForRegist.REDIS_TOKEN_LOGIN_PREFIX + uuid;
			redisUtil.hSet(reidsKey, "userId", String.valueOf(childUser.getUserId()));
			redisUtil.hSet(reidsKey, "roleType", roleType + "");
			redisUtil.expire(reidsKey, RedisConstantsForRegist.TOKEN_AVAIL_TIME);
			Map<String, Object> res = new HashMap<String, Object>();
			res.put("token", uuid);
			res.put("third_id", MD5Util.get32MD5(phone));
			res.put("roleType", roleType);
			res.put("confirm_state", childUser.getConfirmState());
			res.put("img", childUser.getHeadImg());
			res.put("real_name", childUser.getRealName());			
			r = R.ok(res);
		} else {
			r = R.error(CommonErrCodeConstants.RIGISTER_FAIL, "注册用户失败");
		}

		return r;
	}

	@Override
	public R getChildList(AuthorizationUser user) {
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("ownerId", user.getUserId());
		List<ChildAccount> list = childAccountDao.queryChildAccountListByCondition(condition);
		Map<String, Object> res = new HashMap<String, Object>();
		res.put("childList", list);
		return R.ok(res);
	}

}
