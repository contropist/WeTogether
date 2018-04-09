<%@page import="java.util.*"%>
<%@page import='java.text.SimpleDateFormat' %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()+ path + "/";
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="assets/css/bootstrap-combined.min.css" rel="stylesheet">
		<link href="assets/css/font-awesome.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
	function send(url) {
		top.document.getElementsByTagName("iframe")[0].src = urlnew Date() + "?r="
				+ Math.random();
	}
</script>
<style>
.content {
	margin: 100px;
}

#editor {
	resize: vertical;
	overflow: auto;
	border: 1px solid silver;
	border-radius: 5px;
	min-height: 100px;
	box-shadow: inset 0 0 10px silver;
	padding: 1em;
}

#editor2 {
	resize: vertical;
	overflow: auto;
	border: 1px solid silver;
	border-radius: 5px;
	min-height: 10px;
	width:80%;
	box-shadow: inset 0 0 10px silver;
	padding: 1em;
	margin-bottom: 10pt;
	font-size: 20pt;
	
}

.backgroundOfArticle {
	background-image: url(assets/img/lan.jpg);
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-position: center;
}
</style>
<title>WeTogether</title>
</head>
<%
	Integer categoryId =(Integer)request.getAttribute("categoryIdId");

%>
<body >
	<div id="header">
		<h1>
<%-- 				<jsp:include page="/web/jsp/personalCenter/centerMoudle.jsp"></jsp:include> --%>
		</h1>
	</div>

	<div id="user-nav" class="navbar navbar-inverseooopp">
		<ul class="nav btn-group">
			<li class="btn btn-inverse"><a title="" href="#"><i
					class="icon icon-user"></i> <span class="text"> 
					<!-- 					EL表达式获得session中的用户名 -->
						${sessionScope.sessionUser.userName}
				</span></a></li>
			<li class="btn btn-inverse dropdown" id="menu-messages"><a
				href="#" data-toggle="dropdown" data-target="#menu-messages"
				class="dropdown-toggle"><i class="icon icon-en<%=new Date() %>velope"></i> <span
					class="text">消息</span> <span class="label label-important">2</span>
					<b class="caret"></b></a>
				<ul class="dropdown-menu">
					<li><a class="sAdd" title="" href="#">预警信息</a></li>
					<li><a class="sInbox" title="" href="#">日志信息</a></li>
				</ul></li>
			<li class="btn btn-inverse"><a title="" href="#"><i
					class="icon icon-cog"></i> <span class="text">设置</span></a></li>
			<li class="btn btn-inverse"><a title=""
				href="<%=request.getContextPath()%>/web/login.jsp"><i
					class="icon icon-share-alt"></i> <span class="text">退出</span></a></li>
		</ul>
	</div>

	

<!-- 		<div id="style-switcher"> -->
<%-- 			<i class="icon-arrow-left icon-white"></i> <span>Style:</span> <a --%>
<!-- 				href="../#grey" -->
<!-- 				style="background-color: #555555; border-color: #aaaaaa;"></a> <a -->
<!-- 				href="./#blue" style="background-color: #2D2F57;"></a> <a href="./#red" -->
<!-- 				style="background-color: #673232;"></a> -->
<!-- 		</div> -->

<%-- 				<%@ include file="newArticleMoudle.jsp"%> --%>

				<div class="articleContent">
				
	        <div class="container-fluid">
	        	<div id='pad-wrapper'>
					<div id="editparent">
						<div id='editControls' class='span9' style=' padding:5px;'>
							<div class='btn-group'>
								<a class='btn' data-role='undo' href='#'><i class='icon-undo'></i></a>
								<a class='btn' data-role='redo' href='#'><i class='icon-repeat'></i></a>
							</div>
							<!-- <div class='btn-group'>
								<a class='btn' data-role='cut' href='#'><i class='icon-cut'></i></a>
								<a class='btn' data-role='copy' href='#'><i class='icon-copy'></i></a>
								<a class='btn' data-role='paste' href='#'><i class='icon-paste'></i></a>
							</div> -->
							<div class='btn-group'>
								<a class='btn' data-role='bold' href='#'><b>Bold</b></a>
								<a class='btn' data-role='italic' href='#'><em>Italic</em></a>
								<a class='btn' data-role='underline' href='#'><u><b>U</b></u></a>
								<a class='btn' data-role='strikeThrough' href='#'><strike>abc</strike></a>
							</div>
							<div class='btn-group'>
								<a class='btn' data-role='justifyLeft' href='#'><i class='icon-align-left'></i></a>
								<a class='btn' data-role='justifyCenter' href='#'><i class='icon-align-center'></i></a>
								<a class='btn' data-role='justifyRight' href='#'><i class='icon-align-right'></i></a>
								<a class='btn' data-role='justifyFull' href='#'><i class='icon-align-justify'></i></a>
							</div>
							<div class='btn-group'>
								<a class='btn' data-role='indent' href='#'><i class='icon-indent-right'></i></a>
								<a class='btn' data-role='outdent' href='#'><i class='icon-indent-left'></i></a>
							</div>
							<div class='btn-group'>
								<a class='btn' data-role='insertUnorderedList' href='#'><i class='icon-list-ul'></i></a>
								<a class='btn' data-role='insertOrderedList' href='#'><i class='icon-list-ol'></i></a>
							</div>
							<div class='btn-group'>
								<a class='btn' data-role='h1' href='#'>h<sup>1</sup></a>
								<a class='btn' data-role='h2' href='#'>h<sup>2</sup></a>
								<a class='btn' data-role='p' href='#'>p</a>
							</div>
							<div class='btn-group'>
								<a class='btn' data-role='subscript' href='#'><i class='icon-subscript'></i></a>
								<a class='btn' data-role='superscript' href='#'><i class='icon-superscript'></i></a>
							</div>
						</div>
						<div id='editor2' align="center" class='span9' style='' contenteditable>
						</div>
						<div id='editor' class='span9' style='' contenteditable>
							
							
						</div>
					</div>
				</div>
			</div>
			<div align="center">
			<table width="20%" class="" align="center" border="0" rules="none" cellpadding="10" cellspacing="10">
			<tr>
				<td><input type="button" class="button" value="发表日志" onClick="submitArticle(<%=request.getParameter("categoryId")%>)"></td>
				<td><input type="reset" class="button" value="重置内容" onClick = "resetArticleContent()"></td>
				<td><input type="button" class="button" value="关闭窗口" onClick = "closeWindow()"></td>
				<td id="beforeSend"></td>
			</tr>
			</table>
			</div>
		</div>
		<script src="assets/js/jquery.min.js"></script>
		<script src="assets/js/bootstrap.min.js"></script>
		<script src="assets/js/ArticleManager.js" ></script>
		<script>

			$(function() {
				$('#editControls a').click(function(e) {
					switch($(this).data('role')) {
						case 'h1':
						case 'h2':
						case 'p':
							document.execCommand('formatBlock', false, '<' + $(this).data('role') + '>');
							break;
						default:
							document.execCommand($(this).data('role'), false, null);
							break;
					}
					
				})
			});

		</script>

</body>
</html>