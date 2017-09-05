package com.crm.service.cusman;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.crm.bases.BaseManagerDaoImpl;
import com.crm.entity.Consumer;
import com.crm.entity.Follow;
import com.crm.entity.SysParam;
import com.crm.entity.Users;
import com.crm.vo.ResultVo;
import com.modules.commons.CommonReturn;
import com.modules.commons.Pager;
import com.modules.util.ObjValid;
import com.modules.util.Sha256;
import com.modules.util.StringUtil;

public class FollowServiceImpl extends BaseManagerDaoImpl implements FollowService {

	/*
	 * 添加
	 * @see com.crm.service.cusman.FollowService#addFollow(com.crm.entity.Follow)
	 */
	@Override
	public ResultVo addFollow(Follow follow,Users users,Long consumerId,Long typeId) {
		if (ObjValid.isNotValid(follow)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_DATA_EXCEPT,null);
		}
		if (StringUtil.isBlank(follow.getContent()) || ObjValid.isNotValid(consumerId) 
			|| ObjValid.isNotValid(typeId) || ObjValid.isNotValid(follow.getFollowTime())) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_DATA_MISSING,null);
		}
		if (ObjValid.isNotValid(users)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_SESSIONKEY_POPUP,null);
		}
		Map<String, Object> attrs = new HashMap<>();
		attrs.put("id", consumerId);
		Consumer consumer = followDao.query(Consumer.class, attrs);
		if (ObjValid.isNotValid(consumer)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_OBJ_NOEXIST_ERROR,null);
		}
		attrs.clear();
		attrs.put("id", typeId);
		SysParam type = followDao.query(SysParam.class, attrs);
		if (ObjValid.isNotValid(type)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_OBJ_NOEXIST_ERROR,null);
		}
		follow.setIsDel("0");
		follow.setFollower(users);
		follow.setConsumerId(consumer);
		follow.setType(type);
		follow.setAddTime(new Date());
		follow.setToken(Sha256.SHA256((new Date().toString())+String.valueOf(consumerId)+String.valueOf(typeId)+CommonReturn.SIGN_KEY));
		followDao.save(follow);
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_ADD_SUCCESS,null);
	}

	/*
	 * 更新
	 * @see com.crm.service.cusman.FollowService#modifyFollow(com.crm.entity.Follow)
	 */
	@Override
	public ResultVo modifyFollow(Follow follow,Long typeId) {
		if (ObjValid.isNotValid(follow)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_DATA_EXCEPT,null);
		}
		if (StringUtil.isBlank(follow.getContent()) || ObjValid.isNotValid(typeId) || ObjValid.isNotValid(follow.getFollowTime())) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_DATA_MISSING,null);
		}
		Map<String, Object> attrs = new HashMap<>();
		attrs.put("id", typeId);
		SysParam type = followDao.query(SysParam.class, attrs);
		if (ObjValid.isNotValid(type)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_OBJ_NOEXIST_ERROR,null);
		}
		attrs.clear();
		attrs.put("id", follow.getId());
		attrs.put("token", follow.getToken());
		Follow obj = followDao.query(Follow.class, attrs);
		if (ObjValid.isNotValid(obj)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_OBJ_NOEXIST_ERROR,null);
		}
		obj.setFollowTime(follow.getFollowTime());
		obj.setContent(follow.getContent());
		obj.setType(type);
		obj.setUpdateTime(new Date());
		followDao.update(obj);
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_UPDATE_SUCCESS,null);
	}

	/*
	 * 删除
	 * @see com.crm.service.cusman.FollowService#removeFollow(java.lang.Long, java.lang.String)
	 */
	@Override
	public ResultVo removeFollow(Long id, String token) {
		if (ObjValid.isNotValid(id) || StringUtil.isBlank(token)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_DATA_MISSING,null);
		}
		Map<String, Object> attrs = new HashMap<>();
		attrs.put("id", id);
		attrs.put("token", token);
		Follow follow = followDao.query(Follow.class, attrs);
		if (ObjValid.isNotValid(follow)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_OBJ_NOEXIST_ERROR,null);
		}
		follow.setIsDel("1");
		consumerDao.update(follow);
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_DELETE_SUCCESS,null);
	}

	/*
	 * 根据Id和Token查询
	 * @see com.crm.service.cusman.FollowService#retrieveFollow(java.lang.Long, java.lang.String)
	 */
	@Override
	public ResultVo retrieveFollow(Long id, String token) {
		if (ObjValid.isNotValid(id) || StringUtil.isBlank(token)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_DATA_MISSING,null);
		}
		Map<String, Object> attrs = new HashMap<>();
		attrs.put("id", id);
		attrs.put("token", token);
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_FIND_SUCCESS,followDao.query(Follow.class, attrs));
	}

	/*
	 * 查询所有
	 * List
	 * @see com.crm.service.cusman.FollowService#retrieveAllFollows()
	 */
	@Override
	public ResultVo retrieveAllFollows() {
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_FIND_SUCCESS,followDao.queryList(Follow.class,"addTime", "desc", null));
	}

	/*
	 * 分页查询
	 * @see com.crm.service.cusman.FollowService#retrieveFollowsPager(int, int, java.lang.Long)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public ResultVo retrieveFollowsPager(int pageSize, int pageNo, Long userId,String keyWord) {
		Map<String, Object> attrs = new HashMap<>();
		attrs.put("follower.id", userId);
		attrs.put("isDel", "0");
		Pager pager = new Pager(pageSize, pageNo,Integer.parseInt(String.valueOf(followDao.queryTotalRecord(Follow.class, attrs))),
				followDao.queryList(Follow.class, (pageNo - 1) * pageSize, pageSize,"addTime", "desc", attrs));
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_FIND_SUCCESS,followDao.retrieveFollowsPager(pageSize, pageNo, userId, keyWord));
	}

	/*
	 * 统计今日新增记录
	 * @see com.crm.service.cusman.FollowService#countTodayNewFollow(java.lang.Long)
	 */
	@Override
	public int countTodayNewFollow(Long id) {
		return followDao.countTodayNewFollow(id);
	}


}