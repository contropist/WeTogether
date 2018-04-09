package com.wetogether.personalCenter.action;



import java.io.IOException;
import java.io.PrintWriter;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.wetogether.personalCenter.service.IPersonalCenterServices;

public class DeletePhoto extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private IPersonalCenterServices iPersonalCenterServices;
	private Integer photoId;
	private PrintWriter pw;
	public void deletePhoto() throws IOException{
		this.iPersonalCenterServices.deletePhoto(photoId);
		pw = ServletActionContext.getResponse().getWriter();
		pw.write("OK");
		pw.close();
	}
	public IPersonalCenterServices getiPersonalCenterServices() {
		return iPersonalCenterServices;
	}
	public void setiPersonalCenterServices(
			IPersonalCenterServices iPersonalCenterServices) {
		this.iPersonalCenterServices = iPersonalCenterServices;
	}
	public Integer getPhotoId() {
		return photoId;
	}
	public void setPhotoId(Integer photoId) {
		this.photoId = photoId;
	}
	
	
}
