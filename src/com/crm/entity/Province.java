package com.crm.entity;

import java.io.Serializable;

public class Province implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Long provinceId;
	private String province;
	private String inital;
	private String provinceCode;
	
	public Province() {
		
	}
	public Province(Long id, Long provinceId, String province, String inital, String provinceCode) {
		super();
		this.id = id;
		this.provinceId = provinceId;
		this.province = province;
		this.inital = inital;
		this.provinceCode = provinceCode;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getProvinceId() {
		return provinceId;
	}
	public void setProvinceId(Long provinceId) {
		this.provinceId = provinceId;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getInital() {
		return inital;
	}
	public void setInital(String inital) {
		this.inital = inital;
	}
	public String getProvinceCode() {
		return provinceCode;
	}
	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}
	
	
	
}
