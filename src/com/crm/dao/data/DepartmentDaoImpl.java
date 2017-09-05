package com.crm.dao.data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.crm.bases.BaseHibernateDaoImpl;
import com.modules.commons.Pager;
import com.modules.util.StringUtil;

public class DepartmentDaoImpl extends BaseHibernateDaoImpl<Serializable> implements DepartmentDao {

	/*
	 * 分页查询
	 * @see com.crm.dao.data.DepartmentDao#retrieveDepartmentsPager(int, int, java.lang.String, java.lang.String)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Pager retrieveDepartmentsPager(int pageSize, int pageNo, String isDel, String keyWord) {
		StringBuffer hql = new StringBuffer();
		Map<String, Object> arrMap = new HashMap<String, Object>();
		hql.append(" from Department d where d.isDel =:isDel  ");
		if (StringUtil.isNotBlank(keyWord)) {
			arrMap.put("keyWord", "%" + keyWord.replace("%", "\\%") + "%");
			hql.append(" and (d.code like :keyWord or d.name like :keyWord ) ");
		}
		List list = getCurrentSession().createQuery(hql.toString()).setProperties(arrMap).setParameter("isDel", isDel)
		.setFirstResult((pageNo - 1) * pageSize).setMaxResults(pageSize).list();
		String hqlCount = "select count(d.id) " + hql ;
		return new Pager(pageSize, pageNo, Integer.parseInt(String.valueOf(getCurrentSession().createQuery(hqlCount).setProperties(arrMap).setParameter("isDel", isDel).uniqueResult())), list);
	
	}

}