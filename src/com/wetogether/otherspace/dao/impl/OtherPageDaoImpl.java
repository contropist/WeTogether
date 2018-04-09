package com.wetogether.otherspace.dao.impl;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.wetogether.otherspace.dao.IOtherPageDao;

public class OtherPageDaoImpl implements IOtherPageDao {
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	
}
