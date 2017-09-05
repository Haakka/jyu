package com.crm.dao.system;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;

import com.crm.bases.BaseDaoImpl;
import com.crm.entity.LoginLog;
import com.modules.commons.Pager;

public class LoginLogDaoImpl extends BaseDaoImpl implements LoginLogDao {

	public void save(LoginLog loginLog) {
		getHibernateTemplate().save(loginLog);
	}
	
	public void update(LoginLog loginLog) {
		getHibernateTemplate().update(loginLog);
	}
	
	public void delete(LoginLog loginLog) {
		getHibernateTemplate().delete(loginLog);
	}

	public void delete(Long id) {
		getHibernateTemplate().delete(this.get(id));
	}
	
	public LoginLog get(Long id) {
		return (LoginLog) getHibernateTemplate().get(LoginLog.class, id);
	}

	@SuppressWarnings("unchecked")
	public List findAll() {
		return getHibernateTemplate().find("from LoginLog");
	}

	@SuppressWarnings("unchecked")
	public Pager getPager(int pageSize, int pageNo) {
		Session session = this.getSession();
		Criteria criteria = session.createCriteria(LoginLog.class);
		int rowCount = ((Integer) criteria.setProjection(Projections.rowCount()).uniqueResult()).intValue();
		criteria.setProjection(null);
		int startIndex = pageSize * (pageNo - 1);
		criteria.setFirstResult(startIndex);
		criteria.setMaxResults(pageSize);
		List result = criteria.list();
		return new Pager(pageSize, pageNo, rowCount, result);
	}

}