package com.wetogether.login.service.impl;

import com.wetogether.allDaos.IAllDaos;
import com.wetogether.common.hibernate.pojos.User;
import com.wetogether.common.util.loginStatus.LoginStatus;
import com.wetogether.login.dto.LoginBean;
import com.wetogether.login.service.ILoginService;

public class LoginServicesImpl implements ILoginService {
	private IAllDaos allDaos;

	@Override
	public Integer findUserByUserName(LoginBean bean) {
		User user = allDaos.selectUserByUserName(bean.getUserName());
		if(user==null){
			return LoginStatus.NULL_USERNAME;
		}
		
		if(!user.getPassword().equals(bean.getPassword())){
			return LoginStatus.WRONG_PASSWORD;
		}
		
		bean.setUser(user);
		return LoginStatus.LOGIN_SUCCESS;
	}

	public IAllDaos getAllDaos() {
		return allDaos;
	}

	public void setAllDaos(IAllDaos allDaos) {
		this.allDaos = allDaos;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
