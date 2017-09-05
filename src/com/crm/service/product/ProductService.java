package com.crm.service.product;

import com.crm.entity.Product;
import com.crm.vo.ResultVo;

public interface ProductService {

	/**
	 * 添加
	 * @param product
	 * @return
	 */
	public ResultVo addProduct(Product product,Long typeId);
	
	/**
	 * 修改
	 * @param product
	 * @return
	 */
	public ResultVo modifyProduct(Product product,Long typeId);
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	public ResultVo removeProduct(Long id,String token);
	
	/**
	 * 查询
	 * @param id
	 * @return
	 */
	public ResultVo retrieveProduct(Long id,String token);
	
	/**
	 * 查询所有
	 * List
	 * @return
	 */
	public ResultVo retrieveAllProducts();
	
	/**
	 * 分页查询
	 * @param pageSize
	 * @param pageNo
	 * @return
	 */
	public ResultVo retrieveProductsPager(int pageSize, int pageNo,String keyWord);
	
	/**
	 * 分页查询可回收的产品
	 * @param pageSize
	 * @param pageNo
	 * @return
	 */
	public ResultVo retrieveAllTrash(int pageSize, int pageNo);
	
	/**
	 * 回收产品
	 * @param id
	 * @param token
	 * @return
	 */
	public ResultVo updateProductStatus(Long id,String token);
	
}