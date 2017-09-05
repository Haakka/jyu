package com.crm.dao.cusman;

import java.io.Serializable;

import com.crm.bases.BaseHibernateDao;
import com.modules.commons.Pager;

public interface FollowDao extends BaseHibernateDao<Serializable>{

	
	/**
	 * 分页查询
	 * @param pageSize
	 * @param pageNo
	 * @param userId
	 * @param keyWord
	 * @return
	 */
	public Pager retrieveFollowsPager(int pageSize, int pageNo, Long userId,String keyWord);

	/**
	 * 统计今日新增记录
	 * @param id
	 * @return
	 */
	public int countTodayNewFollow(Long id);
}