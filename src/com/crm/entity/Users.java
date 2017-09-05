package com.crm.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 用户表
 * @author Stephen
 *
 */
public class Users implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = -8406166823777698417L;
	private Long id;
	private String loginName; //登录名
	private String password; //密码
	private String name; //真实姓名
	private Date birthday; //生日
	private Date entryDate; //入职日期
	private String idcardno; //身份证信息
	private String sex; //性别
	private String workphone; //工作电话
	private String fax; //传真
	private String email; //邮箱
	private String mobile; //手机号码
	private String state; //状态
	private Date addTime; //添加时间
	private Date updateTime; //更新时间
	private String remark; //备注
	private String address; //详细地址
	private String qq; //QQ
	private String isDel; //是否删除
	private Position positionId; //职位ID
	private String area; //区域

	private Set<UsersRoles> usersRoleses = new HashSet<UsersRoles>();
	private Set<News> news = new HashSet<News>();
	private Set<Note> notes = new HashSet<Note>();
	private Set<LoginLog> loginLogs = new HashSet<LoginLog>();
	private Set<Contact> contacts = new HashSet<Contact>();
	private Set<Consumer> consumers = new HashSet<Consumer>();
	private Set<Business> businesses = new HashSet<Business>();
	private Set<Even> evens = new HashSet<Even>();
	private Set<Follow> follows = new HashSet<Follow>();

	// Constructors

	/** default constructor */
	public Users() {
	}

	/** minimal constructor */
	public Users(Long id, String loginName) {
		this.id = id;
		this.loginName = loginName;
	}

	/** full constructor */
	public Users(Position positionId,Long id,  String loginName, String password,
			String name, Date birthday, Date entryDate, String idcardno, String sex, String workphone,
			String fax, String email, String mobile, String state,Date addTime, Date updateTime, String remark, String address,
		    String qq, String isDel, Set<UsersRoles> usersRoleses,Set<News> news,Set<Note> notes,
			Set<LoginLog> loginLogs,Set<Contact> contacts,Set<Consumer> consumers,Set<Business> businesses,Set<Even> evens,
			Set<Follow> follows,String area) {
		this.positionId = positionId;
		this.id = id;
		this.loginName = loginName;
		this.password = password;
		this.name = name;
		this.birthday = birthday;
		this.entryDate = entryDate;
		this.idcardno = idcardno;
		this.sex = sex;
		this.workphone = workphone;
		this.fax = fax;
		this.email = email;
		this.mobile = mobile;
		this.state = state;
		this.addTime = addTime;
		this.updateTime = updateTime;
		this.remark = remark;
		this.address = address;
		this.qq = qq;
		this.isDel = isDel;
		this.usersRoleses = usersRoleses;
		this.news = news;
		this.notes = notes;
		this.loginLogs = loginLogs;
		this.contacts = contacts;
		this.consumers =consumers;
		this.businesses = businesses;
		this.evens = evens;
		this.follows = follows;
		this.area = area;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLoginName() {
		return this.loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdcardno() {
		return this.idcardno;
	}

	public void setIdcardno(String idcardno) {
		this.idcardno = idcardno;
	}
	
	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getWorkphone() {
		return this.workphone;
	}

	public void setWorkphone(String workphone) {
		this.workphone = workphone;
	}

	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Date getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getIsDel() {
		return isDel;
	}

	public void setIsDel(String isDel) {
		this.isDel = isDel;
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

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Set<UsersRoles> getUsersRoleses() {
		return this.usersRoleses;
	}

	public void setUsersRoleses(Set<UsersRoles> usersRoleses) {
		this.usersRoleses = usersRoleses;
	}
	
	public Set<News> getNews() {
		return news;
	}

	public void setNews(Set<News> news) {
		this.news = news;
	}


	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	public Set<Note> getNotes() {
		return notes;
	}

	public void setNotes(Set<Note> notes) {
		this.notes = notes;
	}

	public Set<LoginLog> getLoginLogs() {
		return loginLogs;
	}

	public void setLoginLogs(Set<LoginLog> loginLogs) {
		this.loginLogs = loginLogs;
	}

	public Position getPositionId() {
		return positionId;
	}

	public void setPositionId(Position positionId) {
		this.positionId = positionId;
	}

	public Set<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(Set<Contact> contacts) {
		this.contacts = contacts;
	}

	public Set<Consumer> getConsumers() {
		return consumers;
	}

	public void setConsumers(Set<Consumer> consumers) {
		this.consumers = consumers;
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
	
	


}