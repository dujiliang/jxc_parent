package com.jxc.user_center.dao;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.jxc.user_center.entity.ChildAccount;

import java.util.List;
import java.util.Map;

@Mapper
public interface ChildAccountDao {


    @Insert("insert into jxc_user(phone,password,role_type,creator,create_time) value(#{phone},#{password},#{roleType},#{creator},now())")
    public void insertUser(@Param("phone") String phone, @Param("password") String password, @Param("roleType") int roleType,@Param("creator")long creator);

    @Insert("insert into jxc_child_account(child_id,owner_id) select user_id,#{ownerId} from jxc_user where phone = #{phone}")
    public void insertChildAccount(@Param("phone") String phone, @Param("ownerId") String ownerId);

    @Select({"select c.child_id as childId,u.phone,ifnull(m.machine_card_no,'') as machineCardNo ",
            "from jxc_child_account c ",
            "left join jxc_user u on c.child_id = u.user_id ",
            "left join jxc_machine m on c.machine_id = m.machine_id ",
            "where c.owner_id = #{ownerId} ",
            "order by u.create_time"})
    public List<Map<String,Object>> getChildAccountList(@Param("ownerId")long ownerId);

	public List<ChildAccount> queryChildAccountListByCondition(Map<String, Object> condition);

	

}
