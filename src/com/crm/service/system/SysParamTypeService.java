/*
 * SysParamTypeManagerDao.java
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

import com.crm.entity.SysParamType;
import com.crm.vo.ResultVo;

public interface SysParamTypeService {

	/**
	 * 添加
	 * @param sysParamType
	 * @return
	 */
	public ResultVo addSysParamType(SysParamType sysParamType);
	
	/**
	 * 修改
	 * @param sysParamType
	 * @return
	 */
	public ResultVo modifySysParamType(SysParamType sysParamType);
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	public ResultVo removeSysParamType(Long id,String token);
	
	/**
	 * 查询单个
	 * @param id
	 * @param token
	 * @return
	 */
	public ResultVo retrieveSysParamType(Long id,String token);
	
	/**
	 * 查询所有List
	 * @return
	 */
	public ResultVo retrieveAllSysParamTypes();
	
	/**
	 * 分页查询
	 * @param pageSize
	 * @param pageNo
	 * @return
	 */
	public ResultVo retrieveSysParamTypesPager(int pageSize, int pageNo);
	
	/**
	 * 检查名称是否存在
	 * @param name
	 * @return
	 */
	public ResultVo findUniqueName(String name);
	
}