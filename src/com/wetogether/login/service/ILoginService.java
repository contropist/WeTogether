package com.wetogether.login.service;

import com.wetogether.login.dto.LoginBean;

public interface ILoginService {
	public Integer findUserByUserName(LoginBean bean);

}
