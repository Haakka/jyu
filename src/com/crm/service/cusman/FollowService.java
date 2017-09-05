package com.crm.service.cusman;

import com.crm.entity.Follow;
import com.crm.entity.Users;
import com.crm.vo.ResultVo;

public interface FollowService {

	/**
	 * 添加
	 * @param follow
	 * @return
	 */
	public ResultVo addFollow(Follow follow,Users users,Long consumerId,Long typeId);
	
	/**
	 * 修改
	 * @param follow
	 * @return
	 */
	public ResultVo modifyFollow(Follow follow,Long typeId);
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	public ResultVo removeFollow(Long id,String token);
	
	/**
	 * 根据Id和Token查询
	 * @param id
	 * @return
	 */
	public ResultVo retrieveFollow(Long id,String token);
	
	/**
	 * 查询所有
	 * List
	 * @return
	 */
	public ResultVo retrieveAllFollows();
	
	/**
	 * 分页查询
	 * @param pageSize
	 * @param pageNo
	 * @return
	 */
	public ResultVo retrieveFollowsPager(int pageSize, int pageNo,Long userId,String keyWord);
	
	/**
	 * 统计今日新增记录
	 * @param id
	 * @return
	 */
	public int countTodayNewFollow(Long id);
	
}