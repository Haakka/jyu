/*
 * LoginLogManagerDao.java
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

import com.crm.entity.LoginLog;
import com.modules.commons.Pager;

public interface LoginLogManagerDao {

	public void addLoginLog(LoginLog loginLog);
	
	public void modifyLoginLog(LoginLog loginLog);
	
	public void removeLoginLog(LoginLog loginLog);
	
	public void removeLoginLog(Long id);
	
	public LoginLog retrieveLoginLog(Long id);
	
	public List retrieveAllLoginLogs();
	
	public Pager retrieveLoginLogsPager(int pageSize, int pageNo);
	
}