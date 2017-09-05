package com.crm.service.cusman;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.crm.bases.BaseManagerDaoImpl;
import com.crm.entity.Invoice;
import com.crm.entity.Order;
import com.crm.entity.Users;
import com.crm.vo.ResultVo;
import com.modules.commons.CommonReturn;
import com.modules.util.ObjValid;
import com.modules.util.Sha256;
import com.modules.util.StringUtil;

public class InvoiceServiceImpl extends BaseManagerDaoImpl implements InvoiceService {

	/*
	 * 添加
	 * @see com.crm.service.cusman.InvoiceService#addInvoice(com.crm.entity.Invoice, com.crm.entity.Users, java.lang.Long)
	 */
	@Override
    public ResultVo addInvoice(Invoice invoice,Users users,Long consumerId,Long orderId) {
		if (ObjValid.isNotValid(invoice)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_DATA_EXCEPT,null);
		}
		if (StringUtil.isBlank(invoice.getNum()) || StringUtil.isBlank(invoice.getCode())
				|| ObjValid.isNotValid(orderId) || ObjValid.isNotValid(invoice.getAmount()) || ObjValid.isNotValid(invoice.getStartDate())
				|| StringUtil.isBlank(invoice.getPayer()) || StringUtil.isBlank(invoice.getPayerAddress()) || StringUtil.isBlank(invoice.getPayerTel())
				|| StringUtil.isBlank(invoice.getPayerBank()) || StringUtil.isBlank(invoice.getPayerAcount()) || StringUtil.isBlank(invoice.getReceiver())
				|| StringUtil.isBlank(invoice.getReceiverAdderss()) || StringUtil.isBlank(invoice.getReceiverTel()) || StringUtil.isBlank(invoice.getReceiverBank())
				|| StringUtil.isBlank(invoice.getReceiverAcount()) || StringUtil.isBlank(invoice.getReceiverBank()) 
				) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_DATA_MISSING,null);
		}
		Map<String, Object> attrs = new HashMap<>();
		attrs.put("id", orderId);
		Order order = invoiceDao.query(Order.class, attrs);
		if (ObjValid.isNotValid(order)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_OBJ_NOEXIST_ERROR,null);
		}
		invoice.setOrderId(order);
		invoice.setAddTime(new Date());
		invoice.setUserId(users);
		invoice.setIsDel("0");
		invoice.setToken(Sha256.SHA256((new Date()).toString()+invoice.getNum()+invoice.getCode()+CommonReturn.SIGN_KEY));
		invoiceDao.save(invoice);
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_ADD_SUCCESS,null);
	}

	/*
	 * 修改
	 * @see com.crm.service.cusman.InvoiceService#modifyInvoice(com.crm.entity.Invoice, java.lang.Long)
	 */
	@Override
	public ResultVo modifyInvoice(Invoice invoice) {
		if (ObjValid.isNotValid(invoice)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_DATA_EXCEPT,null);
		}
		if (StringUtil.isBlank(invoice.getNum()) || StringUtil.isBlank(invoice.getCode())
				 || ObjValid.isNotValid(invoice.getAmount()) || ObjValid.isNotValid(invoice.getStartDate())
				|| StringUtil.isBlank(invoice.getPayer()) || StringUtil.isBlank(invoice.getPayerAddress()) || StringUtil.isBlank(invoice.getPayerTel())
				|| StringUtil.isBlank(invoice.getPayerBank()) || StringUtil.isBlank(invoice.getPayerAcount()) || StringUtil.isBlank(invoice.getReceiver())
				|| StringUtil.isBlank(invoice.getReceiverAdderss()) || StringUtil.isBlank(invoice.getReceiverTel()) || StringUtil.isBlank(invoice.getReceiverBank())
				|| StringUtil.isBlank(invoice.getReceiverAcount()) || StringUtil.isBlank(invoice.getReceiverBank()) 
				) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_DATA_MISSING,null);
		}
		Map<String, Object> attrs = new HashMap<>();
		attrs.put("id", invoice.getId());
		attrs.put("token", invoice.getToken());
		Invoice obj = invoiceDao.query(Invoice.class, attrs);
		if (ObjValid.isNotValid(obj)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_OBJ_NOEXIST_ERROR,null);
		}
		obj.setNum(invoice.getNum());
		obj.setCode(invoice.getCode());
		obj.setAmount(invoice.getAmount());
		obj.setType(invoice.getType());
		obj.setStartDate(invoice.getStartDate());
		obj.setPayer(invoice.getPayer());
		obj.setPayerAddress(invoice.getPayerAddress());
		obj.setPayerTel(invoice.getPayerTel());
		obj.setPayerAcount(invoice.getPayerAcount());
		obj.setPayerBank(invoice.getPayerBank());
		obj.setReceiver(invoice.getReceiver());
		obj.setReceiverAdderss(invoice.getReceiverAdderss());
		obj.setReceiverTel(invoice.getReceiverTel());
		obj.setReceiverAcount(invoice.getReceiverAcount());
		obj.setReceiverBank(invoice.getReceiverBank());
		invoiceDao.update(obj);
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_UPDATE_SUCCESS,null);
	}

	/*
	 * 删除
	 * @see com.crm.service.cusman.InvoiceService#removeInvoice(java.lang.Long, java.lang.String)
	 */
	@Override
	public ResultVo removeInvoice(Long id, String token) {
		if (ObjValid.isNotValid(id) || StringUtil.isBlank(token)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_DATA_MISSING,null);
		}
		Map<String, Object> attrs = new HashMap<>();
		attrs.put("id", id);
		attrs.put("token", token);
		Invoice invoice = invoiceDao.query(Invoice.class, attrs);
		if (ObjValid.isNotValid(invoice)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_OBJ_NOEXIST_ERROR,null);
		}
		invoice.setIsDel("1");
		invoiceDao.update(invoice);
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_DELETE_SUCCESS,null);
	}

	/*
	 * 根据Id和Token查询
	 * @see com.crm.service.cusman.InvoiceService#retrieveInvoice(java.lang.Long, java.lang.String)
	 */
	@Override
	public ResultVo retrieveInvoice(Long id, String token) {
		if (ObjValid.isNotValid(id) || StringUtil.isBlank(token)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_DATA_MISSING,null);
		}
		Map<String, Object> attrs = new HashMap<>();
		attrs.put("id", id);
		attrs.put("token", token);
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_FIND_SUCCESS,invoiceDao.query(Invoice.class, attrs));
	}

	/*
	 * 查询所有
	 * List
	 * @see com.crm.service.cusman.InvoiceService#retrieveAllInvoices()
	 */
	@Override
	public ResultVo retrieveAllInvoices() {
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_FIND_SUCCESS,invoiceDao.queryList(Invoice.class,"addTime", "desc", null));
	}

	/*
	 * 分页查询
	 * @see com.crm.service.cusman.InvoiceService#retrieveInvoicesPager(int, int, com.crm.entity.Users)
	 */
	@Override
	public ResultVo retrieveInvoicesPager(int pageSize, int pageNo,String keyWord) {
		return  new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_FIND_SUCCESS,invoiceDao.retrieveInvoicesPager(pageSize, pageNo, keyWord));
	}


}