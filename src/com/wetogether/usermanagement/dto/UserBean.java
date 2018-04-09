package com.wetogether.usermanagement.dto;

import com.wetogether.common.hibernate.pojos.User;
import com.wetogether.common.util.PubUtil.DateFormater;
import com.wetogether.common.util.PubUtil.SetGender;

public class UserBean {
	private Integer userId;
	private String userName;
	private String email;
	private String chinaName;
	private String gender;
	private String idNumber;
	private String graduateDate;	
	private String birthday;
	private String regDate;
	private String mobile;
	private String qqNumber;
	
	//个性签名
	private String personalWord;
	//昵称
	private String nickName;
	private String college;
	private String university;
	private String address;
	//头像picName
	
	public void setAll(User u ){
		this.userId = u.getUserId();
		this.userName = u.getUserName();
		this.email = u.getEmail();
		this.chinaName = u.getChinaName();
		this.gender = SetGender.setGender(u.getGender());
		this.idNumber = u.getIdNumber();
		this.graduateDate = u.getGraduateDate();
		this.birthday = u.getBirthday();
		this.mobile = u.getMobile();
		this.qqNumber = u.getQqNumber();
		if(u.getRegDate()!=null){
			this.regDate = DateFormater.formater(u.getRegDate(), DateFormater.DATE1);
		}
		this.personalWord = u.getPersonalWord();
		this.nickName = u.getNickName();
		if(u.getCollege()==null){
			this.college = "";
		}else{
			this.college = u.getCollege().getCollegeName();
		}
		
		if(u.getUniversity()==null){
			this.university = "";
		}else{
			this.university = u.getUniversity().getUniversityName();
		}
		
		this.address = u.getAddress();
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
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

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
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

	public String getPersonalWord() {
		return personalWord;
	}

	public void setPersonalWord(String personalWord) {
		this.personalWord = personalWord;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
	
	
}
