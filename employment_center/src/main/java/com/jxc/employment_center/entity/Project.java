package com.jxc.employment_center.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 */
@TableName("jxc_project")
public class Project implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 项目id
	 */
	@TableId
	private Long projectId;
	/**
	 * 项目名称
	 */
	private String projectName;
	/**
	 * 审核状态
	 */
	private Integer confirmState;
	/**
	 * 项目负责人
	 */
	private String projectPerson;
	/**
	 * 负责人电话
	 */
	private String projectPersonPhone;
	/**
	 * 项目地址
	 */
	private String projectArea;
	/**
	 * 开工时间
	 */
	private Date projectStartTime;
	/**
	 * 截止时间
	 */
	private Date projectEndTime;
	/**
	 * 土地证图片
	 */
	private String projectLandLicense;
	/**
	 * 承建方图片
	 */
	private String projectContractorLicense;
	/**
	 * 承接方用户对应的userid
	 */
	private Long userId;

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
	 * 设置：项目名称
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	/**
	 * 获取：项目名称
	 */
	public String getProjectName() {
		return projectName;
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
	 * 设置：项目负责人
	 */
	public void setProjectPerson(String projectPerson) {
		this.projectPerson = projectPerson;
	}
	/**
	 * 获取：项目负责人
	 */
	public String getProjectPerson() {
		return projectPerson;
	}
	/**
	 * 设置：负责人电话
	 */
	public void setProjectPersonPhone(String projectPersonPhone) {
		this.projectPersonPhone = projectPersonPhone;
	}
	/**
	 * 获取：负责人电话
	 */
	public String getProjectPersonPhone() {
		return projectPersonPhone;
	}
	/**
	 * 设置：项目地址
	 */
	public void setProjectArea(String projectArea) {
		this.projectArea = projectArea;
	}
	/**
	 * 获取：项目地址
	 */
	public String getProjectArea() {
		return projectArea;
	}
	/**
	 * 设置：开工时间
	 */
	public void setProjectStartTime(Date projectStartTime) {
		this.projectStartTime = projectStartTime;
	}
	/**
	 * 获取：开工时间
	 */
	public Date getProjectStartTime() {
		return projectStartTime;
	}
	/**
	 * 设置：截止时间
	 */
	public void setProjectEndTime(Date projectEndTime) {
		this.projectEndTime = projectEndTime;
	}
	/**
	 * 获取：截止时间
	 */
	public Date getProjectEndTime() {
		return projectEndTime;
	}
	/**
	 * 设置：土地证图片
	 */
	public void setProjectLandLicense(String projectLandLicense) {
		this.projectLandLicense = projectLandLicense;
	}
	/**
	 * 获取：土地证图片
	 */
	public String getProjectLandLicense() {
		return projectLandLicense;
	}
	/**
	 * 设置：承建方图片
	 */
	public void setProjectContractorLicense(String projectContractorLicense) {
		this.projectContractorLicense = projectContractorLicense;
	}
	/**
	 * 获取：承建方图片
	 */
	public String getProjectContractorLicense() {
		return projectContractorLicense;
	}
	/**
	 * 设置：承接方用户对应的userid
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * 获取：承接方用户对应的userid
	 */
	public Long getUserId() {
		return userId;
	}
}
