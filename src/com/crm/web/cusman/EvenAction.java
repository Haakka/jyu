package com.crm.web.cusman;

import java.util.List;

import com.crm.entity.Consumer;
import com.crm.entity.Contact;
import com.crm.entity.Even;
import com.crm.entity.Users;
import com.crm.vo.ResultVo;
import com.modules.commons.CommonReturn;
import com.modules.commons.GetUsersInfo;
import com.modules.commons.PageAction;
import com.modules.commons.Pager;
import com.modules.util.ObjValid;

import net.sf.json.JSONObject;

public class EvenAction extends PageAction {
	
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String token;
	private Even even;
	
	private List<Even> evens;
	private List<Contact> contactors;
	private List<Consumer> consumers;
	
	private Long contactorId;
	private Long consumerId;
	
	/**
	 * 分页查询
	 * @return
	 * @throws Exception
	 */
	public String retrieveAllEvens() throws Exception {
		try {
			Users user = GetUsersInfo.getUsers();
			resultVo = evenService.retrieveEvensPager(pageSize, pageNo,user.getId(),keyWord);
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
	public String retrieveEvenById() throws Exception {
		try {
			init();
			resultVo = evenService.retrieveEven(id,token);
			if (ObjValid.isValid(resultVo.getResult())) {
				even = (Even) resultVo.getResult();
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
			resultVo = evenService.retrieveEven(id,token);
			if (ObjValid.isValid(resultVo.getResult())) {
				even = (Even) resultVo.getResult();
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
	public String newEven() throws Exception {
		try {
			Users user = GetUsersInfo.getUsers();
			resultVo = this.evenService.addEven(even,contactorId,consumerId,user);
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
	public String editEven() throws Exception {
		try {
			resultVo = evenService.modifyEven(even,contactorId);
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
	public String delEven() throws Exception {
		try {
			resultVo = evenService.removeEven(id,token);
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
		this.consumers = (List<Consumer>) consumerService.retrieveAllConsumers(users.getId()).getResult();
		this.contactors = (List<Contact>) contactService.retrieveAllContacts(users.getId(), null).getResult();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Even getEven() {
		return even;
	}

	public void setEven(Even even) {
		this.even = even;
	}

	public List<Even> getEvens() {
		return evens;
	}

	public void setEvens(
			List<Even> evens) {
		this.evens = evens;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Long getContactorId() {
		return contactorId;
	}

	public void setContactorId(Long contactorId) {
		this.contactorId = contactorId;
	}

	public Long getConsumerId() {
		return consumerId;
	}

	public void setConsumerId(Long consumerId) {
		this.consumerId = consumerId;
	}

	public List<Contact> getContactors() {
		return contactors;
	}

	public void setContactors(List<Contact> contactors) {
		this.contactors = contactors;
	}

	public List<Consumer> getConsumers() {
		return consumers;
	}

	public void setConsumers(List<Consumer> consumers) {
		this.consumers = consumers;
	}
	
	

}