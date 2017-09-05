package com.crm.entity;

import java.io.Serializable;
import java.util.Set;

/**
 * 部门实体类
 * @author Stephen
 *
 */
public class Department implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String code; //部门编码
	private String name; //部门名称
	private String remark; //备注
	private String isDel; //是否删除
	private Users manager; //部门主管
	private String token;
	
	private Set<Position> positions; 
	private Set<Users> users;
	
	public Department() {
		
	}
	public Department(Long id, String code, String name, String remark, String isDel, Users manager,String token,Set<Position> positions,Set<Users> users) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.remark = remark;
		this.isDel = isDel;
		this.manager = manager;
		this.positions = positions;
		this.users = users;
		this.token = token;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public Users getManager() {
		return manager;
	}
	public void setManager(Users manager) {
		this.manager = manager;
	}
	public Set<Position> getPositions() {
		return positions;
	}
	public void setPositions(Set<Position> positions) {
		this.positions = positions;
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
