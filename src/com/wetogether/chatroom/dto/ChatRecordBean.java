package com.wetogether.chatroom.dto;

import com.wetogether.common.hibernate.pojos.ChatRecord;
import com.wetogether.common.util.PubUtil.DateFormater;


public class ChatRecordBean {
	private Integer recordId;
	private Integer fromUserId;
	private Integer toUserId;
	private Integer messageStatus;
	private String messageContent;
	private String sentTime;
	private String fromUserName;
	private String toUserName;
	
	public void setAll(ChatRecord c ){
		this.recordId = c.getRecordId();
		this.fromUserId = c.getFromUser().getUserId();
		this.toUserId = c.getToUser().getUserId();
		this.fromUserName = c.getFromUser().getNickName();
		this.toUserName = c.getToUser().getNickName();
		this.messageContent = c.getMessageContent();
		this.messageStatus = c.getMessageStatus();
		this.sentTime = DateFormater.formater(c.getSentTime(), DateFormater.TIME1);
	}
	
	public Integer getRecordId() {
		return recordId;
	}
	public void setRecordId(Integer recordId) {
		this.recordId = recordId;
	}
	public Integer getFromUserId() {
		return fromUserId;
	}
	public void setFromUserId(Integer fromUserId) {
		this.fromUserId = fromUserId;
	}
	public Integer getToUserId() {
		return toUserId;
	}
	public void setToUserId(Integer toUserId) {
		this.toUserId = toUserId;
	}
	public Integer getMessageStatus() {
		return messageStatus;
	}
	public void setMessageStatus(Integer messageStatus) {
		this.messageStatus = messageStatus;
	}
	public String getMessageContent() {
		return messageContent;
	}
	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}
	public String getSentTime() {
		return sentTime;
	}
	public void setSentTime(String sentTime) {
		this.sentTime = sentTime;
	}
	public String getFromUserName() {
		return fromUserName;
	}
	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}
	public String getToUserName() {
		return toUserName;
	}
	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}
	
	
	
}
