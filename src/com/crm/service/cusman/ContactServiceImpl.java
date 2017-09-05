package com.crm.service.cusman;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.crm.bases.BaseManagerDaoImpl;
import com.crm.entity.Consumer;
import com.crm.entity.Contact;
import com.crm.entity.Users;
import com.crm.vo.ResultVo;
import com.modules.commons.CommonReturn;
import com.modules.util.ObjValid;
import com.modules.util.Sha256;
import com.modules.util.StringUtil;

public class ContactServiceImpl extends BaseManagerDaoImpl implements ContactService {

	/*
	 * 添加
	 * @see com.crm.service.cusman.ContactService#addContact(com.crm.entity.Contact, com.crm.entity.Users)
	 */
	@Override
	public ResultVo addContact(Contact contact, Users users,Long consumerId) {
		if (ObjValid.isNotValid(contact)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_DATA_EXCEPT,null);
		}
		if (StringUtil.isBlank(contact.getName()) || StringUtil.isBlank(contact.getPhone())
				|| StringUtil.isBlank(contact.getAddress()) || StringUtil.isBlank(contact.getSex())	
				|| StringUtil.isBlank(contact.getPosition()) || StringUtil.isBlank(contact.getDepartment())) {
				return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_DATA_MISSING,null);
		}
		if (ObjValid.isNotValid(users)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_SESSIONKEY_POPUP,null);
		}
		Map<String, Object> attrs = new HashMap<>();
		attrs.put("id", consumerId);
		Consumer consumer = contactDao.query(Consumer.class, attrs);
		if (ObjValid.isNotValid(consumer)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_OBJ_NOEXIST_ERROR,null);
		}
		contact.setConsumerId(consumer);
		contact.setAddTime(new Date());
		contact.setUserId(users);
		contact.setIsDel("0");
		contact.setToken(Sha256.SHA256(contact.getName()+contact.getPhone()+contact.getAddress()+CommonReturn.SIGN_KEY));
		contactDao.save(contact);
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_ADD_SUCCESS,null);
	}

	/*
	 * 更新
	 * @see com.crm.service.cusman.ContactService#modifyContact(com.crm.entity.Contact)
	 */
	@Override
	public ResultVo modifyContact(Contact contact) {
		if (ObjValid.isNotValid(contact)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_DATA_EXCEPT,null);
		}
		if (ObjValid.isNotValid(contact.getId()) || StringUtil.isBlank(contact.getToken())
			|| StringUtil.isBlank(contact.getName()) || StringUtil.isBlank(contact.getPhone())
			|| StringUtil.isBlank(contact.getAddress()) || StringUtil.isBlank(contact.getSex())	
			|| StringUtil.isBlank(contact.getPosition()) || StringUtil.isBlank(contact.getDepartment())) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_DATA_MISSING,null);
		}
		Map<String, Object> attrs = new HashMap<>();
		attrs.put("id", contact.getId());
		attrs.put("token", contact.getToken());
		Contact obj = contactDao.query(Contact.class, attrs);
		if (ObjValid.isNotValid(obj)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_OBJ_NOEXIST_ERROR,null);
		}
		obj.setName(contact.getName());
		obj.setPhone(contact.getPhone());
		obj.setSex(contact.getSex());
		obj.setDisplayName(contact.getDisplayName());
		obj.setEmail(contact.getEmail());
		obj.setQq(contact.getQq());
		obj.setAddress(contact.getAddress());
		obj.setPostCode(contact.getPostCode());
		obj.setRemark(contact.getRemark());
		obj.setPosition(contact.getPosition());
		obj.setDepartment(contact.getDepartment());
		obj.setUpdateTime(new Date());
		contactDao.update(obj);
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_UPDATE_SUCCESS,null);
	}

	/*
	 * 删除 （软删）
	 * @see com.crm.service.cusman.ContactService#removeContact(java.lang.Long, java.lang.String)
	 */
	@Override
	public ResultVo removeContact(Long id, String token) {
		if (ObjValid.isNotValid(id) || StringUtil.isBlank(token)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_DATA_MISSING,null);
		}
		Map<String, Object> attrs = new HashMap<>();
		attrs.put("id", id);
		attrs.put("token", token);
		Contact contact = contactDao.query(Contact.class, attrs);
		if (ObjValid.isNotValid(contact)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_OBJ_NOEXIST_ERROR,null);
		}
		contact.setIsDel("1");
		contactDao.update(contact);
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_DELETE_SUCCESS,null);
	}
	
	/*
	 * 根据Id和token查询联系人
	 * @see com.crm.service.cusman.ContactService#retrieveContact(java.lang.Long, java.lang.String)
	 */
	@Override
	public ResultVo retrieveContact(Long id, String token) {
		if (ObjValid.isNotValid(id) || StringUtil.isBlank(token)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_DATA_MISSING,null);
		}
		Map<String, Object> attrs = new HashMap<>();
		attrs.put("id", id);
		attrs.put("token", token);
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_FIND_SUCCESS,contactDao.query(Contact.class, attrs));
	}

	/*
	 * 查询所有联系人
	 * List
	 * @see com.crm.service.cusman.ContactService#retrieveAllContacts()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public ResultVo retrieveAllContacts(Long userId,Long consumerId) {
		Map<String, Object> attrs = new HashMap<>();
		if (ObjValid.isValid(userId)) {
			attrs.put("userId.id", userId);
		}
		if (ObjValid.isValid(consumerId)) {
			attrs.put("consumerId.id", consumerId);
		}
		attrs.put("isDel", "0");
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_FIND_SUCCESS,
				contactDao.queryList(Contact.class,"addTime", "desc", attrs));
	}

	/*
	 * 分页查询所有联系人
	 * @see com.crm.service.cusman.ContactService#retrieveContactsPager(int, int, java.lang.Long)
	 */
	@Override
	public ResultVo retrieveContactsPager(int pageSize, int pageNo, Long userId,String keyWord) {
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_FIND_SUCCESS,contactDao.retrieveContactsPager(pageSize, pageNo, userId, keyWord));
	}

	/*
	 * 分页查询可回收的联系人
	 * @see com.crm.service.cusman.ContactService#retrieveAllTrash(int, int, java.lang.String)
	 */
	@Override
	public ResultVo retrieveAllTrash(int pageSize, int pageNo, String keyWord) {
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_FIND_SUCCESS,contactDao.retrieveAllTrash(pageSize, pageNo, keyWord));
	}

	/*
	 * 回收联系人
	 * @see com.crm.service.cusman.ContactService#updateContactStatus(java.lang.Long, java.lang.String)
	 */
	@Override
	public ResultVo updateContactStatus(Long id, String token) {
		if (ObjValid.isNotValid(id) || StringUtil.isBlank(token)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_DATA_MISSING,null);
		}
		Map<String, Object> attrs = new HashMap<>();
		attrs.put("id", id);
		attrs.put("token", token);
		Contact contact = contactDao.query(Contact.class, attrs);
		if (ObjValid.isNotValid(contact)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_OBJ_NOEXIST_ERROR,null);
		}
		if (contact.getConsumerId().getIsDel().equals("1")) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_CUS_ERROR,null);
		}
		contact.setIsDel("0");
		contactDao.update(contact);
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_SUCCESS,null);
	}

	/*
	 * 根据客户Id查询联系人
	 * @see com.crm.service.cusman.ContactService#findContactByConsumerId(java.lang.Long)
	 */
	@Override
	public ResultVo findContactByConsumerId(Long id) {
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_FIND_SUCCESS,contactDao.findContactByConsumerId(id));
	}


	
}