package com.wetogether.common.hibernate.pojos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class User {
	private Integer userId;
	private String userName;
	private String password;
	private String email;
	private String chinaName;
	private Integer gender;
	private String idNumber;
	private String graduateDate;	
	private String birthday;
	private Date regDate;
	private String mobile;
	private String qqNumber;
	
	//在线状态
	private Integer isOnline;
	//个性签名
	private String personalWord;
	//昵称
	private String nickName;
	private transient UserType  userType;	
	private transient College college;
	private transient University university;
	private transient List<Friend> friends= new ArrayList<Friend>();
	private transient List<DynamicMessage> messages =  new ArrayList<DynamicMessage>();
	private transient Set<BBS> bbs = new TreeSet<BBS>();
	private Set<RecentlyConnecter> connecters = new TreeSet<RecentlyConnecter>();
	private String address;
	//头像picName
	private String picName;
	private Integer loginTimes = 1;
	
	private Set<Album> albums = new TreeSet<Album>();
	
	
	public Set<RecentlyConnecter> getConnecters() {
		return connecters;
	}
	public void setConnecters(Set<RecentlyConnecter> connecters) {
		this.connecters = connecters;
	}
	public Set<Album> getAlbums() {
		return albums;
	}
	public void setAlbums(Set<Album> albums) {
		this.albums = albums;
	}
	public Set<BBS> getBbs() {
		return bbs;
	}
	public void setBbs(Set<BBS> bbs) {
		this.bbs = bbs;
	}
	public List<DynamicMessage> getMessages() {
		return messages;
	}
	public void setMessages(List<DynamicMessage> messages) {
		this.messages = messages;
	}
	public Integer getLoginTimes() {
		return loginTimes;
	}
	public void setLoginTimes(Integer loginTimes) {
		this.loginTimes = loginTimes;
	}
	public String getPicName() {
		return picName;
	}
	public void setPicName(String picName) {
		this.picName = picName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public UserType getUserType() {
		return userType;
	}
	public void setUserType(UserType userType) {
		this.userType = userType;
	}
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getChinaName() {
		return chinaName;
	}
	public void setChinaName(String chinaName) {
		this.chinaName = chinaName;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	
	public String getGraduateDate() {
		return graduateDate;
	}
	public void setGraduateDate(String graduateDate) {
		this.graduateDate = graduateDate;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getQqNumber() {
		return qqNumber;
	}
	public void setQqNumber(String qqNumber) {
		this.qqNumber = qqNumber;
	}
	public List<Friend> getFriends() {
		return friends;
	}
	public void setFriends(List<Friend> friends) {
		this.friends = friends;
	}
	public College getCollege() {
		return college;
	}
	public void setCollege(College college) {
		this.college = college;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getPersonalWord() {
		return personalWord;
	}
	public void setPersonalWord(String personalWord) {
		this.personalWord = personalWord;
	}
	public University getUniversity() {
		return university;
	}
	public void setUniversity(University university) {
		this.university = university;
	}
	public Integer getIsOnline() {
		return isOnline;
	}
	public void setIsOnline(Integer isOnline) {
		this.isOnline = isOnline;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
