package com.wetogether.personalCenter.action;

import java.io.IOException;
import java.io.PrintWriter;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.wetogether.common.hibernate.pojos.Album;
import com.wetogether.common.hibernate.pojos.User;
import com.wetogether.common.util.CodeCst;
import com.wetogether.personalCenter.service.IPersonalCenterServices;

public class AddNewAlbum extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private IPersonalCenterServices iPersonalCenterServices;
	private Album album;
	private User sessionUser = (User)ActionContext.getContext().getSession().get(CodeCst.SESSION_USER_NAME);
	private PrintWriter pw;
	
	public String addNewAlbum() throws IOException{
		album.setAlbumOwer(sessionUser);
		this.iPersonalCenterServices.addNewAlbum(album);
		pw = ServletActionContext.getResponse().getWriter();
		pw.write("ok");
		pw.close();
		return null;
	}

	public IPersonalCenterServices getiPersonalCenterServices() {
		return iPersonalCenterServices;
	}

	public void setiPersonalCenterServices(
			IPersonalCenterServices iPersonalCenterServices) {
		this.iPersonalCenterServices = iPersonalCenterServices;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
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
	
	
}
