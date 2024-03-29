package com.jxc.employment_center.service.impl;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jxc.common.bean.AuthorizationUser;
import com.jxc.common.bean.R;
import com.jxc.common.constants.CommonErrCodeConstants;
import com.jxc.common.constants.RedisConstantsForEmploy;
import com.jxc.common.constants.RedisConstantsForRegist;
import com.jxc.common.util.RedisUtil;
import com.jxc.common.util.S;
import com.jxc.employment_center.dao.ShortJobDao;
import com.jxc.employment_center.entity.ShortJob;
import com.jxc.employment_center.service.ShortJobService;

@Service("shortJobService")
public class ShortJobServiceImpl implements ShortJobService {
	
	@Autowired
	private ShortJobDao shortJobDao;
	
	@Autowired
	private RedisUtil redisUtil;


	@Transactional(rollbackFor = Exception.class)
	@Override
	public R addShortJob(AuthorizationUser user, ShortJob shortJob) throws Exception {
		
		if(!ShortJobHasEmpty(shortJob)){
			return R.error(CommonErrCodeConstants.PARAM_HAS_EMPTY, "参数校验不通过");
		}
		
		String uuid = UUID.randomUUID().toString().replace("-", ""); 
		Long ownerId = user.getUserId();
		shortJob.setJobId(uuid);
		shortJob.setOwnerId(ownerId);
		shortJob.setCreateTime(new Date());
		shortJobDao.insertShortJob(shortJob);
		
		//添加redis count  设置超时时间
		
		long availTime = shortJob.getEffectiveDate().getTime() - System.currentTimeMillis();
		if(availTime > 0){
			String reidsKey = RedisConstantsForEmploy.REDIS_TOKEN_JOB_COUNT_PREFIX + uuid;
			redisUtil.set(reidsKey, String.valueOf(shortJob.getNeedNum()));
			redisUtil.expire(reidsKey, (int)(availTime/1000));
		}else{
			throw new Exception();
		}
		
		return R.ok();
	}
	
	private boolean ShortJobHasEmpty(ShortJob shortJob) {
		
		Integer machineType = shortJob.getMachineType();
		if(machineType == null || machineType != 0){
			return false;
		}
		
		Integer driveYear = shortJob.getDriveYear();
		if(driveYear == null){
			return false;
		}
		
		Integer needNum = shortJob.getNeedNum();
		if(needNum == null){
			return false;
		}
		
		Integer ageLimit = shortJob.getAgeLimit();
		if(ageLimit == null){
			return false;
		}
		
		String workTimeStart = shortJob.getWorkTimeStart();
		if(S.isEmpty(workTimeStart)){
			return false;
		}
		
		String workTimeEnd = shortJob.getWorkTimeEnd();
		if(S.isEmpty(workTimeEnd)){
			return false;
		}
		
		String effectiveDateStr = shortJob.getEffectiveDateStr();
		
		if(S.isEmpty(effectiveDateStr)){
			return false;
		}else{
			try {
				Date effectiveDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(effectiveDateStr+" 23:59:59");
				
				if(effectiveDate.before(new Date())){
					return false;
				}
				shortJob.setEffectiveDate(effectiveDate);
			} catch (ParseException e) {
				return false;
			}
		}
		
		String contactName = shortJob.getContactName();
		if(S.isEmpty(contactName)){
			return false;
		}
		
		String contactPhone = shortJob.getContactPhone();
		if(S.isEmpty(contactPhone)){
			return false;
		}
		
		String accountRuler = shortJob.getAccountRuler();
		if(S.isEmpty(accountRuler)){
			return false;
		}
		
		Integer areaId = shortJob.getAreaId();
		if(areaId == null){
			return false;
		}
		return true;
	}

	@Override
	public R getShortJobListForOwner(AuthorizationUser user) {
		try {
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("DriverId", user.getUserId());
			List<ShortJob> shortJobList = shortJobDao.getShortJobListForOwner(condition);
			Map<String, Object> res = new HashMap<String, Object>();
			res.put("shortJobList", shortJobList);
			return R.ok(res);
		} catch (Exception e) {
			return R.error(CommonErrCodeConstants.SERVICE_EXCEPTION_ERROR, "查询异常");
		}
	}

	@Override
	public R shortJobInfo(int jobId) {
		try {
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("jobId", jobId);
			List<ShortJob> jobList = shortJobDao.getShortJobListForOwner(condition);
			ShortJob job = new ShortJob();
			if(jobList!=null){
				if(jobList.size() == 1){
					job = jobList.get(0);
					Map<String, Object> res = new HashMap<String, Object>();
					res.put("shortJob", job);
					return R.ok(res);
				}else{
					return R.error(CommonErrCodeConstants.MANY_RES_FIND, "多个短期岗位找到");
				}
			}else{
				return R.error(CommonErrCodeConstants.NO_RES_FIND, "没找到");
			}
			
			
		} catch (Exception e) {
			return R.error(CommonErrCodeConstants.SERVICE_EXCEPTION_ERROR, "查询异常");
		}
	}

	@Override
	public R updateShortJob(AuthorizationUser user, ShortJob shortJob) {
		if(!ShortJobHasEmpty(shortJob)){
			return R.error(CommonErrCodeConstants.PARAM_HAS_EMPTY, "参数校验不通过");
		}
		
		try {
			Long ownerId = user.getUserId();
			shortJob.setOwnerId(ownerId);
			shortJobDao.updateShortJob(shortJob);
			return R.ok();
		} catch (Exception e) {
			return R.error(CommonErrCodeConstants.SERVICE_EXCEPTION_ERROR, "添加异常");
		}
	}

	

}
