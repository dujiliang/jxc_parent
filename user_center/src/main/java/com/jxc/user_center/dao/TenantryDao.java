package com.jxc.user_center.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.jxc.user_center.entity.Confirm;
import com.jxc.user_center.entity.Tenantry;


/**
 * 
 * 用户中心--承租方用户信息
 *
 */
public interface TenantryDao {
    
   
	List<Tenantry> queryTenantryListByCondition(Map<String, Object> condition);


    //修改承租方信息
	void updateTenantryInfo(@Param("tenantry")Map<String, Object> map);

	
}
