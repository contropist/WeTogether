package com.wetogether.personalCenter.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.wetogether.common.hibernate.pojos.Comment;
import com.wetogether.common.hibernate.pojos.Friend;
import com.wetogether.common.hibernate.pojos.OriginalSignature;
import com.wetogether.common.hibernate.pojos.User;
import com.wetogether.common.hibernate.pojos.ZanTable;
import com.wetogether.common.util.CodeCst;
import com.wetogether.personalCenter.dto.CommentsBean;
import com.wetogether.personalCenter.dto.FriendsBean;
import com.wetogether.personalCenter.dto.OSsBean;
import com.wetogether.personalCenter.service.IPersonalCenterServices;

public class PersonalCenterAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private IPersonalCenterServices iPersonalCenterServices;
	private Integer currentUserId;
	private CommentsBean commentsBean;
	private Comment comment;
	private FriendsBean friendsBean;
	private OSsBean allOSsBean;
	private OriginalSignature os;
	private List<Friend> friends;
	private List<OriginalSignature> oss;
	private User user;
	private Friend friend;
	private ZanTable zan;
	
	//定义存放在session中的user
	private  User sessionUser = (User)	ActionContext.getContext().getSession().get(CodeCst.SESSION_USER_NAME);
	//定义response输出流对象
	private PrintWriter pw ;
	
	//Ajax搜索好友的名字关键字
	private String tipsName;
	
	
	//定义JSON对象
	private Gson gson = new GsonBuilder().create();
	
	//定义request对象
	private HttpServletRequest request;
	

	
	//获取所有当前用户的信息，个人动态，好友动态，好友列表等
	public String friendList(){
		friends = iPersonalCenterServices.findAllFriends(sessionUser.getUserId());
		return SUCCESS;
	}
	       
	//Ajax实现用户提示功能
	public void searchFriendsByAjax() throws IOException{
		List<Integer> friendIds = iPersonalCenterServices.returnFindFriendIdList(tipsName, sessionUser.getUserId());
		PrintWriter p = ServletActionContext.getResponse().getWriter();
		StringBuffer idsStr = new StringBuffer(); 
		for(Integer i : friendIds){
			idsStr.append(i.toString()+",");
		}
		p.write(idsStr.toString());
		p.close();
		
	}
	
	
	//添加当前用户发布的新说说(ajax)
	public void insertMyNewOsByAjax() throws IOException{
		//转换表情代码为图片路径
		String text = os.getOsContent();
		String reg = "\\[em_([0-9]*)\\]";
		 String rep = "<img src='/WeTogether/web/img/face/$1.gif' border='0'> ";
		 String a = text.replaceAll(reg, rep);
		 os.setOsContent(a);
		//end
		iPersonalCenterServices.addNewOs(sessionUser, os);
		PrintWriter p = ServletActionContext.getResponse().getWriter();
		p.write("OK!");
		p.close();
	}
	//评论说说 ajax
	public void newCommentToOs() throws IOException{
		comment.setCommentUser(sessionUser);
		iPersonalCenterServices.addNewCommentToOs(comment);
		PrintWriter p = ServletActionContext.getResponse().getWriter();
		p.write("OK!");
		p.close();
	}
	
	
	
	
	//通过传入ID查询User(ajax)
	public void findUserById() throws IOException{
		User result = iPersonalCenterServices.findUserById(user.getUserId());
		PrintWriter p = ServletActionContext.getResponse().getWriter();
		String resText = gson.toJson(result);
		p.write(resText);
		p.close();
	}
	
//	通过传入的包含id的friend对象查找到该好友的详细信息
	
	public String findFriendByFriendId(){
		sessionUser = (User)	ActionContext.getContext().getSession().get(CodeCst.SESSION_USER_NAME);
		friend = iPersonalCenterServices.findFriendMessage(friend,sessionUser);
		return SUCCESS;
	}
	
	
	
	//Find all Friend of CurrentUser
	public String getAllFriends(){
		friends = iPersonalCenterServices.findAllFriends(currentUserId);
		return SUCCESS;
	}
	
	
	
	//获取当前用户的所有好友的说说
	public String getAllOriginalSignatures(){
		this.allOSsBean  = iPersonalCenterServices.findAllOSofMyFriend(sessionUser,allOSsBean);
		request = ServletActionContext.getRequest();
		request.setAttribute("allOSsBean", allOSsBean);
		return SUCCESS;
	}
	
//获取当前用户自身的所有说说
	public String getAllOssOfMine(){
		
		this.allOSsBean  = iPersonalCenterServices.findAllOSsOfMine(sessionUser,allOSsBean);
		request = ServletActionContext.getRequest();
		request.setAttribute("allOSsBean", allOSsBean);
		return SUCCESS;
	}
	//删除说说
	public String deleteOS() throws IOException{
		this.iPersonalCenterServices.deleteOS(os);
		pw = ServletActionContext.getResponse().getWriter();
		pw.write("OK");
		pw.close();
		return null;
	}
	//赞说说
	public void zanOs() throws IOException{
		sessionUser = (User)	ActionContext.getContext().getSession().get(CodeCst.SESSION_USER_NAME);
		zan.setZanUser(sessionUser);
		Integer flag = iPersonalCenterServices.addZanToOs(zan);
		pw = ServletActionContext.getResponse().getWriter();
		if(flag==CodeCst.ZAN_ALREADY){
			pw.write("0");
		}else{
			pw.write("1");
		}
		pw.close();
		
	}
	
	

	
	
	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public String getAllComments(){
		
		
		return null;
	}


	public IPersonalCenterServices getiPersonalCenterServices() {
		return iPersonalCenterServices;
	}


	public void setiPersonalCenterServices(
			IPersonalCenterServices iPersonalCenterServices) {
		this.iPersonalCenterServices = iPersonalCenterServices;
	}


	public Integer getCurrentUserId() {
		return currentUserId;
	}


	public void setCurrentUserId(Integer currentUserId) {
		this.currentUserId = currentUserId;
	}


	public CommentsBean getCommentsBean() {
		return commentsBean;
	}


	public void setCommentsBean(CommentsBean commentsBean) {
		this.commentsBean = commentsBean;
	}


	public FriendsBean getFriendsBean() {
		return friendsBean;
	}


	public void setFriendsBean(FriendsBean friendsBean) {
		this.friendsBean = friendsBean;
	}




	public OSsBean getAllOSsBean() {
		return allOSsBean;
	}

	public void setAllOSsBean(OSsBean allOSsBean) {
		this.allOSsBean = allOSsBean;
	}

	public List<Friend> getFriends() {
		return friends;
	}


	public void setFriends(List<Friend> friends) {
		this.friends = friends;
	}

	public String getTipsName() {
		return tipsName;
	}

	public void setTipsName(String tipsName) {
		this.tipsName = tipsName;
	}

	public OriginalSignature getOs() {
		return os;
	}

	public void setOs(OriginalSignature os) {
		this.os = os;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Friend getFriend() {
		return friend;
	}

	public void setFriend(Friend friend) {
		this.friend = friend;
	}

	public List<OriginalSignature> getOss() {
		return oss;
	}

	public void setOss(List<OriginalSignature> oss) {
		this.oss = oss;
	}

	public User getSessionUser() {
		return sessionUser;
	}

	public void setSessionUser(User sessionUser) {
		this.sessionUser = sessionUser;
	}

	public Gson getGson() {
		return gson;
	}

	public void setGson(Gson gson) {
		this.gson = gson;
	}

	public ZanTable getZan() {
		return zan;
	}

	public void setZan(ZanTable zan) {
		this.zan = zan;
	}




	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	



	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
