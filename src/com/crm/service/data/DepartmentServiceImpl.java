package com.crm.service.data;

import java.util.HashMap;
import java.util.Map;

import com.crm.bases.BaseManagerDaoImpl;
import com.crm.entity.Department;
import com.crm.entity.Users;
import com.crm.vo.ResultVo;
import com.modules.commons.CommonReturn;
import com.modules.util.ObjValid;
import com.modules.util.Sha256;
import com.modules.util.StringUtil;

public class DepartmentServiceImpl extends BaseManagerDaoImpl implements DepartmentService {

	/*
	 * 添加
	 * @see com.crm.service.data.DepartmentService#addDepartment(com.crm.entity.Department)
	 */
	@Override
	public ResultVo addDepartment(Department department,Long managerId) {
		if (ObjValid.isNotValid(department)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_DATA_EXCEPT,null);
		}
		if (StringUtil.isBlank(department.getCode()) || StringUtil.isBlank(department.getName()) || ObjValid.isNotValid(managerId)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_DATA_MISSING,null);
		}
		Map<String, Object> attrs = new HashMap<>();
		attrs.put("id", managerId);
		Users manager = departmentDao.query(Users.class, attrs);
		if (ObjValid.isNotValid(manager)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_OBJ_NOEXIST_ERROR,null);
		}
		department.setManager(manager);
		department.setIsDel("0");
		department.setToken(Sha256.SHA256(department.getName()+department.getCode()+managerId.toString()+CommonReturn.SIGN_KEY));
		departmentDao.save(department);
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_ADD_SUCCESS,null);
	}

	/*
	 * 修改
	 * @see com.crm.service.data.DepartmentService#modifyDepartment(com.crm.entity.Department)
	 */
	@Override
	public ResultVo modifyDepartment(Department department,Long managerId) {
		if (ObjValid.isNotValid(department)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_DATA_EXCEPT,null);
		}
		if (StringUtil.isBlank(department.getCode()) || StringUtil.isBlank(department.getName()) || ObjValid.isNotValid(managerId)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_DATA_MISSING,null);
		}
		Map<String, Object> attrs = new HashMap<>();
		attrs.put("id", managerId);
		Users manager = departmentDao.query(Users.class, attrs);
		if (ObjValid.isNotValid(manager)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_OBJ_NOEXIST_ERROR,null);
		}
		attrs.clear();
		attrs.put("id", department.getId());
		attrs.put("token", department.getToken());
		Department obj = departmentDao.query(Department.class, attrs);
		if (ObjValid.isNotValid(obj)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_OBJ_NOEXIST_ERROR,null);
		}
		obj.setManager(manager);
		obj.setCode(department.getCode());
		obj.setName(department.getName());
		obj.setRemark(department.getRemark());
		obj.setIsDel(department.getIsDel());
		departmentDao.update(obj);
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_UPDATE_SUCCESS,null);
	}

	/*
	 * 删除
	 * @see com.crm.service.data.DepartmentService#removeDepartment(java.lang.Long, java.lang.String)
	 */
	@Override
	public ResultVo removeDepartment(Long id, String token) {
		if (ObjValid.isNotValid(id) || StringUtil.isBlank(token)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_DATA_MISSING,null);
		}
		Map<String, Object> attrs = new HashMap<>();
		attrs.put("id", id);
		attrs.put("token", token);
		Department department = departmentDao.query(Department.class, attrs);
		if (ObjValid.isNotValid(department)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_OBJ_NOEXIST_ERROR,null);
		}
		department.setIsDel("1");
		departmentDao.update(department);
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_DELETE_SUCCESS,null);
	}

	/*
	 * 根据Id和Token查询
	 * @see com.crm.service.data.DepartmentService#retrieveDepartment(java.lang.Long, java.lang.String)
	 */
	@Override
	public ResultVo retrieveDepartment(Long id, String token) {
		if (ObjValid.isNotValid(id) || StringUtil.isBlank(token)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_DATA_MISSING,null);
		}
		Map<String, Object> attrs = new HashMap<>();
		attrs.put("id", id);
		attrs.put("token", token);
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_FIND_SUCCESS,departmentDao.query(Department.class, attrs));
	}

	/*
	 * 查询所有
	 * List
	 * @see com.crm.service.data.DepartmentService#retrieveAllDepartments()
	 */
	@Override
	public ResultVo retrieveAllDepartments() {
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_FIND_SUCCESS,departmentDao.queryList(Department.class,"id", "asc", null));
	}

	/*
	 * 分页查询
	 * @see com.crm.service.data.DepartmentService#retrieveDepartmentsPager(int, int)
	 */
	@Override
	public ResultVo retrieveDepartmentsPager(int pageSize, int pageNo,String isDel,String keyWord) {
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_FIND_SUCCESS,departmentDao.retrieveDepartmentsPager(pageSize, pageNo, isDel, keyWord));
	}


}