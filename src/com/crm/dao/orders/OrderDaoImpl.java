package com.crm.dao.orders;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.crm.bases.BaseHibernateDaoImpl;
import com.modules.commons.Pager;
import com.modules.util.StringUtil;

public class OrderDaoImpl extends BaseHibernateDaoImpl<Serializable> implements OrderDao {

	/*
	 * 分页查询
	 * @see com.crm.dao.orders.OrderDao#retrieveOrdersPager(int, int, java.lang.String, java.lang.String)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Pager retrieveOrdersPager(int pageSize, int pageNo, String isDel, String keyWord) {
		StringBuffer hql = new StringBuffer();
		Map<String, Object> arrMap = new HashMap<String, Object>();
		hql.append(" from Order o where o.isDel =:isDel  ");
		if (StringUtil.isNotBlank(keyWord)) {
			arrMap.put("keyWord", "%" + keyWord.replace("%", "\\%") + "%");
			hql.append(" and (o.orderSn like :keyWord or str(o.addTime) like :keyWord or str(o.payTime) like :keyWord or o.totalAmount like :keyWord ) ");
		}
		List list = getCurrentSession().createQuery(hql.toString()).setProperties(arrMap).setParameter("isDel", isDel)
		.setFirstResult((pageNo - 1) * pageSize).setMaxResults(pageSize).list();
		String hqlCount = "select count(o.id) " + hql ;
		return new Pager(pageSize, pageNo, Integer.parseInt(String.valueOf(getCurrentSession().createQuery(hqlCount).setProperties(arrMap).setParameter("isDel", isDel).uniqueResult())), list);
	
	}


}