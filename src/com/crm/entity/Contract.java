package com.crm.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 合同 实体类
 * @author Stephen
 *
 */
public class Contract implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private Consumer consumerId; //客户
	private Users userId; //创建者
	private Business businessId; //商机
	private String num; //合同编号
	private BigDecimal price; //总价
	private Date contractDate; //签约日期
	private String content; //合同内容
	private String description; //合同描述
	private String remark; //合同备注
	private Date addTime; //添加时间
	private Date updateTime; //更新时间
	private String status; //状态
	private String isDel; //是否删除
	private String token;
	
	
	
	public Contract() {
		
		
	}
	
	public Contract(Long id, Consumer consumerId, Users userId, Business businessId, String num, String name,BigDecimal price,
			Date contractDate, String content, String description, String remark, Date addTime, Date updateTime,
			String status, String isDel,String token) {
		super();
		this.id = id;
		this.name = name;
		this.consumerId = consumerId;
		this.userId = userId;
		this.businessId = businessId;
		this.num = num;
		this.price = price;
		this.contractDate = contractDate;
		this.content = content;
		this.description = description;
		this.remark = remark;
		this.addTime = addTime;
		this.updateTime = updateTime;
		this.status = status;
		this.isDel = isDel;
		this.token = token;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Consumer getConsumerId() {
		return consumerId;
	}
	public void setConsumerId(Consumer consumerId) {
		this.consumerId = consumerId;
	}
	public Users getUserId() {
		return userId;
	}
	public void setUserId(Users userId) {
		this.userId = userId;
	}
	public Business getBusinessId() {
		return businessId;
	}
	public void setBusinessId(Business businessId) {
		this.businessId = businessId;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public Date getContractDate() {
		return contractDate;
	}
	public void setContractDate(Date contractDate) {
		this.contractDate = contractDate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Date getAddTime() {
		return addTime;
	}
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getIsDel() {
		return isDel;
	}
	public void setIsDel(String isDel) {
		this.isDel = isDel;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	
}
