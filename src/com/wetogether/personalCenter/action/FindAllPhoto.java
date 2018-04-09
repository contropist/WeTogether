package com.wetogether.personalCenter.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.wetogether.personalCenter.dto.PhotoBean;
import com.wetogether.personalCenter.service.IPersonalCenterServices;

public class FindAllPhoto extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private IPersonalCenterServices iPersonalCenterServices;
	private PhotoBean bean;
	private HttpServletRequest request;
	public String findAllPhoto(){
		bean = this.iPersonalCenterServices.findAllPhoto(bean);
		this.request = ServletActionContext.getRequest();
		request.setAttribute("photoBean", bean);
		return SUCCESS;
	}
	
	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public IPersonalCenterServices getiPersonalCenterServices() {
		return iPersonalCenterServices;
	}

	public void setiPersonalCenterServices(
			IPersonalCenterServices iPersonalCenterServices) {
		this.iPersonalCenterServices = iPersonalCenterServices;
	}

	public PhotoBean getBean() {
		return bean;
	}

	public void setBean(PhotoBean bean) {
		this.bean = bean;
	}
	
	
}
