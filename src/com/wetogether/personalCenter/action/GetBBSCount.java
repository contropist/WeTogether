package com.wetogether.personalCenter.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.wetogether.common.hibernate.pojos.DynamicMessage;
import com.wetogether.common.hibernate.pojos.User;
import com.wetogether.common.util.CodeCst;
import com.wetogether.personalCenter.service.IPersonalCenterServices;

public class GetBBSCount extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private IPersonalCenterServices iPersonalCenterServices;
	private User sessionUser = (User)ActionContext.getContext().getSession().get(CodeCst.SESSION_USER_NAME);
	private PrintWriter pw;
	private DynamicMessage dm;
	
	public void GetBBSCount() throws IOException{
		dm = new DynamicMessage();
		dm.setToWho(sessionUser);
		List<DynamicMessage> list = this.iPersonalCenterServices.getDms(dm);
		pw = ServletActionContext.getResponse().getWriter();
		Integer size = list.size();
		pw.write(size.toString());
		pw.close();
//		for(int i = 0 ; i<list.size();i++){
//			this.iPersonalCenterServices.updateDm(list.get(i));
//		}
	}

	public IPersonalCenterServices getiPersonalCenterServices() {
		return iPersonalCenterServices;
	}

	public void setiPersonalCenterServices(
			IPersonalCenterServices iPersonalCenterServices) {
		this.iPersonalCenterServices = iPersonalCenterServices;
	}

	public User getSessionUser() {
		return sessionUser;
	}

	public void setSessionUser(User sessionUser) {
		this.sessionUser = sessionUser;
	}

	public PrintWriter getPw() {
		return pw;
	}

	public void setPw(PrintWriter pw) {
		this.pw = pw;
	}

	public DynamicMessage getDm() {
		return dm;
	}

	public void setDm(DynamicMessage dm) {
		this.dm = dm;
	}
	
	
}
