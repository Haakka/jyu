package com.crm.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 跟进表 实体类
 * @author Stephen
 *
 */
public class Follow implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Consumer consumerId; //客户
	private Users follower; //跟进人
	private Date followTime; //跟进时间
	private String content; //内容 
	private Date addTime; //添加时间
	private String isDel; //是否删除
	private SysParam type; //跟进类型
	private Date updateTime;
	private String token;
	
	
	public Follow() {
		
	}
	public Follow(Long id, Consumer consumerId, Users follower,Date followTime, String content, Date addTime, String isDel,
			SysParam type, String token,Date updateTime) {
		super();
		this.id = id;
		this.consumerId = consumerId;
		this.follower = follower;
		this.followTime = followTime;
		this.content = content;
		this.addTime = addTime;
		this.isDel = isDel;
		this.type = type;
		this.token = token;
		this.updateTime = updateTime;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Consumer getConsumerId() {
		return consumerId;
	}
	public void setConsumerId(Consumer consumerId) {
		this.consumerId = consumerId;
	}
	public Users getFollower() {
		return follower;
	}
	public void setFollower(Users follower) {
		this.follower = follower;
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
	public SysParam getType() {
		return type;
	}
	public void setType(SysParam type) {
		this.type = type;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Date getFollowTime() {
		return followTime;
	}
	public void setFollowTime(Date followTime) {
		this.followTime = followTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	
}
