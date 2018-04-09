package com.wetogether.usermanagement.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.wetogether.common.hibernate.pojos.University;
import com.wetogether.common.hibernate.pojos.User;
import com.wetogether.usermanagement.service.IUserService;

public class GetAllUniAndCollege extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HashMap<Integer,String> univers = new HashMap<Integer, String>();
	private Map<Integer,String> colleges = new HashMap<Integer, String>();
	private IUserService userServices;
	private University university;
	private GsonBuilder builder;
	private PrintWriter pw;
	private HttpServletRequest request =ServletActionContext.getRequest();
	private String requestType;
	private User user ;
	
	public String showMyMessage(){
		if(user==null){
			user = new User();
		}
		user = (User)ActionContext.getContext().getSession().get("currentUser");
		return SUCCESS;
	}
	//获得所有大学
	public String getAllUniversity(){
		List<University> universities=userServices.getAllUniversity();
		if(universities.size()!=0){
			for(University u : universities){
				univers.put(u.getUniversityId(), u.getUniversityName());
			}
		}
		request.setAttribute("univers", univers);
		
		
		return null;
	}
	
	//获得所有学院ajax
	public void getAllCollege() throws IOException{
		colleges = userServices.getAllCollege(university);
		builder =  new GsonBuilder();
		Gson gson = builder.create();
		String  jCollges = gson.toJson(colleges);
		pw = ServletActionContext.getResponse().getWriter();
		pw.write(jCollges);
		pw.close();
	}
	
	//获得对应学院
	public void getCollegesOfUni(){
		colleges = userServices.getAllCollege(university);
		request.setAttribute("colleges", colleges);
	}


	
	
	
	
	
	
	
	
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	public HashMap<Integer, String> getUnivers() {
		return univers;
	}

	public void setUnivers(HashMap<Integer, String> univers) {
		this.univers = univers;
	}

	

	public Map<Integer, String> getColleges() {
		return colleges;
	}

	public void setColleges(Map<Integer, String> colleges) {
		this.colleges = colleges;
	}

	public IUserService getUserServices() {
		return userServices;
	}

	public void setUserServices(IUserService userServices) {
		this.userServices = userServices;
	}

	public University getUniversity() {
		return university;
	}

	public void setUniversity(University university) {
		this.university = university;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
