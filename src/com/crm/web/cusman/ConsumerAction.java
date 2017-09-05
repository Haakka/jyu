package com.crm.web.cusman;

import java.util.List;

import com.crm.entity.Consumer;
import com.crm.entity.SysParam;
import com.crm.entity.Users;
import com.crm.vo.ResultVo;
import com.modules.commons.CommonReturn;
import com.modules.commons.GetUsersInfo;
import com.modules.commons.PageAction;
import com.modules.commons.Pager;
import com.modules.util.ObjValid;

import net.sf.json.JSONObject;

public class ConsumerAction extends PageAction {
	
	private static final long serialVersionUID = 1L;

	private Long id;
	private String token;
	private Consumer consumer;
	private List<Consumer> consumers;
	
	private Long industryId;  //客户行业Id
	private Long typeId; //客户类型Id
	private Long levelId; //客户等级Id
	
	private List<SysParam> consumerindustry; //客户行业集合
	private List<SysParam> consumerType; //客户类型集合
	private List<SysParam> consumerLevel; //客户等级集合 
	
	/**
	 * 查询该用户的所有客户  分页
	 * @return
	 * @throws Exception
	 */
	public String retrieveAllConsumers() throws Exception {
		try {
			Users users = GetUsersInfo.getUsers();
			if (ObjValid.isValid(users)) {
				resultVo = consumerService.retrieveConsumersPager(pageSize, pageNo,users.getId(),keyWord);
				pager = (Pager) resultVo.getResult();
			}
		} catch (Exception ex) {
			resultVo = new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_EXCEPTION_POPUP,null);
			ex.printStackTrace();
		}
		return "success";
	}
	
	/**
	 * 分页查询所有可回收的客户信息
	 * @return
	 */
	public String retrieveAllTrash(){
		try {	
			resultVo = consumerService.retrieveAllTrash(pageSize, pageNo,keyWord);
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
		resultVo = consumerService.updateConsumerStatus(id, token);
		JSONObject json = JSONObject.fromObject(resultVo);
		return renderText(json == null ? null : json.toString());
	}

	
	/**
	 * 跳转编辑客户信息
	 * @return
	 * @throws Exception
	 */
	public String retrieveConsumerById() throws Exception {
		try {
			init();
			resultVo = this.consumerService.retrieveConsumer(id,token);
			if (ObjValid.isValid(resultVo.getResult())) {
				consumer = (Consumer) resultVo.getResult();
			}
		} catch (Exception ex) {
			resultVo = new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_EXCEPTION_POPUP,null);
			ex.printStackTrace();
		}
		return "editPage";
	}

	/**
	 * 跳转添加客户信息
	 * @return
	 * @throws Exception
	 */
	public String newPage() throws Exception {
		try {
			init();
		} catch (Exception ex) {
			resultVo = new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_EXCEPTION_POPUP,null);
			ex.printStackTrace();
		}
		return "newPage";
	}
	
	/**
	 * 查看客户信息
	 * @return
	 * @throws Exception
	 */
	public String viewPage() throws Exception {
		try {
			resultVo = this.consumerService.retrieveConsumer(id,token);
			if (ObjValid.isValid(resultVo.getResult())) {
				consumer = (Consumer) resultVo.getResult();
			}
		} catch (Exception ex) {
			resultVo = new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_EXCEPTION_POPUP,null);
			ex.printStackTrace();
		}
		return "viewPage";
	}
	
	/**
	 * 添加客户信息
	 * @return
	 * @throws Exception
	 */
	public String newConsumer() throws Exception {
		try {
			Users users = GetUsersInfo.getUsers();
			resultVo = consumerService.addConsumer(consumer,users,industryId,typeId,levelId);
		} catch (Exception ex) {
			resultVo = new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_EXCEPTION_POPUP,null);
			ex.printStackTrace();
		}
		JSONObject json = JSONObject.fromObject(resultVo);
		return renderText(json == null ? null : json.toString());
	}
	
	/**
	 * 更新客户信息
	 * @return
	 * @throws Exception
	 */
	public String editConsumer() throws Exception {
		try {
			resultVo = consumerService.modifyConsumer(consumer,industryId,typeId,levelId);
		} catch (Exception ex) {
			resultVo = new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_EXCEPTION_POPUP,null);
			ex.printStackTrace();
		}
		JSONObject json = JSONObject.fromObject(resultVo);
		return renderText(json == null ? null : json.toString());
	}
	
	/**
	 * 删除客户信息
	 * @return
	 * @throws Exception
	 */
	public String delConsumer() throws Exception {
		try {
			resultVo = consumerService.removeConsumer(id,token);
		} catch (Exception ex) {
			resultVo = new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_EXCEPTION_POPUP,null);
			ex.printStackTrace();
		}
		JSONObject json = JSONObject.fromObject(resultVo);
		return renderText(json == null ? null : json.toString());
	}
	
	/**
	 * 客户指派
	 * @return
	 */
	public String assign(){
		try {
			
		} catch (Exception ex) {
			resultVo = new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_EXCEPTION_POPUP,null);
			ex.printStackTrace();
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
		this.consumers = (List<Consumer>) consumerService.retrieveAllConsumers(null).getResult();
		return "export";
	}
	
	@SuppressWarnings("unchecked")
	private void init(){
		this.consumerindustry = (List<SysParam>) sysParamService.findByTypeId(19L).getResult();
		this.consumerType = (List<SysParam>) sysParamService.findByTypeId(24L).getResult();
		this.consumerLevel = (List<SysParam>) sysParamService.findByTypeId(13L).getResult();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Consumer getConsumer() {
		return consumer;
	}

	public void setConsumer(Consumer consumer) {
		this.consumer = consumer;
	}

	public List<Consumer> getConsumers() {
		return consumers;
	}

	public void setConsumers(
			List<Consumer> consumers) {
		this.consumers = consumers;
	}

	public Long getIndustryId() {
		return industryId;
	}

	public void setIndustryId(Long industryId) {
		this.industryId = industryId;
	}

	public Long getTypeId() {
		return typeId;
	}

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}

	public Long getLevelId() {
		return levelId;
	}

	public void setLevelId(Long levelId) {
		this.levelId = levelId;
	}

	public List<SysParam> getConsumerindustry() {
		return consumerindustry;
	}

	public void setConsumerindustry(List<SysParam> consumerindustry) {
		this.consumerindustry = consumerindustry;
	}

	public List<SysParam> getConsumerType() {
		return consumerType;
	}

	public void setConsumerType(List<SysParam> consumerType) {
		this.consumerType = consumerType;
	}

	public List<SysParam> getConsumerLevel() {
		return consumerLevel;
	}

	public void setConsumerLevel(List<SysParam> consumerLevel) {
		this.consumerLevel = consumerLevel;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	

}