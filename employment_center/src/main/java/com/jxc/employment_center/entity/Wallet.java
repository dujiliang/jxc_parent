package com.jxc.employment_center.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * 
 * 
 */
@TableName("jxc_wallet")
public class Wallet implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 钱包id
	 */
	@TableId
	private Long walletId;
	/**
	 * 用户id
	 */
	private Long userId;
	/**
	 * 角色类型
	 */
	private Integer roleType;
	/**
	 * 状态（预留）
	 */
	private Integer status;
	/**
	 * 总金额（分）
	 */
	private Integer totalCount;
	/**
	 * 冻结金额（分）
	 */
	private Integer lockCount;
	/**
	 * 可用金额(分)
	 */
	private Integer availableCount;

	/**
	 * 设置：钱包id
	 */
	public void setWalletId(Long walletId) {
		this.walletId = walletId;
	}
	/**
	 * 获取：钱包id
	 */
	public Long getWalletId() {
		return walletId;
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
	 * 设置：角色类型
	 */
	public void setRoleType(Integer roleType) {
		this.roleType = roleType;
	}
	/**
	 * 获取：角色类型
	 */
	public Integer getRoleType() {
		return roleType;
	}
	/**
	 * 设置：状态（预留）
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：状态（预留）
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * 设置：总金额（分）
	 */
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	/**
	 * 获取：总金额（分）
	 */
	public Integer getTotalCount() {
		return totalCount;
	}
	/**
	 * 设置：冻结金额（分）
	 */
	public void setLockCount(Integer lockCount) {
		this.lockCount = lockCount;
	}
	/**
	 * 获取：冻结金额（分）
	 */
	public Integer getLockCount() {
		return lockCount;
	}
	/**
	 * 设置：可用金额(分)
	 */
	public void setAvailableCount(Integer availableCount) {
		this.availableCount = availableCount;
	}
	/**
	 * 获取：可用金额(分)
	 */
	public Integer getAvailableCount() {
		return availableCount;
	}
}
