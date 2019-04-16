package com.jxc.employment_center.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 长期司机招聘实体
 * 
 */
@TableName("jxc_long_job")
public class LongJob implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer jobId;
	/**
	 * 0:泥头车
	 */
	private Integer machineType;
	/**
	 * 驾龄
	 */
	private String driveYear;
	/**
	 * 招聘人数
	 */
	private Integer needNum;
	/**
	 * 工程类型
	 */
	private String projectType;
	/**
	 * 工作时间
	 */
	private String workTime;
	/**
	 * 薪资待遇
	 */
	private String payMoney;
	/**
	 * 薪资结算方式；0：按月结，1：面议
	 */
	private Integer payment;
	/**
	 * 更多福利
	 */
	private String welfare;
	/**
	 * 截止日期
	 */
	private String endTime;
	/**
	 * 经验要求
	 */
	private String experience;
	/**
	 * 联系人名称
	 */
	private String contactName;
	/**
	 * 联系电话
	 */
	private String contactPhone;
	/**
	 * 发布状态,0:开启，1：失效
	 */
	private Integer status;
	/**
	 * 发布时间
	 */
	private Date createTime;
	/**
	 * 更新时间
	 */
	private Date updateTime;
	
	/**
	 * 机主id
	 */
	private Long ownerId;

	/**
	 * 设置：
	 */
	public void setJobId(Integer jobId) {
		this.jobId = jobId;
	}
	/**
	 * 获取：
	 */
	public Integer getJobId() {
		return jobId;
	}
	/**
	 * 设置：0:泥头车
	 */
	public void setMachineType(Integer machineType) {
		this.machineType = machineType;
	}
	/**
	 * 获取：0:泥头车
	 */
	public Integer getMachineType() {
		return machineType;
	}
	/**
	 * 设置：驾龄
	 */
	public void setDriveYear(String driveYear) {
		this.driveYear = driveYear;
	}
	/**
	 * 获取：驾龄
	 */
	public String getDriveYear() {
		return driveYear;
	}
	/**
	 * 设置：招聘人数
	 */
	public void setNeedNum(Integer needNum) {
		this.needNum = needNum;
	}
	/**
	 * 获取：招聘人数
	 */
	public Integer getNeedNum() {
		return needNum;
	}
	/**
	 * 设置：工程类型
	 */
	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}
	/**
	 * 获取：工程类型
	 */
	public String getProjectType() {
		return projectType;
	}
	/**
	 * 设置：工作时间
	 */
	public void setWorkTime(String workTime) {
		this.workTime = workTime;
	}
	/**
	 * 获取：工作时间
	 */
	public String getWorkTime() {
		return workTime;
	}
	/**
	 * 设置：薪资待遇
	 */
	public void setPayMoney(String payMoney) {
		this.payMoney = payMoney;
	}
	/**
	 * 获取：薪资待遇
	 */
	public String getPayMoney() {
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
	 * 设置：更多福利
	 */
	public void setWelfare(String welfare) {
		this.welfare = welfare;
	}
	/**
	 * 获取：更多福利
	 */
	public String getWelfare() {
		return welfare;
	}
	/**
	 * 设置：截止日期
	 */
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	/**
	 * 获取：截止日期
	 */
	public String getEndTime() {
		return endTime;
	}
	/**
	 * 设置：经验要求
	 */
	public void setExperience(String experience) {
		this.experience = experience;
	}
	/**
	 * 获取：经验要求
	 */
	public String getExperience() {
		return experience;
	}
	/**
	 * 设置：联系人名称
	 */
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	/**
	 * 获取：联系人名称
	 */
	public String getContactName() {
		return contactName;
	}
	/**
	 * 设置：联系电话
	 */
	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}
	/**
	 * 获取：联系电话
	 */
	public String getContactPhone() {
		return contactPhone;
	}
	/**
	 * 设置：发布状态,0:开启，1：失效
	 */

	/**
	 * 设置：发布时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	/**
	 * 获取：状态
	 * @return
	 */
	public Integer getStatus() {
		return status;
	}
	
	/**
	 * 设置：状态
	 * @param status
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：发布时间
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
	 * 获取：机主id
	 */
	public Long getOwnerId() {
		return ownerId;
	}
	
	/**
	 * 设置：机主id
	 */
	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}
	
	
}
