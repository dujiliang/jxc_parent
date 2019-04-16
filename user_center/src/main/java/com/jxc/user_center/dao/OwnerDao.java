package com.jxc.user_center.dao;

import java.util.List;
import java.util.Map;

import com.jxc.user_center.entity.Owner;



public interface OwnerDao {

	List<Owner> queryOwnerListByCondition(Map<String, Object> condition);

	void insertOwnerInfo(Owner owner);

	
}
