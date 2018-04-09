package com.wetogether.allDaos.impl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.wetogether.allDaos.IAllDaos;
import com.wetogether.common.hibernate.pojos.User;

public class AllDaosImpl implements IAllDaos {
	private HibernateTemplate hibernateTemplate;

	@Override
	public User selectUserByUserName(String name) {
		String hql = "from User u where u.userName=:userName";
		List users = hibernateTemplate.findByNamedParam(hql, "userName", name);
		if(users.size()>0){
			User user = (User)users.get(0);
			return user;
		}
		
		return null;
	}

	@Override
	public List<User> selectAllUserByID(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> selectUserByParam(String param) {
		// TODO Auto-generated method stub
		return null;
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	
	
	


}
