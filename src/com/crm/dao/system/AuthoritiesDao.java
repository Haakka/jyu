
package com.crm.dao.system;

import java.util.List;

import com.crm.entity.Authorities;
import com.modules.commons.Pager;

public interface AuthoritiesDao {

	public Authorities get(Long long1);

	public void save(Authorities authorities);

	public void update(Authorities authorities);

	public void delete(Authorities authorities);

	public void delete(Long long1);

	public List findAll();

	public boolean isNameUnique(String s);

	public boolean isDisplayNameUnique(String s);

	public List findAuthoritiesByTypeId(Long long1);

	public Pager getObjectListByClass(int i, int j, Class class1, String s);

	public List getInfoByClassAndSize(String s, Long long1, Long long2, String s1, String s2, String s3, Long long3,
		String s4);

	public Authorities getByName(String name);
	
	//根据权限名与权限类型查找权限
	public Authorities getByNameAndType(String name, String type);
	
	//根据权限类型查询
	public List<Authorities> findAuthoritiesByType(String type);
	
	//根据权限类型查询除某个ID外的权限列表
	public List<Authorities> findAuthoritiesByTypeAndId(String type, Long id);

	//根据显示名称查询
	public Authorities getAuthByDisplayName(String displayName);

}