package com.crm.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class SysParam implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private SysParamType sysParamType; //参数类型
	private String name; //名称
	private int sort; //排序
	private Date addTime; //添加时间
	private Date updateTime; //修改时间
	private Date deleteTime; //删除时间
	private String isDel; //是否删除
	private String token;
	
	private Set<Product> products = new HashSet<Product>();
	
	
	public SysParam() {
		
	}
	public SysParam(SysParamType sysParamType,Long id, String name, int sort, Date addTime, Date updateTime, Date deleteTime, String isDel,
			Set<Product> products,String token) {
		super();
		this.id = id;
		this.name = name;
		this.sort = sort;
		this.addTime = addTime;
		this.updateTime = updateTime;
		this.deleteTime = deleteTime;
		this.isDel = isDel;
		this.sysParamType = sysParamType;
		this.products = products;
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
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
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
	public Date getDeleteTime() {
		return deleteTime;
	}
	public void setDeleteTime(Date deleteTime) {
		this.deleteTime = deleteTime;
	}
	public String getIsDel() {
		return isDel;
	}
	public void setIsDel(String isDel) {
		this.isDel = isDel;
	}
	public SysParamType getSysParamType() {
		return sysParamType;
	}
	public void setSysParamType(SysParamType sysParamType) {
		this.sysParamType = sysParamType;
	}
	public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	
	

}
