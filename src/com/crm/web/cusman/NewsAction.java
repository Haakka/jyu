package com.crm.web.cusman;

import java.util.List;

import com.crm.entity.News;
import com.crm.entity.Users;
import com.crm.vo.ResultVo;
import com.modules.commons.CommonReturn;
import com.modules.commons.GetUsersInfo;
import com.modules.commons.PageAction;

public class NewsAction extends PageAction {
	
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String token;
	
	private News news;
	
	private List<News> newss;
	
	public String retrieveAllNewss() throws Exception {
		try {
			newsService.retrieveNewssPager(pageSize, pageNo);
		} catch (Exception ex) {
			resultVo = new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_EXCEPTION_POPUP,null);
			ex.printStackTrace();
		}
		return "success";
	}
	
	public String retrieveNewsById() throws Exception {
		try {
			newsService.retrieveNews(id,token);
		} catch (Exception ex) {
			resultVo = new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_EXCEPTION_POPUP,null);
			ex.printStackTrace();
		}
		return "editPage";
	}

	public String newPage() throws Exception {
		return "newPage";
	}
	
	public String viewPage() throws Exception {
		try {
			newsService.retrieveNews(id,token);
		} catch (Exception ex) {
			resultVo = new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_EXCEPTION_POPUP,null);
			ex.printStackTrace();
		}
		return "viewPage";
	}
	
	public String newNews() throws Exception {
		try {
			Users user = GetUsersInfo.getUsers();
			newsService.addNews(news,user);
		} catch (Exception ex) {
			resultVo = new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_EXCEPTION_POPUP,null);
			ex.printStackTrace();
		}
		return "edit_success";
	}
	
	public String editNews() throws Exception {
		try {
			newsService.modifyNews(news);
		} catch (Exception ex) {
			resultVo = new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_EXCEPTION_POPUP,null);
			ex.printStackTrace();
		}
		return "edit_success";
	}
	
	public String delNews() throws Exception {
		try {
			newsService.removeNews(id,token);
		} catch (Exception ex) {
			resultVo = new ResultVo(CommonReturn.ERROR_CODE_FAIL_400,CommonReturn.MSG_EXCEPTION_POPUP,null);
			ex.printStackTrace();
		}
		return "edit_success";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public News getNews() {
		return news;
	}

	public void setNews(News news) {
		this.news = news;
	}

	public List<News> getNewss() {
		return newss;
	}

	public void setNewss(
			List<News> newss) {
		this.newss = newss;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}