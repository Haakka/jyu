package com.crm.service.news;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.crm.bases.BaseManagerDaoImpl;
import com.crm.entity.News;
import com.crm.entity.Users;
import com.crm.vo.ResultVo;
import com.modules.commons.CommonReturn;
import com.modules.commons.Pager;
import com.modules.util.ObjValid;
import com.modules.util.Sha256;
import com.modules.util.StringUtil;

public class NewsServiceImpl extends BaseManagerDaoImpl implements NewsService {

	/*
	 * 添加
	 * @see com.crm.service.news.NewsService#addNews(com.crm.entity.News, java.lang.Long)
	 */
	@Override
	public ResultVo addNews(News news, Users user) {
		if (ObjValid.isNotValid(news)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_DATA_EXCEPT,null);
		}
		if (StringUtil.isBlank(news.getTitle()) || StringUtil.isBlank(news.getContent()) 
			|| ObjValid.isNotValid(news.getSort())) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_DATA_MISSING,null);
		}
		if (ObjValid.isNotValid(user)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_SESSIONKEY_POPUP,null);
		}
		news.setAuthor(user);
		news.setAddTime(new Date());
		news.setIsDel("0");
		news.setView(0);
		news.setToken(Sha256.SHA256(news.getTitle()+news.getAddTime().toString())+CommonReturn.SIGN_KEY);
		newsDao.save(news);
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_ADD_SUCCESS,null);
	}

	/*
	 * 修改
	 * @see com.crm.service.news.NewsService#modifyNews(com.crm.entity.News)
	 */
	@Override
	public ResultVo modifyNews(News news) {
		if (ObjValid.isNotValid(news)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_DATA_EXCEPT,null);
		}
		if (StringUtil.isBlank(news.getTitle()) || StringUtil.isBlank(news.getContent()) || ObjValid.isNotValid(news.getSort())) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_DATA_MISSING,null);
		}
		Map<String, Object> attrs = new HashMap<>();
		attrs.put("id", news.getId());
		attrs.put("token", news.getToken());
		News obj = newsDao.query(News.class, attrs);
		if (ObjValid.isNotValid(obj)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_OBJ_NOEXIST_ERROR,null);
		}
		obj.setTitle(news.getTitle());
		obj.setContent(news.getContent());
		obj.setSort(news.getSort());
		newsDao.update(obj);
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_UPDATE_SUCCESS,null);
	}

	/*
	 * 删除
	 * @see com.crm.service.news.NewsService#removeNews(java.lang.Long, java.lang.String)
	 */
	@Override
	public ResultVo removeNews(Long id, String token) {
		if (ObjValid.isNotValid(id) || StringUtil.isBlank(token)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_DATA_MISSING,null);
		}
		Map<String, Object> attrs = new HashMap<>();
		attrs.put("id", id);
		attrs.put("token", token);
		News news = newsDao.query(News.class, attrs);
		if (ObjValid.isNotValid(news)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_OBJ_NOEXIST_ERROR,null);
		}
		news.setIsDel("1");
		news.setDeleteTime(new Date());
		newsDao.update(news);
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_DELETE_SUCCESS,null);
	}

	/*
	 * 查询
	 * @see com.crm.service.news.NewsService#retrieveNews(java.lang.Long, java.lang.String)
	 */
	@Override
	public ResultVo retrieveNews(Long id, String token) {
		if (ObjValid.isNotValid(id) || StringUtil.isBlank(token)) {
			return new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_DATA_MISSING,null);
		}
		Map<String, Object> attrs = new HashMap<>();
		attrs.put("id", id);
		attrs.put("token", token);
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_FIND_SUCCESS,newsDao.query(News.class, attrs));
	}

	/*
	 * 查询所有
	 * List
	 * @see com.crm.service.news.NewsService#retrieveAllNewss()
	 */
	@Override
	public ResultVo retrieveAllNewss() {
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_FIND_SUCCESS,newsDao.queryList(News.class,"addTime", "desc", null));
	}

	/*
	 * 分页查询
	 * @see com.crm.service.news.NewsService#retrieveNewssPager(int, int)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public ResultVo retrieveNewssPager(int pageSize, int pageNo) {
		Map<String, Object> attrs = new HashMap<>();
		attrs.put("isDel", "0");
		Pager pager = new Pager(pageSize, pageNo,Integer.parseInt(String.valueOf(newsDao.queryTotalRecord(News.class, attrs))),
				newsDao.queryList(News.class, (pageNo - 1) * pageSize, pageSize,"addTime", "desc", attrs));
		return new ResultVo(CommonReturn.SUCCESS_CODE_200,CommonReturn.MSG_FIND_SUCCESS,pager);
	}


}