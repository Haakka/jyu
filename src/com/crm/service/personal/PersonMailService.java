package com.crm.service.personal;

import com.crm.entity.PersonMail;
import com.crm.entity.Users;
import com.crm.vo.ResultVo;

public interface PersonMailService {

	/**
	 * 添加
	 * @param personMail
	 * @param user
	 * @return
	 */
	public ResultVo addPersonMail(PersonMail personMail,Users user,Long receiverId);
	
	/**
	 * 修改
	 * @param personMail
	 * @return
	 */
	public ResultVo modifyPersonMail(PersonMail personMail);
	
	/**
	 * 删除
	 * @param id
	 * @param token
	 * @return
	 */
	public ResultVo removePersonMail(Long id,String token);
	
	/**
	 * 根据Id和Token删除
	 * @param id
	 * @param token
	 * @return
	 */
	public ResultVo retrievePersonMail(Long id,String token);
	
	/**
	 * 查询所有
	 * List
	 * @return
	 */
	public ResultVo retrieveAllPersonMails();
	
	/**
	 * 分页查询
	 * @param pageSize
	 * @param pageNo
	 * @param userId
	 * @return
	 */
	public ResultVo retrievePersonMailsPager(int pageSize, int pageNo,Long userId);
	
}