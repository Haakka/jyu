package com.crm.service.personal;

import com.crm.entity.MailReceive;
import com.crm.vo.ResultVo;

public interface MailReceiveService {

	/**
	 * 添加
	 * @param mailReceive
	 * @return
	 */
	public ResultVo addMailReceive(MailReceive mailReceive);
	
	/**
	 * 修改
	 * @param mailReceive
	 * @return
	 */
	public ResultVo modifyMailReceive(MailReceive mailReceive);
	
	/**
	 * 删除
	 * @param id
	 * @param token
	 * @return
	 */
	public ResultVo removeMailReceive(Long id,String token);
	
	/**
	 * 根据Id和Token查询
	 * @param id
	 * @param token
	 * @return
	 */
	public ResultVo retrieveMailReceive(Long id,String token);
	
	/**
	 * 查询所有
	 * List
	 * @return
	 */
	public ResultVo retrieveAllMailReceives();
	
	/**
	 * 分页查询
	 * @param pageSize
	 * @param pageNo
	 * @return
	 */
	public ResultVo retrieveMailReceivesPager(int pageSize, int pageNo,Long userId);
	
}