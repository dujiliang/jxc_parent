package com.jxc.employment_center.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;

/**
 * 司机简历表
 * 
 * 
 */
@TableName("jxc_driver_resume")
public class DriverResume implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer resumeId;
	/**
	 * 
	 */
	private String name;
	/**
	 * 
	 */
	private String phone;
	/**
	 * 
	 */
	private String log;
	/**
	 * 工作区域
	 */
	private String workArea;
	/**
	 * 
	 */
	private Integer machineType;
	/**
	 * 
	 */
	private String driverYear;
	/**
	 * 薪资待遇
	 */
	private BigDecimal payMoney;
	/**
	 * 薪资结算方式；0：按月结，1：面议
	 */
	private Integer payment;
	/**
	 * 福利要求
	 */
	private String welfare;
	/**
	 * 个人介绍
	 */
	private String personIntroduce;
	/**
	 * 求职状态
	 */
	private String forJobType;
	/**
	 * 简历状态;0:开启，1：失效
	 */
	private Integer status;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 更新时间
	 */
	private Date updateTime;
	
	/**
	 * 司机id
	 */
	private Long driverId;

	/**
	 * 设置：
	 */
	public void setResumeId(Integer resumeId) {
		this.resumeId = resumeId;
	}
	/**
	 * 获取：
	 */
	public Integer getResumeId() {
		return resumeId;
	}
	/**
	 * 设置：
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * 获取：
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * 设置：
	 */
	public void setLog(String log) {
		this.log = log;
	}
	/**
	 * 获取：
	 */
	public String getLog() {
		return log;
	}
	/**
	 * 设置：工作区域
	 */
	public void setWorkArea(String workArea) {
		this.workArea = workArea;
	}
	/**
	 * 获取：工作区域
	 */
	public String getWorkArea() {
		return workArea;
	}
	/**
	 * 设置：
	 */
	public void setMachineType(Integer machineType) {
		this.machineType = machineType;
	}
	/**
	 * 获取：
	 */
	public Integer getMachineType() {
		return machineType;
	}
	/**
	 * 设置：
	 */
	public void setDriverYear(String driverYear) {
		this.driverYear = driverYear;
	}
	/**
	 * 获取：
	 */
	public String getDriverYear() {
		return driverYear;
	}
	/**
	 * 设置：薪资待遇
	 */
	public void setPayMoney(BigDecimal payMoney) {
		this.payMoney = payMoney;
	}
	/**
	 * 获取：薪资待遇
	 */
	public BigDecimal getPayMoney() {
		return payMoney;
	}
	/**
	 * 设置：薪资结算方式；0：按月结，1：面议
	 */
	public void setPayment(Integer payment) {
		this.payment = payment;
	}
	/**
	 * 获取：薪资结算方式；0：按月结，1：面议
	 */
	public Integer getPayment() {
		return payment;
	}
	/**
	 * 设置：福利要求
	 */
	public void setWelfare(String welfare) {
		this.welfare = welfare;
	}
	/**
	 * 获取：福利要求
	 */
	public String getWelfare() {
		return welfare;
	}
	/**
	 * 设置：个人介绍
	 */
	public void setPersonIntroduce(String personIntroduce) {
		this.personIntroduce = personIntroduce;
	}
	/**
	 * 获取：个人介绍
	 */
	public String getPersonIntroduce() {
		return personIntroduce;
	}
	/**
	 * 设置：求职状态
	 */
	public void setForJobType(String forJobType) {
		this.forJobType = forJobType;
	}
	/**
	 * 获取：求职状态
	 */
	public String getForJobType() {
		return forJobType;
	}
	/**
	 * 设置：简历状态;0:开启，1：失效
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：简历状态;0:开启，1：失效
	 */
	public Integer getStatus() {
		return status;
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
	 * 设置：更新时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：更新时间
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
	
	/**
	 * 获取：司机id
	 */
	public Long getDriverId() {
		return driverId;
	}
	
	/**
	 * 设置：司机id
	 */
	public void setDriverId(Long driverId) {
		this.driverId = driverId;
	}
	
	
}
