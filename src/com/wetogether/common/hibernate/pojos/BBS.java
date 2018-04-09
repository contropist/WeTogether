package com.wetogether.common.hibernate.pojos;

import java.util.Date;

public class BBS {
	private Integer bbsId;
	private User commenter;
	private User bbsOwer;
	private String bbsCotent;
	private Date subDate;
	public Integer getBbsId() {
		return bbsId;
	}
	public void setBbsId(Integer bbsId) {
		this.bbsId = bbsId;
	}
	public User getCommenter() {
		return commenter;
	}
	public void setCommenter(User commenter) {
		this.commenter = commenter;
	}
	
	
	public User getBbsOwer() {
		return bbsOwer;
	}
	public void setBbsOwer(User bbsOwer) {
		this.bbsOwer = bbsOwer;
	}
	public String getBbsCotent() {
		return bbsCotent;
	}
	public void setBbsCotent(String bbsCotent) {
		this.bbsCotent = bbsCotent;
	}
	public Date getSubDate() {
		return subDate;
	}
	public void setSubDate(Date subDate) {
		this.subDate = subDate;
	}
	
	
}
