package com.jxc.user_center.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 */
@TableName("jxc_tenantry")
public class Tenantry implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 承租人id
	 */
	@TableId
	private Long tenantryId;
	/**
	 * 身份证号
	 */
	private String cardCode;
	/**
	 * 身份证正面照
	 */
	private String cardImgFront;
	/**
	 * 身份证背面照片
	 */
	private String cardImgBack;
	/**
	 * 实名认证状态
	 */
	private String confirmState;
	/**
	 * 实名认证通过时间
	 */
	private Date confirmTime;
	
	private String confirmTimeStr;
	/**
	 * 真名
	 */
	private String realName;
	/**
	 * 创建时间
	 */
	private Date createTime;
	
	private String createTimeStr;
	/**
	 * 删除人
	 */
	private Long deletor;
	/**
	 * 删除时间
	 */
	private Date deleteTime;
	
	private String deleteTimeStr;
	/**
	 * 修改人
	 */
	private Long updator;
	/**
	 * 修改时间
	 */
	private Date updateTime;
	
	private String updateTimeStr;
	/**
	 * 头像
	 */
	private String tenantryImg;
	/**
	 * 电话号码
	 */
	private String phone;
	
/*
	private Integer confirmType;*/
	
	
	private Integer personConfirm;
	
	private Integer companyConfirm;
	

	/**
	 * 设置：承租人id
	 */
	public void setTenantryId(Long tenantryId) {
		this.tenantryId = tenantryId;
	}
	/**
	 * 获取：承租人id
	 */
	public Long getTenantryId() {
		return tenantryId;
	}
	/**
	 * 设置：身份证号
	 */
	public void setCardCode(String cardCode) {
		this.cardCode = cardCode;
	}
	/**
	 * 获取：身份证号
	 */
	public String getCardCode() {
		return cardCode;
	}
	/**
	 * 设置：身份证正面照
	 */
	public void setCardImgFront(String cardImgFront) {
		this.cardImgFront = cardImgFront;
	}
	/**
	 * 获取：身份证正面照
	 */
	public String getCardImgFront() {
		return cardImgFront;
	}
	/**
	 * 设置：身份证背面照片
	 */
	public void setCardImgBack(String cardImgBack) {
		this.cardImgBack = cardImgBack;
	}
	/**
	 * 获取：身份证背面照片
	 */
	public String getCardImgBack() {
		return cardImgBack;
	}
	/**
	 * 设置：实名认证状态
	 */
	public String getConfirmState() {
		return confirmState;
	}
	public void setConfirmState(String confirmState) {
		this.confirmState = confirmState;
	}
	/**
	 * 设置：实名认证通过时间
	 */
	public void setConfirmTime(Date confirmTime) {
		this.confirmTime = confirmTime;
	}
	
	/**
	 * 获取：实名认证通过时间
	 */
	public Date getConfirmTime() {
		return confirmTime;
	}
	/**
	 * 设置：真名
	 */
	public void setRealName(String realName) {
		this.realName = realName;
	}
	/**
	 * 获取：真名
	 */
	public String getRealName() {
		return realName;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：删除人
	 */
	public void setDeletor(Long deletor) {
		this.deletor = deletor;
	}
	/**
	 * 获取：删除人
	 */
	public Long getDeletor() {
		return deletor;
	}
	/**
	 * 设置：删除时间
	 */
	public void setDeleteTime(Date deleteTime) {
		this.deleteTime = deleteTime;
	}
	/**
	 * 获取：删除时间
	 */
	public Date getDeleteTime() {
		return deleteTime;
	}
	/**
	 * 设置：修改人
	 */
	public void setUpdator(Long updator) {
		this.updator = updator;
	}
	/**
	 * 获取：修改人
	 */
	public Long getUpdator() {
		return updator;
	}
	/**
	 * 设置：修改时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：修改时间
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
	/**
	 * 设置：头像
	 */
	public void setTenantryImg(String tenantryImg) {
		this.tenantryImg = tenantryImg;
	}
	/**
	 * 获取：头像
	 */
	public String getTenantryImg() {
		return tenantryImg;
	}
	
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	

	public Integer getPersonConfirm() {
		return personConfirm;
	}
	public void setPersonConfirm(Integer personConfirm) {
		this.personConfirm = personConfirm;
	}
	
	public Integer getCompanyConfirm() {
		return companyConfirm;
	}
	public void setCompanyConfirm(Integer companyConfirm) {
		this.companyConfirm = companyConfirm;
	}
	
	public String getConfirmTimeStr() {
		return confirmTimeStr;
	}
	public void setConfirmTimeStr(String confirmTimeStr) {
		this.confirmTimeStr = confirmTimeStr;
	}
	
	public String getCreateTimeStr() {
		return createTimeStr;
	}
	public void setCreateTimeStr(String createTimeStr) {
		this.createTimeStr = createTimeStr;
	}
	
	public String getDeleteTimeStr() {
		return deleteTimeStr;
	}
	public void setDeleteTimeStr(String deleteTimeStr) {
		this.deleteTimeStr = deleteTimeStr;
	}
	
	public String getUpdateTimeStr() {
		return updateTimeStr;
	}
	public void setUpdateTimeStr(String updateTimeStr) {
		this.updateTimeStr = updateTimeStr;
	}
	
	
	
}
