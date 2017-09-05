package com.crm.dao.data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.crm.bases.BaseHibernateDaoImpl;
import com.modules.commons.Pager;
import com.modules.util.StringUtil;

public class PositionDaoImpl extends BaseHibernateDaoImpl<Serializable> implements PositionDao {

	/*
	 * 分页查询
	 * @see com.crm.dao.data.PositionDao#retrievePositionsPager(int, int, java.lang.Long, java.lang.String, java.lang.String)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Pager retrievePositionsPager(int pageSize, int pageNo, Long departmentId, String token, String keyWord) {
		StringBuffer hql = new StringBuffer();
		Map<String, Object> arrMap = new HashMap<String, Object>();
		hql.append(" from Position p where p.isDel = '0' and p.departmentId.id =:id and p.departmentId.token =:token ");
		if (StringUtil.isNotBlank(keyWord)) {
			arrMap.put("keyWord", "%" + keyWord.replace("%", "\\%") + "%");
			hql.append(" and (p.name like :keyWord or p.code like :keyWord ) ");
		}
		List list = getCurrentSession().createQuery(hql.toString()).setProperties(arrMap).setParameter("id", departmentId).setParameter("token", token)
		.setFirstResult((pageNo - 1) * pageSize).setMaxResults(pageSize).list();
		String hqlCount = "select count(p.id) " + hql ;
		return new Pager(pageSize, pageNo, Integer.parseInt(String.valueOf(getCurrentSession().createQuery(hqlCount).setProperties(arrMap).setParameter("id", departmentId).setParameter("token", token).uniqueResult())), list);
	
	}


}