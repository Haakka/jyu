package com.crm.web.cusman;

import java.util.List;

import com.crm.entity.SysParam;
import com.crm.entity.SysParamType;
import com.crm.vo.ResultVo;
import com.modules.commons.CommonReturn;
import com.modules.commons.PageAction;
import com.modules.commons.Pager;
import com.modules.util.ObjValid;

import net.sf.json.JSONObject;

public class SysParamAction extends PageAction{

	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String token;
	
	private String name;
	
	private SysParam sysParam;
	
	private List<SysParam> sysParams;
	
	private Long superId;

	
	/**
	 * 查询所有系统参数 分页
	 * @return
	 * @throws Exception
	 */
	public String retrieveAllSysParams() throws Exception {
		try {
			resultVo = sysParamService.retrieveSysParamsPager(pageSize, pageNo);
			pager = (Pager) resultVo.getResult();
		} catch (Exception ex) {
			resultVo = new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_EXCEPTION_POPUP,null);
			ex.printStackTrace();
		}
		return "success";
	}
	
	/**
	 * 根据参数类型Id查询参数类型
	 * @return
	 */
	public String findAllByTypeId(){
		try {
			resultVo = sysParamService.findPagerByTypeId(pageSize,pageNo,id,token);
			pager = (Pager) resultVo.getResult();
		} catch (Exception ex) {
			resultVo = new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_EXCEPTION_POPUP,null);
			ex.printStackTrace();
		}
		return "success";
	}
	
	/**
	 * 跳转编辑系统参数
	 * @return
	 * @throws Exception
	 */
	public String retrieveSysParamById() throws Exception {
		try {
			resultVo = sysParamService.retrieveSysParam(id,token);
			if (ObjValid.isValid(resultVo.getResult())) {
				sysParam = (SysParam) resultVo.getResult();
			}
		} catch (Exception ex) {
			resultVo = new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_EXCEPTION_POPUP,null);
			ex.printStackTrace();
		}
		return "editPage";
	}

	/**
	 * 跳转添加页面
	 * @return
	 * @throws Exception
	 */
	public String newPage() throws Exception {
		return "newPage";
	}
	
	/**
	 * 添加系统参数
	 * @return
	 * @throws Exception
	 */
	public String newSysParam() throws Exception {
		try {
			resultVo = sysParamService.addSysParam(id,token,sysParam);
		} catch (Exception ex) {
			resultVo = new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_EXCEPTION_POPUP,null);
			ex.printStackTrace();
		}
		JSONObject json = JSONObject.fromObject(resultVo);
		return renderText(json == null ? null : json.toString());
	}
	
	/**
	 * 编辑系统参数
	 * @return
	 * @throws Exception
	 */
	public String editSysParam() throws Exception {
		try {
			resultVo = sysParamService.modifySysParam(sysParam);
			if (resultVo.getCode()==200) {
				SysParamType sysParamType = (SysParamType) resultVo.getResult();
				this.id = sysParamType.getId();
				this.token = sysParamType.getToken();
			}
		} catch (Exception ex) {
			resultVo = new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_EXCEPTION_POPUP,null);
			ex.printStackTrace();
		}
		JSONObject json = JSONObject.fromObject(resultVo);
		return renderText(json == null ? null : json.toString());
	}
	
	/**
	 * 删除系统参数
	 * @return
	 * @throws Exception
	 */
	public String delSysParam() throws Exception {
		try {
			resultVo = sysParamService.removeSysParam(id,token);
		} catch (Exception ex) {
			resultVo = new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_EXCEPTION_POPUP,null);
			ex.printStackTrace();
		}
		JSONObject json = JSONObject.fromObject(resultVo);
		return renderText(json == null ? null : json.toString());
	}
	
	/**
	 * 检查名称是否存在
	 * @return
	 */
	public String isUniqueName(){
		Boolean result = true;
		try {
			if (null != name) {
				resultVo = sysParamService.findUniqueName(name);
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

	public SysParam getSysParam() {
		return sysParam;
	}

	public void setSysParam(SysParam sysParam) {
		this.sysParam = sysParam;
	}

	public List<SysParam> getSysParams() {
		return sysParams;
	}

	public void setSysParams(
			List<SysParam> sysParams) {
		this.sysParams = sysParams;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Long getSuperId() {
		return superId;
	}

	public void setSuperId(Long superId) {
		this.superId = superId;
	}

	
	
}
