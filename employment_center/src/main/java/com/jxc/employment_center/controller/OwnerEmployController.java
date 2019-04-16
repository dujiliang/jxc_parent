package com.jxc.employment_center.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jxc.common.annotation.Login;
import com.jxc.common.annotation.Owner;
import com.jxc.common.annotation.OwnerUser;
import com.jxc.common.bean.AuthorizationUser;
import com.jxc.common.bean.R;
import com.jxc.common.constants.CommonErrCodeConstants;
import com.jxc.employment_center.entity.LongJob;
import com.jxc.employment_center.entity.ShortJob;
import com.jxc.employment_center.service.LongJobService;
import com.jxc.employment_center.service.ShortJobService;

/**
 * 
 * 机主招聘相关
 *
 */
@RestController
@RequestMapping("/employment_center/owner")
public class OwnerEmployController {
	
	@Autowired
	private LongJobService longJobService;
	
	@Autowired
	private ShortJobService shortjobService;
	
	/**
	 * 机主创建长期职位  （权限：机主）
	 * @param user
	 * @param request
	 * @return
	 */
	@Owner
	@RequestMapping("/addLongJob")
	@PostMapping
	public R addLongJob(@OwnerUser AuthorizationUser user,@RequestBody LongJob longJob) {
		
		return longJobService.addLongJob(user,longJob);
		
		
	}
	
	/**
	 * 机主查询个人发布的长期司机列表  （权限：机主）
	 * @param user
	 * @return
	 */
	@Owner
	@RequestMapping("/getLongJobListForOwner")
	public R getLongJobListForOwner(@OwnerUser AuthorizationUser user) {
		return longJobService.getLongJobListForOwner(user);
	}

	/**
	 * 查询单个longjob详情  （权限：会员）
	 * @param user
	 * @param jobId
	 * @return
	 */
	@Login
	@RequestMapping("/longJobInfo")
	public R longJobInfo(int jobId) {
		return longJobService.longJobInfo(jobId);
	}
	
	/**
	 * 机主修改长期职位  （权限：机主）
	 * @param user
	 * @param request
	 * @return
	 */
	@Owner
	@RequestMapping("/updateLongJob")
	@PostMapping
	public R updateLongJob(@OwnerUser AuthorizationUser user,@RequestBody LongJob longJob) {
		return longJobService.updateLongJob(user,longJob);
	}
	
	
	//定时器,处理长期岗位的发布截止
	//定时器,处理短期岗位的发布截止
	
	/**
	 * 机主创建短期职位  （权限：机主）
	 * @param user
	 * @param request
	 * @return
	 */
	@Owner
	@RequestMapping("/addShortJob")
	@PostMapping
	public R addShortJob(@OwnerUser AuthorizationUser user,@RequestBody ShortJob shortJob) {
		try {
			return shortjobService.addShortJob(user,shortJob);
		} catch (Exception e) {
			e.printStackTrace();
			return R.error(CommonErrCodeConstants.SERVICE_EXCEPTION_ERROR, "添加异常");
		}
	}
	
	/**
	 * 机主查询个人发布的短期司机列表  （权限：机主）
	 * @param user
	 * @return
	 */
	@Owner
	@RequestMapping("/getShortJobListForOwner")
	public R getShortJobListForOwner(@OwnerUser AuthorizationUser user) {
		return shortjobService.getShortJobListForOwner(user);
	}
	
	/**
	 * 查询单个shortjob详情  （权限：会员）
	 * @param user
	 * @param jobId
	 * @return
	 */
	@Login
	@RequestMapping("/shortJobInfo")
	public R shortJobInfo(int jobId) {
		return shortjobService.shortJobInfo(jobId);
	}
	
	/**
	 * 机主创建长期职位  （权限：机主）
	 * @param user
	 * @param request
	 * @return
	 */
	@Owner
	@RequestMapping("/updateShortJob")
	@PostMapping
	public R updateShortJob(@OwnerUser AuthorizationUser user,@RequestBody ShortJob shortJob) {
		return shortjobService.updateShortJob(user,shortJob);
	}
}
