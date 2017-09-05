package com.crm.web.cusman;

import java.util.List;

import com.crm.entity.Contract;
import com.crm.entity.Order;
import com.crm.entity.Product;
import com.crm.entity.SysParam;
import com.crm.entity.Users;
import com.crm.vo.ResultVo;
import com.modules.commons.CommonReturn;
import com.modules.commons.GetUsersInfo;
import com.modules.commons.PageAction;
import com.modules.commons.Pager;
import com.modules.util.ObjValid;

import net.sf.json.JSONObject;

public class OrderAction extends PageAction {
	
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String token;
	
	private String isDel;
	
	private Order order;
	
	private List<Product> products;
	
	private List<Order> orders;
	
	private List<Contract> contracts;
	
	private List<SysParam> payTypes;
	
	private List<Users> finishers;
	
	private Long productId;
	
	private Long contractId;
	
	private Long finisherId;
	
	private Long payTypeId;
	
	/**
	 * 分页查询
	 * @return
	 * @throws Exception
	 */
	public String retrieveAllOrders() throws Exception {
		try {
			resultVo = orderService.retrieveOrdersPager(pageSize, pageNo,"0",keyWord);
			pager = (Pager) resultVo.getResult();
		} catch (Exception ex) {
			resultVo = new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_EXCEPTION_POPUP,null);
			ex.printStackTrace();
		}
		return "success";
	}
	
	/**
	 * 分页查询所有可回收的产品信息
	 * @return
	 * @throws Exception
	 */
	public String retrieveAllTrash() {
		try {
			resultVo = orderService.retrieveOrdersPager(pageSize, pageNo,"1",keyWord);
			pager = (Pager) resultVo.getResult();
		} catch (Exception ex) {
			resultVo = new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_EXCEPTION_POPUP,null);
			ex.printStackTrace();
		}
		return "trash";
	}
	
	/**
	 * 回收垃圾
	 * @return
	 */
	public String recycleWaste(){
		resultVo = orderService.updateProductStatus(id, token);
		JSONObject json = JSONObject.fromObject(resultVo);
		return renderText(json == null ? null : json.toString());
	}
	
	/**
	 * 跳转编辑
	 * @return
	 * @throws Exception
	 */
	public String retrieveOrderById() throws Exception {
		try {
			init();
			resultVo = orderService.retrieveOrder(id,token);
			if (ObjValid.isValid(resultVo.getResult())) {
				order = (Order) resultVo.getResult();
			}
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
	 * 查看
	 * @return
	 * @throws Exception
	 */
	public String viewPage() throws Exception {
		try {
			resultVo = orderService.retrieveOrder(id,token);
			if (ObjValid.isValid(resultVo.getResult())) {
				order = (Order) resultVo.getResult();
			}
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
	public String newOrder() throws Exception {
		try {
			Users user = GetUsersInfo.getUsers();
			resultVo = orderService.addOrder(order,user,contractId,finisherId,payTypeId,productId);
		} catch (Exception ex) {
			resultVo = new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_EXCEPTION_POPUP,null);
			ex.printStackTrace();
		}
		JSONObject json = JSONObject.fromObject(resultVo);
		return renderText(json == null ? null : json.toString());
	}
	
	/**
	 * 编辑
	 * @return
	 * @throws Exception
	 */
	public String editOrder() throws Exception {
		try {
			resultVo = orderService.modifyOrder(order,contractId,finisherId,payTypeId,productId);
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
	public String delOrder() throws Exception {
		try {
			resultVo = orderService.removeOrder(id,token);
		} catch (Exception ex) {
			resultVo = new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_EXCEPTION_POPUP,null);
			ex.printStackTrace();
		}
		JSONObject json = JSONObject.fromObject(resultVo);
		return renderText(json == null ? null : json.toString());
	}
	
	@SuppressWarnings("unchecked")
	public void init(){
		this.finishers = usersManagerDao.findAllUser();
		this.contracts = (List<Contract>) contractService.retrieveAllContracts().getResult();
		this.payTypes = (List<SysParam>) sysParamService.findByTypeId(16L).getResult();
		this.products = (List<Product>) productService.retrieveAllProducts().getResult();
	}
	
	/**
	 * 导出信息
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String export(){
		this.orders = (List<Order>) orderService.retrieveAllOrders().getResult();
		return "export";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(
			List<Order> orders) {
		this.orders = orders;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Long getContractId() {
		return contractId;
	}

	public void setContractId(Long contractId) {
		this.contractId = contractId;
	}

	public Long getFinisherId() {
		return finisherId;
	}

	public void setFinisherId(Long finisherId) {
		this.finisherId = finisherId;
	}

	public Long getPayTypeId() {
		return payTypeId;
	}

	public void setPayTypeId(Long payTypeId) {
		this.payTypeId = payTypeId;
	}

	public List<Contract> getContracts() {
		return contracts;
	}

	public void setContracts(List<Contract> contracts) {
		this.contracts = contracts;
	}

	public List<SysParam> getPayTypes() {
		return payTypes;
	}

	public void setPayTypes(List<SysParam> payTypes) {
		this.payTypes = payTypes;
	}

	public List<Users> getFinishers() {
		return finishers;
	}

	public void setFinishers(List<Users> finishers) {
		this.finishers = finishers;
	}

	public String getIsDel() {
		return isDel;
	}

	public void setIsDel(String isDel) {
		this.isDel = isDel;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}
	
	

}