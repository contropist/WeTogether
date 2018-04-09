package com.wetogether.usermanagement.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.wetogether.common.hibernate.pojos.College;
import com.wetogether.common.hibernate.pojos.Friend;
import com.wetogether.common.hibernate.pojos.University;
import com.wetogether.common.hibernate.pojos.User;
import com.wetogether.usermanagement.dao.IUserDao;

public class UserDaoImpl implements IUserDao {
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	//添加新用户
	@Override
	public int addNewUser(User user) {
		hibernateTemplate.save(user);
		return 0;
	}

	

	@SuppressWarnings("unchecked")
	@Override
	public User selectUserByUserName(String name) {
		List<User> userList = new ArrayList();
		String hql = "from User u where u.userName=:userName";
		userList = hibernateTemplate.findByNamedParam(hql, "userName", name);
		if(userList.size()>0){
			return (User) userList.get(0);
		}
		return null;
	}

	//获得所有大学
	@Override
	public List<University> getAllUniversity() {
		String hql = "from University u order by u.universityName desc";
		@SuppressWarnings("unchecked")
		List<University> universities = hibernateTemplate.find(hql);
		return universities;
	}

	//通过传入的university查询该大学对应的所有学院
	@SuppressWarnings("unchecked")
	@Override
	public List<College> getAllCollegeOfCurrentUni(University uni) {
		String hql = "from College c where c.university.universityId =:uId";
		return hibernateTemplate.findByNamedParam(hql, "uId", uni.getUniversityId());
	}

	@Override
	public User updateMyMessage(User user) {
		User newUser = hibernateTemplate.get(User.class, user.getUserId());
		newUser.setAddress(user.getAddress());
		newUser.setBirthday(user.getBirthday());
		newUser.setChinaName(user.getChinaName());
		newUser.setCollege(user.getCollege());
		newUser.setEmail(user.getEmail());
		newUser.setGender(user.getGender());
		newUser.setGraduateDate(user.getGraduateDate());
		newUser.setIdNumber(user.getIdNumber());
		newUser.setMobile(user.getMobile());
		newUser.setNickName(user.getNickName());
		newUser.setPersonalWord(user.getPersonalWord());
		newUser.setQqNumber(user.getQqNumber());
		newUser.setUniversity(user.getUniversity());
		hibernateTemplate.saveOrUpdate(newUser);
		return newUser;
	}
//通过主键查询好友
	
	
//	find users
	@SuppressWarnings("unchecked")
	@Override
	public List<User> findUsers(User user) {
		String hql = null;
		if(user.getUserId()!=null&&!(user.getUserId().equals(""))){
			hql = "from User u where u.userId=:id";
			return hibernateTemplate.findByNamedParam(hql, "id", user.getUserId());
		}
		if(user.getChinaName()!=null&&!(user.getChinaName().trim().equals(""))){
			hql = "from User u where u.chinaName like :name";
			return hibernateTemplate.findByNamedParam(hql, "name", "%"+user.getChinaName()+"%");
		}
		if(user.getNickName()!=null&&!(user.getNickName().trim().equals(""))){
			hql = "from User u where u.nickName like :nickName";
			return hibernateTemplate.findByNamedParam(hql, "nickName", "%"+user.getNickName()+"%");
		}
		
		if(user.getUniversity()!=null){
			hql = "from User u where u.university.universityId=:uId and u.gender=:gId";
			String [] paras = {"uId","gId"};
			Object [] values = {user.getUniversity().getUniversityId(),user.getGender()};
			return hibernateTemplate.findByNamedParam(hql, paras, values);
		}
		
		
		return new ArrayList<User>();
	}
	
	//通过主键添加好友
	@Override
	public User findUserById(Integer userId) {
		return this.hibernateTemplate.get(User.class, userId);
	}

	//条件好友
	@Override
	public void addFriend(Friend friend) {
		this.hibernateTemplate.save(friend);
		
	}



	
	

}
