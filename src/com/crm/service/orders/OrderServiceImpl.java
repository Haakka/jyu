package com.crm.service.orders;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.crm.bases.BaseManagerDaoImpl;
import com.crm.entity.Contract;
import com.crm.entity.Order;
import com.crm.entity.Product;
import com.crm.entity.SysParam;
import com.crm.entity.Users;
import com.crm.vo.ResultVo;
import com.modules.commons.CommonReturn;
import com.modules.commons.Pager;
import com.modules.util.DateHelper;
import com.modules.util.ObjValid;
import com.modules.util.RandUtil;
import com.modules.util.Sha256;
import com.modules.util.StringUtil;



public class OrderServiceImpl extends BaseManagerDaoImpl implements OrderService {

	/*
	 * 添加
	 * @see com.crm.service.orders.OrderService#addOrder(com.crm.entity.Order, com.crm.entity.Users, java.lang.Long, java.lang.Long)
	 */
	@Override
	public ResultVo addOrder(Order order, Users user, Long contractId, Long finisherId,Long payTypeId,Long productId) {
		if (ObjValid.isNotValid(order)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_DATA_EXCEPT,null);
		}
		if ( ObjValid.isNotValid(order.getTotalAmount()) || ObjValid.isNotValid(order.getPayTime()) || ObjValid.isNotValid(payTypeId) 
		 || ObjValid.isNotValid(contractId) || ObjValid.isNotValid(finisherId)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_DATA_MISSING,null);
		}
		if (ObjValid.isNotValid(user)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_OBJ_NOEXIST_ERROR,null);
		}
		Map<String, Object> attrs = new HashMap<>();
		attrs.put("id", contractId);
		Contract contract = orderDao.query(Contract.class, attrs);
		if (ObjValid.isNotValid(contract)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_OBJ_NOEXIST_ERROR,null);
		}
		attrs.clear();
		attrs.put("id", finisherId);
		Users finisher = orderDao.query(Users.class, attrs);
		if (ObjValid.isNotValid(finisher)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_OBJ_NOEXIST_ERROR,null);
		}
		attrs.clear();
		attrs.put("id", payTypeId);
		SysParam sysParam = orderDao.query(SysParam.class, attrs);
		if (ObjValid.isNotValid(sysParam)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_OBJ_NOEXIST_ERROR,null);
		}
		attrs.clear();
		attrs.put("id", productId);
		Product product = orderDao.query(Product.class, attrs);
		if (ObjValid.isNotValid(product)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_OBJ_NOEXIST_ERROR,null);
		}
		order.setProductId(product);
		order.setUserId(user);
		order.setFinisher(finisher);
		order.setContractId(contract);
		order.setPayType(sysParam);
		order.setOrderSn( DateHelper.dataToString(new Date(), "yyyyMMddHHmmss" + RandUtil.getRandomStr(6)));
		order.setIsDel("0");
		order.setIsInvoice("0");
		order.setAddTime(new Date());
		order.setToken(Sha256.SHA256(order.getOrderSn()+CommonReturn.SIGN_KEY));
		orderDao.save(order);
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_ADD_SUCCESS,null);
	}

	/*
	 * 修改
	 * @see com.crm.service.orders.OrderService#modifyOrder(com.crm.entity.Order, java.lang.Long, java.lang.Long)
	 */
	@Override
	public ResultVo modifyOrder(Order order, Long contractId, Long finisherId,Long payTypeId,Long productId) {
		if (ObjValid.isNotValid(order)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_DATA_EXCEPT,null);
		}
		if ( ObjValid.isNotValid(order.getTotalAmount()) || ObjValid.isNotValid(order.getPayTime()) || ObjValid.isNotValid(payTypeId) 
		 || ObjValid.isNotValid(contractId) || ObjValid.isNotValid(finisherId)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_DATA_MISSING,null);
		}
		Map<String, Object> attrs = new HashMap<>();
		attrs.put("id", order.getId());
		attrs.put("token", order.getToken());
		Order obj = orderDao.query(Order.class, attrs);
		if (ObjValid.isNotValid(obj)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_OBJ_NOEXIST_ERROR,null);
		}
		attrs.clear();
		attrs.put("id", contractId);
		Contract contract = orderDao.query(Contract.class, attrs);
		if (ObjValid.isNotValid(contract)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_OBJ_NOEXIST_ERROR,null);
		}
		attrs.clear();
		attrs.put("id", finisherId);
		Users finisher = orderDao.query(Users.class, attrs);
		if (ObjValid.isNotValid(finisher)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_OBJ_NOEXIST_ERROR,null);
		}
		attrs.clear();
		attrs.put("id", payTypeId);
		SysParam sysParam = orderDao.query(SysParam.class, attrs);
		if (ObjValid.isNotValid(sysParam)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_OBJ_NOEXIST_ERROR,null);
		}
		attrs.clear();
		attrs.put("id", productId);
		Product product = orderDao.query(Product.class, attrs);
		if (ObjValid.isNotValid(product)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_OBJ_NOEXIST_ERROR,null);
		}
		obj.setProductId(product);
		obj.setFinisher(finisher);
		obj.setContractId(contract);
		obj.setPayType(sysParam);
		orderDao.save(obj);
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_UPDATE_SUCCESS,null);
	}

	/*
	 * 删除
	 * @see com.crm.service.orders.OrderService#removeOrder(java.lang.Long, java.lang.String)
	 */
	@Override
	public ResultVo removeOrder(Long id, String token) {
		if (ObjValid.isNotValid(id) || StringUtil.isBlank(token)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_DATA_MISSING,null);
		}
		Map<String, Object> attrs = new HashMap<>();
		attrs.put("id", id);
		attrs.put("token", token);
		Order order = orderDao.query(Order.class, attrs);
		if (ObjValid.isNotValid(order)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_OBJ_NOEXIST_ERROR,null);
		}
		order.setIsDel("1");
		orderDao.update(order);
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_DELETE_SUCCESS,null);
	}

	/*
	 * 根据Id和Token查询
	 * @see com.crm.service.orders.OrderService#retrieveOrder(java.lang.Long, java.lang.String)
	 */
	@Override
	public ResultVo retrieveOrder(Long id, String token) {
		if (ObjValid.isNotValid(id) || StringUtil.isBlank(token)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_DATA_MISSING,null);
		}
		Map<String, Object> attrs = new HashMap<>();
		attrs.put("id", id);
		attrs.put("token", token);
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_FIND_SUCCESS,orderDao.query(Order.class, attrs));
	}

	/*
	 * 查询所有
	 * List
	 * @see com.crm.service.orders.OrderService#retrieveAllOrders()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public ResultVo retrieveAllOrders() {
		Map<String, Object> attrs = new HashMap<>();
		attrs.put("isDel", "0");
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_FIND_SUCCESS,orderDao.queryList(Order.class,"addTime", "desc", attrs));
	}

	/*
	 * 分页查询
	 * @see com.crm.service.orders.OrderService#retrieveOrdersPager(int, int)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public ResultVo retrieveOrdersPager(int pageSize, int pageNo,String isDel,String keyWord) {
		Map<String, Object> attrs = new HashMap<>();
		attrs.put("isDel", isDel);
		Pager pager = new Pager(pageSize, pageNo,Integer.parseInt(String.valueOf(orderDao.queryTotalRecord(Order.class, attrs))),
				orderDao.queryList(Order.class, (pageNo - 1) * pageSize, pageSize,"addTime", "desc", attrs));
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_FIND_SUCCESS,pager);
	}

	/*
	 * 回收产品
	 * @see com.crm.service.orders.OrderService#updateProductStatus(java.lang.Long, java.lang.String)
	 */
	@Override
	public ResultVo updateProductStatus(Long id, String token) {
		Map<String, Object> attrs = new HashMap<>();
		if (ObjValid.isNotValid(id) || StringUtil.isBlank(token)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_DATA_MISSING,null);
		}
		attrs.put("id", id);
		attrs.put("token", token);
		Order order = orderDao.query(Order.class, attrs);
		if (ObjValid.isNotValid(order)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_OBJ_NOEXIST_ERROR,null);
		}
		order.setIsDel("0");
		orderDao.update(order);
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_SUCCESS,null);
	}


}