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
	href="<%=request.getContextPath()%>/web/css/unicorn.red.css"
	class="skin-color" />
<style>
	.contentBody{
		position:relative;
		left:15%;
		width: 70%;
		top:0pt;
		background-color: white;
		height:auto;
	}
</style>

<script type="text/javascript">
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
		User user = (User)request.getAttribute("user");
		Integer userId = user.getUserId();
	%>
	<input type="hidden" id="sessionUserName" value="<%=sessionUserName%>">
	<input type="hidden" id="sessionUserId" value="<%=sessionUserId%>">
	<input type="hidden" id="userId" value="<%=userId%>">
	<div id="header">
		<h1>
				<jsp:include page="/web/jsp/personalCenter/centerMoudle.jsp"></jsp:include>
		</h1>
	</div>
	
	<div id="user-nav" class="navbar navbar-inverseooopp" >
		<ul class="nav btn-group">
			<li class="btn btn-inverse"><a title="" href="#"><i
					class="icon icon-user"></i> <span class="text" > 
						<%=user.getNickName() %>的个人空间
				</span></a>
			</li>
		</ul>
		<br>
	</div>



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

</body>
</html>