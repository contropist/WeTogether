<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page import="com.wetogether.usermanagement.dto.*"%>
<%@page import="com.wetogether.common.hibernate.pojos.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="<%=request.getContextPath()%>/web/js/jquery.js"></script>
<script src="<%=request.getContextPath()%>/web/js/friendMessagePage.js"></script>
<title>Insert title here</title>
<style type="text/css">
<!--
body{
	margin: 0 0 0 0 ;
}
a:{
	text-decoration: none;
	
}
.headLine{
	height:20pt;
	width:100%;
	font-size:18pt;
	background-color: #CCCCCC;
}	
table{
	padding-top: 0pt;
}

table tr {
	color: #333333;
	height:20px;
}
table tr td{
}
.table2 tr {
	color: #333333;
	height:20px;
	width:100%;
	line-height: 28pt;
}

.table2 tr td {
	color: #333333;
	height:20px;
}

-->
</style>
</head>
<body>
<%
	UserBean bean = (UserBean)request.getAttribute("user");
%>
<div align="center" class='headLine'><%=bean.getNickName() %>的个人资料</div>
	<table>
		<tr >
			<td rowspan="3" ><img src='<%=request.getContextPath()%>/web/img/photo/user<%=bean.getUserId() %>_2.png'></td>
		</tr>
		<tr>
			<td>${u.nickName}</td>
		</tr>
		<tr>
			<td>个性签名</td>
		</tr>

	</table>
<hr>
	<table class="table2"   >
		<tr align="left">
			<td align="left" width="10%">昵&nbsp;&nbsp;&nbsp;&nbsp;称：</td>
			<td width="14%">${u.nickName }</td>
			<td align="center" width="10%">备&nbsp;&nbsp;&nbsp;&nbsp;注：</td>
			<td width="20%"></td>
		</tr>
		
		
		<tr align="left">
			<td align="left" width="10%">Q&nbsp;&nbsp;&nbsp;&nbsp;Q：</td>
			<td width="14%">${u.qqNumber }</td>
			<td align="center" width="10%">电&nbsp;&nbsp;&nbsp;&nbsp;话：</td>
			<td width="20%">${u.mobile }</td>
		</tr>
		
		<tr align="left">
			<td align="left" width="10%">Email：</td>
			<td width="20%">${u.email }</td>
			<td align="center" width="10%">生&nbsp;&nbsp;&nbsp;&nbsp;日：</td>
			<td width="20%">${u.birthday }</td>
		</tr>
		
		<tr align="left">
			<td align="left" width="10%">住&nbsp;&nbsp;&nbsp;&nbsp;址：</td>
			<td width="14%">${u.address }</td>
			<td align="center" width="10%">院&nbsp;&nbsp;&nbsp;&nbsp;校：</td>
			<td width="20%"><%=bean.getUniversity() %></td>
		</tr>
		
		<tr align="left">
			<td align="left" width="10%">他的主页：</td>
			<td colspan="3"><a href="toHisIndexPage?userId=<%=bean.getUserId()%>" target="_blank" >点击访问他的主页</a></td>
		</tr>
		
		<tr align="left">
			<td align="left" width="10%">个性签名：</td>
			<td colspan=3 style="line-height: 14pt;">${u.personalWord }</td>
		</tr>
	
	
	
	</table>




</body>
</html>