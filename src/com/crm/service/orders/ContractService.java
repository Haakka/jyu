package com.crm.service.orders;

import com.crm.entity.Contract;
import com.crm.entity.Users;
import com.crm.vo.ResultVo;

public interface ContractService {

	/**
	 * 添加
	 * @param contract
	 * @param businessId
	 * @param consumerId
	 * @param userId
	 * @return
	 */
	public ResultVo addContract(Contract contract,Long businessId,Long consumerId,Users user);
	
	/**
	 * 更新编辑
	 * @param contract
	 * @return
	 */
	public ResultVo modifyContract(Contract contract);
	
	/**
	 * 删除
	 * @param id
	 * @param token
	 * @return
	 */
	public ResultVo removeContract(Long id,String token);
	
	/**
	 * 根据Id和Token查询
	 * @param id
	 * @param token
	 * @return
	 */
	public ResultVo retrieveContract(Long id,String token);
	
	/**
	 * 查询所有
	 * List
	 * @return
	 */
	public ResultVo retrieveAllContracts();
	
	/**
	 * 分页查询
	 * @param pageSize
	 * @param pageNo
	 * @return
	 */
	public ResultVo retrieveContractsPager(int pageSize, int pageNo,String isDel,String keyWord);
	
	/**
	 * 回收合同
	 * @param id
	 * @param token
	 * @return
	 */
	public ResultVo updateContractStatus(Long id,String token);

	
	
	
}