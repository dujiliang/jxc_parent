package com.jxc.user_center.dao;

import com.jxc.common.entity.ChildAccount;
import com.jxc.user_center.entity.Tenantry;
import com.jxc.user_center.entity.TenantryUser;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface TenantryAccountDao {


    @Insert("insert into jxc_user(phone,password,role_type) value(#{phone},#{password},#{roleType})")
    public void insertUser(@Param("phone") String phone, @Param("password") String password, @Param("roleType") int roleType);

    @Insert("insert into jxc_tenantry_user(tenantry_user_id,tenantry_user_name,tenantry_id) select user_id,#{tenantryUserName},#{tenantryId} from jxc_user where phone = #{phone}")
    public void insertTenantryUserAccount(@Param("phone") String phone, @Param("tenantryId") String tenantryId,@Param("tenantryUserName")String tenantryUserName);

    @Select("select child_id,owner_id,driver_id,status,work_state,machine_id from jxc_child_account where owner_id = #{ownerId}")
    public List<ChildAccount> getChildAccountList(@Param("ownerId")long ownerId);

    //承租方管理员
	public List<TenantryUser> queryTenantryAdminByCondition(Map<String, Object> condition);

}
