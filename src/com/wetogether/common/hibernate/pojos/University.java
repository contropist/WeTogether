package com.wetogether.common.hibernate.pojos;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class University {
	private Integer universityId;
	private String universityName;
	private String universityDesc;
	private String address;
	private Set<College> colleges = new TreeSet<College>();
	private List<User> users = new ArrayList<User>();
	
	
	
	
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	
	public Set<College> getColleges() {
		return colleges;
	}
	public void setColleges(Set<College> colleges) {
		this.colleges = colleges;
	}
	public Integer getUniversityId() {
		return universityId;
	}
	public void setUniversityId(Integer universityId) {
		this.universityId = universityId;
	}
	public String getUniversityName() {
		return universityName;
	}
	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}
	public String getUniversityDesc() {
		return universityDesc;
	}
	public void setUniversityDesc(String universityDesc) {
		this.universityDesc = universityDesc;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
