<%@page import="com.wetogether.common.util.PubUtil.DateFormater"%>
<%@page import="java.text.Format"%>
<%@page import="com.wetogether.common.util.*"%>

<%@page import="java.util.*"%>
<%@page import="com.wetogether.personalCenter.dto.*"%>
<%@page import="com.wetogether.common.hibernate.pojos.*"%>
<%@page import='java.text.SimpleDateFormat' %>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()+ path + "/";
	
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/web/css/moudle_page.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/web/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/web/css/bootstrap-responsive.min.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/web/css/fullcalendar.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/web/css/unicorn.main.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/web/css/unicorn.blue.css"
	class="skin-color" />

<script type="text/javascript">
window.onload = function(){getMessage();};

	function send(url) {
		top.document.getElementsByTagName("iframe")[0].src = urlnew Date() + "?r="
				+ Math.random();
	}
</script>
<title>WeTogether</title>
</head>
<body >


	<%
		User sessionUser = (User)request.getSession().getAttribute(CodeCst.SESSION_USER_NAME);
		String sessionUserName = sessionUser.getUserName();
		Integer sessionUserId  = sessionUser.getUserId();
	%>
	<input type="hidden" id="sessionUserName" value="<%=sessionUserName%>">
	<input type="hidden" id="sessionUserId" value="<%=sessionUserId%>">
	<div id="header">
		<h1>
		</h1>
	</div>

	<div id="user-nav" class="navbar navbar-inverseooopp">
		<ul class="nav btn-group">
			<li class="btn btn-inverse"><a title="" href="#"><i
					class="icon icon-user"></i> <span class="text" > 
					<!-- 					EL表达式获得session中的用户名 -->
						<%=sessionUserName %>
				</span></a></li>
			<li class="btn btn-inverse dropdown" id="menu-messages"><a
				href="#" data-toggle="dropdown" data-target="#menu-messages"
				class="dropdown-toggle"><i class="icon icon-en<%=new Date() %>velope"></i> <span
					class="text">消息</span> <span id="noteSize" class="label label-important">2</span>
					<b class="caret"></b></a>
				<ul class="dropdown-menu" id="dropdown-menu">
					<li id="noteLi"></li>
				</ul></li>
			<li class="btn btn-inverse"><a title="" href="#"><i
					class="icon icon-cog"></i> <span class="text">设置</span></a></li>
			<li class="btn btn-inverse"><a title=""
				href="logout"><i
					class="icon icon-share-alt"></i> <span class="text">退出</span></a></li>
		</ul>
	</div>

	<div id="sidebar">
		<a href="#" class="visible-phone"><i class="icon icon-home"></i> 首页</a>
		<ul>
			<li><a href="allPics?userId=<%=sessionUserId %>" ><i
					class="icon icon-home"></i> <span>首 页</span></a></li>
			<li class="submenu"><a href="#"><i class="icon icon-th-list"></i>
					<span>动态</span> <span class="label">6</span></a>
				<ul>
					<li>
						<table cellpadding="0" cellspacing="0" border="0" width="100%">
							<tr>
								<td width="50%" align="left"><a href="#">与我相关</a></td>
								<td width="20%" align="left"><span id="aboutMe"  class="label">7</span></td>
							</tr>
						</table>
					</li>
					<li><a href="showMyOSsAction?allOSsBean.page.currentPage=1">我的动态</a></li>
					<li><a href="showFriendOSsAction?allOSsBean.page.currentPage=1">好友动态</a></li>
				</ul></li>
				
			<li class="submenu"><a href="#"><i class="icon icon-th-list"></i>
					<span>日志</span> <span class="label">3</span></a>
				<ul>
					<li><a href="showDailyRecordsAction?articleVOs.cateroryId=1&articleVOs.page.currentPage=1">我的日志</a></li>
				</ul></li>
				
			<li class="submenu"><a href="#"><i class="icon icon-th-list"></i>
					<span>相册</span> <span class="label">3</span></a>
				<ul>
					<li><a href="showAlbumAction?albumBean.page.currentPage=1">我的相册</a></li>
				</ul></li>
				
			<li class="submenu"><a href="#"><i class="icon icon-th-list"></i>
					<span>留言板</span> <span class="label">2</span></a>
				<ul>
					<li><a href="GetAllBBSsOfMine?notReload=first&userId=<%=sessionUserId %>">留言板</a></li>
				</ul></li>
				
			<li class="submenu"><a href="#"><i class="icon icon-th-list"></i>
					<span>个人信息维护</span> <span class="label">1</span></a>
				<ul>
					<li><a href="showMyDetailMessage?user.userId=<%=sessionUserId%>">我的资料</a></li>
				</ul></li>

			<li class="submenu"><a href="#"><i class="icon icon-th-list"></i>
					<span>好友列表</span></a>
					
				<ul id="friendsUl">
				<li>
						<table align="center">
							<tr >
							<td><input type="button" onClick="addNewFriend()" value="添加好友"></td>
							<td><input type="button" onClick="" value="好友管理"></td>
							<td><input type="button" onClick="" value="分组"></td>
							</tr>
						</table>
					
					</li>
					<li><input type="text" size="20" name="searchFrend" id="searchFrend"    onInput="friendTips()" placeholder="输入好友名进行检索"></li>
<!-- 					这个action标签很重要，每次加载该页面时都调用这个action -->
<!-- 					处理结果页面为result/friendList.jsp -->
					<s:action name="PersonalCenterAction" executeResult="true" />
<%-- 					<s:iterator value="friends" var="friend"> --%>
<!-- 												迭代出所有好友到好友列表 -->
						
<%-- 						<li id="${friend.friendUser.userId}"> --%>
<%-- 						<a href="#？friendId=${friend.friendUser.userId}"  style="font-size:20pt;	" > --%>
<%-- 						<s:property value="#friend.friendUser.nickName" /></a>  --%>
						
<!-- 						</li> -->
							
<%-- 					</s:iterator> --%>
					<li id="null_Record" style="display:none;color:white">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						Not Fund Record</li>


				</ul></li>
		</ul>
	</div>

		<div id="style-switcher">
			<i class="icon-arrow-left icon-white"></i> <span>Style:</span> <a
				href="#grey"
				style="background-color: #555555; border-color: #aaaaaa;"></a> <a
				href="#blue" style="background-color: #2D2F57;"></a> <a href="#red"
				style="background-color: #673232;"></a>
		</div>

	<!-- 	<div id="content"> -->
	<!-- 				<iframe frameborder="0" style="width:100%;min-height:100%;" src="main.html" scrolling="yes" name="iframe">  -->
	<!-- 				</iframe>  -->
	<!-- 		这里放置你的内容 -->
	<!-- 	</div> -->

	<script src="<%=request.getContextPath()%>/web/js/excanvas.min.js"></script>
	<script src="<%=request.getContextPath()%>/web/js/jquery.min.js"></script>
	<script src="<%=request.getContextPath()%>/web/js/jquery.ui.custom.js"></script>
	<script src="<%=request.getContextPath()%>/web/js/bootstrap.min.js"></script>
	<script src="<%=request.getContextPath()%>/web/js/jquery.flot.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/web/js/jquery.flot.resize.min.js"></script>
	<script src="<%=request.getContextPath()%>/web/js/jquery.peity.min.js"></script>
	<script src="<%=request.getContextPath()%>/web/js/fullcalendar.min.js"></script>
	<script src="<%=request.getContextPath()%>/web/js/unicorn.js"></script>
	<script src="<%=request.getContextPath()%>/web/js/unicorn.dashboard.js"></script>
	<script src="<%=request.getContextPath()%>/web/js/moudle_page.js"></script>
	<!-- 小监听器，监听是否有我的新消息 -->
	<script type="text/javascript">
		getNotes();
		getBBS();
		function getNotes() {
			$.ajax({
				type : "POST",
				url : "/WeTogether/getNotes",
				dataType : "json",
				// 		data : "chat.toUser.userId=" + friendId+"&chat.messageContent="+message,
				success : function(date) {
					$("#noteSize").text(date.length);
					$("#dropdown-menu").html("<li id='noteLi' ></li>");
					if(date.length == 0){
						$("#noteLi").after('<li class=\'sAdd\'>暂无消息</li>');
					}
					for(var i = 0 ;i<date.length;i++){
						var content = "";
						content = content+"<li><a class=\"sAdd\" title='' href=\"ChatNow?friendId="+date[i].userId+"\">"+date[i].userName+"  发来"+date[i].noteCount+"条消息</a></li>";
						$("#noteLi").after(content);
					}
					
					
					
				},
			});

				setTimeout('getNotes()',3000);
		}
		
		function getBBS(){
			$.ajax({
				type : "POST",
				url : "/WeTogether/GetBBSCount",
				dataType : "json",
				// 		data : "chat.toUser.userId=" + friendId+"&chat.messageContent="+message,
				success : function(date) {
					var v = JSON.parse(date);
					$("#bbsCount").text(v);
				},
			});
		}
	
		
	</script>
</body>
</html>