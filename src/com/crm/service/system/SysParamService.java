package com.crm.service.system;

import com.crm.entity.SysParam;
import com.crm.vo.ResultVo;

public interface SysParamService {
	
	/**
	 * 添加
	 * @param sysParam
	 * @return
	 */
	public ResultVo addSysParam(Long id,String token,SysParam sysParam);
	
	/**
	 * 修改
	 * @param sysParam
	 * @return
	 */
	public ResultVo modifySysParam(SysParam sysParam);
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	public ResultVo removeSysParam(Long id,String token);
	
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 */
	public ResultVo retrieveSysParam(Long id,String token);
	
	/**
	 * 查询所有 List
	 * @return
	 */
	public ResultVo retrieveAllSysParams();
	
	/**
	 * 分页查询
	 * @param pageSize
	 * @param pageNo
	 * @return
	 */
	public ResultVo retrieveSysParamsPager(int pageSize, int pageNo);
	
	/**
	 * 根据参数类型Id获取系统参数
	 * 分页
	 * @param pageSize
	 * @param pageNo
	 * @param id
	 * @return
	 */
	public ResultVo findPagerByTypeId(int pageSize, int pageNo,Long id,String token);
	
	/**
	 * 检查名称是否存在
	 * @param name
	 * @return
	 */
	public ResultVo findUniqueName(String name);
	
	/**
	 * 根据参数类型Id获取系统参数
	 * List
	 * @param typeName
	 * @return
	 */
	public ResultVo findByTypeId(Long id);
	
}