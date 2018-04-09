package com.wetogether.usermanagement.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wetogether.common.hibernate.pojos.College;
import com.wetogether.common.hibernate.pojos.Friend;
import com.wetogether.common.hibernate.pojos.University;
import com.wetogether.common.hibernate.pojos.User;
import com.wetogether.common.util.registerState.RegisterStates;
import com.wetogether.usermanagement.dao.IUserDao;
import com.wetogether.usermanagement.service.IUserService;

public class UserServiceImpl implements IUserService {
	private IUserDao userDao;

	public IUserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	//主键查用户
	@Override
	public User findUserById(Integer id) {
		return this.userDao.findUserById(id);
		
	}

	@Override
	public int addNewUser(User user) {
		User result = userDao.selectUserByUserName(user.getUserName());
		if (result == null) {
			user.setRegDate(new Date());
			//把空的用户昵称设置成和帐号相同，以后可更改
			user.setNickName(user.getUserName());
			userDao.addNewUser(user);
			return RegisterStates.USER_REGISTER_SUCCESS;
		} else {
			return RegisterStates.USER_EXISTED;
		}

	}

	@Override
	public User selectUserByName(String name) {
		User result = userDao.selectUserByUserName(name);
		if(result!=null){
			return result;
		}
		return null;
	}

	
	//获得所有大学
	@Override
	public List<University> getAllUniversity() {
		return userDao.getAllUniversity();
	}

	
	//返回当前大学对应的所有学院的map
	@Override
	public Map<Integer, String> getAllCollege(University uni) {
		List<College> result = userDao.getAllCollegeOfCurrentUni(uni);
		Map<Integer,String> colleges = new HashMap<Integer,String>();
		if(result.size()!=0){
			for(College c : result){
				colleges.put(c.getCollegeId(), c.getCollegeName());
			}
		}
		
		return colleges;
	}

	//修改个人信息
	@Override
	public User updateUser(User user) {
		if(user.getCollege()==null){
			user.getCollege().setCollegeId(1);
		}
		return userDao.updateMyMessage(user);	
		
	}

	//查询用户
	@Override
	public List<User> findUsers(User user) {
		return userDao.findUsers(user);
	}

	//批量添加好友
	@Override
	public void addFriends(List<Integer> userIds,User currentUser) {
		User u = null;
		Friend f  = null;
		Date d = null;
		for(int i = 0;i<userIds.size();i++){
			u = this.userDao.findUserById(userIds.get(i));
			d = new Date();
			f = new Friend();
			f.setAddDate(d);
			f.setCurrentUser(currentUser);
			f.setFriendUser(u);
			f.setRemark(u.getUserName());
			this.userDao.addFriend(f);
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
