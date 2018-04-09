package com.wetogether.common.hibernate.pojos;

import java.util.ArrayList;
import java.util.List;


//xue yuan 
public class College {
	private Integer collegeId;
	private String collegeName;
	private String collegeDesc;
	private University university; 
	private List<User> users = new ArrayList();
	
	
	
	
	
	
	public Integer getCollegeId() {
		return collegeId;
	}
	public void setCollegeId(Integer collegeId) {
		this.collegeId = collegeId;
	}
	public String getCollegeName() {
		return collegeName;
	}
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	public String getCollegeDesc() {
		return collegeDesc;
	}
	public void setCollegeDesc(String collegeDesc) {
		this.collegeDesc = collegeDesc;
	}
	public University getUniversity() {
		return university;
	}
	public void setUniversity(University university) {
		this.university = university;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	
	
	
	
}
