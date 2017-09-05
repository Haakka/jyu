
package com.crm.dao.system;

import java.util.List;

import com.crm.entity.UsersRoles;
import com.modules.commons.Pager;

public interface UsersRolesDao {

	public UsersRoles get(Long long1);

	public void save(UsersRoles usersroles);

	public void update(UsersRoles usersroles);

	public void delete(UsersRoles usersroles);

	public void delete(Long long1);

	public List findAll();

	public Pager getObjectListByClass(int i, int j, Class class1, String s);

	public List getLinksAndAdByClassAndSize(Class class1, Long long1);

	public List findByUsersId(Long long1);

	public List findByRolesId(Long long1);

	public void deleteUsersRoleByUserId(Long userId);
}