package com.crm.web.cusman;

import java.util.List;

import com.crm.entity.Consumer;
import com.crm.entity.Contact;
import com.crm.entity.Users;
import com.crm.vo.ResultVo;
import com.modules.commons.CommonReturn;
import com.modules.commons.GetUsersInfo;
import com.modules.commons.PageAction;
import com.modules.commons.Pager;
import com.modules.util.ObjValid;

import net.sf.json.JSONObject;

public class ContactAction extends PageAction {
	
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String token;
	
	private Long consumerId;
	
	private Contact contact;
	
	private List<Contact> contacts;
	
	private List<Consumer> consumers;
	
	/**
	 * 分页查询
	 * @return
	 * @throws Exception
	 */
	public String retrieveAllContacts() throws Exception {
		try {
			Users users = GetUsersInfo.getUsers();
			if (ObjValid.isValid(users)) {
				resultVo = contactService.retrieveContactsPager(pageSize, pageNo,users.getId(),keyWord);
				pager = (Pager) resultVo.getResult();
			}
		} catch (Exception ex) {
			resultVo = new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_EXCEPTION_POPUP,null);
			ex.printStackTrace();
		}
		return "success";
	}
	
	/**
	 * 分页查询可回收的联系人
	 * @return
	 * @throws Exception
	 */
	public String retrieveAllTrash() throws Exception {
		try {
			resultVo = contactService.retrieveAllTrash(pageSize, pageNo,keyWord);
			pager = (Pager) resultVo.getResult();
		} catch (Exception ex) {
			resultVo = new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_EXCEPTION_POPUP,null);
			ex.printStackTrace();
		}
		return "trash";
	}
	
	/**
	 * 回收垃圾
	 * @return
	 */
	public String recycleWaste(){
		resultVo = contactService.updateContactStatus(id, token);
		JSONObject json = JSONObject.fromObject(resultVo);
		return renderText(json == null ? null : json.toString());
	}
	
	/**
	 * 跳转编辑
	 * @return
	 * @throws Exception
	 */
	public String retrieveContactById() throws Exception {
		try {
			resultVo = contactService.retrieveContact(id,token);
			if (ObjValid.isValid(resultVo.getResult())) {
				contact = (Contact) resultVo.getResult();
			}
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
	@SuppressWarnings("unchecked")
	public String newPage() throws Exception {
		try {
			Users users = GetUsersInfo.getUsers();
			resultVo = consumerService.retrieveAllConsumers(users.getId());
			if (ObjValid.isValid(resultVo.getResult())) {
				consumers = (List<Consumer>) resultVo.getResult();
			}
		} catch (Exception ex) {
			resultVo = new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_EXCEPTION_POPUP,null);
			ex.printStackTrace();
		}
		return "newPage";
	}
	
	/**
	 * 查看
	 * @return
	 * @throws Exception
	 */
	public String viewPage() throws Exception {
		try {
			resultVo = contactService.retrieveContact(id,token);
			if (ObjValid.isValid(resultVo.getResult())) {
				contact = (Contact) resultVo.getResult();
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
	public String newContact() throws Exception {
		try {
			Users users = GetUsersInfo.getUsers();
			resultVo = contactService.addContact(contact, users, consumerId);
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
	public String editContact() throws Exception {
		try {
			resultVo = contactService.modifyContact(contact);
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
	public String delContact() throws Exception {
		try {
			resultVo = contactService.removeContact(id, token);
		} catch (Exception ex) {
			resultVo = new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_EXCEPTION_POPUP,null);
			ex.printStackTrace();
		}
		JSONObject json = JSONObject.fromObject(resultVo);
		return renderText(json == null ? null : json.toString());
	}
	
	/**
	 * ajax根据客户ID查询联系人
	 * @return
	 */
	public String ajaxFindContactByConsumerId(){
		try {
			resultVo = contactService.findContactByConsumerId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		JSONObject json = JSONObject.fromObject(resultVo);
		return renderText(json == null ? null : json.toString());
	}
	
	/**
	 * 导出信息
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String export(){
		Users users = GetUsersInfo.getUsers();
		this.contacts = (List<Contact>) contactService.retrieveAllContacts(users.getId(),null).getResult();
		return "export";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(
			List<Contact> contacts) {
		this.contacts = contacts;
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

	public List<Consumer> getConsumers() {
		return consumers;
	}

	public void setConsumers(List<Consumer> consumers) {
		this.consumers = consumers;
	}

}