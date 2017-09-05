package com.crm.service.data;

import java.util.HashMap;
import java.util.Map;

import com.crm.bases.BaseManagerDaoImpl;
import com.crm.entity.Department;
import com.crm.entity.Position;
import com.crm.vo.ResultVo;
import com.modules.commons.CommonReturn;
import com.modules.util.ObjValid;
import com.modules.util.Sha256;
import com.modules.util.StringUtil;

public class PositionServiceImpl extends BaseManagerDaoImpl implements PositionService {

	/*
	 * 添加
	 * @see com.crm.service.data.PositionService#addPosition(com.crm.entity.Position, java.lang.Long)
	 */
	@Override
	public ResultVo addPosition(Position position, Long departmentId) {
		if (ObjValid.isNotValid(position)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_DATA_EXCEPT,null);
		}
		if (StringUtil.isBlank(position.getCode()) || StringUtil.isBlank(position.getName()) || ObjValid.isNotValid(departmentId)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_DATA_MISSING,null);
		}
		Map<String, Object> attrs = new HashMap<>();
		attrs.put("id", departmentId);
		Department department = positionDao.query(Department.class, attrs);
		if (ObjValid.isNotValid(department)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_OBJ_NOEXIST_ERROR,null);
		}
		position.setDepartmentId(department);
		position.setIsDel("0");
		position.setToken(Sha256.SHA256(position.getName()+position.getCode()+departmentId.toString()+CommonReturn.SIGN_KEY));
		positionDao.save(position);
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_ADD_SUCCESS,null);
	}

	/*
	 * 更新、编辑
	 * @see com.crm.service.data.PositionService#modifyPosition(com.crm.entity.Position, java.lang.Long)
	 */
	@Override
	public ResultVo modifyPosition(Position position) {
		if (ObjValid.isNotValid(position)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_DATA_EXCEPT,null);
		}
		if (StringUtil.isBlank(position.getCode()) || StringUtil.isBlank(position.getName()) ) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_DATA_MISSING,null);
		}
		Map<String, Object> attrs = new HashMap<>();
		attrs.put("id", position.getId());
		attrs.put("token", position.getToken());
		Position obj = positionDao.query(Position.class, attrs);
		if (ObjValid.isNotValid(obj)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_OBJ_NOEXIST_ERROR,null);
		}
		obj.setCode(position.getCode());
		obj.setName(position.getName());
		obj.setRemark(position.getRemark());
		obj.setIsDel(position.getIsDel());
		positionDao.update(obj);
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_UPDATE_SUCCESS,null);
	}

	/*
	 * 删除
	 * @see com.crm.service.data.PositionService#removePosition(java.lang.Long, java.lang.String)
	 */
	@Override
	public ResultVo removePosition(Long id, String token) {
		if (ObjValid.isNotValid(id) || StringUtil.isBlank(token)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_DATA_MISSING,null);
		}
		Map<String, Object> attrs = new HashMap<>();
		attrs.put("id", id);
		attrs.put("token", token);
		Position position = positionDao.query(Position.class, attrs);
		if (ObjValid.isNotValid(position)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_OBJ_NOEXIST_ERROR,null);
		}
		position.setIsDel("1");
		positionDao.update(position);
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_DELETE_SUCCESS,null);
	}

	/*
	 * 根据ID和Token查询
	 * @see com.crm.service.data.PositionService#retrievePosition(java.lang.Long, java.lang.String)
	 */
	@Override
	public ResultVo retrievePosition(Long id, String token) {
		if (ObjValid.isNotValid(id) || StringUtil.isBlank(token)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_DATA_MISSING,null);
		}
		Map<String, Object> attrs = new HashMap<>();
		attrs.put("id", id);
		attrs.put("token", token);
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_FIND_SUCCESS,positionDao.query(Position.class, attrs));
	}

	/*
	 * 查询所有
	 * List
	 * @see com.crm.service.data.PositionService#retrieveAllPositions()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public ResultVo retrieveAllPositions() {
		Map<String, Object> attrs = new HashMap<>();
		attrs.put("isDel", "0");
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_FIND_SUCCESS,positionDao.queryList(Position.class,"id", "asc", attrs));
	}

	/*
	 * 分页查询
	 * @see com.crm.service.data.PositionService#retrievePositionsPager(int, int, java.lang.Long)
	 */
	@Override
	public ResultVo retrievePositionsPager(int pageSize, int pageNo, Long departmentId,String token,String keyWord) {
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_FIND_SUCCESS,positionDao.retrievePositionsPager(pageSize, pageNo, departmentId, token, keyWord));
	}

	/*
	 * 根据Id查询
	 * @see com.crm.service.data.PositionService#findPositionById(java.lang.Long)
	 */
	@Override
	public Position findPositionById(Long id) {
		Map<String, Object> attrs = new HashMap<>();
		attrs.put("isDel", "0");
		attrs.put("id", id);
		return positionDao.query(Position.class, attrs);
	}


}