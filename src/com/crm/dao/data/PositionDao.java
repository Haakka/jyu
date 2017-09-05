package com.crm.dao.data;

import java.io.Serializable;

import com.crm.bases.BaseHibernateDao;
import com.modules.commons.Pager;

public interface PositionDao extends BaseHibernateDao<Serializable>{

	
	/**
	 * 分页查询
	 * @param pageSize
	 * @param pageNo
	 * @param departmentId
	 * @param token
	 * @param keyWord
	 * @return
	 */
	public Pager retrievePositionsPager(int pageSize, int pageNo, Long departmentId,String token,String keyWord);
}