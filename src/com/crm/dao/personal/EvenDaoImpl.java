package com.crm.dao.personal;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.crm.bases.BaseHibernateDaoImpl;
import com.modules.commons.Pager;
import com.modules.util.StringUtil;

public class EvenDaoImpl extends BaseHibernateDaoImpl<Serializable> implements EvenDao {

	/*
	 * 分页查询
	 * @see com.crm.dao.personal.EvenDao#retrieveEvensPager(int, int, java.lang.Long, java.lang.String)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Pager retrieveEvensPager(int pageSize, int pageNo, Long userId, String keyWord) {
		StringBuffer hql = new StringBuffer();
		Map<String, Object> arrMap = new HashMap<String, Object>();
		hql.append(" from Even e where e.isDel = '0' and e.userId.id =:id  ");
		if (StringUtil.isNotBlank(keyWord)) {
			arrMap.put("keyWord", "%" + keyWord.replace("%", "\\%") + "%");
			hql.append(" and (e.subject like :keyWord or e.venue like :keyWord or e.consumer.name like :keyWord or e.contactor.name like :keyWord or str(e.startDate) like :keyWord or str(e.endDate) like :keyWord ) ");
		}
		List list = getCurrentSession().createQuery(hql.toString()).setProperties(arrMap).setParameter("id", userId)
		.setFirstResult((pageNo - 1) * pageSize).setMaxResults(pageSize).list();
		String hqlCount = "select count(e.id) " + hql ;
		return new Pager(pageSize, pageNo, Integer.parseInt(String.valueOf(getCurrentSession().createQuery(hqlCount).setProperties(arrMap).setParameter("id", userId).uniqueResult())), list);
	}


}