package com.crm.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 活动 实体类
 * @author Stephen
 *
 */
public class Even implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String subject; //活动主题
	private String description; //描述
	private Date startDate; //开始时间
	private Date endDate; //结束时间
	private String venue; //地点
	private Contact contactor; //联系人
	private Consumer consumer; //客户
	private Users userId; //创建者
	private Date addTime; //添加时间
	private Date updateTime; //修改时间
	private String isDel; //是否删除
	private String token;
	
	public Even() {
		
	}
	public Even(Long id, String subject, String description, Date startDate, Date endDate, String venue,
			Contact contactor, Consumer consumer, Users userId, Date addTime, Date updateTime,
			String isDel,String token) {
		super();
		this.id = id;
		this.subject = subject;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.venue = venue;
		this.contactor = contactor;
		this.consumer = consumer;
		this.userId = userId;
		this.addTime = addTime;
		this.updateTime = updateTime;
		this.isDel = isDel;
		this.token = token;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getVenue() {
		return venue;
	}
	public void setVenue(String venue) {
		this.venue = venue;
	}
	public Contact getContactor() {
		return contactor;
	}
	public void setContactor(Contact contactor) {
		this.contactor = contactor;
	}
	public Consumer getConsumer() {
		return consumer;
	}
	public void setConsumer(Consumer consumer) {
		this.consumer = consumer;
	}
	public Users getUserId() {
		return userId;
	}
	public void setUserId(Users userId) {
		this.userId = userId;
	}
	public Date getAddTime() {
		return addTime;
	}
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public String getIsDel() {
		return isDel;
	}
	public void setIsDel(String isDel) {
		this.isDel = isDel;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	
	
}
