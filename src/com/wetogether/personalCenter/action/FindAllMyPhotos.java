package com.wetogether.personalCenter.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.wetogether.common.hibernate.pojos.Photo;
import com.wetogether.common.hibernate.pojos.User;
import com.wetogether.common.util.CodeCst;
import com.wetogether.personalCenter.service.IPersonalCenterServices;

public class FindAllMyPhotos extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private IPersonalCenterServices iPersonalCenterServices;
	// 定义request对象
	private HttpServletRequest request;
	private  User sessionUser = (User)	ActionContext.getContext().getSession().get(CodeCst.SESSION_USER_NAME);
	private Integer userId;
	public String getAllPhoto(){
		if(userId==null){
			userId = sessionUser.getUserId();
		}
		List<Photo> photos = this.iPersonalCenterServices.allMyPhotos(userId);
		request = ServletActionContext.getRequest();
		request.setAttribute("photos", photos);
		return SUCCESS;
	}
	public IPersonalCenterServices getiPersonalCenterServices() {
		return iPersonalCenterServices;
	}
	public void setiPersonalCenterServices(
			IPersonalCenterServices iPersonalCenterServices) {
		this.iPersonalCenterServices = iPersonalCenterServices;
	}
	public HttpServletRequest getRequest() {
		return request;
	}
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
}
