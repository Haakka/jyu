package com.crm.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
/**
 * 客户实体类
 * @author Stephen
 *
 */
public class Consumer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String name; //客户名称
	private String phone; //客户联系方式
	private String address; //客户地址
	private String description; //客户描述
	private String fax; //传真
	private String postCode; //邮编
	private SysParam industryId; //行业
	private SysParam typeId; //类型
	private SysParam levelId; //等级
	private BigDecimal revenue; //营业额
	private Date addTime; //添加时间
	private Date updateTime; //修改时间
	private String isDel; //是否删除
	private String isLock; //是否锁定
	private Users userId; //创建人
	private String remark; //备注
	private String token;
	private Set<Contact> contacts = new HashSet<Contact>();
	private Set<Business> businesses = new HashSet<Business>();
	private Set<Even> evens = new HashSet<Even>();
	private Set<Follow> follows = new HashSet<Follow>();
	
	public Consumer() {

	}
	
	public Consumer(Long id, String name, String phone, SysParam industryId, SysParam typeId, SysParam levelId,
			BigDecimal revenue, Date addTime, String isLock, String token) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.industryId = industryId;
		this.typeId = typeId;
		this.levelId = levelId;
		this.revenue = revenue;
		this.addTime = addTime;
		this.isLock = isLock;
		this.token = token;
	}

	public Consumer(Long id, String name, String phone, String address, String description, String fax, String postCode,
			SysParam industryId, SysParam typeId, SysParam levelId, BigDecimal revenue, Date addTime, Date updateTime,
			String isDel, String isLock, Users userId, String remark,String token, Set<Contact> contacts,Set<Business> businesses,
			Set<Even> evens,Set<Follow> follows
			) {
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.description = description;
		this.fax = fax;
		this.postCode = postCode;
		this.industryId = industryId;
		this.typeId = typeId;
		this.levelId = levelId;
		this.revenue = revenue;
		this.addTime = addTime;
		this.updateTime = updateTime;
		this.isDel = isDel;
		this.isLock = isLock;
		this.userId = userId;
		this.remark = remark;
		this.contacts = contacts;
		this.businesses = businesses;
		this.evens = evens;
		this.follows = follows;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public SysParam getIndustryId() {
		return industryId;
	}
	public void setIndustryId(SysParam industryId) {
		this.industryId = industryId;
	}
	public SysParam getTypeId() {
		return typeId;
	}
	public void setTypeId(SysParam typeId) {
		this.typeId = typeId;
	}
	public SysParam getLevelId() {
		return levelId;
	}
	public void setLevelId(SysParam levelId) {
		this.levelId = levelId;
	}
	public BigDecimal getRevenue() {
		return revenue;
	}
	public void setRevenue(BigDecimal revenue) {
		this.revenue = revenue;
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
	public String getIsLock() {
		return isLock;
	}
	public void setIsLock(String isLock) {
		this.isLock = isLock;
	}
	public Users getUserId() {
		return userId;
	}
	public void setUserId(Users userId) {
		this.userId = userId;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Set<Contact> getContacts() {
		return contacts;
	}
	public void setContacts(Set<Contact> contacts) {
		this.contacts = contacts;
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

	public Set<Follow> getFollows() {
		return follows;
	}

	public void setFollows(Set<Follow> follows) {
		this.follows = follows;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	
	
	
}
