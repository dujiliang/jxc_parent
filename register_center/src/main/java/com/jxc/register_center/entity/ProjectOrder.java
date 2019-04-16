package com.jxc.register_center.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 */
@TableName("jxc_project_order")
public class ProjectOrder implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 项目订单id
	 */
	@TableId
	private Long orderId;
	/**
	 * 项目id
	 */
	private Long projectId;
	/**
	 * 机械类型
	 */
	private Integer machineType;
	/**
	 * 消纳场id
	 */
	private Long dealFieldId;
	/**
	 * 预计公里数
	 */
	private String orderPreMileage;
	/**
	 * 预计单价
	 */
	private Integer orderPreUnitPrice;
	/**
	 * 预计总工程量
	 */
	private BigDecimal orderPreTotalQuantity;
	/**
	 * 土方类型
	 */
	private Integer earthType;
	/**
	 * 预计车辆数
	 */
	private Integer orderPreMachineCount;
	/**
	 * 结算方式
	 */
	private Integer orderAccountMethod;
	/**
	 * 订单预计开始时间
	 */
	private Date orderStartTime;
	/**
	 * 订单预计结束时间
	 */
	private Date orderEndTime;
	/**
	 * 每天工作开始点
	 */
	private String orderWorkStartTime;
	/**
	 * 每天工作结束点
	 */
	private String orderWorkEndTime;
	/**
	 * 挖机数量
	 */
	private Integer digMachineCount;
	/**
	 * 管理费用类型
	 */
	private Integer cityManagementCostType;
	/**
	 * 审核状态
	 */
	private Integer confirmState;
	/**
	 * 实际参与的车辆数（车次）
	 */
	private Integer orderRealMachineCount;

	/**
	 * 设置：项目订单id
	 */
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	/**
	 * 获取：项目订单id
	 */
	public Long getOrderId() {
		return orderId;
	}
	/**
	 * 设置：项目id
	 */
	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}
	/**
	 * 获取：项目id
	 */
	public Long getProjectId() {
		return projectId;
	}
	/**
	 * 设置：机械类型
	 */
	public void setMachineType(Integer machineType) {
		this.machineType = machineType;
	}
	/**
	 * 获取：机械类型
	 */
	public Integer getMachineType() {
		return machineType;
	}
	/**
	 * 设置：消纳场id
	 */
	public void setDealFieldId(Long dealFieldId) {
		this.dealFieldId = dealFieldId;
	}
	/**
	 * 获取：消纳场id
	 */
	public Long getDealFieldId() {
		return dealFieldId;
	}
	/**
	 * 设置：预计公里数
	 */
	public void setOrderPreMileage(String orderPreMileage) {
		this.orderPreMileage = orderPreMileage;
	}
	/**
	 * 获取：预计公里数
	 */
	public String getOrderPreMileage() {
		return orderPreMileage;
	}
	/**
	 * 设置：预计单价
	 */
	public void setOrderPreUnitPrice(Integer orderPreUnitPrice) {
		this.orderPreUnitPrice = orderPreUnitPrice;
	}
	/**
	 * 获取：预计单价
	 */
	public Integer getOrderPreUnitPrice() {
		return orderPreUnitPrice;
	}
	/**
	 * 设置：预计总工程量
	 */
	public void setOrderPreTotalQuantity(BigDecimal orderPreTotalQuantity) {
		this.orderPreTotalQuantity = orderPreTotalQuantity;
	}
	/**
	 * 获取：预计总工程量
	 */
	public BigDecimal getOrderPreTotalQuantity() {
		return orderPreTotalQuantity;
	}
	/**
	 * 设置：土方类型
	 */
	public void setEarthType(Integer earthType) {
		this.earthType = earthType;
	}
	/**
	 * 获取：土方类型
	 */
	public Integer getEarthType() {
		return earthType;
	}
	/**
	 * 设置：预计车辆数
	 */
	public void setOrderPreMachineCount(Integer orderPreMachineCount) {
		this.orderPreMachineCount = orderPreMachineCount;
	}
	/**
	 * 获取：预计车辆数
	 */
	public Integer getOrderPreMachineCount() {
		return orderPreMachineCount;
	}
	/**
	 * 设置：结算方式
	 */
	public void setOrderAccountMethod(Integer orderAccountMethod) {
		this.orderAccountMethod = orderAccountMethod;
	}
	/**
	 * 获取：结算方式
	 */
	public Integer getOrderAccountMethod() {
		return orderAccountMethod;
	}
	/**
	 * 设置：订单预计开始时间
	 */
	public void setOrderStartTime(Date orderStartTime) {
		this.orderStartTime = orderStartTime;
	}
	/**
	 * 获取：订单预计开始时间
	 */
	public Date getOrderStartTime() {
		return orderStartTime;
	}
	/**
	 * 设置：订单预计结束时间
	 */
	public void setOrderEndTime(Date orderEndTime) {
		this.orderEndTime = orderEndTime;
	}
	/**
	 * 获取：订单预计结束时间
	 */
	public Date getOrderEndTime() {
		return orderEndTime;
	}
	/**
	 * 设置：每天工作开始点
	 */
	public void setOrderWorkStartTime(String orderWorkStartTime) {
		this.orderWorkStartTime = orderWorkStartTime;
	}
	/**
	 * 获取：每天工作开始点
	 */
	public String getOrderWorkStartTime() {
		return orderWorkStartTime;
	}
	/**
	 * 设置：每天工作结束点
	 */
	public void setOrderWorkEndTime(String orderWorkEndTime) {
		this.orderWorkEndTime = orderWorkEndTime;
	}
	/**
	 * 获取：每天工作结束点
	 */
	public String getOrderWorkEndTime() {
		return orderWorkEndTime;
	}
	/**
	 * 设置：挖机数量
	 */
	public void setDigMachineCount(Integer digMachineCount) {
		this.digMachineCount = digMachineCount;
	}
	/**
	 * 获取：挖机数量
	 */
	public Integer getDigMachineCount() {
		return digMachineCount;
	}
	/**
	 * 设置：管理费用类型
	 */
	public void setCityManagementCostType(Integer cityManagementCostType) {
		this.cityManagementCostType = cityManagementCostType;
	}
	/**
	 * 获取：管理费用类型
	 */
	public Integer getCityManagementCostType() {
		return cityManagementCostType;
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
	 * 设置：实际参与的车辆数（车次）
	 */
	public void setOrderRealMachineCount(Integer orderRealMachineCount) {
		this.orderRealMachineCount = orderRealMachineCount;
	}
	/**
	 * 获取：实际参与的车辆数（车次）
	 */
	public Integer getOrderRealMachineCount() {
		return orderRealMachineCount;
	}
}
