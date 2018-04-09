package com.wetogether.chatroom.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.wetogether.chatroom.dto.ChatRecordBean;
import com.wetogether.chatroom.service.IChatService;
import com.wetogether.common.hibernate.pojos.User;
import com.wetogether.common.util.CodeCst;

public class GetNewMessage extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private IChatService chatService;
	
	private  User sessionUser = (User)	ActionContext.getContext().getSession().get(CodeCst.SESSION_USER_NAME);
	//定义response输出流对象
	private PrintWriter pw ;
	//定义JSON对象
	private Gson gson = new GsonBuilder().create();
	private Integer fromId;
	
	public String getMessage() throws IOException{
		List<ChatRecordBean> beans = this.chatService.findMessage(sessionUser.getUserId(), fromId);
		pw = ServletActionContext.getResponse().getWriter();
		String result = gson.toJson(beans);
		pw.write(result);
		pw.close();
		return null;
	}
	
	
	public IChatService getChatService() {
		return chatService;
	}
	public void setChatService(IChatService chatService) {
		this.chatService = chatService;
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
	public Gson getGson() {
		return gson;
	}
	public void setGson(Gson gson) {
		this.gson = gson;
	}


	public Integer getFromId() {
		return fromId;
	}


	public void setFromId(Integer fromId) {
		this.fromId = fromId;
	}


	

	
	
	
	
	
	
	
}
