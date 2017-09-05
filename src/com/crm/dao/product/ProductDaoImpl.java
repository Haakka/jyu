package com.crm.dao.product;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.crm.bases.BaseHibernateDaoImpl;
import com.modules.commons.Pager;
import com.modules.util.StringUtil;

public class ProductDaoImpl extends BaseHibernateDaoImpl<Serializable> implements ProductDao {

	/*
	 * 分页查询
	 * @see com.crm.dao.product.ProductDao#retrieveProductsPager(int, int, java.lang.String)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Pager retrieveProductsPager(int pageSize, int pageNo, String keyWord) {
		StringBuffer hql = new StringBuffer();
		Map<String, Object> arrMap = new HashMap<String, Object>();
		hql.append(" from Product p where p.isDel = '0'  ");
		if (StringUtil.isNotBlank(keyWord)) {
			arrMap.put("keyWord", "%" + keyWord.replace("%", "\\%") + "%");
			hql.append(" and (p.name like :keyWord or p.price like :keyWord or p.costPrice like :keyWord or p.type.name like :keyWord or p.size like :keyWord or p.unit like :keyWord or str(p.addTime) like :keyWord) ");
		}
		List list = getCurrentSession().createQuery(hql.toString()).setProperties(arrMap)
		.setFirstResult((pageNo - 1) * pageSize).setMaxResults(pageSize).list();
		String hqlCount = "select count(p.id) " + hql ;
		return new Pager(pageSize, pageNo, Integer.parseInt(String.valueOf(getCurrentSession().createQuery(hqlCount).setProperties(arrMap).uniqueResult())), list);
	
	}


}