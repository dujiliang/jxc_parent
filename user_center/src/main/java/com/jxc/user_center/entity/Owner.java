package com.jxc.user_center.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 机主
 * 
 */
@TableName("jxc_owner")
public class Owner implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 机主id
	 */
	@TableId
	private Long ownerId;
	/**
	 * 身份证
	 */
	private String cardCode;
	/**
	 * 身份证背面图片
	 */
	private String cardCodeImgBack;
	/**
	 * 身份证正面图片
	 */
	private String cardCodeImgFront;
	/**
	 * 审核状态
	 */
	private String confirmState;
	/**
	 * 机主用户名
	 */
	private String ownerNickName;
	/**
	 * 机主头像
	 */
	private String ownerImg;
	/**
	 * 真实名称
	 */
	private String ownerRealName;
	/**
	 * 账号状态
	 */
	private String status;
	/**
	 * 工作状态
	 */
	private String workState;
	/**
	 * 审核人
	 */
	private Long confirmor;
	/**
	 * 审核时间
	 */
	private Date confirmTime;
	
	private String confirmTimeStr;
	/**
	 * 创建时间
	 */
	private Date createTime;
	
	private String  createTimeStr;
	/**
	 * 创建人
	 */
	private Long creator;
	/**
	 * 修改时间
	 */
	private Date updateTime;
	
	private String updateTimeStr;
	/**
	 * 修改人
	 */
	private Long updator;
	/**
	 * 删除时间
	 */
	private Date deleteTime;
	
	private String deleteTimeStr;
	/**
	 * 删除人
	 */
	private Long deletor;
	
	private String phone;

	/**
	 * 设置：机主id
	 */
	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}
	/**
	 * 获取：机主id
	 */
	public Long getOwnerId() {
		return ownerId;
	}
	/**
	 * 设置：身份证
	 */
	public void setCardCode(String cardCode) {
		this.cardCode = cardCode;
	}
	/**
	 * 获取：身份证
	 */
	public String getCardCode() {
		return cardCode;
	}
	/**
	 * 设置：身份证背面图片
	 */
	public void setCardCodeImgBack(String cardCodeImgBack) {
		this.cardCodeImgBack = cardCodeImgBack;
	}
	/**
	 * 获取：身份证背面图片
	 */
	public String getCardCodeImgBack() {
		return cardCodeImgBack;
	}
	/**
	 * 设置：身份证正面图片
	 */
	public void setCardCodeImgFront(String cardCodeImgFront) {
		this.cardCodeImgFront = cardCodeImgFront;
	}
	/**
	 * 获取：身份证正面图片
	 */
	public String getCardCodeImgFront() {
		return cardCodeImgFront;
	}
	/**
	 * 设置：审核状态
	 */
	public void setConfirmState(String confirmState) {
		this.confirmState = confirmState;
	}
	/**
	 * 获取：审核状态
	 */
	public String getConfirmState() {
		return confirmState;
	}
	/**
	 * 设置：机主用户名
	 */
	public void setOwnerNickName(String ownerNickName) {
		this.ownerNickName = ownerNickName;
	}
	/**
	 * 获取：机主用户名
	 */
	public String getOwnerNickName() {
		return ownerNickName;
	}
	/**
	 * 设置：机主头像
	 */
	public void setOwnerImg(String ownerImg) {
		this.ownerImg = ownerImg;
	}
	/**
	 * 获取：机主头像
	 */
	public String getOwnerImg() {
		return ownerImg;
	}
	/**
	 * 设置：真实名称
	 */
	public void setOwnerRealName(String ownerRealName) {
		this.ownerRealName = ownerRealName;
	}
	/**
	 * 获取：真实名称
	 */
	public String getOwnerRealName() {
		return ownerRealName;
	}
	/**
	 * 设置：账号状态
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 获取：账号状态
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * 设置：工作状态
	 */
	public void setWorkState(String workState) {
		this.workState = workState;
	}
	/**
	 * 获取：工作状态
	 */
	public String getWorkState() {
		return workState;
	}
	/**
	 * 设置：审核人
	 */
	public void setConfirmor(Long confirmor) {
		this.confirmor = confirmor;
	}
	/**
	 * 获取：审核人
	 */
	public Long getConfirmor() {
		return confirmor;
	}
	/**
	 * 设置：审核时间
	 */
	public void setConfirmTime(Date confirmTime) {
		this.confirmTime = confirmTime;
	}
	/**
	 * 获取：审核时间
	 */
	public Date getConfirmTime() {
		return confirmTime;
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
	 * 设置：创建人
	 */
	public void setCreator(Long creator) {
		this.creator = creator;
	}
	/**
	 * 获取：创建人
	 */
	public Long getCreator() {
		return creator;
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
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
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
	
	public String getUpdateTimeStr() {
		return updateTimeStr;
	}
	public void setUpdateTimeStr(String updateTimeStr) {
		this.updateTimeStr = updateTimeStr;
	}
	
	public String getDeleteTimeStr() {
		return deleteTimeStr;
	}
	public void setDeleteTimeStr(String deleteTimeStr) {
		this.deleteTimeStr = deleteTimeStr;
	}
	
	
}
