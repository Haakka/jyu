package com.crm.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 登录记录实体类
 * @author Stephen
 *
 */
public class LoginLog implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Users userId; //登录人
	private Date loginTime; //登录时间
	
	
	public LoginLog() {
	}
	
	public LoginLog(Users userId, Date loginTime) {
		super();
		this.userId = userId;
		this.loginTime = loginTime;
	}

	public LoginLog(Long id, Users userId, Date loginTime) {
		super();
		this.id = id;
		this.userId = userId;
		this.loginTime = loginTime;
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
	public Date getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}
	
	

}
