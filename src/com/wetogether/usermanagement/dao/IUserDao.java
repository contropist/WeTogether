package com.wetogether.usermanagement.dao;

import java.util.List;

import com.wetogether.common.hibernate.pojos.College;
import com.wetogether.common.hibernate.pojos.Friend;
import com.wetogether.common.hibernate.pojos.University;
import com.wetogether.common.hibernate.pojos.User;

public interface IUserDao {
	public int addNewUser(User user);
	public User selectUserByUserName(String name);
	public List<University> getAllUniversity();
	public List<College> getAllCollegeOfCurrentUni(University uni);
	public User updateMyMessage(User user);
	//主键查询好友
	public User findUserById(Integer userId);
	//查询好友
	public List<User> findUsers(User user);
	//添加好友
	public void addFriend(Friend friend);
	
	
	
}

