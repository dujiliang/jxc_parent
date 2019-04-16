package com.jxc.user_center.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * 
 * 
 */
@TableName("jxc_tenantry_user")
public class TenantryUser implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 承租方管理员id
	 */
	@TableId
	private Long tenantryUserId;
	/**
	 * 
	 */
	private String tenantryUserName;
	
	
	private Long tenantryId;
	
	private String phone;
	
	private String headImg;

	/**
	 * 设置：承租方管理员id
	 */
	public void setTenantryUserId(Long tenantryUserId) {
		this.tenantryUserId = tenantryUserId;
	}
	/**
	 * 获取：承租方管理员id
	 */
	public Long getTenantryUserId() {
		return tenantryUserId;
	}
	/**
	 * 设置：
	 */
	public void setTenantryUserName(String tenantryUserName) {
		this.tenantryUserName = tenantryUserName;
	}
	/**
	 * 获取：
	 */
	public String getTenantryUserName() {
		return tenantryUserName;
	}
	public Long getTenantryId() {
		return tenantryId;
	}
	public void setTenantryId(Long tenantryId) {
		this.tenantryId = tenantryId;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getHeadImg() {
		return headImg;
	}
	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}
	
	
	
	
}
