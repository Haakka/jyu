// Decompiled by DJ v2.9.9.60 Copyright 2000 Atanas Neshkov  Date: 2010-5-13 14:33:18
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   UsersRolesManagerDao.java

package com.crm.service.system;

import java.util.List;

import com.crm.entity.UsersRoles;
import com.modules.commons.Pager;

public interface UsersRolesManagerDao {

	public UsersRoles getUsersRoles(Long long1);

	public Pager findUsersRoles(int i, int j, String s);

	public List findAllBYState(String s);

	public void addUsersRoles(UsersRoles usersroles);

	public void updateUsersRoles(UsersRoles usersroles);

	public void deleteUsersRoles(Long long1);

	public void deleteUsersRolesByUsersId(Long long1);

	public List findUsersRoles();

	public boolean isNameUnique(String s, String s1);
}