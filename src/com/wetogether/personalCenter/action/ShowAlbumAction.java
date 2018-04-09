package com.wetogether.personalCenter.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.wetogether.common.hibernate.pojos.User;
import com.wetogether.common.util.CodeCst;
import com.wetogether.common.util.dividePageSize.PageSize;
import com.wetogether.common.util.dividepage.DividePage;
import com.wetogether.personalCenter.dto.AlbumBean;
import com.wetogether.personalCenter.service.IPersonalCenterServices;

public class ShowAlbumAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private IPersonalCenterServices iPersonalCenterServices;
	private AlbumBean albumBean;
	private User sessionUser = (User)ActionContext.getContext().getSession().get(CodeCst.SESSION_USER_NAME);
	private PrintWriter pw;
	private HttpServletRequest request;
	
	public String showAllAlbum(){
		if(null==albumBean){
			albumBean = new AlbumBean();
			DividePage page = new DividePage(PageSize.PAGESIZE_OF_ALBUM);
			page.setCurrentPage(1);
			albumBean.setPage(page);
		}
		albumBean.setUser(sessionUser);
		albumBean = this.iPersonalCenterServices.findAllAlbum(albumBean);
		request = ServletActionContext.getRequest();
		request.setAttribute("albumBean", albumBean);
		return SUCCESS;
	}

	public IPersonalCenterServices getiPersonalCenterServices() {
		return iPersonalCenterServices;
	}

	public void setiPersonalCenterServices(
			IPersonalCenterServices iPersonalCenterServices) {
		this.iPersonalCenterServices = iPersonalCenterServices;
	}

	public AlbumBean getAlbumBean() {
		return albumBean;
	}

	public void setAlbumBean(AlbumBean albumBean) {
		this.albumBean = albumBean;
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
