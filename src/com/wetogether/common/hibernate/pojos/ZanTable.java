package com.wetogether.common.hibernate.pojos;

public class ZanTable {
	private Integer zanId;
	private OriginalSignature os;
	private User zanUser;
	public Integer getZanId() {
		return zanId;
	}
	public void setZanId(Integer zanId) {
		this.zanId = zanId;
	}
	public User getZanUser() {
		return zanUser;
	}
	public void setZanUser(User zanUser) {
		this.zanUser = zanUser;
	}
	public OriginalSignature getOs() {
		return os;
	}
	public void setOs(OriginalSignature os) {
		this.os = os;
	}
	
	
}
