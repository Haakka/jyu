package com.crm.dao.orders;

import java.io.Serializable;

import com.crm.bases.BaseHibernateDao;
import com.modules.commons.Pager;

public interface OrderDao extends BaseHibernateDao<Serializable>{

	/**
	 * 分页查询
	 * @param pageSize
	 * @param pageNo
	 * @param isDel
	 * @param keyWord
	 * @return
	 */
	public Pager retrieveOrdersPager(int pageSize, int pageNo,String isDel,String keyWord);
}