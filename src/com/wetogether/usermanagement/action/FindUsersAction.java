package com.wetogether.usermanagement.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.wetogether.common.hibernate.pojos.User;
import com.wetogether.common.util.CodeCst;
import com.wetogether.usermanagement.service.IUserService;

public class FindUsersAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private IUserService userServices;
	private User user;
	private HttpServletRequest request ;
	private String searchType;
	private  User sessionUser = (User)	ActionContext.getContext().getSession().get(CodeCst.SESSION_USER_NAME);
//	查找好友，用于添加好友
	public String findUsers(){
		List<User> users = this.userServices.findUsers(user);
		for(int i = 0;i<users.size();i++){
			User u = users.get(i);
			if(u.getUserId()==sessionUser.getUserId()){
				users.remove(i);
				break;
			}
		}
		request = ServletActionContext.getRequest();
		request.setAttribute("users", users);
		request.setAttribute("searchType", searchType);
		return SUCCESS;
	}

	public IUserService getUserServices() {
		return userServices;
	}

	public void setUserServices(IUserService userServices) {
		this.userServices = userServices;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	
	
}
