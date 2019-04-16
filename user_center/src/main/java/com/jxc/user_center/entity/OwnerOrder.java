package com.jxc.user_center.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 */
@TableName("jxc_owner_order")
public class OwnerOrder implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 订单id
	 */
	@TableId
	private Long orderId;
	/**
	 * 所属项目的id
	 */
	private Long projectId;
	/**
	 * 机主id
	 */
	private Long ownerId;
	/**
	 * 子账号id
	 */
	private Long childId;
	/**
	 * 参与订单的车辆id
	 */
	private Long machineId;
	/**
	 * 订单状态
	 */
	private Integer orderState;
	/**
	 * 订单预计开始时间（项目开始时间）
	 */
	private Date orderPreStartTime;
	/**
	 * 订单实际开始时间
	 */
	private Date orderRealStartTime;
	/**
	 * 订单预计结束时间（项目截止时间）
	 */
	private Date orderPreEndTime;
	/**
	 * 订单实际结束时间
	 */
	private Date orderRealEndTime;
	/**
	 * 订单类型（是接单还是听单）
	 */
	private Integer orderType;

	/**
	 * 设置：订单id
	 */
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	/**
	 * 获取：订单id
	 */
	public Long getOrderId() {
		return orderId;
	}
	/**
	 * 设置：所属项目的id
	 */
	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}
	/**
	 * 获取：所属项目的id
	 */
	public Long getProjectId() {
		return projectId;
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
	 * 设置：参与订单的车辆id
	 */
	public void setMachineId(Long machineId) {
		this.machineId = machineId;
	}
	/**
	 * 获取：参与订单的车辆id
	 */
	public Long getMachineId() {
		return machineId;
	}
	/**
	 * 设置：订单状态
	 */
	public void setOrderState(Integer orderState) {
		this.orderState = orderState;
	}
	/**
	 * 获取：订单状态
	 */
	public Integer getOrderState() {
		return orderState;
	}
	/**
	 * 设置：订单预计开始时间（项目开始时间）
	 */
	public void setOrderPreStartTime(Date orderPreStartTime) {
		this.orderPreStartTime = orderPreStartTime;
	}
	/**
	 * 获取：订单预计开始时间（项目开始时间）
	 */
	public Date getOrderPreStartTime() {
		return orderPreStartTime;
	}
	/**
	 * 设置：订单实际开始时间
	 */
	public void setOrderRealStartTime(Date orderRealStartTime) {
		this.orderRealStartTime = orderRealStartTime;
	}
	/**
	 * 获取：订单实际开始时间
	 */
	public Date getOrderRealStartTime() {
		return orderRealStartTime;
	}
	/**
	 * 设置：订单预计结束时间（项目截止时间）
	 */
	public void setOrderPreEndTime(Date orderPreEndTime) {
		this.orderPreEndTime = orderPreEndTime;
	}
	/**
	 * 获取：订单预计结束时间（项目截止时间）
	 */
	public Date getOrderPreEndTime() {
		return orderPreEndTime;
	}
	/**
	 * 设置：订单实际结束时间
	 */
	public void setOrderRealEndTime(Date orderRealEndTime) {
		this.orderRealEndTime = orderRealEndTime;
	}
	/**
	 * 获取：订单实际结束时间
	 */
	public Date getOrderRealEndTime() {
		return orderRealEndTime;
	}
	/**
	 * 设置：订单类型（是接单还是听单）
	 */
	public void setOrderType(Integer orderType) {
		this.orderType = orderType;
	}
	/**
	 * 获取：订单类型（是接单还是听单）
	 */
	public Integer getOrderType() {
		return orderType;
	}
}
