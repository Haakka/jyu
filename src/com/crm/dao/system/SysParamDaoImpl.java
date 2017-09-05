package com.crm.dao.system;

import java.io.Serializable;
import java.util.List;

import com.crm.bases.BaseHibernateDaoImpl;
import com.crm.entity.SysParam;
import com.modules.commons.Pager;

public class SysParamDaoImpl extends BaseHibernateDaoImpl<Serializable> implements SysParamDao {

	/*
	 * 检查名称是否存在
	 * @see com.crm.dao.system.SysParamDao#findUniqueName(java.lang.String)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Boolean findUniqueName(String name) {
		List temp = getHibernateTemplate().find("from SysParam where name = ?", name.trim());
		getCurrentSession().flush();
		return temp.size() <= 0;
	}

	/*
	 * 根据参数类型Id查询系统参数
	 * @see com.crm.dao.system.SysParamDao#findPagerByTypeId(int, int, java.lang.Long, java.lang.String)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Pager findPagerByTypeId(int pageSize, int pageNo, Long id, String token) {
		String hql = "select a from SysParam a where a.isDel = '0' and a.sysParamType.id = :id and a.sysParamType.token = :token";
		List list = getCurrentSession().createQuery(hql).setParameter("id", id).setParameter("token", token)
		.setMaxResults(pageSize).setFirstResult((pageNo - 1) * pageSize).list();
		String hqlCount = hql.replace("select a", "select count(id)");
		Long count = (Long) getCurrentSession().createQuery(hqlCount).setParameter("id", id).setParameter("token", token).uniqueResult();
		return new Pager(pageSize, pageNo, count.intValue(), list);
	}

	/*
	 * 根据Id查询参数
	 * @see com.crm.dao.system.SysParamDao#findById(java.lang.Long)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public SysParam findById(Long id) {
		String hql = "select s from SysParam s where s.id = :id ";
		List<SysParam> sysParams = getCurrentSession().createQuery(hql).setParameter("id", id).list();
		if (sysParams.size() <= 0 ) {
			return null;
		}else {
			return sysParams.get(0);
		}
	}

	/*
	 * 根据参数类型名称查询
	 * @see com.crm.dao.system.SysParamDao#findByTypeName(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<SysParam> findByTypeName(String typeName) {
		String hql = "select s from SysParam s where s.isDel = '0' and  s.sysParamType.typeName = :typeName order by s.sort asc";
		return getCurrentSession().createQuery(hql).setParameter("typeName", typeName).list();
	}


}