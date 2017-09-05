/*
 * SysParamManagerDaoImpl.java
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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.crm.bases.BaseManagerDaoImpl;
import com.crm.entity.SysParam;
import com.crm.entity.SysParamType;
import com.crm.vo.ResultVo;
import com.modules.commons.CommonReturn;
import com.modules.commons.Pager;
import com.modules.util.ObjValid;
import com.modules.util.Sha256;

public class SysParamServiceImpl extends BaseManagerDaoImpl implements SysParamService {


	/*
	 * 根据参数类型Id查询系统参数
	 * @see com.crm.service.system.SysParamManagerDao#findPagerByTypeId(int, int, java.lang.Long)
	 */
	@Override
	public ResultVo findPagerByTypeId(int pageSize, int pageNo, Long id,String token) {
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_FIND_SUCCESS,sysParamDao.findPagerByTypeId(pageSize, pageNo, id, token));
	}

	/*
	 * 添加系统参数
	 * @see com.crm.service.system.SysParamService#addSysParam(com.crm.entity.SysParam)
	 */
	@Override
	public ResultVo addSysParam(Long id,String token,SysParam sysParam) {
		if (ObjValid.isNotValid(sysParam)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_DATA_EXCEPT,null);
		}
		if (ObjValid.isNotValid(sysParam.getName())) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_DATA_MISSING,null);
		}
		if (ObjValid.isNotValid(sysParam.getSort())) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_DATA_MISSING,null);
		}
		Map<String, Object> attrs = new HashMap<>();
		attrs.put("id", id);
		attrs.put("token", token);
		SysParamType sysParamType = sysParamDao.query(SysParamType.class, attrs);
		if (ObjValid.isNotValid(sysParamType)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_OBJ_NOEXIST_ERROR,null);
		}
		sysParam.setSysParamType(sysParamType);
		sysParam.setAddTime(new Date());
		sysParam.setIsDel("0");
		sysParam.setToken(Sha256.SHA256(sysParam.getName()+sysParam.getSort()+sysParam.getIsDel()));
		sysParamDao.save(sysParam);
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_ADD_SUCCESS,null);
	}

	/*
	 * 修改系统参数
	 * @see com.crm.service.system.SysParamService#modifySysParam(com.crm.entity.SysParam)
	 */
	@Override
	public ResultVo modifySysParam(SysParam sysParam) {
		if (ObjValid.isNotValid(sysParam)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_DATA_EXCEPT,null);
		}
		if (ObjValid.isNotValid(sysParam.getName())) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_DATA_MISSING,null);
		}
		if (ObjValid.isNotValid(sysParam.getSort())) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_DATA_MISSING,null);
		}
		Map<String, Object> attrs = new HashMap<>();
		attrs.put("id", sysParam.getId());
		attrs.put("token", sysParam.getToken());
		SysParam obj = sysParamDao.query(SysParam.class, attrs);
		if (ObjValid.isNotValid(obj)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_OBJ_NOEXIST_ERROR,null);
		}
		obj.setName(sysParam.getName());
		obj.setSort(sysParam.getSort());
		obj.setUpdateTime(new Date());
		sysParamDao.update(obj);
		SysParamType sysParamType = obj.getSysParamType();
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_UPDATE_SUCCESS,sysParamType);
	}

	/*
	 * 删除系统参数(软删)
	 * @see com.crm.service.system.SysParamService#removeSysParam(java.lang.Long)
	 */
	@Override
	public ResultVo removeSysParam(Long id,String token) {
		Map<String, Object> attrs = new HashMap<>();
		attrs.put("id", id);
		attrs.put("token", token);
		SysParam sysParam = sysParamDao.query(SysParam.class, attrs);
		if (ObjValid.isNotValid(sysParam)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_OBJ_NOEXIST_ERROR,null);
		}
		sysParam.setIsDel("1");
		sysParam.setDeleteTime(new Date());
		sysParamDao.update(sysParam);
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_DELETE_SUCCESS,null);
	}

	/*
	 * 查询单个系统参数
	 * @see com.crm.service.system.SysParamService#retrieveSysParam(java.lang.Long)
	 */
	@Override
	public ResultVo retrieveSysParam(Long id,String token) {
		Map<String, Object> attrs = new HashMap<>();
		attrs.put("id", id);
		attrs.put("token", token);
		SysParam sysParam = sysParamDao.query(SysParam.class, attrs);
		if (ObjValid.isNotValid(sysParam)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_OBJ_NOEXIST_ERROR,null);
		}
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_FIND_SUCCESS,sysParam);
	}

	/*
	 * 查询所有系统参数 List
	 * @see com.crm.service.system.SysParamService#retrieveAllSysParams()
	 */
	@Override
	public ResultVo retrieveAllSysParams() {
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_FIND_SUCCESS,sysParamDao.queryList(SysParam.class,"sort", "asc", null));
	}

	/*
	 * 查询所有系统参数 分页
	 * @see com.crm.service.system.SysParamService#retrieveSysParamsPager(int, int)
	 */
	@Override
	public ResultVo retrieveSysParamsPager(int pageSize, int pageNo) {
		Pager pager = new Pager(pageSize, pageNo,Integer.parseInt(String.valueOf(sysParamDao.queryTotalRecord(SysParam.class, null))),
				sysParamDao.queryList(SysParam.class,(pageNo - 1) * pageSize, pageSize, "sort", "asc", null));
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_FIND_SUCCESS,pager);
	}
	
	/*
	 * 检查名称是否存在
	 * @see com.crm.service.system.SysParamTypeService#isUniqueName(java.lang.String)
	 */
	@Override
	public ResultVo findUniqueName(String name) {
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_FIND_SUCCESS,sysParamDao.findUniqueName(name));
	}

	/*
	 * 根据参数类型Id获取系统参数
	 * List
	 * @see com.crm.service.system.SysParamService#findByTypeName(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public ResultVo findByTypeId(Long id) {
		if (ObjValid.isNotValid(id)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_DATA_MISSING,null);
		}
		Map<String, Object> attrs = new HashMap<>();
		attrs.put("sysParamType.id", id);
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_FIND_SUCCESS,sysParamDao.queryList(SysParam.class, "sort", "asc", attrs));
	}
}