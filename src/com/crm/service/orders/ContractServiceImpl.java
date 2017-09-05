package com.crm.service.orders;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.crm.bases.BaseManagerDaoImpl;
import com.crm.entity.Business;
import com.crm.entity.Consumer;
import com.crm.entity.Contract;
import com.crm.entity.Users;
import com.crm.vo.ResultVo;
import com.modules.commons.CommonReturn;
import com.modules.util.ObjValid;
import com.modules.util.Sha256;
import com.modules.util.StringUtil;

public class ContractServiceImpl extends BaseManagerDaoImpl implements ContractService {

	/*
	 * 添加
	 * @see com.crm.service.orders.ContractService#addContract(com.crm.entity.Contract, java.lang.Long, java.lang.Long, java.lang.Long)
	 */
	@Override
	public ResultVo addContract(Contract contract, Long businessId, Long consumerId,Users user) {
		if (ObjValid.isNotValid(contract)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_DATA_EXCEPT,null);
		}
		if (StringUtil.isBlank(contract.getNum()) || ObjValid.isNotValid(contract.getPrice()) || ObjValid.isNotValid(contract.getContractDate()) 
		 || ObjValid.isNotValid(consumerId) || ObjValid.isNotValid(businessId) || StringUtil.isBlank(contract.getContent()) || StringUtil.isBlank(contract.getStatus())) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_DATA_MISSING,null);
		}
		Map<String, Object> attrs = new HashMap<>();
		if (ObjValid.isNotValid(user)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_OBJ_NOEXIST_ERROR,null);
		}
		attrs.clear();
		attrs.put("id", businessId);
		Business business = contractDao.query(Business.class, attrs);
		if (ObjValid.isNotValid(business)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_OBJ_NOEXIST_ERROR,null);
		}
		attrs.clear();
		attrs.put("id", consumerId);
		Consumer consumer = contractDao.query(Consumer.class, attrs);
		if (ObjValid.isNotValid(consumer)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_OBJ_NOEXIST_ERROR,null);
		}
		contract.setUserId(user);
		contract.setBusinessId(business);
		contract.setConsumerId(consumer);
		contract.setAddTime(new Date());
		contract.setIsDel("0");
		contract.setToken(Sha256.SHA256(contract.getNum()+CommonReturn.SIGN_KEY));
		contractDao.save(contract);
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_ADD_SUCCESS,null);
	}
	
	/*
	 * 更新编辑
	 * @see com.crm.service.orders.ContractService#modifyContract(com.crm.entity.Contract)
	 */
	@Override
	public ResultVo modifyContract(Contract contract) {
		if (ObjValid.isNotValid(contract)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_DATA_EXCEPT,null);
		}
		if (StringUtil.isBlank(contract.getNum()) || ObjValid.isNotValid(contract.getPrice()) || ObjValid.isNotValid(contract.getContractDate()) 
		   || StringUtil.isBlank(contract.getContent()) || StringUtil.isBlank(contract.getStatus())) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_DATA_MISSING,null);
		}
		Map<String, Object> attrs = new HashMap<>();
		attrs.put("id", contract.getId());
		attrs.put("token", contract.getToken());
		Contract obj = contractDao.query(Contract.class, attrs);
		if (ObjValid.isNotValid(obj)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_OBJ_NOEXIST_ERROR,null);
		}
		obj.setName(contract.getName());
		obj.setNum(contract.getNum());
		obj.setPrice(contract.getPrice());
		obj.setContent(contract.getContent());
		obj.setContractDate(contract.getContractDate());
		obj.setDescription(contract.getDescription());
		obj.setRemark(contract.getRemark());
		obj.setStatus(contract.getStatus());
		obj.setUpdateTime(new Date());
		contractDao.update(obj);
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_UPDATE_SUCCESS,null);
	}

	/*
	 * 删除
	 * @see com.crm.service.orders.ContractService#removeContract(java.lang.Long, java.lang.String)
	 */
	@Override
	public ResultVo removeContract(Long id, String token) {
		if (ObjValid.isNotValid(id) || StringUtil.isBlank(token)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_DATA_MISSING,null);
		}
		Map<String, Object> attrs = new HashMap<>();
		attrs.put("id", id);
		attrs.put("token", token);
		Contract contract = contractDao.query(Contract.class, attrs);
		if (ObjValid.isNotValid(contract)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_OBJ_NOEXIST_ERROR,null);
		}
		contract.setIsDel("1");
		contract.setStatus("0");
		contractDao.update(contract);
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_DELETE_SUCCESS,null);
	}

	/*
	 * 根据Id和Token查询
	 * @see com.crm.service.orders.ContractService#retrieveContract(java.lang.Long, java.lang.String)
	 */
	@Override
	public ResultVo retrieveContract(Long id, String token) {
		if (ObjValid.isNotValid(id) || StringUtil.isBlank(token)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_DATA_MISSING,null);
		}
		Map<String, Object> attrs = new HashMap<>();
		attrs.put("id", id);
		attrs.put("token", token);
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_FIND_SUCCESS,contractDao.query(Contract.class, attrs));
	}

	/*
	 * 查询所有
	 * List
	 * @see com.crm.service.orders.ContractService#retrieveAllContracts()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public ResultVo retrieveAllContracts() {
		Map<String, Object> attrs = new HashMap<>();
		attrs.put("isDel", "0");
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_FIND_SUCCESS,contractDao.queryList(Contract.class,"addTime", "desc", attrs));
	}

	/*
	 * 分页查询
	 * @see com.crm.service.orders.ContractService#retrieveContractsPager(int, int)
	 */
	@Override
	public ResultVo retrieveContractsPager(int pageSize, int pageNo,String isDel,String keyWord) {
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_FIND_SUCCESS,contractDao.retrieveContractsPager(pageSize, pageNo, isDel, keyWord));
	}

	/*
	 * 回收合同
	 * @see com.crm.service.orders.ContractService#updateContractStatus(java.lang.Long, java.lang.String)
	 */
	@Override
	public ResultVo updateContractStatus(Long id, String token) {
		if (ObjValid.isNotValid(id) || StringUtil.isBlank(token)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_DATA_MISSING,null);
		}
		Map<String, Object> attrs = new HashMap<>();
		attrs.put("id", id);
		attrs.put("token", token);
		Contract contract = contractDao.query(Contract.class, attrs);
		if (ObjValid.isNotValid(contract)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_OBJ_NOEXIST_ERROR,null);
		}
		contract.setIsDel("0");
		contract.setStatus("1");
		contractDao.update(contract);
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_SUCCESS,null);
	}
	
	


	

}