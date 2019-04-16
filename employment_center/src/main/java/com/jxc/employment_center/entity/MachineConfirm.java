package com.jxc.employment_center.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 */
@TableName("jxc_machine_confirm")
public class MachineConfirm implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 机械id
	 */
	@TableId
	private Long machineId;
	/**
	 * 机械类型
	 */
	private Integer machineType;
	/**
	 * 车牌号
	 */
	private String machineCardNo;
	/**
	 * 车辆归属地(市级)
	 */
	private Long areaCode;
	/**
	 * 车辆生产出厂时间
	 */
	private Date machineProductTime;
	/**
	 * 营运证图片
	 */
	private String machineOperationCertificate;
	/**
	 * 行驶证图片
	 */
	private String machineDrivingLicense;
	/**
	 * 审核状态
	 */
	private Integer confirmState;
	/**
	 * 机主id
	 */
	private Long ownerId;

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
	 * 设置：车牌号
	 */
	public void setMachineCardNo(String machineCardNo) {
		this.machineCardNo = machineCardNo;
	}
	/**
	 * 获取：车牌号
	 */
	public String getMachineCardNo() {
		return machineCardNo;
	}
	/**
	 * 设置：车辆归属地(市级)
	 */
	public void setAreaCode(Long areaCode) {
		this.areaCode = areaCode;
	}
	/**
	 * 获取：车辆归属地(市级)
	 */
	public Long getAreaCode() {
		return areaCode;
	}
	/**
	 * 设置：车辆生产出厂时间
	 */
	public void setMachineProductTime(Date machineProductTime) {
		this.machineProductTime = machineProductTime;
	}
	/**
	 * 获取：车辆生产出厂时间
	 */
	public Date getMachineProductTime() {
		return machineProductTime;
	}
	/**
	 * 设置：营运证图片
	 */
	public void setMachineOperationCertificate(String machineOperationCertificate) {
		this.machineOperationCertificate = machineOperationCertificate;
	}
	/**
	 * 获取：营运证图片
	 */
	public String getMachineOperationCertificate() {
		return machineOperationCertificate;
	}
	/**
	 * 设置：行驶证图片
	 */
	public void setMachineDrivingLicense(String machineDrivingLicense) {
		this.machineDrivingLicense = machineDrivingLicense;
	}
	/**
	 * 获取：行驶证图片
	 */
	public String getMachineDrivingLicense() {
		return machineDrivingLicense;
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
}
