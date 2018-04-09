package com.wetogether.otherspace.service.imp;

import com.wetogether.otherspace.dao.IOtherPageDao;
import com.wetogether.otherspace.service.IOtherPageService;

public class OtherPageServiceImpl implements IOtherPageService {
	private IOtherPageDao opDao;

	public IOtherPageDao getOpDao() {
		return opDao;
	}

	public void setOpDao(IOtherPageDao opDao) {
		this.opDao = opDao;
	}
	
	
}
