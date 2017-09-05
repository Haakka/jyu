package com.crm.dao.cusman;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.crm.bases.BaseHibernateDaoImpl;
import com.modules.commons.Pager;
import com.modules.util.StringUtil;

public class ReceivingDaoImpl extends BaseHibernateDaoImpl<Serializable> implements ReceivingDao {

	/*
	 * 分页查询
	 * @see com.crm.dao.cusman.ReceivingDao#retrieveReceivingsPager(int, int, java.lang.String)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Pager retrieveReceivingsPager(int pageSize, int pageNo, String keyWords) {
		StringBuffer hql = new StringBuffer();
		Map<String, Object> arrMap = new HashMap<String, Object>();
		hql.append(" from Receiving r where r.isDel = '0' ");
		if (StringUtil.isNotBlank(keyWords)) {
			arrMap.put("keyWord", "%" + keyWords.replace("%", "\\%") + "%");
			hql.append(" and ( r.orderId.orderSn like :keyWord or r.money like :keyWord or str(r.payTime) like :keyWord ");
		}
		List list = getCurrentSession().createQuery(hql.toString())
		.setFirstResult((pageNo - 1) * pageSize).setMaxResults(pageSize).list();
		String hqlCount = "select count(r.id)" + hql;
		return new Pager(pageSize, pageNo, Integer.parseInt(String.valueOf(getCurrentSession().createQuery(hqlCount).uniqueResult())), list);
	
	}


}