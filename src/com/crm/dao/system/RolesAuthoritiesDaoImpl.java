
package com.crm.dao.system;

import java.util.List;

import com.crm.bases.BaseDaoImpl;
import com.crm.entity.RolesAuthorities;

public class RolesAuthoritiesDaoImpl extends BaseDaoImpl implements RolesAuthoritiesDao {

	public RolesAuthoritiesDaoImpl() {
	}

	public void delete(RolesAuthorities rolesAuthorities) {
		getHibernateTemplate().delete(rolesAuthorities);
	}

	public void delete(Long id) {
		getHibernateTemplate().delete(get(id));
	}

	public List findAll() {
		List find = getHibernateTemplate().find("from RolesAuthorities");
		return find;
	}

	public RolesAuthorities get(Long id) {
		return (RolesAuthorities) getHibernateTemplate().get(RolesAuthorities.class, id);
	}

	public void save(RolesAuthorities rolesAuthorities) {
		getHibernateTemplate().save(rolesAuthorities);
	}

	public void update(RolesAuthorities rolesAuthorities) {
		getSessionFactory().getCurrentSession().clear();
		getHibernateTemplate().saveOrUpdate(rolesAuthorities);
	}

	public List findByRolesId(Long id) {
		return getHibernateTemplate().find("from RolesAuthorities where roles.id = ?", id);
	}

	public List findByAuthId(Long id) {
		return getHibernateTemplate().find("from RolesAuthorities where authorities.id = ?", id);
	}
}