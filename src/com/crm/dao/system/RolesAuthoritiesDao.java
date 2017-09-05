
package com.crm.dao.system;

import java.util.List;

import com.crm.entity.RolesAuthorities;
import com.modules.commons.Pager;

public interface RolesAuthoritiesDao {

	public RolesAuthorities get(Long long1);

	public void save(RolesAuthorities rolesauthorities);

	public void update(RolesAuthorities rolesauthorities);

	public void delete(RolesAuthorities rolesauthorities);

	public void delete(Long long1);

	public List findAll();

	public List findByRolesId(Long long1);

	public List findByAuthId(Long long1);

	public Pager getObjectListByClass(int i, int j, Class class1, String s);

	public List getInfoByClassAndSize(String s, Long long1, Long long2, String s1, String s2, String s3, Long long3,
		String s4);
}