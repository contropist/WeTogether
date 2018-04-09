package com.wetogether.chatroom.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.wetogether.chatroom.service.IChatService;
import com.wetogether.common.hibernate.pojos.User;
import com.wetogether.common.util.CodeCst;

public class ChangeMessageStatus extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private IChatService chatService;
	
	private  User sessionUser = (User)	ActionContext.getContext().getSession().get(CodeCst.SESSION_USER_NAME);
	//定义response输出流对象
	private PrintWriter pw ;
	//定义JSON对象
	private Gson gson = new GsonBuilder().create();
	
	private String messageIds;
	
	public String changeMessageStatus(){
		List<Integer> ids = new ArrayList<Integer>();
		String [] temp = messageIds.split(",");
		for(String str : temp){
			ids.add(Integer.parseInt(str));
		}
		this.chatService.updateMessage(ids);
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

	public String getMessageIds() {
		return messageIds;
	}

	public void setMessageIds(String messageIds) {
		this.messageIds = messageIds;
	}
	
	
}
