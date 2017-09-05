package com.crm.service.personal;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.crm.bases.BaseManagerDaoImpl;
import com.crm.entity.Consumer;
import com.crm.entity.Contact;
import com.crm.entity.Even;
import com.crm.entity.Users;
import com.crm.vo.ResultVo;
import com.modules.commons.CommonReturn;
import com.modules.util.ObjValid;
import com.modules.util.StringUtil;

public class EvenServiceImpl extends BaseManagerDaoImpl implements EvenService {

	/*
	 * 添加
	 * @see com.crm.service.personal.EvenService#addEven(com.crm.entity.Even, java.lang.Long, java.lang.Long, java.lang.Long)
	 */
	@Override
	public ResultVo addEven(Even even, Long contactorId, Long consumerId,Users user) {
		if (ObjValid.isNotValid(even)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_DATA_EXCEPT,null);
		}
		if (StringUtil.isBlank(even.getSubject()) || StringUtil.isBlank(even.getVenue())
			|| ObjValid.isNotValid(contactorId) || ObjValid.isNotValid(consumerId)
		    || ObjValid.isNotValid(even.getStartDate()) || ObjValid.isNotValid(even.getEndDate())) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_DATA_MISSING,null);
		}
		if (ObjValid.isNotValid(user)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_SESSIONKEY_POPUP,null);
		}
		Map<String, Object> attrs = new HashMap<>();
		attrs.put("id", contactorId);
		Contact contact = evenDao.query(Contact.class, attrs);
		if (ObjValid.isNotValid(contact)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_OBJ_NOEXIST_ERROR,null);
		}
		attrs.clear();
		attrs.put("id", consumerId);
		Consumer consumer = evenDao.query(Consumer.class, attrs);
		if (ObjValid.isNotValid(consumer)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_OBJ_NOEXIST_ERROR,null);
		}
		even.setContactor(contact);
		even.setConsumer(consumer);
		even.setUserId(user);
		even.setAddTime(new Date());
		even.setIsDel("0");
		even.setToken(even.getSubject()+even.getVenue()+CommonReturn.SIGN_KEY);
		evenDao.save(even);
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_ADD_SUCCESS,null);
	}

	/*
	 * 更新
	 * @see com.crm.service.personal.EvenService#modifyEven(com.crm.entity.Even, java.lang.Long)
	 */
	@Override
	public ResultVo modifyEven(Even even, Long contactorId) {
		if (ObjValid.isNotValid(even)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_DATA_EXCEPT,null);
		}
		if (StringUtil.isBlank(even.getSubject()) || StringUtil.isBlank(even.getVenue())
			 || ObjValid.isNotValid(even.getStartDate()) || ObjValid.isNotValid(even.getEndDate())) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_DATA_MISSING,null);
		}
		Map<String, Object> attrs = new HashMap<>();
		attrs.put("id", even.getId());
		attrs.put("token", even.getToken());
		Even obj = evenDao.query(Even.class, attrs);
		if (ObjValid.isNotValid(obj)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_OBJ_NOEXIST_ERROR,null);
		}
		obj.setSubject(even.getSubject());
		obj.setDescription(even.getDescription());
		obj.setStartDate(even.getStartDate());
		obj.setEndDate(even.getEndDate());
		obj.setVenue(even.getVenue());
		obj.setUpdateTime(new Date());
		evenDao.update(obj);
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_UPDATE_SUCCESS,null);
	}
	
	/*
	 * 删除
	 * @see com.crm.service.personal.EvenService#removeEven(java.lang.Long, java.lang.String)
	 */
	@Override
	public ResultVo removeEven(Long id, String token) {
		if (ObjValid.isNotValid(id) || StringUtil.isBlank(token)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_DATA_MISSING,null);
		}
		Map<String, Object> attrs = new HashMap<>();
		attrs.put("id", id);
		attrs.put("token", token);
		Even even = evenDao.query(Even.class, attrs);
		if (ObjValid.isNotValid(even)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_OBJ_NOEXIST_ERROR,null);
		}
		even.setIsDel("1");
		evenDao.update(even);
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_DELETE_SUCCESS,null);
	}

	/*
	 * 根据Id和Token查询
	 * @see com.crm.service.personal.EvenService#retrieveEven(java.lang.Long, java.lang.String)
	 */
	@Override
	public ResultVo retrieveEven(Long id, String token) {
		if (ObjValid.isNotValid(id) || StringUtil.isBlank(token)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_DATA_MISSING,null);
		}
		Map<String, Object> attrs = new HashMap<>();
		attrs.put("id", id);
		attrs.put("token", token);
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_FIND_SUCCESS,evenDao.query(Even.class, attrs));
	}

	/*
	 * 查询所有
	 * List
	 * @see com.crm.service.personal.EvenService#retrieveAllEvens()
	 */
	@Override
	public ResultVo retrieveAllEvens() {
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_FIND_SUCCESS,evenDao.queryList(Even.class,"addTime", "desc", null));
	}

	/*
	 * 分页查询
	 * @see com.crm.service.personal.EvenService#retrieveEvensPager(int, int, java.lang.Long)
	 */
	@Override
	public ResultVo retrieveEvensPager(int pageSize, int pageNo, Long userId,String keyWord) {
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_FIND_SUCCESS,evenDao.retrieveEvensPager(pageSize, pageNo, userId, keyWord));
	}


}