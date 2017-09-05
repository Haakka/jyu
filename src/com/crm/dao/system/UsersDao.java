package com.crm.dao.system;

import java.util.List;

import com.crm.entity.Users;
import com.modules.commons.Pager;

public interface UsersDao {

	public Users get(String s);

	public Users get(String s, String s1);

	public Users get(Long long1);

	public void save(Users users);

	public void update(Users users);

	public void delete(Users users);

	public void delete(Long long1);

	public List findAll();

	public boolean isNameUnique(String s);

	public Pager getAllUsers(int pageSize, int pageNo, Class classObject, String statu, String area);

	public List getLinksAndAdByClassAndSize(Class class1, Long long1);

	public Users getUserByUnit(String area);
	
	public List getUserByName(String name);
}