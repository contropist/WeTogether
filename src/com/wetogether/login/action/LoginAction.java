package com.wetogether.login.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.wetogether.common.hibernate.pojos.User;
import com.wetogether.common.util.CodeCst;
import com.wetogether.common.util.loginStatus.LoginStatus;
import com.wetogether.login.dto.LoginBean;
import com.wetogether.login.service.ILoginService;

public class LoginAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ILoginService loginServices;
	private LoginBean loginBean;
	
	
	public String login(){
		Integer flag = loginServices.findUserByUserName(loginBean);
		if(flag==LoginStatus.NULL_USERNAME){
			addActionMessage("用户名不存在");
			return INPUT;
		}
		
		if(flag==LoginStatus.WRONG_PASSWORD){
			addActionMessage("密码错误");
			return INPUT;
		}
		User currentUser = loginBean.getUser();
		ActionContext.getContext().getSession().put(CodeCst.SESSION_USER_NAME, currentUser);
		ActionContext.getContext().getApplication().put(currentUser.getUserId().toString(), currentUser);

		return SUCCESS;
	}
	
	public ILoginService getLoginServices() {
		return loginServices;
	}
	public void setLoginServices(ILoginService loginServices) {
		this.loginServices = loginServices;
	}
	public LoginBean getLoginBean() {
		return loginBean;
	}
	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

	
	
	
	
}
