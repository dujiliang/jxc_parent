package com.jxc.user_center.dao;

import java.util.List;
import java.util.Map;

import com.jxc.user_center.entity.Confirm;

public interface ConfirmDao {
	
	//个人认证
	void insertComfirm(Confirm personalConfirm);
    //查出审核信息
	List<Confirm> selectConfirmInfo(Map<String, Object> condition);

}
