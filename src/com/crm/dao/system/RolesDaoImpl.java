
package com.crm.dao.system;

import java.util.List;

import com.crm.bases.BaseDaoImpl;
import com.crm.entity.Roles;


public class RolesDaoImpl extends BaseDaoImpl implements RolesDao {

	public RolesDaoImpl() {
	}

	public void delete(Roles roles) {
		getHibernateTemplate().delete(roles);
	}

	public void delete(Long id) {
		getHibernateTemplate().delete(get(id));
	}

	public List findAll() {
		List find = getHibernateTemplate().find("from Roles order by addTime asc");
		getSessionFactory().getCurrentSession().flush();
		return find;
	}

	public List findAllBYState(String state) {
		List find = getHibernateTemplate().find("from Roles where state = ?", state);
		getSessionFactory().getCurrentSession().flush();
		return find;
	}

	public Roles get(Long id) {
		return (Roles) getHibernateTemplate().get(Roles.class, id);
	}

	public void save(Roles roles) {
		getSessionFactory().getCurrentSession().clear();
		getHibernateTemplate().save(roles);
	}

	public void update(Roles roles) {
		getSessionFactory().getCurrentSession().clear();
		getHibernateTemplate().saveOrUpdate(roles);
	}

	public boolean isNameUnique(String name) {
		List temp = getHibernateTemplate().find("from Roles where name = ?", name.trim());
		getSessionFactory().getCurrentSession().flush();
		return temp.size() <= 0;
	}
}