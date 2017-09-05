package com.crm.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 发票实体类
 * @author Stephen
 *
 */
public class Invoice implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Users userId; //创建人
	private Order orderId; //订单编号
	private String num; //发票号码
	private String code; //发票代码
	private String type; //发票类型
	private BigDecimal amount; //金额
	private Date addTime; //添加时间
	private String isDel; //是否删除
	private Date startDate; //开票时间
	private String payer; //支付方名称
	private String payerAddress; //支付方地址
	private String payerTel;//支付方式电话
	private String payerBank; //支付方开户行
	private String payerAcount; //支付方开户账号
	private String receiver; //收款方名称
	private String receiverAdderss; //收款方地址
	private String receiverTel;  //收款方电话
	private String receiverBank; //收款方开户行
	private String receiverAcount; //收款方开户账号
	private String token;
	
	
	public Invoice() {
		
	}
	
	public Invoice(Long id,  Users userId, Order orderId, String num, String code, String type,
			BigDecimal amount, Date addTime, String isDel, Date startDate, String payer, String payerAddress,
			String payerTel, String payerBank, String payerAcount, String receiver, String receiverAdderss,
			String receiverTel, String receiverBank, String receiverAcount,String token) {
		super();
		this.id = id;
		this.userId = userId;
		this.orderId = orderId;
		this.num = num;
		this.code = code;
		this.type = type;
		this.amount = amount;
		this.addTime = addTime;
		this.isDel = isDel;
		this.startDate = startDate;
		this.payer = payer;
		this.payerAddress = payerAddress;
		this.payerTel = payerTel;
		this.payerBank = payerBank;
		this.payerAcount = payerAcount;
		this.receiver = receiver;
		this.receiverAdderss = receiverAdderss;
		this.receiverTel = receiverTel;
		this.receiverBank = receiverBank;
		this.receiverAcount = receiverAcount;
		this.token = token;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Users getUserId() {
		return userId;
	}
	public void setUserId(Users userId) {
		this.userId = userId;
	}
	public Order getOrderId() {
		return orderId;
	}
	public void setOrderId(Order orderId) {
		this.orderId = orderId;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public Date getAddTime() {
		return addTime;
	}
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
	public String getIsDel() {
		return isDel;
	}
	public void setIsDel(String isDel) {
		this.isDel = isDel;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public String getPayer() {
		return payer;
	}
	public void setPayer(String payer) {
		this.payer = payer;
	}
	public String getPayerAddress() {
		return payerAddress;
	}
	public void setPayerAddress(String payerAddress) {
		this.payerAddress = payerAddress;
	}
	public String getPayerTel() {
		return payerTel;
	}
	public void setPayerTel(String payerTel) {
		this.payerTel = payerTel;
	}
	public String getPayerBank() {
		return payerBank;
	}
	public void setPayerBank(String payerBank) {
		this.payerBank = payerBank;
	}
	public String getPayerAcount() {
		return payerAcount;
	}
	public void setPayerAcount(String payerAcount) {
		this.payerAcount = payerAcount;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getReceiverAdderss() {
		return receiverAdderss;
	}
	public void setReceiverAdderss(String receiverAdderss) {
		this.receiverAdderss = receiverAdderss;
	}
	public String getReceiverTel() {
		return receiverTel;
	}
	public void setReceiverTel(String receiverTel) {
		this.receiverTel = receiverTel;
	}
	public String getReceiverBank() {
		return receiverBank;
	}
	public void setReceiverBank(String receiverBank) {
		this.receiverBank = receiverBank;
	}
	public String getReceiverAcount() {
		return receiverAcount;
	}
	public void setReceiverAcount(String receiverAcount) {
		this.receiverAcount = receiverAcount;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	

}
