package com.crm.dao.cusman;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.crm.bases.BaseHibernateDaoImpl;
import com.crm.entity.Consumer;
import com.modules.commons.Pager;
import com.modules.util.BeanUtil;
import com.modules.util.StringUtil;

public class BusinessDaoImpl extends BaseHibernateDaoImpl<Serializable> implements BusinessDao {

	/*
	 * 根据负责人Id查询客户
	 * @see com.crm.dao.cusman.BusinessDao#findConsumerByBusinesssId(java.lang.Long)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Consumer> findConsumerByAssignerId(Long id) {
		String hql = "select b.consumer from Business b where b.assigner.id = :id";
		return getCurrentSession().createQuery(hql).setParameter("id", id).list();
	}

	/*
	 * 分页查询
	 * @see com.crm.dao.cusman.BusinessDao#retrieveBusinesssPager(int, int, java.lang.Long, java.lang.String)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Pager retrieveBusinesssPager(int pageSize, int pageNo, Long userId, String keyWord) {
		StringBuffer hql = new StringBuffer();
		Map<String, Object> arrMap = new HashMap<String, Object>();
		hql.append("select b from Business b where b.isDel = '0' and b.userId.id = :userId ");
		if (StringUtil.isNotBlank(keyWord)) {
			arrMap.put("keyWord", "%" + keyWord.replace("%", "\\%") + "%");
			hql.append(" and (b.name like :keyWord or b.originId.name like :keyWord or b.typeId.name like :keyWord or b.valueId.name like :keyWord or str(b.addTime) like :keyWord or b.consumer.name like :keyWord or b.contactor.name like :keyWord )");
		}
		arrMap.put("userId", userId);
		List list = getCurrentSession().createQuery(hql.toString()).setProperties(arrMap)
		.setFirstResult((pageNo - 1) * pageSize).setMaxResults(pageSize).list();
		String hqlCount = hql.toString().replace("select b",
				"select count(b.id)");
		return new Pager(pageSize, pageNo, Integer.parseInt(String.valueOf(getCurrentSession().createQuery(hqlCount).setProperties(arrMap).uniqueResult())), list);
	}

	/*
	 * 根据客户Id查询商机
	 * @see com.crm.dao.cusman.BusinessDao#findBusinessByComId(java.lang.Long)
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List findBusinessByComId(Long id) {
		String sql = "select ID,NAME from crm_business where CONSUMER = :id and IS_DEL = '0' and STATUS = '4' order by ID asc";
		List list = getCurrentSession().createSQLQuery(sql).setParameter("id", id).list();
		String [] param ={"id","name"};
		list = BeanUtil.changeObjectArrayToMaps(list, param);
		return list;
	}

	/*
	 * 统计记录
	 * @see com.crm.dao.cusman.BusinessDao#findTodayNewBis(java.lang.Long)
	 */
	@Override
	public int countBis(Long id) {
		String sql = "select count(ID) from crm_business where IS_DEL = '0' and  USER_ID =:userId";
		return Integer.parseInt(String.valueOf(getCurrentSession().createSQLQuery(sql).setParameter("userId", id).uniqueResult()));
	}


}