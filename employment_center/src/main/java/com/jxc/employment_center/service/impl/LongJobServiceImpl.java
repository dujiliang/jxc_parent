package com.jxc.employment_center.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jxc.common.bean.AuthorizationUser;
import com.jxc.common.bean.R;
import com.jxc.common.constants.CommonErrCodeConstants;
import com.jxc.common.util.AccountValidatorUtil;
import com.jxc.employment_center.dao.LongJobDao;
import com.jxc.employment_center.entity.LongJob;
import com.jxc.employment_center.service.LongJobService;

@Service("longJobService")
public class LongJobServiceImpl implements LongJobService {

	@Autowired
	private LongJobDao longJobDao;

	/**
	 * 发布一个长期司机招聘(长期司机不会被司机选中，因此创建只需要直接插入数据库即可)
	 */
	public R addLongJob(AuthorizationUser user, LongJob longJob) {

		
		if(!LongJobHasEmpty(longJob)){
			return R.error(CommonErrCodeConstants.PARAM_HAS_EMPTY, "参数校验不通过");
		}
		
		try {
			Long ownerId = user.getUserId();
			longJob.setOwnerId(ownerId);
			longJobDao.insertLongJob(longJob);
			return R.ok();
		} catch (Exception e) {
			return R.error(CommonErrCodeConstants.SERVICE_EXCEPTION_ERROR, "添加异常");
		}
	}

	//TODO   完善longJob的参数校验
	private boolean LongJobHasEmpty(LongJob longJob) {
		
		if (longJob.getMachineType() != null && longJob.getDriveYear() !=null && !longJob.getDriveYear().isEmpty() &&
				longJob.getNeedNum() !=null && longJob.getProjectType() !=null && !longJob.getProjectType().isEmpty() &&
				longJob.getWorkTime() !=null && !longJob.getWorkTime().isEmpty() && 
				longJob.getPayMoney() !=null && !longJob.getPayMoney().isEmpty() && 
				longJob.getPayment() !=null &&
				longJob.getWelfare() !=null && !longJob.getWelfare().isEmpty() && 
				longJob.getContactPhone() != null && !longJob.getContactPhone().isEmpty() && 
				AccountValidatorUtil.isMobile(longJob.getContactPhone()) && 
				longJob.getContactName() !=null && !longJob.getContactName().isEmpty() &&
				longJob.getEndTime() !=null && !longJob.getEndTime().isEmpty()) {
				
			  return true;
		}
		
		
		return false;
	}

	/**
	 * 查询长期司机招聘信息
	 */
	@Override
	public R getLongJobListForOwner(AuthorizationUser user) {
		try {
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("ownerId", user.getUserId());
			List<LongJob> longJobList = longJobDao.queryLongJobList(condition);
			Map<String, Object> res = new HashMap<String, Object>();
			res.put("longJobList", longJobList);
			return R.ok(res);
		} catch (Exception e) {
			return R.error(CommonErrCodeConstants.SERVICE_EXCEPTION_ERROR, "查询异常");
		}

	}

	/**
	 * 查询单个长期job详情
	 */
	@Override
	public R longJobInfo(int jobId) {
		try {
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("jobId", jobId);
			List<LongJob> jobList = longJobDao.queryLongJobList(condition);
			LongJob job = new LongJob();
			if(jobList!=null){
				if(jobList.size() == 1){
					job = jobList.get(0);
					Map<String, Object> res = new HashMap<String, Object>();
					res.put("long_job_info", job);
					return R.ok(res);
				}else{
					return R.error(CommonErrCodeConstants.MANY_RES_FIND, "多个长期岗位找到");
				}
			}else{
				return R.error(CommonErrCodeConstants.NO_RES_FIND, "没找到");
			}
			
			
		} catch (Exception e) {
			return R.error(CommonErrCodeConstants.SERVICE_EXCEPTION_ERROR, "查询异常");
		}
	}

	/**
	 * 修改长期职位信息
	 */
	@Override
	public R updateLongJob(AuthorizationUser user, LongJob longJob) {
		R r = R.ok();
	     
		Map<String, Object> condition = new HashMap<String, Object>();
		Integer jobId = longJob.getJobId();
		Long ownerId =user.getUserId();
		condition.put("jobId", jobId);
		condition.put("ownerId", ownerId);
		List<LongJob> jobList = longJobDao.queryLongJobList(condition);
		LongJob longJob2 = jobList.get(0);
		
		longJobDao.updateLongJob(user,longJob2);
		
		return r;
	}

}
