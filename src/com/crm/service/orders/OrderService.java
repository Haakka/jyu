package com.crm.service.orders;

import com.crm.entity.Order;
import com.crm.entity.Users;
import com.crm.vo.ResultVo;

public interface OrderService {

	/**
	 * 添加
	 * @param order
	 * @param user
	 * @param contractId
	 * @param finisherId
	 * @return
	 */
	public ResultVo addOrder(Order order,Users user,Long contractId,Long finisherId,Long payTypeId,Long productId);
	
	/**
	 * 修改
	 * @param order
	 * @param contractId
	 * @param finisherId
	 * @return
	 */
	public ResultVo modifyOrder(Order order,Long contractId,Long finisherId,Long payTypeId,Long productId);
	
	/**
	 * 删除
	 * @param id
	 * @param token
	 * @return
	 */
	public ResultVo removeOrder(Long id,String token);
	
	/**
	 * 根据Id和Token查询
	 * @param id
	 * @param token
	 * @return
	 */
	public ResultVo retrieveOrder(Long id,String token);
	
	/**
	 * 查询所有
	 * List
	 * @return
	 */
	public ResultVo retrieveAllOrders();
	
	/**
	 * 分页查询
	 * @param pageSize
	 * @param pageNo
	 * @return
	 */
	public ResultVo retrieveOrdersPager(int pageSize, int pageNo,String isDel,String keyWord);
	
	/**
	 * 回收产品
	 * @param id
	 * @return
	 */
	public ResultVo updateProductStatus(Long id,String token);
	
}