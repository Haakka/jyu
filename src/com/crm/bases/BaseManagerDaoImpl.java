package com.crm.bases;

import java.io.Serializable;
import java.util.List;

import com.crm.dao.cusman.BusinessDao;
import com.crm.dao.cusman.ConsumerDao;
import com.crm.dao.cusman.ContactDao;
import com.crm.dao.cusman.FollowDao;
import com.crm.dao.cusman.InvoiceDao;
import com.crm.dao.cusman.ReceivingDao;
import com.crm.dao.data.DepartmentDao;
import com.crm.dao.data.PositionDao;
import com.crm.dao.news.NewsDao;
import com.crm.dao.orders.ContractDao;
import com.crm.dao.orders.OrderDao;
import com.crm.dao.personal.EvenDao;
import com.crm.dao.personal.MailReceiveDao;
import com.crm.dao.personal.NoteDao;
import com.crm.dao.personal.PersonMailDao;
import com.crm.dao.product.ProductDao;
import com.crm.dao.system.AuthoritiesDao;
import com.crm.dao.system.LoginLogDao;
import com.crm.dao.system.RolesAuthoritiesDao;
import com.crm.dao.system.RolesDao;
import com.crm.dao.system.SysParamDao;
import com.crm.dao.system.SysParamTypeDao;
import com.crm.dao.system.UsersDao;
import com.crm.dao.system.UsersRolesDao;

public class BaseManagerDaoImpl implements BaseManagerDao,Serializable {

	private static final long serialVersionUID = -2308147651026388956L;
	private BaseDao baseDao;
	protected UsersDao usersDao;
	protected RolesDao rolesDao;
	protected UsersRolesDao usersRolesDao;
	protected RolesAuthoritiesDao rolesAuthoritiesDao;
	protected AuthoritiesDao authoritiesDao;
	protected LoginLogDao loginLogDao;
	protected SysParamTypeDao sysParamTypeDao;
	protected SysParamDao sysParamDao;
	protected BusinessDao businessDao;
	protected ConsumerDao consumerDao;
	protected ContactDao contactDao;
	protected FollowDao followDao;
	protected DepartmentDao departmentDao;
	protected PositionDao positionDao;
	protected NewsDao newsDao;
	protected ContractDao contractDao;
	protected OrderDao orderDao;
	protected EvenDao evenDao;
	protected NoteDao noteDao;
	protected PersonMailDao personMailDao;
	protected MailReceiveDao mailReceiveDao;
	protected ProductDao productDao;
	protected InvoiceDao invoiceDao;
	protected ReceivingDao receivingDao;
	
	public BaseManagerDaoImpl() {
	}
	

	public RolesDao getRolesDao() {
		return rolesDao;
	}

	public void setRolesDao(RolesDao rolesDao) {
		this.rolesDao = rolesDao;
	}

	public UsersDao getUsersDao() {
		return usersDao;
	}

	public void setUsersDao(UsersDao usersDao) {
		this.usersDao = usersDao;
	}

	public UsersRolesDao getUsersRolesDao() {
		return usersRolesDao;
	}

	public void setUsersRolesDao(UsersRolesDao usersRolesDao) {
		this.usersRolesDao = usersRolesDao;
	}

	public RolesAuthoritiesDao getRolesAuthoritiesDao() {
		return rolesAuthoritiesDao;
	}

	public void setRolesAuthoritiesDao(RolesAuthoritiesDao rolesAuthoritiesDao) {
		this.rolesAuthoritiesDao = rolesAuthoritiesDao;
	}

	public AuthoritiesDao getAuthoritiesDao() {
		return authoritiesDao;
	}

	public void setAuthoritiesDao(AuthoritiesDao authoritiesDao) {
		this.authoritiesDao = authoritiesDao;
	}

	public BaseDao getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

	public void deleteObject(Long id, String objName) {
		this.baseDao.delete(id, objName);
	}

	@SuppressWarnings("rawtypes")
	public List getAllObjects(String objName) {
		return this.baseDao.getAll(objName);
	}

	public void saveObject(Object obj) {
		this.baseDao.save(obj);
	}

	public void updateObject(Object obj) {
		this.baseDao.update(obj);
	}

	public Object getObjectById(Long id, String objName) {
		return this.baseDao.get(id, objName);
	}

	public LoginLogDao getLoginLogDao() {
		return loginLogDao;
	}


	public void setLoginLogDao(LoginLogDao loginLogDao) {
		this.loginLogDao = loginLogDao;
	}


	public SysParamTypeDao getSysParamTypeDao() {
		return sysParamTypeDao;
	}


	public void setSysParamTypeDao(SysParamTypeDao sysParamTypeDao) {
		this.sysParamTypeDao = sysParamTypeDao;
	}


	public SysParamDao getSysParamDao() {
		return sysParamDao;
	}


	public void setSysParamDao(SysParamDao sysParamDao) {
		this.sysParamDao = sysParamDao;
	}


	public BusinessDao getBusinessDao() {
		return businessDao;
	}


	public void setBusinessDao(BusinessDao businessDao) {
		this.businessDao = businessDao;
	}


	public ConsumerDao getConsumerDao() {
		return consumerDao;
	}


	public void setConsumerDao(ConsumerDao consumerDao) {
		this.consumerDao = consumerDao;
	}


	public ContactDao getContactDao() {
		return contactDao;
	}


	public void setContactDao(ContactDao contactDao) {
		this.contactDao = contactDao;
	}


	public FollowDao getFollowDao() {
		return followDao;
	}


	public void setFollowDao(FollowDao followDao) {
		this.followDao = followDao;
	}


	public DepartmentDao getDepartmentDao() {
		return departmentDao;
	}


	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}


	public PositionDao getPositionDao() {
		return positionDao;
	}


	public void setPositionDao(PositionDao positionDao) {
		this.positionDao = positionDao;
	}


	public NewsDao getNewsDao() {
		return newsDao;
	}


	public void setNewsDao(NewsDao newsDao) {
		this.newsDao = newsDao;
	}


	public ContractDao getContractDao() {
		return contractDao;
	}


	public void setContractDao(ContractDao contractDao) {
		this.contractDao = contractDao;
	}


	public OrderDao getOrderDao() {
		return orderDao;
	}


	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	public EvenDao getEvenDao() {
		return evenDao;
	}


	public void setEvenDao(EvenDao evenDao) {
		this.evenDao = evenDao;
	}


	public NoteDao getNoteDao() {
		return noteDao;
	}


	public void setNoteDao(NoteDao noteDao) {
		this.noteDao = noteDao;
	}


	public PersonMailDao getPersonMailDao() {
		return personMailDao;
	}


	public void setPersonMailDao(PersonMailDao personMailDao) {
		this.personMailDao = personMailDao;
	}


	public MailReceiveDao getMailReceiveDao() {
		return mailReceiveDao;
	}


	public void setMailReceiveDao(MailReceiveDao mailReceiveDao) {
		this.mailReceiveDao = mailReceiveDao;
	}


	public ProductDao getProductDao() {
		return productDao;
	}


	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}


	public InvoiceDao getInvoiceDao() {
		return invoiceDao;
	}


	public void setInvoiceDao(InvoiceDao invoiceDao) {
		this.invoiceDao = invoiceDao;
	}


	public ReceivingDao getReceivingDao() {
		return receivingDao;
	}


	public void setReceivingDao(ReceivingDao receivingDao) {
		this.receivingDao = receivingDao;
	}


	


}