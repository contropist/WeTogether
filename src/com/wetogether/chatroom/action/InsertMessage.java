package com.wetogether.chatroom.action;

import java.io.IOException;
import java.io.PrintWriter;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.wetogether.chatroom.dto.ChatRecordBean;
import com.wetogether.chatroom.service.IChatService;
import com.wetogether.common.hibernate.pojos.ChatRecord;
import com.wetogether.common.hibernate.pojos.User;
import com.wetogether.common.util.CodeCst;

public class InsertMessage extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	private IChatService chatService;
	
	private  User sessionUser = (User)	ActionContext.getContext().getSession().get(CodeCst.SESSION_USER_NAME);
	//定义response输出流对象
	private PrintWriter pw ;
	//定义JSON对象
	private Gson gson = new GsonBuilder().create();
	private ChatRecordBean chatBean ;
	private ChatRecord chat;
	//发送消息。AJAX实现
	public String sentMessage() throws IOException{
		//转换表情代码为图片路径
				String text = chat.getMessageContent();
				String reg = "\\[em_([0-9]*)\\]";
				 String rep = "<img src='/WeTogether/web/img/face/$1.gif' border='0'> ";
				 String a = text.replaceAll(reg, rep);
				chat.setMessageContent(a);
        //end
		this.chat.setFromUser(sessionUser);
		this.chatService.addMessage(chat);
		pw = ServletActionContext.getResponse().getWriter();
		chatBean = new ChatRecordBean();
		chatBean.setAll(chat);
		String result = gson.toJson(chatBean);
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

	public ChatRecordBean getChatBean() {
		return chatBean;
	}

	public void setChatBean(ChatRecordBean chatBean) {
		this.chatBean = chatBean;
	}

	public ChatRecord getChat() {
		return chat;
	}

	public void setChat(ChatRecord chat) {
		this.chat = chat;
	}
	
	
	
}
