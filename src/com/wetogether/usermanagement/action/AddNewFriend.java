package com.wetogether.usermanagement.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.wetogether.common.hibernate.pojos.Friend;
import com.wetogether.common.hibernate.pojos.User;
import com.wetogether.common.util.CodeCst;
import com.wetogether.personalCenter.service.IPersonalCenterServices;
import com.wetogether.usermanagement.service.IUserService;

public class AddNewFriend extends ActionSupport {
	private static final long serialVersionUID = 1L;
		private IUserService userServices;
		private IPersonalCenterServices iPersonalCenterServices;
		//定义存放在session中的user
		private  User sessionUser = (User)	ActionContext.getContext().getSession().get(CodeCst.SESSION_USER_NAME);
		//定义response输出流对象
		private PrintWriter pw ;
		private String userIds;
	
	//添加新好友(ajax)
		public void addNewFriend() throws IOException{
			sessionUser = (User)	ActionContext.getContext().getSession().get(CodeCst.SESSION_USER_NAME);
			pw = ServletActionContext.getResponse().getWriter();
			String [] temp = userIds.split(",");
			List<Integer> ids = new ArrayList<Integer>();
			List<Friend> hasFriend = this.iPersonalCenterServices.findAllFriends(sessionUser.getUserId());
			for(int i = 0;i<temp.length;i++){
				Integer thisUserId = Integer.parseInt(temp[i]); 
				//判断是否已经是好友
				Boolean found = false;
				Integer nowUserId = sessionUser.getUserId();
				for(int j = 0;j<hasFriend.size();j++){
					Integer frienduserId = hasFriend.get(j).getFriendUser().getUserId();
					Integer friendCurrentUserId = hasFriend.get(j).getCurrentUser().getUserId();
					found = nowUserId.equals(friendCurrentUserId)&&thisUserId.equals(frienduserId);//符合条件说明已经是好友found = true
					if(found){
						break;
					}
				}
				if(!found){
					ids.add(thisUserId);
				}
				
			}
			this.userServices.addFriends(ids, sessionUser);
			pw.close();
			
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

		public String getUserIds() {
			return userIds;
		}

		public void setUserIds(String userIds) {
			this.userIds = userIds;
		}

		public IUserService getUserServices() {
			return userServices;
		}

		public void setUserServices(IUserService userServices) {
			this.userServices = userServices;
		}

		public IPersonalCenterServices getiPersonalCenterServices() {
			return iPersonalCenterServices;
		}

		public void setiPersonalCenterServices(
				IPersonalCenterServices iPersonalCenterServices) {
			this.iPersonalCenterServices = iPersonalCenterServices;
		}

		
		
		
}
