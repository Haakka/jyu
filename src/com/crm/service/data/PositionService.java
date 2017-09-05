package com.crm.service.data;

import com.crm.entity.Position;
import com.crm.vo.ResultVo;

public interface PositionService {

	/**
	 * 添加
	 * @param position
	 * @param departmentId
	 * @return
	 */
	public ResultVo addPosition(Position position,Long departmentId);
	
	/**
	 * 编辑
	 * @param position
	 * @param departmentId
	 * @return
	 */
	public ResultVo modifyPosition(Position position);
	
	/**
	 * 删除
	 * @param id
	 * @param token
	 * @return
	 */
	public ResultVo removePosition(Long id,String token);
	
	/**
	 * 根据Id和Token查询
	 * @param id
	 * @param token
	 * @return
	 */
	public ResultVo retrievePosition(Long id,String token);
	
	/**
	 * 根据Id查询
	 * @param id
	 * @return
	 */
	public Position findPositionById(Long id);
	
	/**
	 * 查询所有
	 * List
	 * @return
	 */
	public ResultVo retrieveAllPositions();
	
	/**
	 * 分页查询
	 * @param pageSize
	 * @param pageNo
	 * @param departmentId
	 * @return
	 */
	public ResultVo retrievePositionsPager(int pageSize, int pageNo,Long departmentId,String token,String keyWord);
	
}