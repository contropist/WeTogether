package com.wetogether.chatroom.dto;

public class MessageNoteBean {
	private Integer userId;
	private String noteCount;
	private String userName;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public String getNoteCount() {
		return noteCount;
	}
	public void setNoteCount(String noteCount) {
		this.noteCount = noteCount;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
}
