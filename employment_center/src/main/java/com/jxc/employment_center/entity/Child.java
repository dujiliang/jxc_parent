package com.jxc.employment_center.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 */
@TableName("jxc_child")
public class Child implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 子账号id
	 */
	@TableId
	private Long childId;
	/**
	 * 机主id
	 */
	private Long ownerId;
	/**
	 * 当前使用司机id
	 */
	private Long driverId;
	/**
	 * 状态
	 */
	private Integer status;
	/**
	 * 工作状态
	 */
	private Integer workState;
	/**
	 * 机械id
	 */
	private Long machineId;

	/**
	 * 设置：子账号id
	 */
	public void setChildId(Long childId) {
		this.childId = childId;
	}
	/**
	 * 获取：子账号id
	 */
	public Long getChildId() {
		return childId;
	}
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
	 * 设置：当前使用司机id
	 */
	public void setDriverId(Long driverId) {
		this.driverId = driverId;
	}
	/**
	 * 获取：当前使用司机id
	 */
	public Long getDriverId() {
		return driverId;
	}
	/**
	 * 设置：状态
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：状态
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * 设置：工作状态
	 */
	public void setWorkState(Integer workState) {
		this.workState = workState;
	}
	/**
	 * 获取：工作状态
	 */
	public Integer getWorkState() {
		return workState;
	}
	/**
	 * 设置：机械id
	 */
	public void setMachineId(Long machineId) {
		this.machineId = machineId;
	}
	/**
	 * 获取：机械id
	 */
	public Long getMachineId() {
		return machineId;
	}
}
