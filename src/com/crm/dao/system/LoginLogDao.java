package com.crm.dao.system;

import java.util.List;

import com.crm.entity.LoginLog;
import com.modules.commons.Pager;

public interface LoginLogDao {

	public void save(LoginLog loginLog);
	
	public void update(LoginLog loginLog);
	
	public void delete(LoginLog loginLog);
	
	public void delete(Long id);
	
	public LoginLog get(Long id);
	
	public List findAll();
	
	public Pager getPager(int pageSize, int pageNo);
	
}