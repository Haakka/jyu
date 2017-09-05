package com.crm.vo;
/**
 * 查询条件的vo实体
 * @author Jane 
 * @date 2016-2-26 上午11:59:08
 * @version 版本号码
 * @TODO 描述
 */
public class ConditionVo {
	private String name;
	private String name1;
	private String name2;
	private String name3;
	private String name4;
	private String name5;
	private String number;
	private String state;
	private String type;
	private String beginDate;
	private String endDate;
	private String beginDateTwo;
	private String endDateTwo;
	
	public ConditionVo() {
		super();
	}
	public ConditionVo(String name, String name1, String name2, String number,String state) {
		super();
		this.name = name;
		this.name1 = name1;
		this.name2 = name2;
		this.number = number;
		this.state = state;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getName1() {
		return name1;
	}
	public void setName1(String name1) {
		this.name1 = name1;
	}
	public String getName2() {
		return name2;
	}
	public void setName2(String name2) {
		this.name2 = name2;
	}
	public String getBeginDateTwo() {
		return beginDateTwo;
	}
	public void setBeginDateTwo(String beginDateTwo) {
		this.beginDateTwo = beginDateTwo;
	}
	public String getEndDateTwo() {
		return endDateTwo;
	}
	public void setEndDateTwo(String endDateTwo) {
		this.endDateTwo = endDateTwo;
	}
	public String getName3() {
		return name3;
	}
	public void setName3(String name3) {
		this.name3 = name3;
	}
	public String getName4() {
		return name4;
	}
	public void setName4(String name4) {
		this.name4 = name4;
	}
	public String getName5() {
		return name5;
	}
	public void setName5(String name5) {
		this.name5 = name5;
	}
}
