package com.wetogether.allDaos;

import java.util.List;

import com.wetogether.common.hibernate.pojos.User;

public interface IAllDaos {
	public User selectUserByUserName(String name);
	public List<User> selectAllUserByID(Integer id);
	public List<User> selectUserByParam(String param);
}
