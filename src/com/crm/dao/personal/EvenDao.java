package com.crm.dao.personal;

import java.io.Serializable;

import com.crm.bases.BaseHibernateDao;
import com.modules.commons.Pager;

public interface EvenDao extends BaseHibernateDao<Serializable>{

	/**
	 *  分页查询
	 * @param pageSize
	 * @param pageNo
	 * @param userId
	 * @param keyWord
	 * @return
	 */
	public Pager retrieveEvensPager(int pageSize, int pageNo, Long userId,String keyWord);
}