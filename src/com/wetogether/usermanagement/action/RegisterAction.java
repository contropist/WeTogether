package com.wetogether.usermanagement.action;

import com.opensymphony.xwork2.ActionSupport;
import com.wetogether.common.hibernate.pojos.User;
import com.wetogether.common.util.registerState.RegisterStates;
import com.wetogether.usermanagement.service.IUserService;

public class RegisterAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user;
	private IUserService userServices;

	public String register() {
		int flag = userServices.addNewUser(user);
		if (flag == RegisterStates.USER_EXISTED) {
			System.out.println("UserName has existed");
			return INPUT;
		} else {
			return SUCCESS;
		}
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
