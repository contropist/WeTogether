package com.wetogether.check.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.wetogether.common.hibernate.pojos.User;
import com.wetogether.usermanagement.service.IUserService;

public class CheckUserName extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private IUserService userServices;

	
	//register name check
	public void checkUsername() {
		String message = "";
		HttpServletRequest req = ServletActionContext.getRequest();
		HttpServletResponse res = ServletActionContext.getResponse();
		User flag = userServices.selectUserByName(username);
		
		

		if (flag!=null) {
			message = "faile";
		} else {
			message = "ok";
		}

		try {
			PrintWriter p = res.getWriter();
			p.print(message);
			p.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void test1() {
		System.out.println("check");
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public IUserService getUserServices() {
		return userServices;
	}

	public void setUserServices(IUserService userServices) {
		this.userServices = userServices;
	}
	
	

}
