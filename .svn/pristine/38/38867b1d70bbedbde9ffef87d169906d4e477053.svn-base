package com.jxc.employment_center.service;

import com.jxc.common.bean.AuthorizationUser;
import com.jxc.common.bean.R;
import com.jxc.employment_center.entity.LongJob;

public interface LongJobService {

	/**
	 * 机主创建长期职位
	 */
	R addLongJob(AuthorizationUser user,LongJob longJob);

	/**
	 * 机主查询个人发布的长期司机列表
	 */
	R getLongJobListForOwner(AuthorizationUser user);

	/**
	 * 查询单个longjob详情
	 */
	R longJobInfo(int jobId);

	/**
	 * 修改longJob
	 */
	R updateLongJob(AuthorizationUser user, LongJob longJob);

}
