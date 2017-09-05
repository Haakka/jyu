package com.crm.service.personal;

import com.crm.entity.Note;
import com.crm.entity.Users;
import com.crm.vo.ResultVo;

public interface NoteService {

	/**
	 * 添加
	 * @param note
	 * @param user
	 * @return
	 */
	public ResultVo addNote(Note note,Users user);
	
	/**
	 * 更新编辑
	 * @param note
	 * @return
	 */
	public ResultVo modifyNote(Note note);
	
	/**
	 * 删除
	 * @param id
	 * @param token
	 * @return
	 */
	public ResultVo removeNote(Long id,String token);
	
	/**
	 * 根据Id和Token删除
	 * @param id
	 * @param token
	 * @return
	 */
	public ResultVo retrieveNote(Long id,String token);
	
	/**
	 * 查询所有
	 * List
	 * @return
	 */
	public ResultVo retrieveAllNotes();
	
	/**
	 * 分页查询
	 * @param pageSize
	 * @param pageNo
	 * @param userId
	 * @return
	 */
	public ResultVo retrieveNotesPager(int pageSize, int pageNo,Long userId);
	
}