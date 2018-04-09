package com.wetogether.personalCenter.dto;

import com.wetogether.common.hibernate.pojos.Album;
import com.wetogether.common.hibernate.pojos.User;

public class BaseBean {
	private User user;
	private Integer userId;
	private Album album;
	
	
	public Album getAlbum() {
		return album;
	}
	public void setAlbum(Album album) {
		this.album = album;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
}
