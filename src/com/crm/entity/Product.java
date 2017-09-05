/**
 * 
 */
package com.crm.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


public class Product implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id; 
	private String name; //产品名称
	private Date addTime; //添加时间
	private Date updateTime; //修改时间
	private BigDecimal price; //价格
	private BigDecimal costPrice; //成本价
	private String size; //规格
	private String unit; //单位
	private String isDel; //是否删除
	private SysParam type; //产品类型
	private String remark; //备注
	private String token;

	public Product() {
		
	}
	public Product(Long id, String name, Date addTime, Date updateTime, BigDecimal price, BigDecimal costPrice, String size,
			String unit, String isDel, SysParam type,String remark,String token) {
		super();
		this.id = id;
		this.name = name;
		this.addTime = addTime;
		this.updateTime = updateTime;
		this.price = price;
		this.costPrice = costPrice;
		this.size = size;
		this.unit = unit;
		this.isDel = isDel;
		this.type = type;
		this.remark = remark;
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
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public BigDecimal getCostPrice() {
		return costPrice;
	}
	public void setCostPrice(BigDecimal costPrice) {
		this.costPrice = costPrice;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getIsDel() {
		return isDel;
	}
	public void setIsDel(String isDel) {
		this.isDel = isDel;
	}
	public SysParam getType() {
		return type;
	}
	public void setType(SysParam type) {
		this.type = type;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	
}
