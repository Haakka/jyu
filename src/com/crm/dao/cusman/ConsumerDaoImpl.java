package com.crm.dao.cusman;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.crm.bases.BaseHibernateDaoImpl;
import com.modules.commons.Pager;
import com.modules.util.StringUtil;

public class ConsumerDaoImpl extends BaseHibernateDaoImpl<Serializable> implements ConsumerDao {

	/*
	 * 分页查询
	 * @see com.crm.dao.cusman.ConsumerDao#retrieveConsumersPager(int, int, java.lang.Long, java.lang.String)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Pager retrieveConsumersPager(int pageSize, int pageNo, Long userId, String keyWord) {
		StringBuffer hql = new StringBuffer();
		Map<String, Object> arrMap = new HashMap<String, Object>();
		hql.append("select new Consumer(c.id,c.name,c.phone,c.industryId,c.typeId,c.levelId,c.revenue,c.addTime,c.isLock,c.token) from Consumer c where c.isDel = '0' and c.userId.id = :userId ");
		if (StringUtil.isNotBlank(keyWord)) {
			arrMap.put("keyWord", "%" + keyWord.replace("%", "\\%") + "%");
			hql.append(" and (c.name like :keyWord or c.phone like :keyWord or c.industryId.name like :keyWord or c.typeId.name like :keyWord or c.levelId.name like :keyWord or str(c.addTime) like :keyWord) ");
		}
		arrMap.put("userId", userId);
		List list = getCurrentSession().createQuery(hql.toString()).setProperties(arrMap)
		.setFirstResult((pageNo - 1) * pageSize).setMaxResults(pageSize).list();
		String hqlCount = hql.toString().replace("select new Consumer(c.id,c.name,c.phone,c.industryId,c.typeId,c.levelId,c.revenue,c.addTime,c.isLock,c.token)", "select count(c.id)");
		return new Pager(pageSize, pageNo, Integer.parseInt(String.valueOf(getCurrentSession().createQuery(hqlCount).setProperties(arrMap).uniqueResult())), list);
	}

	/*
	 * 分页查询可回收客户
	 * @see com.crm.dao.cusman.ConsumerDao#retrieveAllTrash(int, int, java.lang.String)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Pager retrieveAllTrash(int pageSize, int pageNo, String keyWord) {
		StringBuffer hql = new StringBuffer();
		Map<String, Object> arrMap = new HashMap<String, Object>();
		hql.append("select new Consumer(c.id,c.name,c.phone,c.industryId,c.typeId,c.levelId,c.revenue,c.addTime,c.isLock,c.token) from Consumer c where c.isDel = '1' ");
		if (StringUtil.isNotBlank(keyWord)) {
			arrMap.put("keyWord", "%" + keyWord.replace("%", "\\%") + "%");
			hql.append(" and (c.name like :keyWord or c.phone like :keyWord or c.industryId.name like :keyWord or c.typeId.name like :keyWord or c.levelId.name like :keyWord or str(c.addTime) like :keyWord) ");
		}
		List list = getCurrentSession().createQuery(hql.toString()).setProperties(arrMap)
		.setFirstResult((pageNo - 1) * pageSize).setMaxResults(pageSize).list();
		String hqlCount = hql.toString().replace("select new Consumer(c.id,c.name,c.phone,c.industryId,c.typeId,c.levelId,c.revenue,c.addTime,c.isLock,c.token)", "select count(c.id)");
		return new Pager(pageSize, pageNo, Integer.parseInt(String.valueOf(getCurrentSession().createQuery(hqlCount).setProperties(arrMap).uniqueResult())), list);
	}

	/*
	 *  统计今日新增客户
	 * @see com.crm.dao.cusman.ConsumerDao#countTodayConsumer(java.lang.Long)
	 */
	@Override
	public int countTodayConsumer(Long userId) {
		String sql = "select count(ID) from crm_consumer where date_format(ADD_TIME,'%Y-%m-%d') = date_format(now(),'%Y-%m-%d') and USER_ID =:userId";
		return Integer.parseInt(String.valueOf(getCurrentSession().createSQLQuery(sql).setParameter("userId", userId).uniqueResult()));
	}

	/*
	 * 统计昨日新增客户
	 * @see com.crm.dao.cusman.ConsumerDao#countYesConsumer(java.lang.Long)
	 */
	@Override
	public int countYesConsumer(Long userId) {    
		String sql = "select count(ID) from crm_consumer where date(ADD_TIME)=curdate()-INTERVAL 1 day and USER_ID =:userId";
		return Integer.parseInt(String.valueOf(getCurrentSession().createSQLQuery(sql).setParameter("userId", userId).uniqueResult()));
	}
	
	


}