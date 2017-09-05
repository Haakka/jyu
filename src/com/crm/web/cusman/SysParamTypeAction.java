package com.crm.web.cusman;

import java.io.UnsupportedEncodingException;
import java.util.List;

import com.crm.entity.SysParamType;
import com.crm.vo.ResultVo;
import com.modules.commons.CommonReturn;
import com.modules.commons.PageAction;
import com.modules.commons.Pager;

import net.sf.json.JSONObject;

public class SysParamTypeAction extends PageAction {
	
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String token;
	
	private String name;
	
	private SysParamType sysParamType;
	
	private List<SysParamType> sysParamTypes;
	
	/**
	 * 查询所有参数类型
	 * @return
	 * @throws Exception
	 */
	public String retrieveAllSysParamTypes() throws Exception {
		try {
			resultVo = sysParamTypeService.retrieveSysParamTypesPager(pageSize,pageNo);
			pager = (Pager) resultVo.getResult();
		} catch (Exception ex) {
			resultVo = new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_EXCEPTION_POPUP,null);
			ex.printStackTrace();
		}
		return "success";
	}
	
	/**
	 * 跳转修改参数类型
	 * @return
	 * @throws Exception
	 */
	public String retrieveSysParamTypeById() throws Exception {
		try {
			resultVo = sysParamTypeService.retrieveSysParamType(id,token);
			if (null != resultVo.getResult()) {
				sysParamType = (SysParamType) resultVo.getResult();
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
		return "newPage";
	}
	
	/**
	 * 添加参数类型
	 * @return
	 * @throws Exception
	 */
	public String newSysParamType() throws Exception {
		try {
			resultVo = sysParamTypeService.addSysParamType(sysParamType);
		} catch (Exception ex) {
			resultVo = new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_EXCEPTION_POPUP,null);
			ex.printStackTrace();
		}
		JSONObject json = JSONObject.fromObject(resultVo);
		return renderText(json == null ? null : json.toString());
	}
	
	/**
	 * 修改参数类型
	 * @return
	 * @throws Exception
	 */
	public String editSysParamType() throws Exception {
		try {
			resultVo = sysParamTypeService.modifySysParamType(sysParamType);
		} catch (Exception ex) {
			resultVo = new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_EXCEPTION_POPUP,null);
			ex.printStackTrace();
		}
		JSONObject json = JSONObject.fromObject(resultVo);
		return renderText(json == null ? null : json.toString());
	}
	
	/**
	 * 删除参数类型
	 * @return
	 * @throws Exception
	 */
	public String delSysParamType() throws Exception {
		try {
			resultVo = sysParamTypeService.removeSysParamType(id,token);
		} catch (Exception ex) {
			resultVo = new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_EXCEPTION_POPUP,null);
			ex.printStackTrace();
		}
		JSONObject json = JSONObject.fromObject(resultVo);
		return renderText(json == null ? null : json.toString());
	}
	
	/**
	 * 名称是否唯一
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public String isUniqueName() throws UnsupportedEncodingException{
		Boolean result = true;
		try {
			if (null != name) {
				resultVo = sysParamTypeService.findUniqueName(name);
				result = (Boolean) resultVo.getResult();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (result)
			return renderText("true");
		else
			return renderText("false");
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public SysParamType getSysParamType() {
		return sysParamType;
	}

	public void setSysParamType(SysParamType sysParamType) {
		this.sysParamType = sysParamType;
	}

	public List<SysParamType> getSysParamTypes() {
		return sysParamTypes;
	}

	public void setSysParamTypes(
			List<SysParamType> sysParamTypes) {
		this.sysParamTypes = sysParamTypes;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}