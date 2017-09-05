package com.crm.dao.system;

import java.io.Serializable;

import com.crm.bases.BaseHibernateDao;

public interface SysParamTypeDao extends BaseHibernateDao<Serializable>{

	/**
	 * 删除参数类型 软删
	 * @param id
	 */
	public void removeSysParamType(Long id);

	/**
	 * 检查名称是否存在
	 * @param name
	 * @return
	 */
	public Boolean findUniqueName(String name);
}