package com.crm.service.cusman;

import com.crm.entity.Consumer;
import com.crm.entity.Users;
import com.crm.vo.ResultVo;

public interface ConsumerService {

	/**
	 * 添加
	 * @param consumer
	 * @return
	 */
	public ResultVo addConsumer(Consumer consumer,Users users,Long industryId,Long typeId,Long levelId);
	
	/**
	 * 更新
	 * @param consumer
	 * @return
	 */
	public ResultVo modifyConsumer(Consumer consumer,Long industryId,Long typeId,Long levelId);
	
	/**
	 * 删除   （软删）
	 * @param id
	 * @return
	 */
	public ResultVo removeConsumer(Long id,String token);
	
	/**
	 * 根据Id和Token查询客户
	 * @param id
	 * @param token
	 * @return
	 */
	public ResultVo retrieveConsumer(Long id,String token);
	
	/**
	 * 查询所有客户 List
	 * isDel 0
	 * @return
	 */
	public ResultVo retrieveAllConsumers(Long id);
	
	/**
	 * 分页查询所有客户
	 * isDel 0
	 * @param pageSize
	 * @param pageNo
	 * @return
	 */
	public ResultVo retrieveConsumersPager(int pageSize, int pageNo,Long userId,String keyWord);
	
	/**
	 * 分页查询可回收的客户
	 * @param pageSize
	 * @param pageNo
	 * @return
	 */
	public ResultVo retrieveAllTrash(int pageSize, int pageNo,String keyWord);
	
	/**
	 * 回收客户
	 * @param id
	 * @return
	 */
	public ResultVo updateConsumerStatus(Long id,String token);
	
	/**
	 * 统计今日新增客户
	 * @param userId
	 * @return
	 */
	public int countTodayConsumer(Long userId);
	
	/**
	 * 统计昨日新增客户
	 * @param userId
	 * @return
	 */
	public int countYesConsumer(Long userId);
	
}