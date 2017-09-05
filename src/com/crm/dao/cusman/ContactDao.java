package com.crm.dao.cusman;

import java.io.Serializable;
import java.util.List;

import com.crm.bases.BaseHibernateDao;
import com.modules.commons.Pager;


public interface ContactDao extends BaseHibernateDao<Serializable>{

	/**
	 * 分页查询
	 * @param pageSize
	 * @param pageNo
	 * @param userId
	 * @param keyWord
	 * @return
	 */
	public Pager retrieveContactsPager(int pageSize, int pageNo, Long userId,String keyWord);
	
	/**
	 * 分页查询可回收的联系人
	 * @param pageSize
	 * @param pageNo
	 * @param keyWord
	 * @return
	 */
	public Pager retrieveAllTrash(int pageSize, int pageNo,String keyWord);

	/**
	 * 根据客户Id查询联系人
	 * @param id
	 * @return
	 */
	public List findContactByConsumerId(Long id);
	
}