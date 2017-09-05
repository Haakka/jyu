package com.crm.service.data;

import com.crm.entity.Department;
import com.crm.vo.ResultVo;

public interface DepartmentService {

	/**
	 * 添加
	 * @param department
	 * @return
	 */
	public ResultVo addDepartment(Department department,Long managerId);
	
	/**
	 * 修改
	 * @param department
	 * @return
	 */
	public ResultVo modifyDepartment(Department department,Long managerId);
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	public ResultVo removeDepartment(Long id,String token);
	
	/**
	 * 根据Id和Token查询
	 * @param id
	 * @return
	 */
	public ResultVo retrieveDepartment(Long id,String token);
	
	/**
	 * 查询所有
	 * List
	 * @return
	 */
	public ResultVo retrieveAllDepartments();
	
	/**
	 * 分页查询
	 * @param pageSize
	 * @param pageNo
	 * @return
	 */
	public ResultVo retrieveDepartmentsPager(int pageSize, int pageNo,String isDel,String keyWord);
	
}