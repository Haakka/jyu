package com.crm.dao.cusman;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.crm.bases.BaseHibernateDaoImpl;
import com.modules.commons.Pager;
import com.modules.util.StringUtil;

public class FollowDaoImpl extends BaseHibernateDaoImpl<Serializable> implements FollowDao {

	/*
	 * 分页查询
	 * @see com.crm.dao.cusman.FollowDao#retrieveFollowsPager(int, int, java.lang.Long, java.lang.String)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Pager retrieveFollowsPager(int pageSize, int pageNo, Long userId, String keyWord) {
		StringBuffer hql = new StringBuffer();
		Map<String, Object> arrMap = new HashMap<String, Object>();
		hql.append(" from Follow f where f.isDel = '0' and f.follower.id =:id ");
		if (StringUtil.isNotBlank(keyWord)) {
			arrMap.put("keyWord", "%" + keyWord.replace("%", "\\%") + "%");
			hql.append(" and (f.consumerId.name like :keyWord or f.type.name like :keyWord or str(f.followTime) like :keyWord ) ");
		}
		List list = getCurrentSession().createQuery(hql.toString()).setProperties(arrMap).setParameter("id", userId)
		.setFirstResult((pageNo - 1) * pageSize).setMaxResults(pageSize).list();
		String hqlCount = "select count(f.id) " + hql ;
		return new Pager(pageSize, pageNo, Integer.parseInt(String.valueOf(getCurrentSession().createQuery(hqlCount).setProperties(arrMap).setParameter("id", userId).uniqueResult())), list);
	}

	/*
	 * 统计今日新增记录
	 * @see com.crm.dao.cusman.FollowDao#countTodayNewFollow(java.lang.Long)
	 */
	@Override
	public int countTodayNewFollow(Long id) {
		String sql = "select count(ID) from crm_follow where date_format(ADD_TIME,'%Y-%m-%d') = date_format(now(),'%Y-%m-%d') and FOLLOWER =:userId";
		return Integer.parseInt(String.valueOf(getCurrentSession().createSQLQuery(sql).setParameter("userId", id).uniqueResult()));
	}


}