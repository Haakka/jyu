package com.crm.service.news;

import com.crm.entity.News;
import com.crm.entity.Users;
import com.crm.vo.ResultVo;

public interface NewsService {

	/**
	 * 添加
	 * @param news
	 * @param userId
	 * @return
	 */
	public ResultVo addNews(News news,Users user);
	
	/**
	 * 修改
	 * @param news
	 * @return
	 */
	public ResultVo modifyNews(News news);
	
	/**
	 * 删除
	 * @param id
	 * @param token
	 * @return
	 */
	public ResultVo removeNews(Long id,String token);
	
	/**
	 * 根据Id和Token获取
	 * @param id
	 * @param token
	 * @return
	 */
	public ResultVo retrieveNews(Long id,String token);
	
	/**
	 * 查询所有
	 * List
	 * @return
	 */
	public ResultVo retrieveAllNewss();
	
	/**
	 * 分页查询
	 * @param pageSize
	 * @param pageNo
	 * @return
	 */
	public ResultVo retrieveNewssPager(int pageSize, int pageNo);
	
}