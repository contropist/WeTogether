package com.wetogether.common.hibernate.pojos;

import java.util.Date;

public class Friend {
	private Integer friendId;
	private User currentUser;
	private User friendUser;
	//填加好友日期
	private Date addDate;
	//好友备注
	private String remark;
	public User getCurrentUser() {
		return currentUser;
	}
	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}
	public User getFriendUser() {
		return friendUser;
	}
	public void setFriendUser(User friendUser) {
		this.friendUser = friendUser;
	}
	public Integer getFriendId() {
		return friendId;
	}
	public void setFriendId(Integer friendId) {
		this.friendId = friendId;
	}
	public Date getAddDate() {
		return addDate;
	}
	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	
	
	
}
