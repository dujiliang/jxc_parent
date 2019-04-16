package com.jxc.employment_center.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 临时司机招聘实体
 */
@TableName("jxc_short_job")
public class ShortJob implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 短期职位主键
	 */
	@TableId
	private String jobId;
	/**
	 * 0:泥头车
	 */
	private Integer machineType;
	/**
	 * 驾龄要求
	 */
	private Integer driveYear;
	/**
	 * 招聘人数
	 */
	private Integer needNum;
	/**
	 * 年龄限制
	 */
	private Integer ageLimit;
	/**
	 * 工作时段(开始)
	 */
	private String workTimeStart;
	
	/**
	 * 工作时段(结束)
	 */
	private String workTimeEnd;
	/**
	 * 有效时间
	 */
	private Date effectiveDate;
	
	/**
	 * 有效时间
	 */
	private String effectiveDateStr;
	
	/**
	 * 联系人姓名
	 */
	private String contactName;
	/**
	 * 联系电话
	 */
	private String contactPhone;
	/**
	 * 计费规则
	 */
	private String accountRuler;
	/**
	 * 0：开启，1：失效
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
	 * areaId
	 */
	private Integer areaId;

	/**
	 * 设置：短期职位主键
	 */
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	/**
	 * 获取：短期职位主键
	 */
	public String getJobId() {
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
	 * 设置：驾龄要求
	 */
	public void setDriveYear(Integer driveYear) {
		this.driveYear = driveYear;
	}
	/**
	 * 获取：驾龄要求
	 */
	public Integer getDriveYear() {
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
	 * 设置：年龄限制
	 */
	public void setAgeLimit(Integer ageLimit) {
		this.ageLimit = ageLimit;
	}
	/**
	 * 获取：年龄限制
	 */
	public Integer getAgeLimit() {
		return ageLimit;
	}
	
	/**
	 * 设置：有效时间
	 */
	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
	/**
	 * 获取：有效时间
	 */
	public Date getEffectiveDate() {
		return effectiveDate;
	}
	/**
	 * 设置：联系人姓名
	 */
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	/**
	 * 获取：联系人姓名
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
	
	public String getAccountRuler() {
		return accountRuler;
	}
	public void setAccountRuler(String accountRuler) {
		this.accountRuler = accountRuler;
	}
	/**
	 * 设置：0：开启，1：失效
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：0：开启，1：失效
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * 设置：发布时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
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
	
	public Integer getAreaId() {
		return areaId;
	}
	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}
	public String getWorkTimeStart() {
		return workTimeStart;
	}
	public void setWorkTimeStart(String workTimeStart) {
		this.workTimeStart = workTimeStart;
	}
	public String getWorkTimeEnd() {
		return workTimeEnd;
	}
	public void setWorkTimeEnd(String workTimeEnd) {
		this.workTimeEnd = workTimeEnd;
	}
	public String getEffectiveDateStr() {
		return effectiveDateStr;
	}
	public void setEffectiveDateStr(String effectiveDateStr) {
		this.effectiveDateStr = effectiveDateStr;
	}
	
	
	
}
