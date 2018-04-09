package com.wetogether.common.hibernate.pojos;

import java.util.Date;
import java.util.Set;
import java.util.TreeSet;



//个签
public class OriginalSignature {
	private Integer originalSignatureId;
	private User osOwer;
	private String osContent;
	private Date osSubmitDate;
	private Set<Comment> comments = new TreeSet<Comment>();
	private Set<ZanTable> zans = new TreeSet<ZanTable>();
	private Set<DynamicMessage> dms = new TreeSet<DynamicMessage>();
	
	
	
	public Set<ZanTable> getZans() {
		return zans;
	}
	public void setZans(Set<ZanTable> zans) {
		this.zans = zans;
	}
	public User getOsOwer() {
		return osOwer;
	}
	public void setOsOwer(User osOwer) {
		this.osOwer = osOwer;
	}
	public String getOsContent() {
		return osContent;
	}
	public void setOsContent(String osContent) {
		this.osContent = osContent;
	}
	public Date getOsSubmitDate() {
		return osSubmitDate;
	}
	public void setOsSubmitDate(Date osSubmitDate) {
		this.osSubmitDate = osSubmitDate;
	}
	
	public Set<Comment> getComments() {
		return comments;
	}
	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}
	public Integer getOriginalSignatureId() {
		return originalSignatureId;
	}
	public void setOriginalSignatureId(Integer originalSignatureId) {
		this.originalSignatureId = originalSignatureId;
	}
	public Set<DynamicMessage> getDms() {
		return dms;
	}
	public void setDms(Set<DynamicMessage> dms) {
		this.dms = dms;
	}
	
	
	
	
	
	
}
