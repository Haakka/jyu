package com.crm.entity;

import java.io.Serializable;
import java.util.Date;
/**
 * 商机实体类
 * @author Stephen
 *
 */
public class Business implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name; //商机名称
	private Users assigner; //负责人
	private SysParam originId; //商机来源
	private SysParam typeId; //商机类型
	private SysParam valueId; //商机价值
	private Integer rate; //赢单率（百分比）
	private Date addTime;  //添加时间
	private String status; //状态状态(0:未指派 1:已指派 2:已跟进 3:价格谈判 4:赢单 5:输单)
	private Date updateTime;  //修改时间
	private String isDel; //是否删除
	private Users userId; //创建人
	private Consumer consumer; //客户
	private Contact contactor; //联系人
	private String remark; //备注
	private String token;
	
	public Business() {
		
	}
	
	public Business(Long id, String name, Users assigner, SysParam originId, SysParam typeId, SysParam valueId,
			Integer rate, Date addTime, String status, Consumer consumer, Contact contactor, String token) {
		this.id = id;
		this.name = name;
		this.assigner = assigner;
		this.originId = originId;
		this.typeId = typeId;
		this.valueId = valueId;
		this.rate = rate;
		this.addTime = addTime;
		this.status = status;
		this.consumer = consumer;
		this.contactor = contactor;
		this.token = token;
	}



	public Business(Long id, String name,Users assigner, SysParam originId, SysParam typeId, SysParam valueId, Integer rate,
			Date addTime, String status, Date updateTime, String isDel, Users userId, Consumer consumer,
			Contact contactor, String remark, String token) {
		super();
		this.id = id;
		this.name = name;
		this.assigner = assigner;
		this.originId = originId;
		this.typeId = typeId;
		this.valueId = valueId;
		this.rate = rate;
		this.addTime = addTime;
		this.status = status;
		this.updateTime = updateTime;
		this.isDel = isDel;
		this.userId = userId;
		this.consumer = consumer;
		this.contactor = contactor;
		this.remark = remark;
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
	public SysParam getOriginId() {
		return originId;
	}
	public void setOriginId(SysParam originId) {
		this.originId = originId;
	}
	public SysParam getTypeId() {
		return typeId;
	}
	public void setTypeId(SysParam typeId) {
		this.typeId = typeId;
	}
	public SysParam getValueId() {
		return valueId;
	}
	public void setValueId(SysParam valueId) {
		this.valueId = valueId;
	}
	public Integer getRate() {
		return rate;
	}
	public void setRate(Integer rate) {
		this.rate = rate;
	}
	public Date getAddTime() {
		return addTime;
	}
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
	public Consumer getConsumer() {
		return consumer;
	}
	public void setConsumer(Consumer consumer) {
		this.consumer = consumer;
	}
	public Contact getContactor() {
		return contactor;
	}
	public void setContactor(Contact contactor) {
		this.contactor = contactor;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Users getAssigner() {
		return assigner;
	}
	public void setAssigner(Users assigner) {
		this.assigner = assigner;
	}
	
	
}
