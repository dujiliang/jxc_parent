package com.jxc.employment_center.dao;

import java.util.List;
import java.util.Map;

import com.jxc.common.bean.AuthorizationUser;
import com.jxc.employment_center.entity.LongJob;

public interface LongJobDao {

	/**
	 * 添加长期job
	 */
	void insertLongJob(LongJob longJob);


	/**
	 * 根据条件查询长期job
	 */
	List<LongJob> queryLongJobList(Map<String, Object> condition);

    
	/**
	 * 修改长期job
	 * @param longJob
	 * @return 
	 */

	void updateLongJob(AuthorizationUser user, LongJob longJob);

}
