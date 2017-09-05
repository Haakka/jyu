
package com.crm.dao.system;

import java.util.List;

import com.crm.entity.Roles;
import com.modules.commons.Pager;

public interface RolesDao {

	public Roles get(Long long1);

	public void save(Roles roles);

	public void update(Roles roles);

	public void delete(Roles roles);

	public void delete(Long long1);

	public List findAll();

	public List findAllBYState(String s);

	public boolean isNameUnique(String s);

	public Pager getObjectListByClass(int i, int j, Class class1, String s);

	public List getInfoByClassAndSize(String s, Long long1, Long long2, String s1, String s2, String s3, Long long3,
		String s4);
}