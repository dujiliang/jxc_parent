package com.jxc.user_center.entity;

import java.io.Serializable;

import com.mysql.fabric.xmlrpc.base.Data;

public class Confirm implements Serializable{
	
	/**
	 * 承租方个人认证
	 */
	private static final long serialVersionUID = 1L;

	private Integer confirmId;
	
	private String realName;
	
	private String cardCode;
	
	private String phone;
	
	private String cardImgFront;
	
	private String cardImgBack;
	
	private String faceImg;
	
	private Integer confirmStatus;
	
	/**
	 * 法人姓名
	 */
	private String legalName;
	/**
	 * 工商注册号
	 */
	private String businessNum;
	
	/**
	 * 企业名称
	 */	
	private String companyName;

	/**
	 * 工地负责人
	 */
	private String siteManager;
	
	/**
	 * 营业执照
	 */
	
	private String businessLicense;
	
	/**
	 * 承租方id
	 */
	private Long tenantryId;
	
	private Integer confirmType;
	
	private Data createTime;
	
	private String  createTimeStr;
	
	private Data updateTime;
	
	private String updateTimeStr;


	public Integer getConfirmId() {
		return confirmId;
	}

	public void setConfirmId(Integer confirmId) {
		this.confirmId = confirmId;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getCardCode() {
		return cardCode;
	}

	public void setCardCode(String cardCode) {
		this.cardCode = cardCode;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCardImgFront() {
		return cardImgFront;
	}

	public void setCardImgFront(String cardImgFront) {
		this.cardImgFront = cardImgFront;
	}

	public String getCardImgBack() {
		return cardImgBack;
	}

	public void setCardImgBack(String cardImgBack) {
		this.cardImgBack = cardImgBack;
	}

	public Integer getConfirmStatus() {
		return confirmStatus;
	}

	public void setConfirmStatus(Integer confirmStatus) {
		this.confirmStatus = confirmStatus;
	}
	

	public String getLegalName() {
		return legalName;
	}

	public void setLegalName(String legalName) {
		this.legalName = legalName;
	}

	public String getBusinessNum() {
		return businessNum;
	}

	public void setBusinessNum(String businessNum) {
		this.businessNum = businessNum;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getSiteManager() {
		return siteManager;
	}

	public void setSiteManager(String siteManager) {
		this.siteManager = siteManager;
	}

	public String getBusinessLicense() {
		return businessLicense;
	}

	public void setBusinessLicense(String businessLicense) {
		this.businessLicense = businessLicense;
	}


	public Long getTenantryId() {
		return tenantryId;
	}

	public void setTenantryId(Long tenantryId) {
		this.tenantryId = tenantryId;
	}

	public Data getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Data createTime) {
		this.createTime = createTime;
	}

	public Data getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Data updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getConfirmType() {
		return confirmType;
	}

	public void setConfirmType(Integer confirmType) {
		this.confirmType = confirmType;
	}

	public String getFaceImg() {
		return faceImg;
	}

	public void setFaceImg(String faceImg) {
		this.faceImg = faceImg;
	}

	public String getCreateTimeStr() {
		return createTimeStr;
	}

	public void setCreateTimeStr(String createTimeStr) {
		this.createTimeStr = createTimeStr;
	}

	public String getUpdateTimeStr() {
		return updateTimeStr;
	}

	public void setUpdateTimeStr(String updateTimeStr) {
		this.updateTimeStr = updateTimeStr;
	}
	
	
	

}
