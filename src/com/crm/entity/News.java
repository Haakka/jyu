package com.crm.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 新闻实体类
 * @author Stephen
 *
 */
public class News implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String title; //标题
	private String content; //内容 
	private Users author; //发布人
	private Date addTime; //添加时间
	private Date deleteTime; //删除时间
	private String isDel; //是否删除
	private Integer sort;  //排序
	private Integer view; //查看次数
	private String token;
	
	public News() {
		
	}
	public News(Long id, String title, String content, Users author, Date addTime, Date deleteTime, String isDel,
			Integer sort, Integer view,String token) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.author = author;
		this.addTime = addTime;
		this.deleteTime = deleteTime;
		this.isDel = isDel;
		this.sort = sort;
		this.view = view;
		this.token = token;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Users getAuthor() {
		return author;
	}
	public void setAuthor(Users author) {
		this.author = author;
	}
	public Date getAddTime() {
		return addTime;
	}
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
	public Date getDeleteTime() {
		return deleteTime;
	}
	public void setDeleteTime(Date deleteTime) {
		this.deleteTime = deleteTime;
	}
	public String getIsDel() {
		return isDel;
	}
	public void setIsDel(String isDel) {
		this.isDel = isDel;
	}
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	public Integer getView() {
		return view;
	}
	public void setView(Integer view) {
		this.view = view;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	
}
