package com.crm.service.personal;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.crm.bases.BaseManagerDaoImpl;
import com.crm.entity.MailReceive;
import com.crm.entity.PersonMail;
import com.crm.entity.Users;
import com.crm.vo.ResultVo;
import com.modules.commons.CommonReturn;
import com.modules.commons.Pager;
import com.modules.util.ObjValid;
import com.modules.util.StringUtil;

public class PersonMailServiceImpl extends BaseManagerDaoImpl implements PersonMailService {

	/*
	 * 添加
	 * @see com.crm.service.personal.PersonMailService#addPersonMail(com.crm.entity.PersonMail, com.crm.entity.Users)
	 */
	@Override
	public ResultVo addPersonMail(PersonMail personMail, Users user,Long receiverId) {
		if (ObjValid.isNotValid(personMail)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_DATA_EXCEPT,null);
		}
		if (StringUtil.isBlank(personMail.getContent()) || StringUtil.isBlank(personMail.getTitle()) || ObjValid.isNotValid(receiverId)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_DATA_MISSING,null);
		}
		if (ObjValid.isNotValid(user)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_SESSIONKEY_POPUP,null);
		}
		personMail.setSendTime(new Date());
		personMail.setSender(user);
		personMail.setIsDel("0");
		personMail.setToken((new Date()).toString()+CommonReturn.SIGN_KEY);
		personMailDao.save(personMail);
		MailReceive mailReceive = new MailReceive();
		Map<String, Object> attrs = new HashMap<>();
		attrs.put("id", receiverId);
		mailReceive.setReceiver(personMailDao.query(Users.class, attrs));
		mailReceive.setIsDel("0");
		mailReceive.setIsView("0");
		mailReceive.setMailId(personMail);
		mailReceive.setToken((new Date().toString()+CommonReturn.SIGN_KEY));
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_ADD_SUCCESS,null);
	}

	/*
	 * 修改
	 * @see com.crm.service.personal.PersonMailService#modifyPersonMail(com.crm.entity.PersonMail)
	 */
	@Override
	public ResultVo modifyPersonMail(PersonMail personMail) {
		return null;
	}

	/*
	 * 删除
	 * @see com.crm.service.personal.PersonMailService#removePersonMail(java.lang.Long, java.lang.String)
	 */
	@Override
	public ResultVo removePersonMail(Long id, String token) {
		if (ObjValid.isNotValid(id) || StringUtil.isBlank(token)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_DATA_MISSING,null);
		}
		Map<String, Object> attrs = new HashMap<>();
		attrs.put("id", id);
		attrs.put("token", token);
		PersonMail personMail = personMailDao.query(PersonMail.class, attrs);
		if (ObjValid.isNotValid(personMail)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_OBJ_NOEXIST_ERROR,null);
		}
		personMail.setIsDel("1");
		personMailDao.update(personMail);
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_DELETE_SUCCESS,null);
	}

	/*
	 * 根据Id和Token
	 * @see com.crm.service.personal.PersonMailService#retrievePersonMail(java.lang.Long, java.lang.String)
	 */
	@Override
	public ResultVo retrievePersonMail(Long id, String token) {
		if (ObjValid.isNotValid(id) || StringUtil.isBlank(token)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_DATA_MISSING,null);
		}
		Map<String, Object> attrs = new HashMap<>();
		attrs.put("id", id);
		attrs.put("token", token);
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_FIND_SUCCESS,personMailDao.query(PersonMail.class, attrs));
	}

	/*
	 * 查询所有
	 * List
	 * @see com.crm.service.personal.PersonMailService#retrieveAllPersonMails()
	 */
	@Override
	public ResultVo retrieveAllPersonMails() {
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_FIND_SUCCESS,personMailDao.queryList(PersonMail.class,"sendTime", "desc", null));
	}

	/*
	 * 分页查询
	 * @see com.crm.service.personal.PersonMailService#retrievePersonMailsPager(int, int, java.lang.Long)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public ResultVo retrievePersonMailsPager(int pageSize, int pageNo, Long userId) {
		Map<String, Object> attrs = new HashMap<>();
		attrs.put("sender.id", userId);
		attrs.put("isDel", "0");
		Pager pager = new Pager(pageSize, pageNo,Integer.parseInt(String.valueOf(personMailDao.queryTotalRecord(PersonMail.class, attrs))),
				personMailDao.queryList(PersonMail.class, (pageNo - 1) * pageSize, pageSize,"sendTime", "desc", attrs));
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_FIND_SUCCESS,pager);
	}


}