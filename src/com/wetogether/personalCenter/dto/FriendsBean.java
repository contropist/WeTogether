package com.wetogether.personalCenter.dto;

import java.util.Date;

import com.wetogether.common.hibernate.pojos.Friend;
import com.wetogether.common.hibernate.pojos.User;

public class FriendsBean {

	// user message
	/*
	 * select * from User u where u.userId in( select f_id from friend f where
	 * f.userId = "id" ); String hql =
	 * "from  User u where u.userId in (select  f_id from friend  f where f.userId =:id)"
	 */
	
	private User currentUser;
	private User friendUser;
	private Date addDate;
	
	private int friendListSize;

	
	public void setFriendBean(Friend friend){
		this.currentUser = friend.getCurrentUser();
		this.friendUser = friend.getFriendUser();
		this.addDate = friend.getAddDate();
	}
	
	public int getFriendListSize() {
		return friendListSize;
	}

	public void setFriendListSize(int friendListSize) {
		this.friendListSize = friendListSize;
	}
	
	
	
	
	

}
