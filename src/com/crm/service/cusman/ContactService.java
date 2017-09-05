package com.crm.service.cusman;

import com.crm.entity.Contact;
import com.crm.entity.Users;
import com.crm.vo.ResultVo;

public interface ContactService {

	/**
	 * 添加
	 * @param contact
	 * @return
	 */
	public ResultVo addContact(Contact contact,Users users,Long consumerId);
	
	/**
	 * 更新
	 * @param contact
	 * @return
	 */
	public ResultVo modifyContact(Contact contact);
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	public ResultVo removeContact(Long id,String token);
	
	/**
	 * 根据Id和Token查询
	 * @param id
	 * @return
	 */
	public ResultVo retrieveContact(Long id,String token);
	
	/**
	 * 查询所有联系人
	 * List
	 * @return
	 */
	public ResultVo retrieveAllContacts(Long userId,Long consumerId);
	
	/**
	 * 查询所有联系人 分页
	 * @param pageSize
	 * @param pageNo
	 * @return
	 */
	public ResultVo retrieveContactsPager(int pageSize, int pageNo,Long userId,String keyWord);
	
	/**
	 * 分页查询可回收的联系人
	 * @param pageSize
	 * @param pageNo
	 * @param keyWord
	 * @return
	 */
	public ResultVo retrieveAllTrash(int pageSize, int pageNo,String keyWord);
	
	/**
	 * 回收联系人
	 * @param id
	 * @param token
	 * @return
	 */
	public ResultVo updateContactStatus(Long id, String token);
	
	/**
	 * 根据客户Id查询联系人
	 * @param id
	 * @return
	 */
	public ResultVo findContactByConsumerId(Long id);
	
}