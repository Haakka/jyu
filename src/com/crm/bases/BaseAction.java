package com.crm.bases;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.crm.service.cusman.BusinessService;
import com.crm.service.cusman.ConsumerService;
import com.crm.service.cusman.ContactService;
import com.crm.service.cusman.FollowService;
import com.crm.service.cusman.InvoiceService;
import com.crm.service.cusman.ReceivingService;
import com.crm.service.data.DepartmentService;
import com.crm.service.data.PositionService;
import com.crm.service.news.NewsService;
import com.crm.service.orders.ContractService;
import com.crm.service.orders.OrderService;
import com.crm.service.personal.EvenService;
import com.crm.service.personal.MailReceiveService;
import com.crm.service.personal.NoteService;
import com.crm.service.personal.PersonMailService;
import com.crm.service.product.ProductService;
import com.crm.service.system.AuthoritiesManagerDao;
import com.crm.service.system.LoginLogManagerDao;
import com.crm.service.system.RolesAuthoritiesManagerDao;
import com.crm.service.system.RolesManagerDao;
import com.crm.service.system.SysParamService;
import com.crm.service.system.SysParamTypeService;
import com.crm.service.system.UsersManagerDao;
import com.crm.service.system.UsersRolesManagerDao;
import com.crm.vo.ResultVo;
import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	
	protected UsersManagerDao usersManagerDao;
	protected RolesManagerDao rolesManagerDao;
	protected UsersRolesManagerDao usersRolesManagerDao;
	protected AuthoritiesManagerDao authoritiesManagerDao;
	protected RolesAuthoritiesManagerDao rolesAuthoritiesManagerDao;
	protected BaseManagerAction baseManagerAction;
	
	
	protected SysParamService sysParamService ;
	protected SysParamTypeService sysParamTypeService ;
	protected LoginLogManagerDao loginLogManagerDao;
	protected BusinessService businessService;
	protected ConsumerService consumerService;
	protected ContactService contactService;
	protected FollowService followService;
	protected DepartmentService departmentService;
	protected PositionService positionService;
	protected NewsService newsService;
	protected ContractService contractService;
	protected OrderService orderService;
	protected EvenService evenService;
	protected NoteService noteService;
	protected PersonMailService personMailService;
	protected MailReceiveService mailReceiveService;
	protected ProductService productService;
	protected InvoiceService invoiceService;
	protected ReceivingService receivingService;
	
	protected ResultVo resultVo;
	protected String keyWord;//搜索的关键字
	
	public ResultVo getResultVo() {
		return resultVo;
	}

	public void setResultVo(ResultVo resultVo) {
		this.resultVo = resultVo;
	}

	public BaseAction() {
	}

	protected String renderText(String text) {
		return render(text, "text/plain;charset=UTF-8");
	}

	protected String render(String text, String contentType) {
		try {
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType(contentType);
			response.getWriter().write(text);
		} catch (IOException ioexception) {
		}
		return null;
	}


	public UsersManagerDao getUsersManagerDao() {
		return usersManagerDao;
	}

	public void setUsersManagerDao(UsersManagerDao usersManagerDao) {
		this.usersManagerDao = usersManagerDao;
	}

	public RolesManagerDao getRolesManagerDao() {
		return rolesManagerDao;
	}

	public void setRolesManagerDao(RolesManagerDao rolesManagerDao) {
		this.rolesManagerDao = rolesManagerDao;
	}

	public UsersRolesManagerDao getUsersRolesManagerDao() {
		return usersRolesManagerDao;
	}

	public void setUsersRolesManagerDao(UsersRolesManagerDao usersRolesManagerDao) {
		this.usersRolesManagerDao = usersRolesManagerDao;
	}

	public AuthoritiesManagerDao getAuthoritiesManagerDao() {
		return authoritiesManagerDao;
	}

	public void setAuthoritiesManagerDao(AuthoritiesManagerDao authoritiesManagerDao) {
		this.authoritiesManagerDao = authoritiesManagerDao;
	}

	public RolesAuthoritiesManagerDao getRolesAuthoritiesManagerDao() {
		return rolesAuthoritiesManagerDao;
	}

	public void setRolesAuthoritiesManagerDao(RolesAuthoritiesManagerDao rolesAuthoritiesManagerDao) {
		this.rolesAuthoritiesManagerDao = rolesAuthoritiesManagerDao;
	}


	public BaseManagerAction getBaseManagerAction() {
		return baseManagerAction;
	}

	public void setBaseManagerAction(BaseManagerAction baseManagerAction) {
		this.baseManagerAction = baseManagerAction;
	}


	public SysParamService getSysParamService() {
		return sysParamService;
	}

	public void setSysParamService(SysParamService sysParamService) {
		this.sysParamService = sysParamService;
	}

	public SysParamTypeService getSysParamTypeService() {
		return sysParamTypeService;
	}

	public void setSysParamTypeService(SysParamTypeService sysParamTypeService) {
		this.sysParamTypeService = sysParamTypeService;
	}

	public LoginLogManagerDao getLoginLogManagerDao() {
		return loginLogManagerDao;
	}

	public void setLoginLogManagerDao(LoginLogManagerDao loginLogManagerDao) {
		this.loginLogManagerDao = loginLogManagerDao;
	}

	public BusinessService getBusinessService() {
		return businessService;
	}

	public void setBusinessService(BusinessService businessService) {
		this.businessService = businessService;
	}

	public ConsumerService getConsumerService() {
		return consumerService;
	}

	public void setConsumerService(ConsumerService consumerService) {
		this.consumerService = consumerService;
	}

	public ContactService getContactService() {
		return contactService;
	}

	public void setContactService(ContactService contactService) {
		this.contactService = contactService;
	}

	public FollowService getFollowService() {
		return followService;
	}

	public void setFollowService(FollowService followService) {
		this.followService = followService;
	}

	public DepartmentService getDepartmentService() {
		return departmentService;
	}

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	public PositionService getPositionService() {
		return positionService;
	}

	public void setPositionService(PositionService positionService) {
		this.positionService = positionService;
	}

	public NewsService getNewsService() {
		return newsService;
	}

	public void setNewsService(NewsService newsService) {
		this.newsService = newsService;
	}

	public ContractService getContractService() {
		return contractService;
	}

	public void setContractService(ContractService contractService) {
		this.contractService = contractService;
	}

	public OrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	public EvenService getEvenService() {
		return evenService;
	}

	public void setEvenService(EvenService evenService) {
		this.evenService = evenService;
	}

	public NoteService getNoteService() {
		return noteService;
	}

	public void setNoteService(NoteService noteService) {
		this.noteService = noteService;
	}

	public PersonMailService getPersonMailService() {
		return personMailService;
	}

	public void setPersonMailService(PersonMailService personMailService) {
		this.personMailService = personMailService;
	}

	public MailReceiveService getMailReceiveService() {
		return mailReceiveService;
	}

	public void setMailReceiveService(MailReceiveService mailReceiveService) {
		this.mailReceiveService = mailReceiveService;
	}

	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	public InvoiceService getInvoiceService() {
		return invoiceService;
	}

	public void setInvoiceService(InvoiceService invoiceService) {
		this.invoiceService = invoiceService;
	}

	public ReceivingService getReceivingService() {
		return receivingService;
	}

	public void setReceivingService(ReceivingService receivingService) {
		this.receivingService = receivingService;
	}



	
	
}