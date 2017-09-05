package com.crm.service.cusman;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.crm.bases.BaseManagerDaoImpl;
import com.crm.entity.Business;
import com.crm.entity.Consumer;
import com.crm.entity.Contact;
import com.crm.entity.SysParam;
import com.crm.entity.Users;
import com.crm.vo.ResultVo;
import com.modules.commons.CommonReturn;
import com.modules.util.ObjValid;
import com.modules.util.Sha256;
import com.modules.util.StringUtil;

public class BusinessServiceImpl extends BaseManagerDaoImpl implements BusinessService {

	/*
	 * 添加
	 * @see com.crm.service.cusman.BusinessService#addBusiness(com.crm.entity.Business, com.crm.entity.Users, java.lang.Long, java.lang.Long, java.lang.Long)
	 */
	@Override
	public ResultVo addBusiness(Business business,Users users,Long consumerId,
			Long contactorId,Long originId,Long typeId,Long valueId) {
		if (ObjValid.isNotValid(business)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_DATA_EXCEPT,null);
		}
		if (ObjValid.isNotValid(business.getRate()) || StringUtil.isBlank(business.getStatus())
			|| ObjValid.isNotValid(consumerId) || ObjValid.isNotValid(valueId)
			|| ObjValid.isNotValid(contactorId) || ObjValid.isNotValid(typeId) || ObjValid.isNotValid(originId)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_DATA_MISSING,null);
		}
		if (ObjValid.isNotValid(users)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_SESSIONKEY_POPUP,null);
		}
		Map<String, Object> attrs = new HashMap<>();
		attrs.put("id", consumerId);
		Consumer consumer = businessDao.query(Consumer.class, attrs);
		if (ObjValid.isNotValid(consumer)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_OBJ_NOEXIST_ERROR,null);
		}
		attrs.clear();
		attrs.put("id", contactorId);
		Contact contact = businessDao.query(Contact.class, attrs);
		if (ObjValid.isNotValid(contact)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_OBJ_NOEXIST_ERROR,null);
		}
		attrs.clear();
		attrs.put("id", originId);
		SysParam origin = businessDao.query(SysParam.class, attrs);
		attrs.clear();
		attrs.put("id", typeId);
		SysParam type = businessDao.query(SysParam.class, attrs);
		attrs.clear();
		attrs.put("id", valueId);
		SysParam value = businessDao.query(SysParam.class, attrs);
		business.setOriginId(origin);
		business.setTypeId(type);
		business.setValueId(value);
		business.setUserId(users);
		business.setConsumer(consumer);
		business.setContactor(contact);
		business.setAddTime(new Date());
		business.setIsDel("0");
		business.setToken(Sha256.SHA256(business.getName()+consumerId.toString()
		+contactorId.toString()+originId.toString()+typeId.toString()+valueId.toString()+CommonReturn.SIGN_KEY));
		businessDao.save(business);
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_ADD_SUCCESS,null);
	}

	/*
	 * 修改
	 * @see com.crm.service.cusman.BusinessService#modifyBusiness(com.crm.entity.Business, java.lang.Long, java.lang.Long)
	 */
	@Override
	public ResultVo modifyBusiness(Business business,Long contactorId,Long originId,Long typeId,Long valueId) {
		if (ObjValid.isNotValid(business)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_DATA_EXCEPT,null);
		}
		if (ObjValid.isNotValid(business.getRate()) || StringUtil.isBlank(business.getStatus())
			 || ObjValid.isNotValid(valueId)
			|| ObjValid.isNotValid(contactorId) || ObjValid.isNotValid(typeId) || ObjValid.isNotValid(originId)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_DATA_MISSING,null);
		}
		Map<String, Object> attrs = new HashMap<>();
		attrs.put("id", business.getId());
		attrs.put("token", business.getToken());
		Business obj = businessDao.query(Business.class, attrs);
		if (ObjValid.isNotValid(obj)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_OBJ_NOEXIST_ERROR,null);
		}
		attrs.clear();
		attrs.put("id", contactorId);
		Contact contact = businessDao.query(Contact.class, attrs);
		if (ObjValid.isNotValid(contact)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_OBJ_NOEXIST_ERROR,null);
		}
		attrs.clear();
		attrs.put("id", originId);
		SysParam origin = businessDao.query(SysParam.class, attrs);
		attrs.clear();
		attrs.put("id", typeId);
		SysParam type = businessDao.query(SysParam.class, attrs);
		attrs.clear();
		attrs.put("id", valueId);
		SysParam value = businessDao.query(SysParam.class, attrs);
		obj.setOriginId(origin);
		obj.setTypeId(type);
		obj.setValueId(value);
		obj.setName(business.getName());
		obj.setRate(business.getRate());
		obj.setStatus(business.getStatus());
		obj.setUpdateTime(new Date());
		obj.setRemark(business.getRemark());
		businessDao.update(obj);
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_UPDATE_SUCCESS,null);
	}

	/*
	 * 删除
	 * 软删
	 * @see com.crm.service.cusman.BusinessService#removeBusiness(java.lang.Long, java.lang.String)
	 */
	@Override
	public ResultVo removeBusiness(Long id, String token) {
		if (ObjValid.isNotValid(id) || StringUtil.isBlank(token)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_DATA_MISSING,null);
		}
		Map<String, Object> attrs = new HashMap<>();
		attrs.put("id", id);
		attrs.put("token", token);
		Business business = businessDao.query(Business.class, attrs);
		if (ObjValid.isNotValid(business)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_OBJ_NOEXIST_ERROR,null);
		}
		business.setIsDel("1");
		businessDao.update(business);
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_DELETE_SUCCESS,null);
	}

	/*
	 * 根据Id和Token查询
	 * @see com.crm.service.cusman.BusinessService#retrieveBusiness(java.lang.Long, java.lang.String)
	 */
	@Override
	public ResultVo retrieveBusiness(Long id, String token) {
		if (ObjValid.isNotValid(id) || StringUtil.isBlank(token)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_DATA_MISSING,null);
		}
		Map<String, Object> attrs = new HashMap<>();
		attrs.put("id", id);
		attrs.put("token", token);
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_FIND_SUCCESS,businessDao.query(Business.class, attrs));
	}

	/*
	 * 查询所有
	 * List
	 * @see com.crm.service.cusman.BusinessService#retrieveAllBusinesss()
	 */
	@Override
	public ResultVo retrieveAllBusinesss() {
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_FIND_SUCCESS,businessDao.queryList(Business.class,"addTime", "desc", null));
	}

	/*
	 * 分页查询
	 * @see com.crm.service.cusman.BusinessService#retrieveBusinesssPager(int, int, java.lang.Long)
	 */
	@Override
	public ResultVo retrieveBusinesssPager(int pageSize, int pageNo, Long userId,String keyWord) {
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_FIND_SUCCESS,businessDao.retrieveBusinesssPager(pageSize, pageNo, userId, keyWord));
	}

	/*
	 * 根据负责人Id查询客户
	 * @see com.crm.service.cusman.BusinessService#findConsumerByBusinesssId(java.lang.Long)
	 */
	@Override
	public ResultVo findConsumerByAssignerId(Long id) {
		if (ObjValid.isNotValid(id)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_DATA_MISSING,null);
		}
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_FIND_SUCCESS,businessDao.findConsumerByAssignerId(id));
	}

	/*
	 * 根据客户Id查询商机
	 * @see com.crm.service.cusman.BusinessService#findBusinessByComId(java.lang.Long)
	 */
	@Override
	public ResultVo findBusinessByComId(Long id) {
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_FIND_SUCCESS,businessDao.findBusinessByComId(id));
	}

	/*
	 * 统计今日新增记录
	 * @see com.crm.service.cusman.BusinessService#findTodayNewBis(java.lang.Long)
	 */
	@Override
	public int countBis(Long id) {
		return businessDao.countBis(id);
	}



}