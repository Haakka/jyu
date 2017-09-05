package com.crm.web.cusman;

import java.util.List;

import com.crm.entity.Business;
import com.crm.entity.Consumer;
import com.crm.entity.Contract;
import com.crm.entity.Users;
import com.crm.vo.ResultVo;
import com.modules.commons.CommonReturn;
import com.modules.commons.GetUsersInfo;
import com.modules.commons.PageAction;
import com.modules.commons.Pager;
import com.modules.util.ObjValid;

import net.sf.json.JSONObject;

public class ContractAction extends PageAction {
	
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String token;
	
	private String isDel;
	
	private Contract contract;
	
	private Long businessId;
	
	private Long consumerId;
	
	private List<Contract> contracts;
	
	private List<Business> businesses;
	
	private List<Consumer> consumers;
	
	/**
	 * 分页查询
	 * @return
	 * @throws Exception
	 */
	public String retrieveAllContracts() throws Exception {
		try {
			resultVo = contractService.retrieveContractsPager(pageSize, pageNo,"0",keyWord);
			pager = (Pager) resultVo.getResult();
		} catch (Exception ex) {
			resultVo = new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_EXCEPTION_POPUP,null);
			ex.printStackTrace();
		}
		return "success";
	}
	
	/**
	 * 分页查询可回收合同
	 * @return
	 * @throws Exception
	 */
	public String retrieveAllTrash() {
		try {
			resultVo = contractService.retrieveContractsPager(pageSize, pageNo,"1",keyWord);
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
		resultVo = contractService.updateContractStatus(id, token);
		JSONObject json = JSONObject.fromObject(resultVo);
		return renderText(json == null ? null : json.toString());
	}
	
	/**
	 * 跳转编辑
	 * @return
	 * @throws Exception
	 */
	public String retrieveContractById() throws Exception {
		try {
			 resultVo = contractService.retrieveContract(id,token);
			 if (ObjValid.isValid(resultVo.getResult())) {
				contract = (Contract) resultVo.getResult();
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
			resultVo = contractService.retrieveContract(id,token);
			 if (ObjValid.isValid(resultVo.getResult())) {
				contract = (Contract) resultVo.getResult();
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
	public String newContract() throws Exception {
		try {
			Users users = GetUsersInfo.getUsers();
			resultVo = contractService.addContract(contract,businessId,consumerId,users);
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
	public String editContract() throws Exception {
		try {
			resultVo = contractService.modifyContract(contract);
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
	public String delContract() throws Exception {
		try {
			resultVo = contractService.removeContract(id,token);
		} catch (Exception ex) {
			resultVo = new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_EXCEPTION_POPUP,null);
			ex.printStackTrace();
		}
		JSONObject json = JSONObject.fromObject(resultVo);
		return renderText(json == null ? null : json.toString());
	}

	@SuppressWarnings("unchecked")
	private void init(){
		this.consumers = (List<Consumer>) consumerService.retrieveAllConsumers(null).getResult();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Contract getContract() {
		return contract;
	}

	public void setContract(Contract contract) {
		this.contract = contract;
	}

	public List<Contract> getContracts() {
		return contracts;
	}

	public void setContracts(
			List<Contract> contracts) {
		this.contracts = contracts;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Long getBusinessId() {
		return businessId;
	}

	public void setBusinessId(Long businessId) {
		this.businessId = businessId;
	}

	public Long getConsumerId() {
		return consumerId;
	}

	public void setConsumerId(Long consumerId) {
		this.consumerId = consumerId;
	}

	public List<Business> getBusinesses() {
		return businesses;
	}

	public void setBusinesses(List<Business> businesses) {
		this.businesses = businesses;
	}

	public List<Consumer> getConsumers() {
		return consumers;
	}

	public void setConsumers(List<Consumer> consumers) {
		this.consumers = consumers;
	}

	public String getIsDel() {
		return isDel;
	}

	public void setIsDel(String isDel) {
		this.isDel = isDel;
	}
	
	

}