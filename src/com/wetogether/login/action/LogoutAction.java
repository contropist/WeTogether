package com.wetogether.login.action;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.wetogether.common.hibernate.pojos.User;
import com.wetogether.common.util.CodeCst;

public class LogoutAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private User sessionUser = (User)ActionContext.getContext().getSession().get(CodeCst.SESSION_USER_NAME);
	public String logout(){
		if(sessionUser!=null){
			ActionContext.getContext().getSession().remove(CodeCst.SESSION_USER_NAME);
			ActionContext.getContext().getApplication().remove(sessionUser.getUserId());
		}
		
		return SUCCESS;
	}
}
