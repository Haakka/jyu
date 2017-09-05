package com.crm.dao.cusman;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.crm.bases.BaseHibernateDaoImpl;
import com.modules.commons.Pager;
import com.modules.util.BeanUtil;
import com.modules.util.StringUtil;


public class ContactDaoImpl extends BaseHibernateDaoImpl<Serializable> implements ContactDao {

	/*
	 * 分页查询
	 * @see com.crm.dao.cusman.ContactDao#retrieveContactsPager(int, int, java.lang.Long, java.lang.String)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Pager retrieveContactsPager(int pageSize, int pageNo, Long userId, String keyWord) {
		StringBuffer hql = new StringBuffer();
		Map<String, Object> arrMap = new HashMap<String, Object>();
		hql.append("select new Contact(c.id,c.name,c.phone,c.sex,c.displayName,c.position,c.department,c.addTime,c.consumerId,c.token) from Contact c where c.isDel = '0' and c.userId.id = :userId ");
		if (StringUtil.isNotBlank(keyWord)) {
			arrMap.put("keyWord", "%" + keyWord.replace("%", "\\%") + "%");
			hql.append(" and (c.name like :keyWord or c.phone like :keyWord or c.displayName like :keyWord or c.consumerId.name like :keyWord or c.department like :keyWord or c.position like :keyWord or str(c.addTime) like :keyWord) ");
		}
		arrMap.put("userId", userId);
		List list = getCurrentSession().createQuery(hql.toString()).setProperties(arrMap)
		.setFirstResult((pageNo - 1) * pageSize).setMaxResults(pageSize).list();
		String hqlCount = hql.toString().replace("select new Contact(c.id,c.name,c.phone,c.sex,c.displayName,c.position,c.department,c.addTime,c.consumerId,c.token)", "select count(c.id)");
		return new Pager(pageSize, pageNo, Integer.parseInt(String.valueOf(getCurrentSession().createQuery(hqlCount).setProperties(arrMap).uniqueResult())), list);
	}

	/*
	 * 分页查询可回收的联系人
	 * @see com.crm.dao.cusman.ContactDao#retrieveAllTrash(int, int, java.lang.String)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Pager retrieveAllTrash(int pageSize, int pageNo, String keyWord) {
		StringBuffer hql = new StringBuffer();
		Map<String, Object> arrMap = new HashMap<String, Object>();
		hql.append("select new Contact(c.id,c.name,c.phone,c.sex,c.displayName,c.position,c.department,c.addTime,c.consumerId,c.token) from Contact c where c.isDel = '1'  ");
		if (StringUtil.isNotBlank(keyWord)) {
			arrMap.put("keyWord", "%" + keyWord.replace("%", "\\%") + "%");
			hql.append(" and (c.name like :keyWord or c.phone like :keyWord or c.displayName like :keyWord or c.consumerId.name like :keyWord or c.department like :keyWord or c.position like :keyWord or str(c.addTime) like :keyWord) ");
		}
		List list = getCurrentSession().createQuery(hql.toString()).setProperties(arrMap)
		.setFirstResult((pageNo - 1) * pageSize).setMaxResults(pageSize).list();
		String hqlCount = hql.toString().replace("select new Contact(c.id,c.name,c.phone,c.sex,c.displayName,c.position,c.department,c.addTime,c.consumerId,c.token)", "select count(c.id)");
		return new Pager(pageSize, pageNo, Integer.parseInt(String.valueOf(getCurrentSession().createQuery(hqlCount).setProperties(arrMap).uniqueResult())), list);
	}
	
	/*
	 * 根据客户Id查询联系人
	 * @see com.crm.dao.cusman.ContactDao#findContactByConsumerId(java.lang.Long)
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List findContactByConsumerId(Long id) {
		String sql = "select ID,NAME from crm_contact where CONSUMER_ID = :id and IS_DEL = '0' order by ID asc";
		List list = getCurrentSession().createSQLQuery(sql).setParameter("id", id).list();
		String [] param ={"id","name"};
		list = BeanUtil.changeObjectArrayToMaps(list, param);
		return list;
	}


}