package com.crm.dao.cusman;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.crm.bases.BaseHibernateDaoImpl;
import com.modules.commons.Pager;
import com.modules.util.StringUtil;

public class InvoiceDaoImpl extends BaseHibernateDaoImpl<Serializable> implements InvoiceDao {

	/*
	 * 分页查询
	 * @see com.crm.dao.cusman.InvoiceDao#retrieveInvoicesPager(int, int, java.lang.String)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Pager retrieveInvoicesPager(int pageSize, int pageNo, String keyWord) {
		StringBuffer hql = new StringBuffer();
		Map<String, Object> arrMap = new HashMap<String, Object>();
		hql.append(" from Invoice i where i.isDel = '0' ");
		if (StringUtil.isNotBlank(keyWord)) {
			arrMap.put("keyWord", "%" + keyWord.replace("%", "\\%") + "%");
			hql.append(" and ( i.num like :keyWord or i.code like :keyWord or i.payer like :keyWord or i.payerAddress like :keyWord or i.payerTel like :keyWord or i.payerBank like :keyWord or i.payerAcount like :keyWord "
					+ " or i.receiver like :keyWord or i.receiverAdderss like :keyWord or i.receiverTel like :keyWord or i.receiverBank like :keyWord or i.receiverAcount like :keyWord "
					+ " or str(i.addTime) like :keyWord or str(i.startDate) like :keyWord ) ");
		}
		List list = getCurrentSession().createQuery(hql.toString()).setProperties(arrMap)
		.setFirstResult((pageNo - 1) * pageSize).setMaxResults(pageSize).list();
		String hqlCount = "select count(i.id)" + hql;
		return new Pager(pageSize, pageNo, Integer.parseInt(String.valueOf(getCurrentSession().createQuery(hqlCount).setProperties(arrMap).uniqueResult())), list);
	}

}