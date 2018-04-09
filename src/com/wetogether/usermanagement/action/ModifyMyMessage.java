package com.wetogether.usermanagement.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.wetogether.common.hibernate.pojos.User;
import com.wetogether.usermanagement.service.IUserService;

public class ModifyMyMessage extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IUserService userServices;
	private HttpServletRequest request =ServletActionContext.getRequest();
	private User user ;
	
	
	public String modifyMessage(){
		this.user = userServices.updateUser(user);
		request.setAttribute("user", user);
		request.setAttribute("message", "信息修改成功  ∩_∩");
		return SUCCESS;
	}


	public IUserService getUserServices() {
		return userServices;
	}


	public void setUserServices(IUserService userServices) {
		this.userServices = userServices;
	}


	public HttpServletRequest getRequest() {
		return request;
	}


	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}
