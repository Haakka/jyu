package com.crm.entity;

import java.io.Serializable;
/**
 * 区实体类
 * @author Stephen
 *
 */
public class Area implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	private Long areaId; //区编码
	private String area; //区名称
	private Long fatherId; //上级ID
	private String inital; //
	
	
	public Area() {
		
	}
	
	public Area(Long id, Long areaId, String area, Long fatherId, String inital) {
		super();
		this.id = id;
		this.areaId = areaId;
		this.area = area;
		this.fatherId = fatherId;
		this.inital = inital;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getAreaId() {
		return areaId;
	}
	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
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
	
	
}
