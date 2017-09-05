package com.crm.dao.cusman;

import java.io.Serializable;

import com.crm.bases.BaseHibernateDao;
import com.modules.commons.Pager;

public interface InvoiceDao extends BaseHibernateDao<Serializable>{


	/**
	 * 分页查询
	 * @param pageSize
	 * @param pageNo
	 * @param keyWord
	 * @return
	 */
	public Pager retrieveInvoicesPager(int pageSize, int pageNo,String keyWord);
}