package com.wetogether.common.hibernate.pojos;

import java.util.Date;

public class RecentlyConnecter {
	private Integer recordId;
	private User whose;
	private User users;
	private Date lastConnectTime;
	public Integer getRecordId() {
		return recordId;
	}
	public void setRecordId(Integer recordId) {
		this.recordId = recordId;
	}
	public User getWhose() {
		return whose;
	}
	public void setWhose(User whose) {
		this.whose = whose;
	}
	public User getUsers() {
		return users;
	}
	public void setUsers(User users) {
		this.users = users;
	}
	public Date getLastConnectTime() {
		return lastConnectTime;
	}
	public void setLastConnectTime(Date lastConnectTime) {
		this.lastConnectTime = lastConnectTime;
	}
	
}
