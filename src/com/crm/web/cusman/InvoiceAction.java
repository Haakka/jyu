package com.crm.web.cusman;

import java.util.List;

import com.crm.entity.Consumer;
import com.crm.entity.Invoice;
import com.crm.entity.Order;
import com.crm.entity.Users;
import com.crm.vo.ResultVo;
import com.modules.commons.CommonReturn;
import com.modules.commons.GetUsersInfo;
import com.modules.commons.PageAction;
import com.modules.commons.Pager;

import net.sf.json.JSONObject;

public class InvoiceAction extends PageAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private Invoice invoice;
	
	private String token;
	
	private Long consumerId;
	
	private Long orderId;
	
	private List<Invoice> invoices;
	
	private List<Consumer> consumers;
	
	private List<Order> orders;
	
	/**
	 * 分页查询
	 * @return
	 * @throws Exception
	 */
	public String retrieveAllInvoices() throws Exception {
		try {
			resultVo = invoiceService.retrieveInvoicesPager(pageSize, pageNo, keyWord);
			pager = (Pager) resultVo.getResult();
		} catch (Exception ex) {
			resultVo = new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_EXCEPTION_POPUP,null);
			ex.printStackTrace();
		}
		return "success";
	}
	
	/**
	 * 跳转编辑
	 * @return
	 * @throws Exception
	 */
	public String retrieveInvoiceById() throws Exception {
		try {
			init();
			resultVo = invoiceService.retrieveInvoice(id, token);
			invoice = (Invoice) resultVo.getResult();
		} catch (Exception ex) {
			resultVo = new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_EXCEPTION_POPUP,null);
			ex.printStackTrace();
		}
		return "editPage";
	}

	/**
	 * 跳转添加
	 * @return
	 * @throws Exception
	 */
	public String newPage() throws Exception {
		init();
		return "newPage";
	}
	
	/**
	 * 跳转查看
	 * @return
	 * @throws Exception
	 */
	public String viewPage() throws Exception {
		try {
			resultVo = invoiceService.retrieveInvoice(id, token);
			invoice = (Invoice) resultVo.getResult();
		} catch (Exception ex) {
			resultVo = new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_EXCEPTION_POPUP,null);
			ex.printStackTrace();
		}
		return "viewPage";
	}
	
	/**
	 * 添加
	 * @return
	 * @throws Exception
	 */
	public String newInvoice() throws Exception {
		try {
			Users users = GetUsersInfo.getUsers();
			resultVo = invoiceService.addInvoice(invoice, users, consumerId, orderId);
		} catch (Exception ex) {
			resultVo = new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_EXCEPTION_POPUP,null);
			ex.printStackTrace();
		}
		JSONObject json = JSONObject.fromObject(resultVo);
		return renderText(json == null ? null : json.toString());
	}
	
	/**
	 * 修改
	 * @return
	 * @throws Exception
	 */
	public String editInvoice() throws Exception {
		try {
			resultVo = invoiceService.modifyInvoice(invoice);
		} catch (Exception ex) {
			resultVo = new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_EXCEPTION_POPUP,null);
			ex.printStackTrace();
		}
		JSONObject json = JSONObject.fromObject(resultVo);
		return renderText(json == null ? null : json.toString());
	}
	
	/**
	 * 删除
	 * @return
	 * @throws Exception
	 */
	public String delInvoice() throws Exception {
		try {
			resultVo = invoiceService.removeInvoice(id, token);
		} catch (Exception ex) {
			resultVo = new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_EXCEPTION_POPUP,null);
			ex.printStackTrace();
		}
		JSONObject json = JSONObject.fromObject(resultVo);
		return renderText(json == null ? null : json.toString());
	}
	
	@SuppressWarnings({ "unchecked", "unused" })
	private void init(){
		Users users = GetUsersInfo.getUsers();
		this.orders = (List<Order>) orderService.retrieveAllOrders().getResult();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	public List<Invoice> getInvoices() {
		return invoices;
	}

	public void setInvoices(
			List<Invoice> invoices) {
		this.invoices = invoices;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Long getConsumerId() {
		return consumerId;
	}

	public void setConsumerId(Long consumerId) {
		this.consumerId = consumerId;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public List<Consumer> getConsumers() {
		return consumers;
	}

	public void setConsumers(List<Consumer> consumers) {
		this.consumers = consumers;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
	

}