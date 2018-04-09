<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath()%>/web/css/bootstrap.min.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/web/css/bootstrap-responsive.min.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/web/css/unicorn.login.css" />
<title>WeTogether Login</title>
</head>
<body>
<%
	String message = (String) request.getAttribute("loginStatus");
	if (message != null) {
		String content = "<script>alert('" + message + "')</script>";
		out.println(content);
	}
%>
	<div id="logo">
				<img src="/WeTogether/web/img/logo.png" alt="" />
	</div>
	<div id="loginbox">
		<s:actionmessage/>
		<s:form id="loginform" class="form-vertical" action="loginAction" >
		<p>请输入您的用户名和密码！</p>
		<div class="control-group">
			<div class="controls">
				<div class="input-prepend">
					<span class="add-on"><i class="icon-user"></i></span><input
						type="text" name="loginBean.userName" placeholder="Username" />
				</div>
			</div>
		</div>
		<div class="control-group">
			<div class="controls">
				<div class="input-prepend">
					<span class="add-on"><i class="icon-lock"></i></span><input
						type="password" name="loginBean.password" placeholder="Password" />
				</div>
			</div>
		</div>
		<div class="form-actions">
			<span class="pull-left"><a href="#" class="flip-link"
				id="to-recover">忘记密码?</a></span> <span class="pull-right">
				<input
				type="button" class="btn btn-inverse" onClick="window.location.href='<%=request.getContextPath()%>/web/jsp/Register.jsp'" value="注册" />
				<input type="submit" class="btn btn-inverse" value="登陆" /></span>
		</div>
		</s:form>
		<form id="recoverform" action="#" class="form-vertical" >
		<p>请输入您的注册预留邮箱，我们将把您的密码发送到您的邮箱，请查收！</p>
		<div class="control-group">
			<div class="controls">
				<div class="input-prepend">
					<span class="add-on"><i class="icon-envelope"></i></span><input
						type="text" placeholder="E-mail address" />
				</div>
			</div>
		</div>
		<div class="form-actions">
			<span class="pull-left"><a href="#" class="flip-link"
				id="to-login">&lt; 返回</a></span> <span class="pull-right"><input
				type="submit" class="btn btn-inverse" value="发送" /></span>
		</div>
		</form>
	</div>

	<script src="<%=request.getContextPath()%>/web/js/jquery.min.js"></script>
	<script src="<%=request.getContextPath()%>/web/js/unicorn.login.js"></script>

</body>
</html>