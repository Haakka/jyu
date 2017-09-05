/*
 * LoginLogManagerDaoImpl.java
 * 
 * Create by MCGT
 * 
 * Create time 2017-03-24
 * 
 * Version 1.0
 * 
 * Copyright 2013 Messcat, Inc. All rights reserved.
 * 
 */
package com.crm.service.system;

import java.util.List;

import com.crm.bases.BaseManagerDaoImpl;
import com.crm.entity.LoginLog;
import com.modules.commons.Pager;

public class LoginLogManagerDaoImpl extends BaseManagerDaoImpl implements LoginLogManagerDao {

	public void addLoginLog(LoginLog loginLog) {
		this.loginLogDao.save(loginLog);
	}
	
	public void modifyLoginLog(LoginLog loginLog) {
		this.loginLogDao.update(loginLog);
	}
	
	public void removeLoginLog(LoginLog loginLog) {
		this.loginLogDao.delete(loginLog);
	}

	public void removeLoginLog(Long id) {
		this.loginLogDao.delete(id);
	}
	
	public LoginLog retrieveLoginLog(Long id) {
		return (LoginLog) this.loginLogDao.get(id);
	}

	@SuppressWarnings("unchecked")
	public List retrieveAllLoginLogs() {
		return this.loginLogDao.findAll();
	}
	
	public Pager retrieveLoginLogsPager(int pageSize, int pageNo) {
		return this.loginLogDao.getPager(pageSize, pageNo);
	}

}