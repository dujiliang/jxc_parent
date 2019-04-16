package com.jxc.employment_center.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jxc.common.annotation.Driver;
import com.jxc.common.annotation.DriverUser;
import com.jxc.common.annotation.Login;
import com.jxc.common.bean.AuthorizationUser;
import com.jxc.common.bean.R;
import com.jxc.common.constants.CommonErrCodeConstants;
import com.jxc.employment_center.entity.DriverResume;
import com.jxc.employment_center.entity.ShortJob;
import com.jxc.employment_center.service.DriverResumeService;

/**
 * 
 * 司机招聘相关
 *
 */
@RestController
@RequestMapping("/employment_center/driver")
public class DriverEmployController {
	
	@Autowired
	private DriverResumeService driverResumeService;
	
	
	/**
	 * 司机创建简历  （权限：司机）
	 * @param user
	 * @param request
	 * @return
	 */
	@Driver
	@RequestMapping("/addResume")
	@PostMapping
	public R addResume(@DriverUser AuthorizationUser user,@RequestBody DriverResume resume) {
		return driverResumeService.addResume(user,resume);
	}
	
	/**
	 * 司机查询个人的简历列表  （权限：司机）
	 * @param user
	 * @return
	 */
	@Driver
	@RequestMapping("/getDriverResumeListForDriver")
	public R getDriverResumeListForDriver(@DriverUser AuthorizationUser user) {
		return driverResumeService.getDriverResumeListForDriver(user);
	}

	/**
	 * 查询单个简历详情  （权限：会员）
	 * @param user
	 * @param jobId
	 * @return
	 */
	@Login
	@RequestMapping("/resumeInfo")
	public R resumeInfo(int resumeId) {
		return driverResumeService.resumeInfo(resumeId);
	}
	
	
	/**
	 * 司机修改简历  （权限：司机）
	 * @param user
	 * @param request
	 * @return
	 */
	@Driver
	@RequestMapping("/updateResume")
	@PostMapping
	public R updateResume(@DriverUser AuthorizationUser user,@RequestBody DriverResume resume) {
		return driverResumeService.updateResume(user,resume);
	}
	
	/**
	 * 司机删除简历  （权限：司机）
	 * @param user
	 * @param request
	 * @return
	 */
	@Driver
	@RequestMapping("/deleteResume")
	@PostMapping
	public R deleteResume(@DriverUser AuthorizationUser user,@RequestBody DriverResume resume) {
		return driverResumeService.deleteResume(user,resume);
	}
	
	/**
	 * 司机投递短期简历
	 */
	@Driver
	@RequestMapping("/sendShortJob")
	@PostMapping
	public R sendShortJob(@DriverUser AuthorizationUser user,String shortJobId) {
		try {
			return driverResumeService.sendShortJob(user,shortJobId);
		} catch (Exception e) {
			e.printStackTrace();
			return R.error(CommonErrCodeConstants.SERVICE_EXCEPTION_ERROR, "投递简历异常");
		}
	}
	
	
	
}
