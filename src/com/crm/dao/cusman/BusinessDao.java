package com.crm.dao.cusman;

import java.io.Serializable;
import java.util.List;

import com.crm.bases.BaseHibernateDao;
import com.crm.entity.Consumer;
import com.modules.commons.Pager;

public interface BusinessDao extends BaseHibernateDao<Serializable>{
	
	/**
	 * 根据负责人Id查询客户
	 * @param id
	 * @return
	 */
	public List<Consumer> findConsumerByAssignerId(Long id);
	
	/**
	 * 分页查询
	 * @param pageSize
	 * @param pageNo
	 * @param userId
	 * @param keyWord
	 * @return
	 */
	public Pager retrieveBusinesssPager(int pageSize, int pageNo, Long userId,String keyWord);
	
	/**
	 * 根据客户Id查询商机
	 * @param id
	 * @return
	 */
	public List findBusinessByComId(Long id);

	/**
	 * 统计今日新增记录
	 * @param id
	 * @return
	 */
	public int countBis(Long id);

}