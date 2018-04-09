package com.wetogether.otherspace.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.wetogether.common.hibernate.pojos.User;
import com.wetogether.common.util.CodeCst;
import com.wetogether.otherspace.service.IOtherPageService;
import com.wetogether.personalCenter.dto.ArticleVOs;
import com.wetogether.personalCenter.service.IPersonalCenterServices;
import com.wetogether.usermanagement.service.IUserService;

public class ToHisDaliyRecordPage extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private IOtherPageService opService;
	private IUserService userServices;
	private Integer userId;
	private User user;
	private IPersonalCenterServices iPersonalCenterServices;
	
	//定义ArticleVOs对象
	private ArticleVOs articleVOs;
	
	//获得request对象
	private HttpServletRequest request = ServletActionContext.getRequest();
	// 定义response输出流对象
	private PrintWriter pw;
	// 定义JSON对象
	private Gson gson = new GsonBuilder().create();
	//获得请求类型，普通方式还是ajax方式
	private String requestType;
	
	public String getAllDaliyRecords() throws IOException{
		this.user = userServices.findUserById(userId);
		//为了避免空指针，当发出没有参数的请求时返回类型为1的第一页的文章
				if(articleVOs==null){
					articleVOs = new ArticleVOs();
					articleVOs.setCateroryId(1);
					articleVOs.getPage().setCurrentPage(1);
				}
				articleVOs.setCurrentUser(user);
				articleVOs = iPersonalCenterServices.FindAllArticle(articleVOs);
				request.setAttribute("articleVOs", articleVOs);
				//普通方式
				if(requestType==null){
					
					return SUCCESS;
				}else{//ajax方式
					pw = ServletActionContext.getResponse().getWriter();
					String vo = gson.toJson(articleVOs);
					System.out.println("VO:"+vo);
					pw.write(vo);
					pw.close();
					return SUCCESS;
				}
	}

	public IOtherPageService getOpService() {
		return opService;
	}

	public void setOpService(IOtherPageService opService) {
		this.opService = opService;
	}

	public IUserService getUserServices() {
		return userServices;
	}

	public void setUserServices(IUserService userServices) {
		this.userServices = userServices;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public IPersonalCenterServices getiPersonalCenterServices() {
		return iPersonalCenterServices;
	}

	public void setiPersonalCenterServices(
			IPersonalCenterServices iPersonalCenterServices) {
		this.iPersonalCenterServices = iPersonalCenterServices;
	}

	public ArticleVOs getArticleVOs() {
		return articleVOs;
	}

	public void setArticleVOs(ArticleVOs articleVOs) {
		this.articleVOs = articleVOs;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public PrintWriter getPw() {
		return pw;
	}

	public void setPw(PrintWriter pw) {
		this.pw = pw;
	}

	public Gson getGson() {
		return gson;
	}

	public void setGson(Gson gson) {
		this.gson = gson;
	}

	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}
	
	
	
	
}
