package com.crm.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
/**
 * 联系人实体类
 * @author Stephen
 *
 */
public class Contact implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name; //联系人姓名
	private String phone;  //联系方式
	private String sex; //性别
	private String displayName; //称呼
	private String email; //邮箱
	private String qq; //QQ
	private String address; //地址
	private String postCode; //邮编
	private String remark; //备注
	private String position; //联系人职位
	private String department; //联系人部门
	private Date addTime; //添加时间
	private Date updateTime; //修改时间
	private String isDel; //是否删除
	private Users userId; //创建人 
	private Consumer consumerId; //客户
	private String token;
	
	private Set<Business> businesses = new HashSet<Business>();
	private Set<Even> evens = new HashSet<Even>();
	
	public Contact() {
		
	}
	
	public Contact(Long id, String name, String phone, String sex, String displayName, String position,
			String department, Date addTime, Consumer consumerId, String token) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.sex = sex;
		this.displayName = displayName;
		this.position = position;
		this.department = department;
		this.addTime = addTime;
		this.consumerId = consumerId;
		this.token = token;
	}



	public Contact(Long id, String name, String phone, String sex, String displayName, String email, String qq, String address,
			String postCode, String remark, String position,String department, Date addTime, Date updateTime,
			String isDel, Users userId,Consumer consumerId,String token,Set<Business> businesses,Set<Even> evens) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.sex = sex;
		this.displayName = displayName;
		this.email = email;
		this.qq = qq;
		this.address = address;
		this.postCode = postCode;
		this.remark = remark;
		this.position = position;
		this.addTime = addTime;
		this.updateTime = updateTime;
		this.isDel = isDel;
		this.userId = userId;
		this.department = department;
		this.consumerId = consumerId;
		this.businesses = businesses;
		this.evens = evens;
		this.token = token;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
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

	public Users getUserId() {
		return userId;
	}

	public void setUserId(Users userId) {
		this.userId = userId;
	}

	public Consumer getConsumerId() {
		return consumerId;
	}

	public void setConsumerId(Consumer consumerId) {
		this.consumerId = consumerId;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Set<Business> getBusinesses() {
		return businesses;
	}

	public void setBusinesses(Set<Business> businesses) {
		this.businesses = businesses;
	}

	public Set<Even> getEvens() {
		return evens;
	}

	public void setEvens(Set<Even> evens) {
		this.evens = evens;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	
	
}
