package com.crm.web.cusman;

import java.util.List;

import com.crm.entity.Consumer;
import com.crm.entity.Follow;
import com.crm.entity.SysParam;
import com.crm.entity.Users;
import com.crm.vo.ResultVo;
import com.modules.commons.CommonReturn;
import com.modules.commons.GetUsersInfo;
import com.modules.commons.PageAction;
import com.modules.commons.Pager;
import com.modules.util.ObjValid;

import net.sf.json.JSONObject;

public class FollowAction extends PageAction {
	
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String token;
	
	private Follow follow;
	
	private Long consumerId;
	
	private Long typeId;
	
	private List<Follow> follows;
	private List<Consumer> consumers;
	private List<SysParam> types;
	
	
	/**
	 * 分页查询
	 * @return
	 * @throws Exception
	 */
	public String retrieveAllFollows() throws Exception {
		try {
			Users user = GetUsersInfo.getUsers();
			resultVo = followService.retrieveFollowsPager(pageSize, pageNo,user.getId(),keyWord);
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
	public String retrieveFollowById() throws Exception {
		try {
			init();
			resultVo = followService.retrieveFollow(id,token);
			if (ObjValid.isValid(resultVo.getResult())) {
				follow = (Follow) resultVo.getResult();
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
			resultVo = followService.retrieveFollow(id,token);
			if (ObjValid.isValid(resultVo.getResult())) {
				follow = (Follow) resultVo.getResult();
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
	public String newFollow() throws Exception {
		try {
			Users user = GetUsersInfo.getUsers();
			resultVo = followService.addFollow(follow,user,consumerId,typeId);
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
	public String editFollow() throws Exception {
		try {
			init();
			resultVo = followService.modifyFollow(follow,typeId);
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
	public String delFollow() throws Exception {
		try {
			resultVo = followService.removeFollow(id,token);
		} catch (Exception ex) {
			resultVo = new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_EXCEPTION_POPUP,null);
			ex.printStackTrace();
		}
		JSONObject json = JSONObject.fromObject(resultVo);
		return renderText(json == null ? null : json.toString());
	}
	
	@SuppressWarnings("unchecked")
	private void init(){
		Users users = GetUsersInfo.getUsers();
		this.consumers = (List<Consumer>) consumerService.retrieveAllConsumers(users.getId()).getResult();
		this.types = (List<SysParam>) sysParamService.findByTypeId(15L).getResult();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Follow getFollow() {
		return follow;
	}

	public void setFollow(Follow follow) {
		this.follow = follow;
	}

	public List<Follow> getFollows() {
		return follows;
	}

	public void setFollows(
			List<Follow> follows) {
		this.follows = follows;
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

	public Long getTypeId() {
		return typeId;
	}

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}

	public List<Consumer> getConsumers() {
		return consumers;
	}

	public void setConsumers(List<Consumer> consumers) {
		this.consumers = consumers;
	}

	public List<SysParam> getTypes() {
		return types;
	}

	public void setTypes(List<SysParam> types) {
		this.types = types;
	}


	
}