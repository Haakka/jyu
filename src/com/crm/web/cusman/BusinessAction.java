package com.crm.web.cusman;

import java.util.List;

import com.crm.entity.Business;
import com.crm.entity.Consumer;
import com.crm.entity.Contact;
import com.crm.entity.SysParam;
import com.crm.entity.Users;
import com.crm.vo.ResultVo;
import com.modules.commons.CommonReturn;
import com.modules.commons.GetUsersInfo;
import com.modules.commons.PageAction;
import com.modules.commons.Pager;

import net.sf.json.JSONObject;

public class BusinessAction extends PageAction {
	
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private Business business;
	
	private String token;
	
	private List<Business> businesss;
	private List<Consumer> consumers;
	private List<Contact> contactors;
	private List<SysParam> origins;
	private List<SysParam> types;
	private List<SysParam> values;
	
	private Long assignId;	
	private Long consumerId;
	private Long contactorId;
	private Long originId;
	private Long typeId;
	private Long valueId;
	
	/**
	 * 分页查询
	 * @return
	 * @throws Exception
	 */
	public String retrieveAllBusinesss() throws Exception {
		try {
			Users users = GetUsersInfo.getUsers();
			resultVo = businessService.retrieveBusinesssPager(pageSize, pageNo,users.getId(),keyWord);
			pager = (Pager) resultVo.getResult();
		} catch (Exception ex) {
			resultVo = new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_EXCEPTION_POPUP,null);
			ex.printStackTrace();
		}
		return "success";
	}
	
	/**
	 * 跳转编辑
	 * @return
	 * @throws Exception
	 */
	public String retrieveBusinessById() throws Exception {
		try {
			resultVo = businessService.retrieveBusiness(id,token);
			if (null != resultVo.getResult()) {
				business = (Business) resultVo.getResult();
			}
			init();
		} catch (Exception ex) {
			resultVo = new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_EXCEPTION_POPUP,null);
			ex.printStackTrace();
		}
		return "editPage";
	}

	/**
	 * 跳转添加
	 * @return
	 * @throws Exception
	 */
	public String newPage() throws Exception {
		init();
		return "newPage";
	}
	
	/**
	 * 查看
	 * @return
	 * @throws Exception
	 */
	public String viewPage() throws Exception {
		try {
			resultVo = businessService.retrieveBusiness(id,token);
			if (null != resultVo.getResult()) {
				business = (Business) resultVo.getResult();
			}
		} catch (Exception ex) {
			resultVo = new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_EXCEPTION_POPUP,null);
			ex.printStackTrace();
		}
		return "viewPage";
	}
	
	/**
	 * 添加
	 * @return
	 * @throws Exception
	 */
	public String newBusiness() throws Exception {
		try {
			Users users = GetUsersInfo.getUsers();
			resultVo = businessService.addBusiness(business,users,consumerId,contactorId,originId,typeId,valueId);
		} catch (Exception ex) {
			resultVo = new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_EXCEPTION_POPUP,null);
			ex.printStackTrace();
		}
		JSONObject json = JSONObject.fromObject(resultVo);
		return renderText(json == null ? null : json.toString());
	}
	
	/**
	 * 编辑
	 * @return
	 * @throws Exception
	 */
	public String editBusiness() throws Exception {
		try {
			resultVo = businessService.modifyBusiness(business,contactorId,originId,typeId,valueId);
		} catch (Exception ex) {
			resultVo = new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_EXCEPTION_POPUP,null);
			ex.printStackTrace();
		}
		JSONObject json = JSONObject.fromObject(resultVo);
		return renderText(json == null ? null : json.toString());
	}
	
	/**
	 * 删除
	 * @return
	 * @throws Exception
	 */
	public String delBusiness() throws Exception {
		try {
			resultVo = businessService.removeBusiness(id,token);
		} catch (Exception ex) {
			resultVo = new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_EXCEPTION_POPUP,null);
			ex.printStackTrace();
		}
		JSONObject json = JSONObject.fromObject(resultVo);
		return renderText(json == null ? null : json.toString());
	}
	
	
	@SuppressWarnings("unchecked")
	private void init(){
		Users users = GetUsersInfo.getUsers();
		this.origins = (List<SysParam>) sysParamService.findByTypeId(23L).getResult();
		this.types = (List<SysParam>) sysParamService.findByTypeId(24L).getResult();
		this.values = (List<SysParam>) sysParamService.findByTypeId(25L).getResult();
		this.consumers = (List<Consumer>) consumerService.retrieveAllConsumers(users.getId()).getResult();
		this.contactors = (List<Contact>) contactService.retrieveAllContacts(users.getId(),null).getResult();
	}
	
	/**
	 * ajax根据客户Id查询商机
	 * @return
	 */
	public String ajaxFindBusinessByConsumerId(){
		try {
			resultVo = businessService.findBusinessByComId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		JSONObject json = JSONObject.fromObject(resultVo);
		return renderText(json == null ? null : json.toString());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Business getBusiness() {
		return business;
	}

	public void setBusiness(Business business) {
		this.business = business;
	}

	public List<Business> getBusinesss() {
		return businesss;
	}

	public void setBusinesss(
			List<Business> businesss) {
		this.businesss = businesss;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Long getConsumerId() {
		return consumerId;
	}

	public void setConsumerId(Long consumerId) {
		this.consumerId = consumerId;
	}

	public Long getContactorId() {
		return contactorId;
	}

	public void setContactorId(Long contactorId) {
		this.contactorId = contactorId;
	}

	public Long getOriginId() {
		return originId;
	}

	public void setOriginId(Long originId) {
		this.originId = originId;
	}

	public Long getTypeId() {
		return typeId;
	}

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}

	public Long getValueId() {
		return valueId;
	}

	public void setValueId(Long valueId) {
		this.valueId = valueId;
	}

	public List<Consumer> getConsumers() {
		return consumers;
	}

	public void setConsumers(List<Consumer> consumers) {
		this.consumers = consumers;
	}

	public List<Contact> getContactors() {
		return contactors;
	}

	public void setContactors(List<Contact> contactors) {
		this.contactors = contactors;
	}

	public List<SysParam> getOrigins() {
		return origins;
	}

	public void setOrigins(List<SysParam> origins) {
		this.origins = origins;
	}

	public List<SysParam> getTypes() {
		return types;
	}

	public void setTypes(List<SysParam> types) {
		this.types = types;
	}

	public List<SysParam> getValues() {
		return values;
	}

	public void setValues(List<SysParam> values) {
		this.values = values;
	}

	public Long getAssignId() {
		return assignId;
	}

	public void setAssignId(Long assignId) {
		this.assignId = assignId;
	}
	
	

}