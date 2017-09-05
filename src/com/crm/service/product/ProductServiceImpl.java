package com.crm.service.product;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.crm.bases.BaseManagerDaoImpl;
import com.crm.entity.Product;
import com.crm.entity.SysParam;
import com.crm.vo.ResultVo;
import com.modules.commons.CommonReturn;
import com.modules.commons.Pager;
import com.modules.util.ObjValid;
import com.modules.util.Sha256;
import com.modules.util.StringUtil;

public class ProductServiceImpl extends BaseManagerDaoImpl implements ProductService {

	private static final long serialVersionUID = 1L;

	/*
	 * 添加
	 * @see com.crm.service.product.ProductService#addProduct(com.crm.entity.Product, java.lang.Long)
	 */
	@Override
	public ResultVo addProduct(Product product,Long typeId) {
		if (ObjValid.isNotValid(product)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_DATA_EXCEPT,null);
		}
		if (StringUtil.isBlank(product.getName()) || ObjValid.isNotValid(product.getPrice())
				|| ObjValid.isNotValid(product.getCostPrice()) || ObjValid.isNotValid(typeId) || ObjValid.isNotValid(product.getSize()) || ObjValid.isNotValid(product.getUnit())) {
				return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_DATA_MISSING,null);
		}
		Map<String, Object> attrs = new HashMap<>();
		attrs.put("id", typeId);
		SysParam type = productDao.query(SysParam.class, attrs);
		if (ObjValid.isNotValid(type)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_SESSIONKEY_POPUP,null);
		}
		product.setType(type);
		product.setIsDel("0");
		product.setAddTime(new Date());
		product.setToken(Sha256.SHA256(product.getName()+new Date().toString()+CommonReturn.SIGN_KEY));
		productDao.save(product);
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_ADD_SUCCESS,null);
	}

	/*
	 * 修改
	 * @see com.crm.service.product.ProductService#modifyProduct(com.crm.entity.Product, java.lang.Long)
	 */
	@Override
	public ResultVo modifyProduct(Product product,Long typeId) {
		if (ObjValid.isNotValid(product)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_DATA_EXCEPT,null);
		}
		if (StringUtil.isBlank(product.getName()) || ObjValid.isNotValid(product.getPrice())
				|| ObjValid.isNotValid(product.getCostPrice()) || ObjValid.isNotValid(typeId) || ObjValid.isNotValid(product.getSize()) || ObjValid.isNotValid(product.getUnit())) {
				return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_DATA_MISSING,null);
		}
		Map<String, Object> attrs = new HashMap<>();
		attrs.put("id", typeId);
		SysParam type = productDao.query(SysParam.class, attrs);
		if (ObjValid.isNotValid(type)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_SESSIONKEY_POPUP,null);
		}
		attrs.clear();
		attrs.put("id", product.getId());
		attrs.put("token", product.getToken());
		Product obj = productDao.query(Product.class, attrs);
		if (ObjValid.isNotValid(obj)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_OBJ_NOEXIST_ERROR,null);
		}
		obj.setName(product.getName());
		obj.setPrice(product.getPrice());
		obj.setCostPrice(product.getCostPrice());
		obj.setRemark(product.getRemark());
		obj.setSize(product.getSize());
		obj.setUnit(product.getUnit());
		obj.setType(type);
		obj.setUpdateTime(new Date());
		productDao.update(obj);
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_UPDATE_SUCCESS,null);
	}

	/*
	 * 删除
	 * @see com.crm.service.product.ProductService#removeProduct(java.lang.Long, java.lang.String)
	 */
	@Override
	public ResultVo removeProduct(Long id,String token) {
		if (ObjValid.isNotValid(id) || StringUtil.isBlank(token)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_DATA_MISSING,null);
		}
		Map<String, Object> attrs = new HashMap<>();
		attrs.put("id", id);
		attrs.put("token", token);
		Product product = consumerDao.query(Product.class, attrs);
		if (ObjValid.isNotValid(product)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_OBJ_NOEXIST_ERROR,null);
		}
		product.setIsDel("1");
		productDao.update(product);
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_DELETE_SUCCESS,null);
	}

	/*
	 * 查询
	 * @see com.crm.service.product.ProductService#retrieveProduct(java.lang.Long)
	 */
	@Override
	public ResultVo retrieveProduct(Long id,String token) {
		if (ObjValid.isNotValid(id) || StringUtil.isBlank(token)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_DATA_MISSING,null);
		}
		Map<String, Object> attrs = new HashMap<>();
		attrs.put("id", id);
		attrs.put("token", token);
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_FIND_SUCCESS,productDao.query(Product.class, attrs));
	}

	/*
	 * 查询
	 * List
	 * @see com.crm.service.product.ProductService#retrieveAllProducts()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public ResultVo retrieveAllProducts() {
		Map<String, Object> attrs = new HashMap<>();
		attrs.put("isDel", "0");
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_FIND_SUCCESS,productDao.queryList(Product.class,"addTime", "desc", attrs));
	}

	/*
	 * 分页查询
	 * @see com.crm.service.product.ProductService#retrieveProductsPager(int, int)
	 */
	@Override
	public ResultVo retrieveProductsPager(int pageSize, int pageNo,String keyWord) {
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_FIND_SUCCESS,productDao.retrieveProductsPager(pageSize, pageNo, keyWord));
	}

	/*
	 * 分页查询可回收的产品
	 * @see com.crm.service.product.ProductService#retrieveAllTrash(int, int)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public ResultVo retrieveAllTrash(int pageSize, int pageNo) {
		Map<String, Object> attrs = new HashMap<>();
		attrs.put("isDel", "1");
		Pager pager = new Pager(pageSize, pageNo,Integer.parseInt(String.valueOf(productDao.queryTotalRecord(Product.class, attrs))),
				productDao.queryList(Product.class, (pageNo - 1) * pageSize, pageSize,"addTime", "desc", attrs));
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_FIND_SUCCESS,pager);
	}

	/*
	 * 回收产品
	 * @see com.crm.service.product.ProductService#updateProductStatus(java.lang.Long, java.lang.String)
	 */
	@Override
	public ResultVo updateProductStatus(Long id, String token) {
		if (ObjValid.isNotValid(id) || StringUtil.isBlank(token)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_DATA_MISSING,null);
		}
		Map<String, Object> attrs = new HashMap<>();
		attrs.put("id", id);
		attrs.put("token", token);
		Product product = productDao.query(Product.class, attrs);
		if (ObjValid.isNotValid(product)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_OBJ_NOEXIST_ERROR,null);
		}
		product.setIsDel("0");
		productDao.update(product);
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_SUCCESS,nullValue());
	}
	
	


}