package com.crm.entity;

import java.io.Serializable;
import java.util.Set;


public class Position implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String name; //职位名称
	private String code; //职位代码
	private Department departmentId; //所属部门
	private String remark; //备注
	private String isDel; //是否删除
	private String token;
	
	private Set<Users> users;
	
	
	public Position() {
		
	}
	public Position(Long id, String name,String code, Department departmentId, String remark, String isDel,String token) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
		this.departmentId = departmentId;
		this.remark = remark;
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
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Department getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Department departmentId) {
		this.departmentId = departmentId;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getIsDel() {
		return isDel;
	}
	public void setIsDel(String isDel) {
		this.isDel = isDel;
	}
	public Set<Users> getUsers() {
		return users;
	}
	public void setUsers(Set<Users> users) {
		this.users = users;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	
	
	
}
