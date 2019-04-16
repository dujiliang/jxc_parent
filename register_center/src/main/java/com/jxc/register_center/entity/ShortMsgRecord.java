package com.jxc.register_center.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 */
@TableName("jxc_short_msg_record")
public class ShortMsgRecord implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long recordId;
	/**
	 * 
	 */
	private Long phone;
	/**
	 * 
	 */
	private Integer type;
	/**
	 * 
	 */
	private Date createTime;
	/**
	 * 
	 */
	private Integer client;
	
	/**
	 * 
	 */
	private String msg;

	/**
	 * 设置：
	 */
	public void setRecordId(Long recordId) {
		this.recordId = recordId;
	}
	/**
	 * 获取：
	 */
	public Long getRecordId() {
		return recordId;
	}
	/**
	 * 设置：
	 */
	public void setPhone(Long phone) {
		this.phone = phone;
	}
	/**
	 * 获取：
	 */
	public Long getPhone() {
		return phone;
	}
	/**
	 * 设置：
	 */
	public void setType(Integer type) {
		this.type = type;
	}
	/**
	 * 获取：
	 */
	public Integer getType() {
		return type;
	}
	/**
	 * 设置：
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：
	 */
	public void setClient(Integer client) {
		this.client = client;
	}
	/**
	 * 获取：
	 */
	public Integer getClient() {
		return client;
	}

	/**
	 * 设置：
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}
	/**
	 * 获取：
	 */
	public String getMsg() {
		return msg;
	}
}
