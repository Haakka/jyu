package com.crm.dao.orders;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.crm.bases.BaseHibernateDaoImpl;
import com.modules.commons.Pager;
import com.modules.util.StringUtil;

public class ContractDaoImpl extends BaseHibernateDaoImpl<Serializable> implements ContractDao {

	/*
	 * 分页查询
	 * @see com.crm.dao.orders.ContractDao#retrieveContractsPager(int, int, java.lang.String, java.lang.String)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Pager retrieveContractsPager(int pageSize, int pageNo, String isDel, String keyWord) {
		StringBuffer hql = new StringBuffer();
		Map<String, Object> arrMap = new HashMap<String, Object>();
		hql.append(" from Contract c where c.isDel =:isDel  ");
		if (StringUtil.isNotBlank(keyWord)) {
			arrMap.put("keyWord", "%" + keyWord.replace("%", "\\%") + "%");
			hql.append(" and (c.name like :keyWord or c.num like :keyWord or c.consumerId.name like :keyWord or c.businessId.name like :keyWord or c.price like :keyWord or str(c.contractDate) like :keyWord) ");
		}
		List list = getCurrentSession().createQuery(hql.toString()).setProperties(arrMap).setParameter("isDel", isDel)
		.setFirstResult((pageNo - 1) * pageSize).setMaxResults(pageSize).list();
		String hqlCount = "select count(c.id) " + hql ;
		return new Pager(pageSize, pageNo, Integer.parseInt(String.valueOf(getCurrentSession().createQuery(hqlCount).setProperties(arrMap).setParameter("isDel", isDel).uniqueResult())), list);
	
	}


}