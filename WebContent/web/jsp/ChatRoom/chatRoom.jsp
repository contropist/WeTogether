<%@page import="com.wetogether.personalCenter.dto.ArticleBean"%>
<%@page import="java.text.Format"%>
<%@page import="java.util.*"%>
<%@page import="com.wetogether.personalCenter.dto.*"%>
<%@page import="com.wetogether.common.hibernate.pojos.*"%>	
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import=" com.wetogether.personalCenter.dto.ArticleVOs"%>	
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="<%=request.getContextPath()%>/web/js/jquery.js"></script>
<script src="<%=request.getContextPath()%>/web/jsp/dailyRecord/assets/js/DailyRecord_page.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/web/css/main_page.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/web/css/DailyRecord_page.css" />
<title>正在聊天</title>
<script language="javascript">
window.onload = function(){getMessage();};
document.onkeydown = function(event){
	var e  = event||window.event||arguements.caller.argumentss[0];
	if(e&&e.keyCode==13){
		sendMessage();
	}
}

function sendMessage(){
	var friendId = $("#friendId").val();
// 	var message = $("#msg-box").val();
	var message = $("#saytext").val();
	if(message==""){
		alert("消息内容不能为空!");
		return false;
	}
	
	$.ajax({
		type : "POST",
		url : "/WeTogether/sentMessage",
		dataType : "json",
		data : "chat.toUser.userId=" + friendId+"&chat.messageContent="+message,
		success:function(date){
			var content = "<table cellpadding=\"10\" cellspacing=\"5\" width=\"86%\" align='right' border=\"0\" rules=\"none\" style=\"border-style: dotted;\" >";
			content = content+"<tr><td width=\"85%\">";
			content = content+"<table cellpadding=\"5\" cellspacing=\"5\" align=\"right\" width=\"100%\" border=\"1\" rules=\"none\" style=\"border-style: dotted; border-color: green;\">";
			content = content+"<tr><td></td><td width=\"30%\"  align=\"right\" class=\"font-black\">"+date.fromUserName+"</td>";
			content = content+"<td width=\"10%\"  style='color:grey;' align=\"right\">"+date.sentTime+"</td>";
			content = content+"</tr><tr><td colspan=\"3\" class='font1' align=\"right\">"+date.messageContent+"</td>";
			content = content+"</tr></table></td>";	
			content = content+"<td width=\"10%\" align=\"center\" ><img  src=\"/WeTogether/web/img/photo/user"+date.fromUserId+"_2.png\" alt=\"请先上传头像\" /></td>";		
			content = content+"</tr></table>";			
			$("#lastP").before(content);
			


			$("#endMessage").focus();
			$("#saytext").val("");
			$("#saytext").focus();
		},
	});
	
	
}

function getMessage(){
	var friendId = $("#friendId").val();
	var messageId="";
	$.ajax({
		type : "POST",
		url : "/WeTogether/getMessage",
		dataType : "json",
		data : "fromId=" + friendId,
		success:function(date){
		for(var i = 0 ;i<date.length;i++){
			messageId = messageId+date[i].recordId+",";
			var content = "<table cellpadding=\"10\" cellspacing=\"5\" width=\"90%\" align='left' border=\"0\" rules=\"none\"  >";
			content = content+"<tr><td width=\"15%\" align=\"center\" ><img  src=\"/WeTogether/web/img/photo/user"+date[i].fromUserId+"_2.png\" alt=\"请先上传头像\" /></td>";
			content = content+"<td width=\"85%\">";
			content = content+"<table cellpadding=\"10\" cellspacing=\"5\" style=\"border-style: dotted; border-color: green;\" width=\"100%\" border=\"1\" rules=\"none\">";
			content = content+"<tr><td width=\"30%\" class=\"font-black\">"+date[i].fromUserName+"</td>";
			content = content+"<td width=\"10%\" style='color:grey;' align=\"left\">"+date[i].sentTime+"</td>";
			content = content+"<td></td></tr><tr><td colspan=\"3\" class=\"font1\">"+date[i].messageContent+"</td>";	
			content = content+"</tr></table></td></tr></table>";	
			$("#lastP").before(content);
			$("#endMessage").focus();
		}	
		$.ajax({
			type : "POST",
			url : "/WeTogether/ChangeMessageStatus",
//				dataType : "json",
			data : "messageIds=" + messageId,
			success:function(date){
			},
		});	
			
			
		},
	});
	
	
	setTimeout('getMessage()',500);
}

</script>
<style type="text/css">
	.chatBody{
		position: absolute;
		left: 0pt;
		top:15pt;
		width: 90%;
		height: auto;
		overflow:auto;
	}
</style>
</head>
<body>
	<jsp:include page="/web/jsp/moudle.jsp"></jsp:include>
		<div id="content">
		<%
			String userId = request.getParameter("friendId");
		%>
		<input type="hidden" name="friendId" id="friendId"
			value="<%=userId%>">

		<div class="chatBody">
				<div class="row-fluid">
					<div class="span12">
						
						<div class="widget-box widget-chat">
							<div class="widget-title">
								<span class="icon">
									<i class="icon-comment"></i>
								</span>
								<h5>
								正在与<%
									String friendName = ((User)request.getAttribute("chatUser")).getNickName();
									Integer firndUserId = ((User)request.getAttribute("chatUser")).getUserId();
									out.println(friendName);
								%>聊天... 
								</h5>
							</div>
							<div class="widget-content nopadding">
								<div class="chat-content panel-left">                   
								   <div class="chat-messages" id="chat-messages">
										<div id="chat-messages-inner">
<!-- 											聊天内容 -->
											<p id="lastP"></p>
											<div align="center"><input type="text" id='endMessage'   style="position:relative;height:0pt;width:90%;background-color: grey;  "></div>
										</div>
								   </div>									
								   <div class="chat-message well" >
								   <div style="z-index:9999999">
								   		<jsp:include page="/web/jsp/ChatRoom/ChatFaceText.jsp"></jsp:include>
								   </div>
								   
<!-- 										<button class="btn btn-success" onClick="sendMessage()">Send</button>   -->
										
<%-- 										<span class="input-box"> --%>
<!-- 											<input type="text" name="msg-box" id="msg-box"  /> -->
<%-- 										</span>										                   --%>
								   </div>                   
								</div>
								<div class="chat-users panel-right">
									<div class="panel-title"><h5>最近联系</h5></div>
									<div class="panel-content nopadding">
										<ul class="contact-list">
										<%
											List<RecentlyConnecter> rcs = (List)request.getAttribute("rcs");
											for(int i = 0;i<rcs.size();i++){
												User rcFriend = rcs.get(i).getUsers();
										%>
										
										<li id="user-michelle" 
										<%if(firndUserId.equals(rcFriend.getUserId())){
											%>
											class="online new"
											
											<% 
										} %>
										>
										<a href="ChatNow?friendId=<%=rcFriend.getUserId()%>">
										<img src='<%=request.getContextPath()%>/web/img/photo/user<%=rcFriend.getUserId() %>_3.png'>
										<span><%=rcFriend.getNickName() %></span></a>
										</li>
										
										<%} %>
<%-- 											<li id="user-michelle" class="online new"><a href="#"><img alt="" src="img/demo/av1.jpg" /> <span>Michelle</span></a><span class="msg-count badge badge-info">3</span></li> --%>
<%-- 											<li id="user-neytiri"><a href="#"><img alt="" src="img/demo/av2.jpg" /> <span>Neytiri</span></a></li> --%>
										</ul>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				
				
			</div>
	</div>
	<script src=""></script>
	
	<script src="<%=request.getContextPath()%>/web/js/unicorn.chat.js"></script>
	
</body>
</html>