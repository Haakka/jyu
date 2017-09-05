/*
 * PersonMailAction.java
 * 
 * Create by MCGT
 * 
 * Create time 2017-03-28
 * 
 * Version 1.0
 * 
 * Copyright 2013 Messcat, Inc. All rights reserved.
 * 
 */
package com.crm.web.cusman;

import java.util.List;

import com.crm.entity.PersonMail;
import com.crm.entity.Users;
import com.crm.vo.ResultVo;
import com.modules.commons.CommonReturn;
import com.modules.commons.GetUsersInfo;
import com.modules.commons.PageAction;

public class PersonMailAction extends PageAction {
	
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private PersonMail personMail;
	
	private Long receiverId;
	
	private String token;
	
	private List<PersonMail> personMails;
	
	/**
	 * 分页查询
	 * @return
	 * @throws Exception
	 */
	public String retrieveAllPersonMails() throws Exception {
		try {
			Users user = GetUsersInfo.getUsers();
			resultVo = personMailService.retrievePersonMailsPager(pageSize, pageNo,user.getId());
		} catch (Exception ex) {
			resultVo = new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_EXCEPTION_POPUP,null);
			ex.printStackTrace();
		}
		return "success";
	}
	
	/**
	 * 根据Id和Token查询
	 * @return
	 * @throws Exception
	 */
	public String retrievePersonMailById() throws Exception {
		try {
			resultVo = personMailService.retrievePersonMail(id,token);
		} catch (Exception ex) {
			resultVo = new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_EXCEPTION_POPUP,null);
			ex.printStackTrace();
		}
		return "editPage";
	}

	/**
	 * 跳转添加
	 * @return
	 * @throws Exception
	 */
	public String newPage() throws Exception {
		return "newPage";
	}
	
	/**
	 * 查看
	 * @return
	 * @throws Exception
	 */
	public String viewPage() throws Exception {
		try {
			resultVo = personMailService.retrievePersonMail(id,token);
		} catch (Exception ex) {
			resultVo = new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_EXCEPTION_POPUP,null);
			ex.printStackTrace();
		}
		return "viewPage";
	}
	
	/**
	 * 添加
	 * @return
	 * @throws Exception
	 */
	public String newPersonMail() throws Exception {
		try {
			Users user = GetUsersInfo.getUsers();
			resultVo = personMailService.addPersonMail(personMail,user,receiverId);
		} catch (Exception ex) {
			resultVo = new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_EXCEPTION_POPUP,null);
			ex.printStackTrace();
		}
		return "edit_success";
	}
	
	/**
	 * 编辑
	 * @return
	 * @throws Exception
	 */
	public String editPersonMail() throws Exception {
		try {
			resultVo = personMailService.modifyPersonMail(personMail);
		} catch (Exception ex) {
			resultVo = new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_EXCEPTION_POPUP,null);
			ex.printStackTrace();
		}
		return "edit_success";
	}
	
	/**
	 * 删除
	 * @return
	 * @throws Exception
	 */
	public String delPersonMail() throws Exception {
		try {
			resultVo = personMailService.removePersonMail(id,token);
		} catch (Exception ex) {
			resultVo = new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_EXCEPTION_POPUP,null);
			ex.printStackTrace();
		}
		return "edit_success";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PersonMail getPersonMail() {
		return personMail;
	}

	public void setPersonMail(PersonMail personMail) {
		this.personMail = personMail;
	}

	public List<PersonMail> getPersonMails() {
		return personMails;
	}

	public void setPersonMails(
			List<PersonMail> personMails) {
		this.personMails = personMails;
	}

}