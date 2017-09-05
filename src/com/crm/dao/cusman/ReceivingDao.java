package com.crm.dao.cusman;

import java.io.Serializable;

import com.crm.bases.BaseHibernateDao;
import com.modules.commons.Pager;

public interface ReceivingDao extends BaseHibernateDao<Serializable>{

	/**
	 * 分页查询
	 * @param pageSize
	 * @param pageNo
	 * @param keyWords
	 * @return
	 */
	public Pager retrieveReceivingsPager(int pageSize, int pageNo, String keyWords);

}