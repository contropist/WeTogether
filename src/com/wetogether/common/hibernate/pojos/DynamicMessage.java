package com.wetogether.common.hibernate.pojos;

import java.util.Date;

public class DynamicMessage {
	/*
	 *不用配双向 
	 */
	private Integer messageId;
	private User toWho;
	private User fromWho;
	private MessageType messageType;
	private OriginalSignature os;
	private Article article;
	private Date messageTime;
	private Integer messageStatus = 1;
	
	
	public Date getMessageTime() {
		return messageTime;
	}
	public void setMessageTime(Date messageTime) {
		this.messageTime = messageTime;
	}
	public Integer getMessageId() {
		return messageId;
	}
	public void setMessageId(Integer messageId) {
		this.messageId = messageId;
	}
	public User getToWho() {
		return toWho;
	}
	public void setToWho(User toWho) {
		this.toWho = toWho;
	}
	public User getFromWho() {
		return fromWho;
	}
	public void setFromWho(User fromWho) {
		this.fromWho = fromWho;
	}
	public MessageType getMessageType() {
		return messageType;
	}
	public void setMessageType(MessageType messageType) {
		this.messageType = messageType;
	}
	public OriginalSignature getOs() {
		return os;
	}
	public void setOs(OriginalSignature os) {
		this.os = os;
	}
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
	public Integer getMessageStatus() {
		return messageStatus;
	}
	public void setMessageStatus(Integer messageStatus) {
		this.messageStatus = messageStatus;
	}
	
	
}
