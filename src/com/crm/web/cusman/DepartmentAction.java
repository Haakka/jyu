package com.crm.web.cusman;

import java.util.List;

import com.crm.entity.Department;
import com.crm.entity.Users;
import com.crm.vo.ResultVo;
import com.modules.commons.CommonReturn;
import com.modules.commons.PageAction;
import com.modules.commons.Pager;
import com.modules.util.ObjValid;

import net.sf.json.JSONObject;

public class DepartmentAction extends PageAction {
	
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String token;
	
	private Department department;
	
	private Long managerId;
	
	private List<Department> departments;
	
	private List<Users> managers;
	
	/**
	 * 分页查询
	 * @return
	 * @throws Exception
	 */
	public String retrieveAllDepartments() throws Exception {
		try {
			resultVo = departmentService.retrieveDepartmentsPager(pageSize, pageNo,"0",keyWord);
			pager = (Pager) resultVo.getResult();
		} catch (Exception ex) {
			resultVo = new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_EXCEPTION_POPUP,null);
			ex.printStackTrace();
		}
		return "success";
	}
	
	/**
	 * 分页查询可回收列表
	 * @return
	 * @throws Exception
	 */
	public String retrieveAllTrash() throws Exception {
		try {
			resultVo = departmentService.retrieveDepartmentsPager(pageSize, pageNo,"1",keyWord);
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
		resultVo = consumerService.updateConsumerStatus(id, token);
		JSONObject json = JSONObject.fromObject(resultVo);
		return renderText(json == null ? null : json.toString());
	}
	
	/**
	 * 跳转编辑
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public String retrieveDepartmentById() throws Exception {
		try {
			this.managers = usersManagerDao.findAllUser();
			resultVo = departmentService.retrieveDepartment(id,token);
			if (ObjValid.isValid(resultVo.getResult())) {
				department = (Department) resultVo.getResult();
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
	@SuppressWarnings("unchecked")
	public String newPage() throws Exception {
		this.managers = usersManagerDao.findAllUser();
		return "newPage";
	}
	
	/**
	 * 查看
	 * @return
	 * @throws Exception
	 */
	public String viewPage() throws Exception {
		try {
			resultVo = departmentService.retrieveDepartment(id,token);
			if (ObjValid.isValid(resultVo.getResult())) {
				department = (Department) resultVo.getResult();
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
	public String newDepartment() throws Exception {
		try {
			resultVo = departmentService.addDepartment(department,managerId);
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
	public String editDepartment() throws Exception {
		try {
			resultVo = departmentService.modifyDepartment(department,managerId);
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
	public String delDepartment() throws Exception {
		try {
			resultVo = departmentService.removeDepartment(id,token);
		} catch (Exception ex) {
			resultVo = new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_EXCEPTION_POPUP,null);
			ex.printStackTrace();
		}
		JSONObject json = JSONObject.fromObject(resultVo);
		return renderText(json == null ? null : json.toString());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(
			List<Department> departments) {
		this.departments = departments;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Long getManagerId() {
		return managerId;
	}

	public void setManagerId(Long managerId) {
		this.managerId = managerId;
	}

	public List<Users> getManagers() {
		return managers;
	}

	public void setManagers(List<Users> managers) {
		this.managers = managers;
	}

	
}