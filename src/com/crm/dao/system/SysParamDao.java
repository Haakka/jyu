package com.crm.dao.system;

import java.io.Serializable;
import java.util.List;

import com.crm.bases.BaseHibernateDao;
import com.crm.entity.SysParam;
import com.modules.commons.Pager;

public interface SysParamDao extends BaseHibernateDao<Serializable>{

	/**
	 * 检查名称是否存在
	 * @param name
	 * @return
	 */
	public Boolean findUniqueName(String name);
	
	/**
	 * 根据参数类型Id查询系统参数
	 * @param pageSize
	 * @param pageNo
	 * @param id
	 * @param token
	 * @return
	 */
	public Pager findPagerByTypeId(int pageSize, int pageNo, Long id,String token);
	
	/**
	 * 根据Id查询参数
	 * @param id
	 * @return
	 */
	public SysParam findById(Long id);
	
	/**
	 * 根据参数类型名称查询
	 * @param typeName
	 * @return
	 */
	public List<SysParam> findByTypeName(String typeName);

	
}