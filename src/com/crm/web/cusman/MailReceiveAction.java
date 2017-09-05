package com.crm.web.cusman;

import java.util.List;

import com.crm.entity.MailReceive;
import com.crm.entity.Users;
import com.crm.vo.ResultVo;
import com.modules.commons.CommonReturn;
import com.modules.commons.GetUsersInfo;
import com.modules.commons.PageAction;
import com.modules.commons.Pager;

public class MailReceiveAction extends PageAction {
	
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String token;
	
	private MailReceive mailReceive;
	
	private List<MailReceive> mailReceives;
	
	/**
	 * 分页查询
	 * @return
	 * @throws Exception
	 */
	public String retrieveAllMailReceives() throws Exception {
		try {
			Users user = GetUsersInfo.getUsers();
			resultVo = mailReceiveService.retrieveMailReceivesPager(pageSize, pageNo,user.getId());
			pager = (Pager) resultVo.getResult();
		} catch (Exception ex) {
			resultVo = new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_EXCEPTION_POPUP,null);
			ex.printStackTrace();
		}
		return "success";
	}
	
	/**
	 * 根据ID和token查询
	 * @return
	 * @throws Exception
	 */
	public String viewPage() throws Exception {
		try {
			resultVo = mailReceiveService.retrieveMailReceive(id,token);
		} catch (Exception ex) {
			resultVo = new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_EXCEPTION_POPUP,null);
			ex.printStackTrace();
		}
		return "viewPage";
	}
	
	/**
	 * 删除
	 * @return
	 * @throws Exception
	 */
	public String delMailReceive() throws Exception {
		try {
			resultVo = mailReceiveService.removeMailReceive(id,token);
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

	public MailReceive getMailReceive() {
		return mailReceive;
	}

	public void setMailReceive(MailReceive mailReceive) {
		this.mailReceive = mailReceive;
	}

	public List<MailReceive> getMailReceives() {
		return mailReceives;
	}

	public void setMailReceives(
			List<MailReceive> mailReceives) {
		this.mailReceives = mailReceives;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	

}