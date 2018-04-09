package com.wetogether.chatroom.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.wetogether.chatroom.dto.MessageNoteBean;
import com.wetogether.chatroom.service.IChatService;
import com.wetogether.common.hibernate.pojos.User;
import com.wetogether.common.util.CodeCst;

public class GetMessageNote extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private IChatService chatService;
	private  User sessionUser = (User)	ActionContext.getContext().getSession().get(CodeCst.SESSION_USER_NAME);
	private PrintWriter pw ;
	// 定义JSON对象
	private Gson gson = new GsonBuilder().create();
	
	public String getNotes() throws IOException{
		@SuppressWarnings("rawtypes")
		List result = this.chatService.findMessageNotes(sessionUser.getUserId());
		List<MessageNoteBean> beans = new ArrayList<MessageNoteBean>();
		for(int i = 0 ;i<result.size();i++){
			Object [] temp1 = (Object[])result.get(i);
			User user = (User)temp1[0];
			String count = temp1[1].toString();
			MessageNoteBean bean = new MessageNoteBean();
			bean.setNoteCount(count);
			bean.setUserId(user.getUserId());
			bean.setUserName(user.getUserName());
			beans.add(bean);
		}
		pw = ServletActionContext.getResponse().getWriter();
		pw.write(gson.toJson(beans));
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
	
	
	
}
