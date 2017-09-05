package com.modules.commons;

import java.util.Map;

import com.crm.entity.Users;
import com.opensymphony.xwork2.ActionContext;

/**
 * 获取当前用户
 * @author Stephen
 *
 */
public class GetUsersInfo {

	@SuppressWarnings("rawtypes")
	public static Users getUsers(){
		Map session = ActionContext.getContext().getSession();
		Users users = (Users)session.get("users");
		return users;
	}
}
