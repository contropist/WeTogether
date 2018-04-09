<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/web/css/daohang.css" />
<title>Insert title here</title>
</head>
</head>
<body>
<script>
	var userId = document.getElementById("userId").value;
	function goHome(){
		window.location.href="toHisIndexPage?userId="+userId;
	}
	function goDaliy(){
		window.location.href="getAllDaliyRecords?articleVOs.cateroryId=1&articleVOs.page.currentPage=1&userId="+userId;
	}
	function goBBS(){
		window.location.href="GetAllBBSs?userId="+userId;
	}
</script>
	<div align="center" class="menu">
		<ul>
			<li><a href="#" onClick="goHome()">主页</a></li>
			<li><a href="#" onClick="goDaliy()">日志</a></li>
			<li><a href="#" onClick="goAlbum()">相册</a></li>
			<li><a href="#" onClick="goCenter()">个人中心</a></li>
			<li><a href="#" onClick="goBBS()">留言版</a></li>
		</ul>
	</div>
</body>
</html>