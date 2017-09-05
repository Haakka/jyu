package com.crm.dao.system;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.crm.bases.BaseHibernateDaoImpl;

@Repository("sysParamTypeDao")
public class SysParamTypeDaoImpl extends BaseHibernateDaoImpl<Serializable> implements SysParamTypeDao {

	/**
	 * 删除参数类型 同时删除下级参数 
	 * 软删
	 * 
	 */
	@Override
	public void removeSysParamType(Long id) {
		String hql = "update SysParamType a set a.isDel = '1',a.deleteTime = :deleteTime where a.id = :id ";
		String hql2 = "update SysParam b set b.isDel = '1',b.deleteTime = :deleteTime where b.sysParamType.id = :id";
		getCurrentSession().createQuery(hql).setParameter("id", id).setParameter("deleteTime", new Date());
		getCurrentSession().createQuery(hql2).setParameter("id", id).setParameter("deleteTime", new Date());
	}

	/**
	 * 检查名称是否存在
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Boolean findUniqueName(String name) {
		List temp = getHibernateTemplate().find("from SysParamType where typeName = ?", name.trim());
		getCurrentSession().flush();
		return temp.size() <= 0;
	}


	

}