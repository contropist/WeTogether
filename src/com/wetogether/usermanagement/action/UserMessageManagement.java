package com.wetogether.usermanagement.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.wetogether.common.hibernate.pojos.User;
import com.wetogether.common.util.CodeCst;
import com.wetogether.usermanagement.service.IUserService;

public class UserMessageManagement extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private IUserService userServices;
	private User user;
	private HttpServletRequest request = ServletActionContext.getRequest();

	public String showMyMessage() {
	User sessionuser = (User) ActionContext.getContext().getSession()
				.get(CodeCst.SESSION_USER_NAME);
	user = userServices.selectUserByName(sessionuser.getUserName());
		request.setAttribute("user", user);
		return SUCCESS;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public IUserService getUserServices() {
		return userServices;
	}

	public void setUserServices(IUserService userServices) {
		this.userServices = userServices;
	}

}
