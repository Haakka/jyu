package com.crm.web.system;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.crm.bases.BaseAction;

public class CheckCodeAction extends BaseAction {

	private static final long serialVersionUID = 0xe1bca1fd8ed0ad1dL;

	public CheckCodeAction() {
	}

	public String checkCode() throws Exception {
		clearMessages();
		HttpServletRequest request = ServletActionContext.getRequest();
		String rand = request.getParameter("vercode");
		HttpSession session = request.getSession(false);
		String checkCode = session.getAttribute("rand") != null ? (String) session.getAttribute("rand") : "";
		rand = rand.toUpperCase();
		checkCode = checkCode.toUpperCase();
		if (checkCode.equalsIgnoreCase(rand)) {
			session.setAttribute("rand", null);
			return renderText("true");
		} else {
			this.addActionMessage("验证码不正确.");
			return renderText("false");
		}
	}

}