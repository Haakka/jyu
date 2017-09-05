package com.crm.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 邮件 发送方
 * @author Stephen
 *
 */
public class PersonMail implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String content; //内容
	private String title; //标题
	private Users sender; //发送者
	private String isDel; //是否删除
	private String level; //等级
	private Date sendTime; //发送时间
	private String token;
	
	public PersonMail() {
		
	}
	
	public PersonMail(Long id, String content, String title, Users sender, String isDel, String level, Date sendTime,
			String token) {
		super();
		this.id = id;
		this.content = content;
		this.title = title;
		this.sender = sender;
		this.isDel = isDel;
		this.level = level;
		this.sendTime = sendTime;
		this.token = token;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Users getSender() {
		return sender;
	}
	public void setSender(Users sender) {
		this.sender = sender;
	}
	public String getIsDel() {
		return isDel;
	}
	public void setIsDel(String isDel) {
		this.isDel = isDel;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public Date getSendTime() {
		return sendTime;
	}
	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	
	
	
	
	
}
