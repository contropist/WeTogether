package com.wetogether.chatroom.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.wetogether.chatroom.service.IChatService;
import com.wetogether.common.hibernate.pojos.RecentlyConnecter;
import com.wetogether.common.hibernate.pojos.User;
import com.wetogether.common.util.CodeCst;
import com.wetogether.usermanagement.service.IUserService;

public class ChatNowAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private IChatService chatService;
	private Integer friendId;
	private IUserService userServices;
	private  User sessionUser = (User)	ActionContext.getContext().getSession().get(CodeCst.SESSION_USER_NAME);
	private HttpServletRequest request ;
	private User chatUser;
	private RecentlyConnecter rc;
	private List<RecentlyConnecter> rcs ;
	public String ChatNow(){
		chatUser = userServices.findUserById(friendId);
		rc = new RecentlyConnecter();
		rc.setUsers(chatUser);
		rc.setWhose(sessionUser);
		rc.setLastConnectTime(new Date());
		this.chatService.addRecentlyConnecter(rc);
		this.rcs = this.chatService.findMyRc(sessionUser.getUserId());
		request = ServletActionContext.getRequest();
		request.setAttribute("chatUser", chatUser);
		request.setAttribute("rcs", rcs);
		return SUCCESS;
	}
	public IChatService getChatService() {
		return chatService;
	}
	public void setChatService(IChatService chatService) {
		this.chatService = chatService;
	}
	public Integer getFriendId() {
		return friendId;
	}
	public void setFriendId(Integer friendId) {
		this.friendId = friendId;
	}
	public IUserService getUserServices() {
		return userServices;
	}
	public void setUserServices(IUserService userServices) {
		this.userServices = userServices;
	}
	public User getChatUser() {
		return chatUser;
	}
	public void setChatUser(User chatUser) {
		this.chatUser = chatUser;
	}
	public User getSessionUser() {
		return sessionUser;
	}
	public void setSessionUser(User sessionUser) {
		this.sessionUser = sessionUser;
	}
	public RecentlyConnecter getRc() {
		return rc;
	}
	public void setRc(RecentlyConnecter rc) {
		this.rc = rc;
	}
	public HttpServletRequest getRequest() {
		return request;
	}
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	public List<RecentlyConnecter> getRcs() {
		return rcs;
	}
	public void setRcs(List<RecentlyConnecter> rcs) {
		this.rcs = rcs;
	}
	
	
	
}
