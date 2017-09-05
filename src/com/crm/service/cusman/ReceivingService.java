package com.crm.service.cusman;

import com.crm.entity.Receiving;
import com.crm.vo.ResultVo;

public interface ReceivingService {

	/**
	 * 添加
	 * @param receiving
	 * @param orderId
	 */
	public ResultVo addReceiving(Receiving receiving,Long orderId);
	
	/**
	 * 修改
	 * @param receiving
	 * @param orderId
	 */
	public ResultVo modifyReceiving(Receiving receiving);
	
	/**
	 * 删除
	 * @param id
	 * @param token
	 */
	public ResultVo removeReceiving(Long id,String token);
	
	/**
	 * 根据Id和Token查询
	 * @param id
	 * @param token
	 * @return
	 */
	public ResultVo retrieveReceiving(Long id,String token);
	
	/**
	 * 查询所有
	 * List
	 * @return
	 */
	public ResultVo retrieveAllReceivings();
	
	/**
	 * 分页查询
	 * @param pageSize
	 * @param pageNo
	 * @return
	 */
	public ResultVo retrieveReceivingsPager(int pageSize, int pageNo,String keyWords);
	
}