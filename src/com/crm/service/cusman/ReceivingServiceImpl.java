package com.crm.service.cusman;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.crm.bases.BaseManagerDaoImpl;
import com.crm.entity.Order;
import com.crm.entity.Receiving;
import com.crm.vo.ResultVo;
import com.modules.commons.CommonReturn;
import com.modules.util.ObjValid;
import com.modules.util.Sha256;
import com.modules.util.StringUtil;

public class ReceivingServiceImpl extends BaseManagerDaoImpl implements ReceivingService {

	/*
	 * 添加
	 * @see com.crm.service.cusman.ReceivingService#addReceiving(com.crm.entity.Receiving, java.lang.Long)
	 */
	@Override
	public ResultVo addReceiving(Receiving receiving, Long orderId) {
		if (ObjValid.isNotValid(receiving)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_DATA_EXCEPT,null);
		}
		if (ObjValid.isNotValid(receiving.getMoney()) || ObjValid.isNotValid(receiving.getPayTime()) || ObjValid.isNotValid(orderId)
				) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_DATA_MISSING,null);
		}
		Map<String, Object> attrs = new HashMap<>();
		attrs.put("id", orderId);
		Order order = receivingDao.query(Order.class, attrs);
		if (ObjValid.isNotValid(order)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_OBJ_NOEXIST_ERROR,null);
		}
		receiving.setOrderId(order);
		receiving.setAddTime(new Date());
		receiving.setToken(Sha256.SHA256((new Date()).toString()+CommonReturn.SIGN_KEY));
		receiving.setIsDel("0");
		receivingDao.save(receiving);
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_ADD_SUCCESS,null);
	}

	/*
	 * 修改
	 * @see com.crm.service.cusman.ReceivingService#modifyReceiving(com.crm.entity.Receiving, java.lang.Long)
	 */
	@Override
	public ResultVo modifyReceiving(Receiving receiving) {
		if (ObjValid.isNotValid(receiving)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_DATA_EXCEPT,null);
		}
		if (ObjValid.isNotValid(receiving.getMoney()) || ObjValid.isNotValid(receiving.getPayTime()) 
				) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_DATA_MISSING,null);
		}
		Map<String, Object> attrs = new HashMap<>();
		attrs.put("id", receiving.getId());
		attrs.put("token", receiving.getToken());
		Receiving obj = receivingDao.query(Receiving.class, attrs);
		if (ObjValid.isNotValid(obj)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_OBJ_NOEXIST_ERROR,null);
		}
		obj.setMoney(receiving.getMoney());
		obj.setPayTime(receiving.getPayTime());
		obj.setRemark(receiving.getRemark());
		receivingDao.update(obj);
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_UPDATE_SUCCESS,null);
	}

	/*
	 *  删除
	 * @see com.crm.service.cusman.ReceivingService#removeReceiving(java.lang.Long, java.lang.String)
	 */
	@Override
	public ResultVo removeReceiving(Long id, String token) {
		if (ObjValid.isNotValid(id) || StringUtil.isBlank(token)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_DATA_MISSING,null);
		}
		Map<String, Object> attrs = new HashMap<>();
		attrs.put("id", id);
		attrs.put("token", token);
		Receiving receiving = receivingDao.query(Receiving.class, attrs);
		if (ObjValid.isNotValid(receiving)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_OBJ_NOEXIST_ERROR,null);
		}
		receiving.setIsDel("1");
		receivingDao.update(receiving);
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_DELETE_SUCCESS,null);
	}

	/*
	 * 根据Id和Token查询
	 * @see com.crm.service.cusman.ReceivingService#retrieveReceiving(java.lang.Long, java.lang.String)
	 */
	@Override
	public ResultVo retrieveReceiving(Long id, String token) {
		if (ObjValid.isNotValid(id) || StringUtil.isBlank(token)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_DATA_MISSING,null);
		}
		Map<String, Object> attrs = new HashMap<>();
		attrs.put("id", id);
		attrs.put("token", token);
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_FIND_SUCCESS,receivingDao.query(Receiving.class, attrs));
	
	}

	/*
	 * 查询所有
	 * @see com.crm.service.cusman.ReceivingService#retrieveAllReceivings()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public ResultVo retrieveAllReceivings() {
		Map<String, Object> attrs = new HashMap<>();
		attrs.put("isDel", "0");
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_FIND_SUCCESS,receivingDao.queryList(Receiving.class,"addTime", "desc", attrs));
		
	}

	/*
	 * 分页查询
	 * @see com.crm.service.cusman.ReceivingService#retrieveReceivingsPager(int, int)
	 */
	@Override
	public ResultVo retrieveReceivingsPager(int pageSize, int pageNo,String keyWords) {
		return  new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_FIND_SUCCESS,receivingDao.retrieveReceivingsPager(pageSize, pageNo, keyWords));
	}


}