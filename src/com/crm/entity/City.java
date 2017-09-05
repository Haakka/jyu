package com.crm.entity;

import java.io.Serializable;
/**
 * 市实体类
 * @author Stephen
 *
 */
public class City implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id; 
	private Long cityId; //市编码
	private String city; //市名称
	private Long fatherId; //上级Id
	private String inital;
	private String cityCode;
	
	public City() {
		
	}
	
	public City(Long id, Long cityId, String city, Long fatherId, String inital, String cityCode) {
		super();
		this.id = id;
		this.cityId = cityId;
		this.city = city;
		this.fatherId = fatherId;
		this.inital = inital;
		this.cityCode = cityCode;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getCityId() {
		return cityId;
	}
	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Long getFatherId() {
		return fatherId;
	}
	public void setFatherId(Long fatherId) {
		this.fatherId = fatherId;
	}
	public String getInital() {
		return inital;
	}
	public void setInital(String inital) {
		this.inital = inital;
	}
	public String getCityCode() {
		return cityCode;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	
	
	
}
