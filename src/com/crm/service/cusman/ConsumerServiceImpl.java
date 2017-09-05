package com.crm.service.cusman;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.crm.bases.BaseManagerDaoImpl;
import com.crm.entity.Business;
import com.crm.entity.Consumer;
import com.crm.entity.Contact;
import com.crm.entity.Users;
import com.crm.vo.ResultVo;
import com.modules.commons.CommonReturn;
import com.modules.util.ObjValid;
import com.modules.util.Sha256;
import com.modules.util.StringUtil;

public class ConsumerServiceImpl extends BaseManagerDaoImpl implements ConsumerService {

	/*
	 * 添加
	 * @see com.crm.service.cusman.ConsumerService#addConsumer(com.crm.entity.Consumer)
	 */
	@Override
	public ResultVo addConsumer(Consumer consumer,Users users,Long industryId,Long typeId,Long levelId) {
		if (ObjValid.isNotValid(consumer)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_DATA_EXCEPT,null);
		}
		if (StringUtil.isBlank(consumer.getName()) || StringUtil.isBlank(consumer.getPhone())
			|| StringUtil.isBlank(consumer.getAddress()) || ObjValid.isNotValid(industryId) || ObjValid.isNotValid(typeId) || ObjValid.isNotValid(levelId)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_DATA_MISSING,null);
		}
		if (ObjValid.isNotValid(users)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_SESSIONKEY_POPUP,null);
		}
		consumer.setIndustryId(sysParamDao.findById(industryId));
		consumer.setTypeId(sysParamDao.findById(typeId));
		consumer.setLevelId(sysParamDao.findById(levelId));
		consumer.setUserId(users);
		consumer.setIsDel("0");
		consumer.setIsLock("0");
		consumer.setAddTime(new Date());
		consumer.setToken(Sha256.SHA256(consumer.getName()+consumer.getPhone()+consumer.getAddress()+CommonReturn.SIGN_KEY));
		consumerDao.save(consumer);
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_ADD_SUCCESS,null);
	}

	/*
	 * 更新
	 * @see com.crm.service.cusman.ConsumerService#modifyConsumer(com.crm.entity.Consumer)
	 */
	@Override
	public ResultVo modifyConsumer(Consumer consumer,Long industryId,Long typeId,Long levelId) {
		if (ObjValid.isNotValid(consumer)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_DATA_EXCEPT,null);
		}
		if (ObjValid.isNotValid(consumer.getId()) || StringUtil.isBlank(consumer.getToken())
			|| StringUtil.isBlank(consumer.getName()) || StringUtil.isBlank(consumer.getPhone())
			|| StringUtil.isBlank(consumer.getAddress()) || ObjValid.isNotValid(industryId) 
			|| ObjValid.isNotValid(typeId) || ObjValid.isNotValid(levelId)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_DATA_MISSING,null);
		}
		Map<String, Object> attrs = new HashMap<>();
		attrs.put("id", consumer.getId());
		attrs.put("token", consumer.getToken());
		Consumer obj = consumerDao.query(Consumer.class, attrs);
		if (ObjValid.isNotValid(obj)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_OBJ_NOEXIST_ERROR,null);
		}
		obj.setName(consumer.getName());
		obj.setPhone(consumer.getPhone());
		obj.setAddress(consumer.getAddress());
		obj.setDescription(consumer.getDescription());
		obj.setFax(consumer.getFax());
		obj.setPostCode(consumer.getPostCode());
		obj.setRevenue(consumer.getRevenue());
		obj.setUpdateTime(new Date());
		obj.setRemark(consumer.getRemark());
		obj.setIndustryId(sysParamDao.findById(industryId));
		obj.setTypeId(sysParamDao.findById(typeId));
		obj.setLevelId(sysParamDao.findById(levelId));
		consumerDao.update(obj);
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_UPDATE_SUCCESS,null);
	}

	/*
	 * 删除   （软删）
	 * @see com.crm.service.cusman.ConsumerService#removeConsumer(java.lang.Long, java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public ResultVo removeConsumer(Long id, String token) {
		if (ObjValid.isNotValid(id) || StringUtil.isBlank(token)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_DATA_MISSING,null);
		}
		Map<String, Object> attrs = new HashMap<>();
		attrs.put("id", id);
		attrs.put("token", token);
		Consumer consumer = consumerDao.query(Consumer.class, attrs);
		if (ObjValid.isNotValid(consumer)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_OBJ_NOEXIST_ERROR,null);
		}
		consumer.setIsDel("1");
		consumerDao.update(consumer);
		attrs.clear();
		attrs.put("consumerId.id", id);
		List<Contact> contacts = consumerDao.queryList(Contact.class, "id", "desc", attrs);
		if (contacts.size() > 0) {
			for (int i = 0; i < contacts.size(); i++) {
				contacts.get(i).setIsDel("1");
				consumerDao.update(contacts.get(i));
			}
		}
		attrs.clear();
		attrs.put("consumer.id", id);
		List<Business> businesses = consumerDao.queryList(Business.class, "id", "desc", attrs);
		if (businesses.size() > 0) {
			for (int i = 0; i < businesses.size(); i++) {
				businesses.get(i).setIsDel("1");
				consumerDao.update(businesses.get(i));
			}
		}
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_DELETE_SUCCESS,null);
	}

	/*
	 * 根据Id和Token查询客户
	 * @see com.crm.service.cusman.ConsumerService#retrieveConsumer(java.lang.Long, java.lang.String)
	 */
	@Override
	public ResultVo retrieveConsumer(Long id, String token) {
		if (ObjValid.isNotValid(id) || StringUtil.isBlank(token)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_DATA_MISSING,null);
		}
		Map<String, Object> attrs = new HashMap<>();
		attrs.put("id", id);
		attrs.put("token", token);
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_FIND_SUCCESS,consumerDao.query(Consumer.class, attrs));
	}

	/*
	 * 查询所有客户 List
	 * @see com.crm.service.cusman.ConsumerService#retrieveAllConsumers()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public ResultVo retrieveAllConsumers(Long id) {
		Map<String, Object> attrs = new HashMap<>();
		if (ObjValid.isValid(id)) {
			attrs.put("userId.id", id);
		}
		attrs.put("isDel", "0");
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_FIND_SUCCESS,consumerDao.queryList(Consumer.class,"addTime", "desc", attrs));
	}

	/*
	 * 分页查询属于该用户的所有客户
	 * @see com.crm.service.cusman.ConsumerService#retrieveConsumersPager(int, int)
	 */
	@Override
	public ResultVo retrieveConsumersPager(int pageSize, int pageNo,Long userId,String keyWord) {
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_FIND_SUCCESS,consumerDao.retrieveConsumersPager(pageSize, pageNo, userId, keyWord));
	}

	/*
	 * 分页查询可回收的客户
	 * @see com.crm.service.cusman.ConsumerService#retrieveAllTrash(int, int)
	 */
	@Override
	public ResultVo retrieveAllTrash(int pageSize, int pageNo,String keyWord) {
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_FIND_SUCCESS,consumerDao.retrieveAllTrash(pageSize, pageNo, keyWord));
	}

	/*
	 * 回收客户
	 * @see com.crm.service.cusman.ConsumerService#updateConsumerStatus(java.lang.Long)
	 */
	public ResultVo updateConsumerStatus(Long id,String token){
		Map<String, Object> attrs = new HashMap<>();
		if (ObjValid.isNotValid(id) || StringUtil.isBlank(token)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_DATA_MISSING,null);
		}
		attrs.put("id", id);
		attrs.put("token", token);
		Consumer consumer = consumerDao.query(Consumer.class, attrs);
		if (ObjValid.isNotValid(consumer)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_OBJ_NOEXIST_ERROR,null);
		}
		consumer.setIsDel("0");
		consumerDao.update(consumer);
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_SUCCESS,null);
	}

	/*
	 * 统计今日新增客户
	 * @see com.crm.service.cusman.ConsumerService#countTodayConsumer(java.lang.Long)
	 */
	@Override
	public int countTodayConsumer(Long userId) {
		return consumerDao.countTodayConsumer(userId);
	}

	/*
	 * 统计昨日新增客户
	 * @see com.crm.service.cusman.ConsumerService#countYesConsumer(java.lang.Long)
	 */
	@Override
	public int countYesConsumer(Long userId) {
		return consumerDao.countYesConsumer(userId);
	}
	
	



}