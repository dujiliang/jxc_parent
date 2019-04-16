package com.jxc.user_center.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 */
@TableName("jxc_cash_apply")
public class CashApply implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 提现申请id
	 */
	@TableId
	private Long applyId;
	/**
	 * 用户id
	 */
	private Long userId;
	/**
	 * 金额（分）
	 */
	private Integer applyCount;
	/**
	 * 审核状态
	 */
	private Integer confirmState;
	/**
	 * 支付状态
	 */
	private Integer payState;
	/**
	 * 支付类型（银行卡，微信，支付宝。。）
	 */
	private Integer payType;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 审核时间
	 */
	private Date confirmTime;
	/**
	 * 完结时间
	 */
	private Date endTime;
	/**
	 * 审核人
	 */
	private Long confirmor;

	/**
	 * 设置：提现申请id
	 */
	public void setApplyId(Long applyId) {
		this.applyId = applyId;
	}
	/**
	 * 获取：提现申请id
	 */
	public Long getApplyId() {
		return applyId;
	}
	/**
	 * 设置：用户id
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * 获取：用户id
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * 设置：金额（分）
	 */
	public void setApplyCount(Integer applyCount) {
		this.applyCount = applyCount;
	}
	/**
	 * 获取：金额（分）
	 */
	public Integer getApplyCount() {
		return applyCount;
	}
	/**
	 * 设置：审核状态
	 */
	public void setConfirmState(Integer confirmState) {
		this.confirmState = confirmState;
	}
	/**
	 * 获取：审核状态
	 */
	public Integer getConfirmState() {
		return confirmState;
	}
	/**
	 * 设置：支付状态
	 */
	public void setPayState(Integer payState) {
		this.payState = payState;
	}
	/**
	 * 获取：支付状态
	 */
	public Integer getPayState() {
		return payState;
	}
	/**
	 * 设置：支付类型（银行卡，微信，支付宝。。）
	 */
	public void setPayType(Integer payType) {
		this.payType = payType;
	}
	/**
	 * 获取：支付类型（银行卡，微信，支付宝。。）
	 */
	public Integer getPayType() {
		return payType;
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
	 * 设置：完结时间
	 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	/**
	 * 获取：完结时间
	 */
	public Date getEndTime() {
		return endTime;
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
}
