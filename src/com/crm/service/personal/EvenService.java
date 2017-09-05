package com.crm.service.personal;

import com.crm.entity.Even;
import com.crm.entity.Users;
import com.crm.vo.ResultVo;

public interface EvenService {

	/**
	 * 添加
	 * @param even
	 * @param contactorId
	 * @param consumerId
	 * @param userId
	 * @return
	 */
	public ResultVo addEven(Even even,Long contactorId,Long consumerId,Users user);
	
	/**
	 * 更新编辑
	 * @param even
	 * @param contactorId
	 * @return
	 */
	public ResultVo modifyEven(Even even,Long contactorId);
	
	/**
	 * 删除
	 * @param id
	 * @param token
	 * @return
	 */
	public ResultVo removeEven(Long id,String token);
	
	/**
	 * 根据Id和Token查询
	 * @param id
	 * @param token
	 * @return
	 */
	public ResultVo retrieveEven(Long id,String token);
	
	/**
	 * 查询所有
	 * List
	 * @return
	 */
	public ResultVo retrieveAllEvens();
	
	/**
	 * 分页查询
	 * @param pageSize
	 * @param pageNo
	 * @param userId
	 * @return
	 */
	public ResultVo retrieveEvensPager(int pageSize, int pageNo,Long userId,String keyWord);
	
}