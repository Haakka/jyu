package com.crm.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 便签实体类
 * @author Stephen
 *
 */
public class Note implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Users author; //作者
	private String content; //内容
	private Date addTime; //添加时间
	private String isDel; //是否删除
	private Date updateTime; //更新时间
	private Date deleteTime; //删除时间
	private String token;
	
	
	public Note() {
		
	}
	
	public Note(Long id, Users author, String content, Date addTime,Date updateTime, String isDel, Date deleteTime,String token) {
		super();
		this.id = id;
		this.author = author;
		this.content = content;
		this.addTime = addTime;
		this.isDel = isDel;
		this.deleteTime = deleteTime;
		this.token = token;
		this.updateTime = updateTime;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Users getAuthor() {
		return author;
	}
	public void setAuthor(Users author) {
		this.author = author;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getAddTime() {
		return addTime;
	}
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
	public String getIsDel() {
		return isDel;
	}
	public void setIsDel(String isDel) {
		this.isDel = isDel;
	}
	public Date getDeleteTime() {
		return deleteTime;
	}
	public void setDeleteTime(Date deleteTime) {
		this.deleteTime = deleteTime;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	
}
