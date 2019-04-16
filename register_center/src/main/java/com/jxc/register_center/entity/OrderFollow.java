package com.jxc.register_center.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 */
@TableName("jxc_order_follow")
public class OrderFollow implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 继续要车记录id
	 */
	@TableId
	private Long orderFollowId;
	/**
	 * 项目订单id
	 */
	private Long projectOrderId;
	/**
	 * 要车时间
	 */
	private Date createTime;
	/**
	 * 最大要车数
	 */
	private Integer maxMechineCount;
	/**
	 * 实际派车数
	 */
	private Integer realMechineCount;
	/**
	 * 是否完结
	 */
	private Integer finishState;
	/**
	 * 后台处理人id
	 */
	private Long dealerId;
	/**
	 * 处理时间
	 */
	private Date dealTime;

	/**
	 * 设置：继续要车记录id
	 */
	public void setOrderFollowId(Long orderFollowId) {
		this.orderFollowId = orderFollowId;
	}
	/**
	 * 获取：继续要车记录id
	 */
	public Long getOrderFollowId() {
		return orderFollowId;
	}
	/**
	 * 设置：项目订单id
	 */
	public void setProjectOrderId(Long projectOrderId) {
		this.projectOrderId = projectOrderId;
	}
	/**
	 * 获取：项目订单id
	 */
	public Long getProjectOrderId() {
		return projectOrderId;
	}
	/**
	 * 设置：要车时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：要车时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：最大要车数
	 */
	public void setMaxMechineCount(Integer maxMechineCount) {
		this.maxMechineCount = maxMechineCount;
	}
	/**
	 * 获取：最大要车数
	 */
	public Integer getMaxMechineCount() {
		return maxMechineCount;
	}
	/**
	 * 设置：实际派车数
	 */
	public void setRealMechineCount(Integer realMechineCount) {
		this.realMechineCount = realMechineCount;
	}
	/**
	 * 获取：实际派车数
	 */
	public Integer getRealMechineCount() {
		return realMechineCount;
	}
	/**
	 * 设置：是否完结
	 */
	public void setFinishState(Integer finishState) {
		this.finishState = finishState;
	}
	/**
	 * 获取：是否完结
	 */
	public Integer getFinishState() {
		return finishState;
	}
	/**
	 * 设置：后台处理人id
	 */
	public void setDealerId(Long dealerId) {
		this.dealerId = dealerId;
	}
	/**
	 * 获取：后台处理人id
	 */
	public Long getDealerId() {
		return dealerId;
	}
	/**
	 * 设置：处理时间
	 */
	public void setDealTime(Date dealTime) {
		this.dealTime = dealTime;
	}
	/**
	 * 获取：处理时间
	 */
	public Date getDealTime() {
		return dealTime;
	}
}
