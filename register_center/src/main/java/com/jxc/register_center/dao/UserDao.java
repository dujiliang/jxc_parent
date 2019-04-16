package com.jxc.register_center.dao;

import java.util.List;
import java.util.Map;

import com.jxc.register_center.entity.User;



public interface UserDao {
    
    List<User> queryUserListByCondition(Map<String, Object> condtion);

	void insert(User user);

	void updatePwd(User user);
    
}
