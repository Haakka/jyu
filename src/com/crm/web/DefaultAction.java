package com.crm.web;

import java.util.Map;
import java.util.Properties;

import com.crm.bases.BaseAction;
import com.crm.entity.Users;
import com.modules.constants.ActionConstants;
import com.opensymphony.xwork2.ActionContext;

public class DefaultAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Properties prop;
	private String isFine;
	private int epMessCount;
	private int userMessCount;
	private int todayNewConsumer;
	private int yesNewConsumer;
	private int todayNewFollow;
	private int totalBusiness;

	public String execute() throws Exception {
		
		
		prop = System.getProperties();
		if (this.usersManagerDao.isFullInfo())
			isFine = "1";
		else
			isFine = "0";

		Map session = ActionContext.getContext().getSession();
		Users users = (Users) session.get("users");

		todayNewConsumer = consumerService.countTodayConsumer(users.getId());
		yesNewConsumer = consumerService.countYesConsumer(users.getId());
		totalBusiness = businessService.countBis(users.getId());
		todayNewFollow = followService.countTodayNewFollow(users.getId());
		return ActionConstants.SUCCESS_KEY;
	}

	public Properties getProp() {
		return prop;
	}

	public void setProp(Properties prop) {
		this.prop = prop;
	}

	public String getIsFine() {
		return isFine;
	}

	public void setIsFine(String isFine) {
		this.isFine = isFine;
	}

	public int getEpMessCount() {
		return epMessCount;
	}

	public void setEpMessCount(int epMessCount) {
		this.epMessCount = epMessCount;
	}

	public int getUserMessCount() {
		return userMessCount;
	}

	public void setUserMessCount(int userMessCount) {
		this.userMessCount = userMessCount;
	}

	public int getTodayNewConsumer() {
		return todayNewConsumer;
	}

	public void setTodayNewConsumer(int todayNewConsumer) {
		this.todayNewConsumer = todayNewConsumer;
	}

	public int getYesNewConsumer() {
		return yesNewConsumer;
	}

	public void setYesNewConsumer(int yesNewConsumer) {
		this.yesNewConsumer = yesNewConsumer;
	}

	public int getTodayNewFollow() {
		return todayNewFollow;
	}

	public void setTodayNewFollow(int todayNewFollow) {
		this.todayNewFollow = todayNewFollow;
	}

	public int getTotalBusiness() {
		return totalBusiness;
	}

	public void setTotalBusiness(int totalBusiness) {
		this.totalBusiness = totalBusiness;
	}
	
	

}