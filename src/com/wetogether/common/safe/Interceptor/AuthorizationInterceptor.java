package com.wetogether.common.safe.Interceptor;

import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.wetogether.common.hibernate.pojos.User;
import com.wetogether.common.util.CodeCst;

public class AuthorizationInterceptor extends AbstractInterceptor{
	private static final long serialVersionUID = 1L;
	
	
	//权限控制拦截器
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		Map session = invocation.getInvocationContext().getSession();
		User sessionUser = (User) session.get(CodeCst.SESSION_USER_NAME);
		
		if(null!=sessionUser){
			System.out.println("用户已经登陆");
			return invocation.invoke();
		}else{
			System.out.println("用户尚未登录，请先登录");
			ServletActionContext.getRequest().setAttribute("loginStatus", "非法操作，请先登录！");
			return Action.LOGIN;
		}
		
	}

}
