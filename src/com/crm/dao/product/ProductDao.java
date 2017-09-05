package com.crm.dao.product;

import java.io.Serializable;

import com.crm.bases.BaseHibernateDao;
import com.modules.commons.Pager;

public interface ProductDao extends BaseHibernateDao<Serializable>{

	/**
	 *  分页查询
	 * @param pageSize
	 * @param pageNo
	 * @param keyWord
	 * @return
	 */
	public Pager retrieveProductsPager(int pageSize, int pageNo,String keyWord);
	
}