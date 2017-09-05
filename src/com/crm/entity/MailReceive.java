package com.crm.entity;

import java.io.Serializable;

/**
 * 邮件 接收方
 * @author Stephen
 *
 */
public class MailReceive implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private PersonMail mailId;
	private Users receiver;
	private String isDel;
	private String isView;
	private String token;
	
	public MailReceive() {
		
	}

	public MailReceive(Long id, PersonMail mailId, Users receiver, String isDel, String isView,String token) {
		super();
		this.id = id;
		this.mailId = mailId;
		this.receiver = receiver;
		this.isDel = isDel;
		this.isView = isView;
		this.token = token;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PersonMail getMailId() {
		return mailId;
	}

	public void setMailId(PersonMail mailId) {
		this.mailId = mailId;
	}

	public Users getReceiver() {
		return receiver;
	}

	public void setReceiver(Users receiver) {
		this.receiver = receiver;
	}

	public String getIsDel() {
		return isDel;
	}

	public void setIsDel(String isDel) {
		this.isDel = isDel;
	}

	public String getIsView() {
		return isView;
	}

	public void setIsView(String isView) {
		this.isView = isView;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	
	
	
}
