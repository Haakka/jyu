package com.crm.dao.cusman;

import java.io.Serializable;

import com.crm.bases.BaseHibernateDao;
import com.modules.commons.Pager;

public interface ConsumerDao extends BaseHibernateDao<Serializable>{

	/**
	 * 分页查询
	 * @param pageSize
	 * @param pageNo
	 * @param userId
	 * @param keyWord
	 * @return
	 */
	public Pager retrieveConsumersPager(int pageSize, int pageNo,Long userId,String keyWord);
	
	/**
	 * 分页查询可回收客户
	 * @param pageSize
	 * @param pageNo
	 * @param keyWord
	 * @return
	 */
	public Pager retrieveAllTrash(int pageSize, int pageNo,String keyWord);

	/**
	 *  统计今日新增客户
	 * @param userId
	 * @return
	 */
	public int countTodayConsumer(Long userId);

	/**
	 * 统计昨日新增客户
	 * @param userId
	 * @return
	 */
	public int countYesConsumer(Long userId);
	
}