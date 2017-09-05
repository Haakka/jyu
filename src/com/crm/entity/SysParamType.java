package com.crm.entity;

import java.io.Serializable;
import java.util.Date;

public class SysParamType implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String typeName; //名称
	private int sort; //排序
	private String isDel; //是否被删除
 	private Date deleteTime; //删除时间
 	private String token; 
	
	
	public SysParamType() {
		
	}
	public SysParamType(Long id, String typeName, int sort, String isDel, Date deleteTime,String token) {
		super();
		this.id = id;
		this.typeName = typeName;
		this.sort = sort;
		this.isDel = isDel;
		this.deleteTime = deleteTime;
		this.token = token;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
	public String getIsDel() {
		return isDel;
	}
	public void setIsDel(String isDel) {
		this.isDel = isDel;
	}
	public Date getDeleteTime() {
		return deleteTime;
	}
	public void setDeleteTime(Date deleteTime) {
		this.deleteTime = deleteTime;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	
	
}
