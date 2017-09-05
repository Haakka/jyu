
package com.crm.dao.system;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import com.crm.bases.BaseDaoImpl;
import com.crm.entity.UsersRoles;

public class UsersRolesDaoImpl extends BaseDaoImpl implements UsersRolesDao {

	public UsersRolesDaoImpl() {
	}

	public void delete(UsersRoles usersRoles) {
		getHibernateTemplate().delete(usersRoles);
	}

	public void delete(Long id) {
		getHibernateTemplate().delete(get(id));
	}

	public List findAll() {
		List find = getHibernateTemplate().find("from UsersRoles");
		return find;
	}

	public UsersRoles get(Long id) {
		return (UsersRoles) getHibernateTemplate().load(UsersRoles.class, id);
	}

	public void save(UsersRoles usersRoles) {
		getHibernateTemplate().save(usersRoles);
	}

	public void update(UsersRoles usersRoles) {
		getSessionFactory().getCurrentSession().clear();
		getHibernateTemplate().saveOrUpdate(usersRoles);
	}

	public List findByUsersId(Long id) {
		return getHibernateTemplate().find("from UsersRoles where users.id = ?", id);
	}

	public void deleteUsersRoleByUserId(Long userId) {
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		StringBuffer sql = new StringBuffer();
		sql.append("delete UsersRoles where users.id=" + userId);
		Query query = session.createQuery(sql.toString());
		//int dels =
		query.executeUpdate();
		tx.commit();
		session.close();
	}

	public List findByRolesId(Long id) {
		return getHibernateTemplate().find("from UsersRoles where roles.id = ?", id);
	}
}