package com.jxc.employment_center.service;

import com.jxc.common.bean.AuthorizationUser;
import com.jxc.common.bean.R;
import com.jxc.employment_center.entity.ShortJob;

public interface ShortJobService {
	
    /**
     * 机主添加短期job
     */
	R addShortJob(AuthorizationUser user, ShortJob shortJob) throws Exception;
	
	/**
	 * 机主查询个人发布的短期job
	 */
	R getShortJobListForOwner(AuthorizationUser user);
	
	/**
	 * 查询短期job的信息
	 */
	R shortJobInfo(int jobId);

	/**
	 * 修改短期job
	 */
	R updateShortJob(AuthorizationUser user, ShortJob shortJob);
}
