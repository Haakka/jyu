package com.crm.service.personal;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.crm.bases.BaseManagerDaoImpl;
import com.crm.entity.Note;
import com.crm.entity.Users;
import com.crm.vo.ResultVo;
import com.modules.commons.CommonReturn;
import com.modules.commons.Pager;
import com.modules.util.ObjValid;
import com.modules.util.StringUtil;

public class NoteServiceImpl extends BaseManagerDaoImpl implements NoteService {

	/*
	 * 添加
	 * @see com.crm.service.personal.NoteService#addNote(com.crm.entity.Note, com.crm.entity.Users)
	 */
	@Override
	public ResultVo addNote(Note note, Users user) {
		if (ObjValid.isNotValid(note)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_DATA_EXCEPT,null);
		}
		if (StringUtil.isBlank(note.getContent())) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_DATA_MISSING,null);
		}
		if (ObjValid.isNotValid(user)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_SESSIONKEY_POPUP,null);
		}
		note.setAddTime(new Date());
		note.setAuthor(user);
		note.setIsDel("0");
		note.setToken((new Date()).toString()+CommonReturn.SIGN_KEY);
		noteDao.save(note);
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_ADD_SUCCESS,null);
	}

	/*
	 * 修改
	 * @see com.crm.service.personal.NoteService#modifyNote(com.crm.entity.Note)
	 */
	@Override
	public ResultVo modifyNote(Note note) {
		if (ObjValid.isNotValid(note)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_DATA_EXCEPT,null);
		}
		if (StringUtil.isBlank(note.getContent())) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_DATA_MISSING,null);
		}
		Map<String, Object> attrs = new HashMap<>();
		attrs.put("id", note.getId());
		attrs.put("token", note.getToken());
		Note obj = noteDao.query(Note.class, attrs);
		if (ObjValid.isNotValid(obj)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_OBJ_NOEXIST_ERROR,null);
		}
		obj.setContent(note.getContent());
		obj.setIsDel(note.getIsDel());
		obj.setUpdateTime(new Date());
		noteDao.update(obj);
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_UPDATE_SUCCESS,null);
	}

	/*
	 * 删除
	 * @see com.crm.service.personal.NoteService#removeNote(java.lang.Long, java.lang.String)
	 */
	@Override
	public ResultVo removeNote(Long id, String token) {
		if (ObjValid.isNotValid(id) || StringUtil.isBlank(token)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_DATA_MISSING,null);
		}
		Map<String, Object> attrs = new HashMap<>();
		attrs.put("id", id);
		attrs.put("token", token);
		Note note = noteDao.query(Note.class, attrs);
		if (ObjValid.isNotValid(note)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_OBJ_NOEXIST_ERROR,null);
		}
		note.setIsDel("1");
		note.setDeleteTime(new Date());
		noteDao.update(note);
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_DELETE_SUCCESS,null);
	}

	/*
	 * 根据Id和Token查询
	 * @see com.crm.service.personal.NoteService#retrieveNote(java.lang.Long, java.lang.String)
	 */
	@Override
	public ResultVo retrieveNote(Long id, String token) {
		if (ObjValid.isNotValid(id) || StringUtil.isBlank(token)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_DATA_MISSING,null);
		}
		Map<String, Object> attrs = new HashMap<>();
		attrs.put("id", id);
		attrs.put("token", token);
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_FIND_SUCCESS,noteDao.query(Note.class, attrs));
	}

	/*
	 * 查询所有
	 * List
	 * @see com.crm.service.personal.NoteService#retrieveAllNotes()
	 */
	@Override
	public ResultVo retrieveAllNotes() {
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_FIND_SUCCESS,noteDao.queryList(Note.class,"addTime", "desc", null));
	}

	/*
	 * 分页查询
	 * @see com.crm.service.personal.NoteService#retrieveNotesPager(int, int, java.lang.Long)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public ResultVo retrieveNotesPager(int pageSize, int pageNo, Long userId) {
		Map<String, Object> attrs = new HashMap<>();
		attrs.put("author.id", userId);
		attrs.put("isDel", "0");
		Pager pager = new Pager(pageSize, pageNo,Integer.parseInt(String.valueOf(noteDao.queryTotalRecord(Note.class, attrs))),
				noteDao.queryList(Note.class, (pageNo - 1) * pageSize, pageSize,"addTime", "desc", attrs));
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_FIND_SUCCESS,pager);
	}


}