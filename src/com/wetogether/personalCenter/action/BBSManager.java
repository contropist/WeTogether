package com.wetogether.personalCenter.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.wetogether.common.hibernate.pojos.BBS;
import com.wetogether.common.hibernate.pojos.DynamicMessage;
import com.wetogether.common.hibernate.pojos.MessageType;
import com.wetogether.common.hibernate.pojos.User;
import com.wetogether.common.util.CodeCst;
import com.wetogether.otherspace.service.IOtherPageService;
import com.wetogether.personalCenter.service.IPersonalCenterServices;
import com.wetogether.usermanagement.service.IUserService;

public class BBSManager extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private IOtherPageService opService;
	private IUserService userServices;
	private Integer userId;
	private User user;
	private IPersonalCenterServices iPersonalCenterServices;
	private User sessionUser = (User)ActionContext.getContext().getSession().get(CodeCst.SESSION_USER_NAME);
	//获得request对象
	private HttpServletRequest request = ServletActionContext.getRequest();
	// 定义response输出流对象
	private PrintWriter pw;
	// 定义JSON对象
	private Gson gson = new GsonBuilder().create();
	
	private BBS bbs;
	private List<BBS> bbss ;
	
	private String notReload;
	
	//获取所有留言
	public String getBBSs(){
		user = userServices.findUserById(userId);
		bbss = this.iPersonalCenterServices.getBBSs(userId);
		//将未读的新留言置为已读状态
		if(notReload!=null){
			this.iPersonalCenterServices.updateDm(userId);
		}
		
		//end
		request.setAttribute("user", user);
		request.setAttribute("bbss", bbss);
		return SUCCESS;
	}
	
	//留言
	public void addBBS() throws IOException{
		user = userServices.findUserById(userId);
		bbs.setBbsOwer(user);
		bbs.setCommenter(sessionUser);
		//转换表情代码为图片路径
		String text = bbs.getBbsCotent();
		String reg = "\\[em_([0-9]*)\\]";
		 String rep = "<img src='/WeTogether/web/img/face/$1.gif' border='0'> ";
		 String a = text.replaceAll(reg, rep);
		bbs.setBbsCotent(a);
		//end
		this.iPersonalCenterServices.addBbs(bbs);
		//留言后插入留言提醒
		DynamicMessage d = new DynamicMessage();
		MessageType  type = new MessageType();
		type.setMessageTypeId(1);
		d.setMessageType(type);
		d.setToWho(user);
		d.setFromWho(sessionUser);
		this.iPersonalCenterServices.addDynamicMessage(d);
		//end
		request.setAttribute("user", user);
		
		pw = ServletActionContext.getResponse().getWriter();
		pw.write("OK");
		pw.close();
	}
	
	public IOtherPageService getOpService() {
		return opService;
	}

	public void setOpService(IOtherPageService opService) {
		this.opService = opService;
	}

	public IUserService getUserServices() {
		return userServices;
	}

	public void setUserServices(IUserService userServices) {
		this.userServices = userServices;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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

	public PrintWriter getPw() {
		return pw;
	}

	public void setPw(PrintWriter pw) {
		this.pw = pw;
	}

	public Gson getGson() {
		return gson;
	}

	public void setGson(Gson gson) {
		this.gson = gson;
	}

	public User getSessionUser() {
		return sessionUser;
	}

	public void setSessionUser(User sessionUser) {
		this.sessionUser = sessionUser;
	}

	public BBS getBbs() {
		return bbs;
	}

	public void setBbs(BBS bbs) {
		this.bbs = bbs;
	}

	public List<BBS> getBbss() {
		return bbss;
	}

	public void setBbss(List<BBS> bbss) {
		this.bbss = bbss;
	}

	public String getNotReload() {
		return notReload;
	}

	public void setNotReload(String notReload) {
		this.notReload = notReload;
	}
	
	
}
