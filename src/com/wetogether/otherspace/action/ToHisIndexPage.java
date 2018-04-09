package com.wetogether.otherspace.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.wetogether.common.hibernate.pojos.Photo;
import com.wetogether.common.hibernate.pojos.User;
import com.wetogether.personalCenter.service.IPersonalCenterServices;
import com.wetogether.usermanagement.service.IUserService;

public class ToHisIndexPage extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	private IUserService userServices;
	private Integer userId;
	private User user;
	private IPersonalCenterServices iPersonalCenterServices;
	private List<Photo> photos;
	private HttpServletRequest request;
	
	public String toHisIndexPage(){
		photos = iPersonalCenterServices.allMyPhotos(userId);
		request = ServletActionContext.getRequest();
		request.setAttribute("photos", photos);
		request.setAttribute("userId", userId);
		user = userServices.findUserById(userId);
		request.setAttribute("user", user);
		return SUCCESS;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public IPersonalCenterServices getiPersonalCenterServices() {
		return iPersonalCenterServices;
	}

	public void setiPersonalCenterServices(
			IPersonalCenterServices iPersonalCenterServices) {
		this.iPersonalCenterServices = iPersonalCenterServices;
	}

	public List<Photo> getPhotos() {
		return photos;
	}

	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public IUserService getUserServices() {
		return userServices;
	}

	public void setUserServices(IUserService userServices) {
		this.userServices = userServices;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
