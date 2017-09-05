package com.crm.service.personal;

import java.util.HashMap;
import java.util.Map;

import com.crm.bases.BaseManagerDaoImpl;
import com.crm.entity.MailReceive;
import com.crm.vo.ResultVo;
import com.modules.commons.CommonReturn;
import com.modules.commons.Pager;
import com.modules.util.ObjValid;
import com.modules.util.StringUtil;

public class MailReceiveServiceImpl extends BaseManagerDaoImpl implements MailReceiveService {

	/*
	 * 添加
	 * @see com.crm.service.personal.MailReceiveService#addMailReceive(com.crm.entity.MailReceive)
	 */
	@Override
	public ResultVo addMailReceive(MailReceive mailReceive) {
		return null;
	}

	/*
	 * 更新
	 * @see com.crm.service.personal.MailReceiveService#modifyMailReceive(com.crm.entity.MailReceive)
	 */
	@Override
	public ResultVo modifyMailReceive(MailReceive mailReceive) {
		return null;
	}

	/*
	 * 删除
	 * @see com.crm.service.personal.MailReceiveService#removeMailReceive(java.lang.Long, java.lang.String)
	 */
	@Override
	public ResultVo removeMailReceive(Long id, String token) {
		if (ObjValid.isNotValid(id) || StringUtil.isBlank(token)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_DATA_MISSING,null);
		}
		Map<String, Object> attrs = new HashMap<>();
		attrs.put("id", id);
		attrs.put("token", token);
		MailReceive mailReceive = mailReceiveDao.query(MailReceive.class, attrs);
		if (ObjValid.isNotValid(mailReceive)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_OBJ_NOEXIST_ERROR,null);
		}
		mailReceive.setIsDel("1");
		mailReceiveDao.update(mailReceive);
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_DELETE_SUCCESS,null);
	}

	/*
	 * 根据Id和Token查询
	 * @see com.crm.service.personal.MailReceiveService#retrieveMailReceive(java.lang.Long, java.lang.String)
	 */
	@Override
	public ResultVo retrieveMailReceive(Long id, String token) {
		if (ObjValid.isNotValid(id) || StringUtil.isBlank(token)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_DATA_MISSING,null);
		}
		Map<String, Object> attrs = new HashMap<>();
		attrs.put("id", id);
		attrs.put("token", token);
		MailReceive mailReceive = mailReceiveDao.query(MailReceive.class, attrs);
		mailReceive.setIsView("1");
		mailReceiveDao.update(mailReceive);
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_FIND_SUCCESS,mailReceive);
	}

	/*
	 * 查询所有
	 * List
	 * @see com.crm.service.personal.MailReceiveService#retrieveAllMailReceives()
	 */
	@Override
	public ResultVo retrieveAllMailReceives() {
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_FIND_SUCCESS,mailReceiveDao.queryList(MailReceive.class,"id", "desc", null));
	}

	/*
	 * 分页查询
	 * @see com.crm.service.personal.MailReceiveService#retrieveMailReceivesPager(int, int)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public ResultVo retrieveMailReceivesPager(int pageSize, int pageNo,Long userId) {
		Map<String, Object> attrs = new HashMap<>();
		attrs.put("receiver.id", userId);
		attrs.put("isDel", "0");
		Pager pager = new Pager(pageSize, pageNo,Integer.parseInt(String.valueOf(mailReceiveDao.queryTotalRecord(MailReceive.class, attrs))),
				mailReceiveDao.queryList(MailReceive.class, (pageNo - 1) * pageSize, pageSize,"addTime", "desc", attrs));
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_FIND_SUCCESS,pager);
	}

}