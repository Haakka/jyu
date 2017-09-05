/*
 * SysParamTypeManagerDaoImpl.java
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

import java.util.HashMap;
import java.util.Map;

import com.crm.bases.BaseManagerDaoImpl;
import com.crm.entity.SysParamType;
import com.crm.vo.ResultVo;
import com.modules.commons.CommonReturn;
import com.modules.commons.Pager;
import com.modules.util.ObjValid;
import com.modules.util.Sha256;

public class SysParamTypeServiceImpl extends BaseManagerDaoImpl implements SysParamTypeService {


	/*
	 * 添加参数类型
	 * @see com.crm.service.system.SysParamTypeManagerDao#addSysParamType(com.crm.entity.SysParamType)
	 */
	@Override
	public ResultVo addSysParamType(SysParamType sysParamType) {
		if (ObjValid.isNotValid(sysParamType)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_DATA_EXCEPT,null);
		}
		if (ObjValid.isNotValid(sysParamType.getTypeName())) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_DATA_MISSING,null);
		}
		if (ObjValid.isNotValid(sysParamType.getTypeName())) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_DATA_MISSING,null);
		}
		sysParamType.setIsDel("0");
		sysParamType.setToken(Sha256.SHA256(sysParamType.getTypeName()+sysParamType.getSort()+sysParamType.getIsDel()));
		sysParamTypeDao.save(sysParamType);
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_ADD_SUCCESS,null);
	}

	/*
	 * 修改参数类型
	 * @see com.crm.service.system.SysParamTypeManagerDao#modifySysParamType(com.crm.entity.SysParamType)
	 */
	@Override
	public ResultVo modifySysParamType(SysParamType sysParamType) {
		if (ObjValid.isNotValid(sysParamType)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_DATA_EXCEPT,null);
		}
		if (ObjValid.isNotValid(sysParamType.getTypeName())) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_DATA_MISSING,null);
		}
		if (ObjValid.isNotValid(sysParamType.getTypeName())) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_DATA_MISSING,null);
		}
		Map<String, Object> attrs = new HashMap<>();
		attrs.put("id", sysParamType.getId());
		attrs.put("token", sysParamType.getToken());
		SysParamType obj = sysParamTypeDao.query(SysParamType.class, attrs);
		if (ObjValid.isNotValid(obj)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_OBJ_NOEXIST_ERROR,null);
		}
		obj.setTypeName(sysParamType.getTypeName());
		obj.setSort(sysParamType.getSort());
		sysParamTypeDao.update(obj);
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_UPDATE_SUCCESS,null);
	}

	/*
	 * 删除参数类型（软删）
	 * @see com.crm.service.system.SysParamTypeManagerDao#removeSysParamType(java.lang.Long)
	 */
	@Override
	public ResultVo removeSysParamType(Long id,String token) {
		Map<String, Object> attrs = new HashMap<>();
		attrs.put("id", id);
		attrs.put("token", token);
		SysParamType obj = sysParamTypeDao.query(SysParamType.class, attrs);
		if (ObjValid.isNotValid(obj)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_OBJ_NOEXIST_ERROR,null);
		}
		sysParamTypeDao.removeSysParamType(id);
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_DELETE_SUCCESS,null);
	}

	/*
	 * 查询参数类型
	 * @see com.crm.service.system.SysParamTypeManagerDao#retrieveSysParamType(java.lang.Long)
	 */
	@Override
	public ResultVo retrieveSysParamType(Long id,String token) {
		Map<String, Object> attrs = new HashMap<>();
		attrs.put("id", id);
		attrs.put("token", token);
		SysParamType sysParamType = sysParamTypeDao.query(SysParamType.class, attrs);
		if (ObjValid.isNotValid(sysParamType)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_OBJ_NOEXIST_ERROR,null);
		}
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_FIND_SUCCESS,sysParamType);
	}

	/*
	 * 查询所有参数类型 List
	 * @see com.crm.service.system.SysParamTypeManagerDao#retrieveAllSysParamTypes()
	 */
	@Override
	public ResultVo retrieveAllSysParamTypes() {
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_FIND_SUCCESS,sysParamTypeDao.queryList(SysParamType.class,"sort", "asc", null));
	}

	/*
	 * 查询参数类型 分页
	 * @see com.crm.service.system.SysParamTypeManagerDao#retrieveSysParamTypesPager(int, int)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public ResultVo retrieveSysParamTypesPager(int pageSize, int pageNo) {
		Map<String, Object> attrs = new HashMap<>();
		attrs.put("isDel", "0");
		Pager pager = new Pager(pageSize, pageNo,Integer.parseInt(String.valueOf(sysParamTypeDao.queryTotalRecord(SysParamType.class, attrs))),
				sysParamTypeDao.queryList(SysParamType.class, (pageNo - 1) * pageSize, pageSize,"sort", "asc", attrs));
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_FIND_SUCCESS,pager);
	}

	/*
	 * 检查名称是否存在
	 * @see com.crm.service.system.SysParamTypeService#isUniqueName(java.lang.String)
	 */
	@Override
	public ResultVo findUniqueName(String name) {
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_FIND_SUCCESS,sysParamTypeDao.findUniqueName(name));
	}


}