package com.crm.service.cusman;

import com.crm.entity.Invoice;
import com.crm.entity.Users;
import com.crm.vo.ResultVo;

public interface InvoiceService {

	/**
	 * 添加
	 * @param invoice
	 * @param users
	 * @param type
	 */
	public ResultVo addInvoice(Invoice invoice,Users users,Long consumerId,Long orderId);
	
	/**
	 * 修改
	 * @param invoice
	 * @param type
	 */
	public ResultVo modifyInvoice(Invoice invoice);
	
	/**
	 * 删除
	 * @param id
	 * @param token
	 */
	public ResultVo removeInvoice(Long id,String token);
	
	/**
	 * 根据Id和Token查询
	 * @param id
	 * @param token
	 * @return
	 */
	public ResultVo retrieveInvoice(Long id,String token);
	
	/**
	 * 查询所有 
	 * List
	 * @return
	 */
	public ResultVo retrieveAllInvoices();
	
	/**
	 * 分页查询
	 * @param pageSize
	 * @param pageNo
	 * @return
	 */
	public ResultVo retrieveInvoicesPager(int pageSize, int pageNo,String keyWord);
	
}