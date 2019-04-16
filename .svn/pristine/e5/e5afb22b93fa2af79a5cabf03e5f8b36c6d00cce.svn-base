package com.jxc.user_center.dao;

import java.util.List;
import java.util.Map;


import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.jxc.user_center.entity.User;



public interface UserDao {
    
	void updateUser(User user);

	@Select("select count(1) from jxc_user where phone = #{phone}")
	int phoneCheck(String phone);
	
    List<User> queryUserListByCondition(Map<String, Object> condtion);

	
	@Update("update jxc_user set head_img = #{url} where user_id = #{userId}")
	int updateHeadImg(@Param("url")String url,@Param("userId")Long userId);
	
	void insert(User user);

	void updatePwd(User user);
    
}
