package com.crm.service.cusman;

import com.crm.entity.Business;
import com.crm.entity.Users;
import com.crm.vo.ResultVo;

public interface BusinessService {

	/**
	 * 添加
	 * @param business
	 * @return
	 */
	public ResultVo addBusiness(Business business,Users users,Long consumerId,
			Long contactorId,Long originId,Long typeId,Long valueId);
	
	/**
	 * 修改
	 * @param business
	 * @return
	 */
	public ResultVo modifyBusiness(Business business,Long contactorId,Long originId,Long typeId,Long valueId);
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	public ResultVo removeBusiness(Long id,String token);
	
	/**
	 * 根据Id和Token查询
	 * @param id
	 * @return
	 */
	public ResultVo retrieveBusiness(Long id,String token);
	
	/**
	 * 查询所有 
	 * List
	 * @return
	 */
	public ResultVo retrieveAllBusinesss();
	
	/**
	 * 分页查询
	 * @param pageSize
	 * @param pageNo
	 * @return
	 */
	public ResultVo retrieveBusinesssPager(int pageSize, int pageNo,Long userId,String keyWord);
	
	/**
	 * 根据负责人Id查询客户
	 * List
	 * @return
	 */
	public ResultVo findConsumerByAssignerId(Long id);
	
	/**
	 * 根据客户Id查询商机
	 * List
	 * @param id
	 * @return
	 */
	public ResultVo findBusinessByComId(Long id);
	
	/**
	 * 统计记录
	 * @param id
	 * @return
	 */
	public int countBis(Long id);
	
}