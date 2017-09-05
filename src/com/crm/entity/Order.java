package com.crm.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


public class Order implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String orderSn; //订单编号
	private Contract contractId; //合同Id
	private Date addTime; //添加时间
	private BigDecimal totalAmount; //总金额
	private SysParam payType;//支付方式   -->外键
	private Date payTime;
	private String isDel; //是否删除
	private String isInvoice; //是否开票
	private Users userId; //创建人
	private Users finisher;//完成人
	private Product productId;
	private String token;
	
	
	public Order() {
		
	}
	public Order(Product productId,Long id, String orderSn, Contract contractId, Date addTime,  BigDecimal totalAmount,
			SysParam payType,Date payTime, String isDel, String isInvoice, Users userId, Users finisher,String token) {
		super();
		this.productId = productId;
		this.id = id;
		this.orderSn = orderSn;
		this.contractId = contractId;
		this.addTime = addTime;
		this.totalAmount = totalAmount;
		this.payType = payType;
		this.isDel = isDel;
		this.payTime = payTime;
		this.isInvoice = isInvoice;
		this.userId = userId;
		this.finisher = finisher;
		this.token = token;
	}
	
	
	
	public Product getProductId() {
		return productId;
	}
	public void setProductId(Product productId) {
		this.productId = productId;
	}
	public Date getPayTime() {
		return payTime;
	}
	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getOrderSn() {
		return orderSn;
	}
	public void setOrderSn(String orderSn) {
		this.orderSn = orderSn;
	}
	public Contract getContractId() {
		return contractId;
	}
	public void setContractId(Contract contractId) {
		this.contractId = contractId;
	}
	public Date getAddTime() {
		return addTime;
	}
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
	public BigDecimal getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}
	public SysParam getPayType() {
		return payType;
	}
	public void setPayType(SysParam payType) {
		this.payType = payType;
	}
	public String getIsDel() {
		return isDel;
	}
	public void setIsDel(String isDel) {
		this.isDel = isDel;
	}
	public String getIsInvoice() {
		return isInvoice;
	}
	public void setIsInvoice(String isInvoice) {
		this.isInvoice = isInvoice;
	}
	public Users getUserId() {
		return userId;
	}
	public void setUserId(Users userId) {
		this.userId = userId;
	}
	public Users getFinisher() {
		return finisher;
	}
	public void setFinisher(Users finisher) {
		this.finisher = finisher;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	
	
}
