package com.wetogether.usermanagement.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.wetogether.common.hibernate.pojos.User;
import com.wetogether.usermanagement.dto.UserBean;
import com.wetogether.usermanagement.service.IUserService;

public class FindSingleUser extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private IUserService userServices;
	private Integer userId;
	private HttpServletRequest request;
	private User u  ;
	public String findSingleUser(){
		UserBean user = new UserBean();
		u = this.userServices.findUserById(userId);
		user.setAll(u);
		request = ServletActionContext.getRequest();
		request.setAttribute("user", user);
		return SUCCESS;
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
	public HttpServletRequest getRequest() {
		return request;
	}
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	public User getU() {
		return u;
	}
	public void setU(User u) {
		this.u = u;
	}
	
	
}
