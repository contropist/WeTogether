package com.wetogether.usermanagement.service;

import java.util.List;
import java.util.Map;

import com.wetogether.common.hibernate.pojos.University;
import com.wetogether.common.hibernate.pojos.User;

public interface IUserService {
	public int addNewUser(User user);
	public User selectUserByName(String name);
	public List<University> getAllUniversity();
	public Map<Integer,String> getAllCollege(University uni);
	public User updateUser(User user);
	
	//条件查询好友
	public List<User> findUsers(User user);
	
	//添加好友
	public void addFriends(List<Integer> userIds,User currentUser);
	//主键查用户
	public User findUserById(Integer id);
	
}