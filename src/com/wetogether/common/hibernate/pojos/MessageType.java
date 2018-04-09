package com.wetogether.common.hibernate.pojos;

import java.util.ArrayList;
import java.util.List;

public class MessageType {
	private Integer messageTypeId;
	private String messageTypenName;
	private String messageTypeDesc;
	private List<DynamicMessage> messages = new ArrayList<DynamicMessage>();
	public Integer getMessageTypeId() {
		return messageTypeId;
	}
	public void setMessageTypeId(Integer messageTypeId) {
		this.messageTypeId = messageTypeId;
	}
	
	public String getMessageTypenName() {
		return messageTypenName;
	}
	public void setMessageTypenName(String messageTypenName) {
		this.messageTypenName = messageTypenName;
	}
	public String getMessageTypeDesc() {
		return messageTypeDesc;
	}
	public void setMessageTypeDesc(String messageTypeDesc) {
		this.messageTypeDesc = messageTypeDesc;
	}
	public List<DynamicMessage> getMessages() {
		return messages;
	}
	public void setMessages(List<DynamicMessage> messages) {
		this.messages = messages;
	}
	
	
	
}
