package com.crm.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 收款表
 * @author Stephen
 *
 */
public class Receiving implements Serializable{

	private Long id;
	private Order orderId; 
	private BigDecimal money;
	private String remark;
	private Date payTime;
	private Date addTime;
	private String token;
	private String isDel;
	
	
	public Receiving() {
		
	}
	
	public Receiving(Long id, Order orderId, BigDecimal money, String remark, Date payTime, Date addTime,String token
			,String isDel) {
		super();
		this.id = id;
		this.isDel =isDel;
		this.orderId = orderId;
		this.money = money;
		this.remark = remark;
		this.payTime = payTime;
		this.addTime = addTime;
		this.token = token;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Order getOrderId() {
		return orderId;
	}
	public void setOrderId(Order orderId) {
		this.orderId = orderId;
	}
	public BigDecimal getMoney() {
		return money;
	}
	public void setMoney(BigDecimal money) {
		this.money = money;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Date getPayTime() {
		return payTime;
	}
	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}
	public Date getAddTime() {
		return addTime;
	}
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getIsDel() {
		return isDel;
	}

	public void setIsDel(String isDel) {
		this.isDel = isDel;
	}
	
	
	
}
