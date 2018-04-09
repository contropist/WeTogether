<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.wetogether.common.hibernate.pojos.*"%>  
<%@page import="java.util.*"%>  
<%@ taglib prefix="s" uri="/struts-tags" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/web/css/moudle_page.css" />
<script src="<%=request.getContextPath()%>/web/js/jquery.min.js"></script>	

<script type="text/javascript">
	function send(url) {
		top.document.getElementsByTagName("iframe")[0].src = urlnew Date() + "?r="
				+ Math.random();
	}
</script>
<style>
.content {
	position: absolute;
	top: 50pt;
	left: 20%;
	width:60%;
	height:auto;
	background-color: none;
}
.article{
	position: relative;
	top: 0pt;
	left: 0%;
	width:100%;
	height:auto;
	background-color: none;
}
.comments{
	position: relative;
	top: 30pt;
	left: 0%;
	width:100%;
	height:auto;
	background-color: none;
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
	width:100%;
	box-shadow: inset 0 0 10px silver;
	padding: 1em;
	margin-bottom: 10pt;
	font-size: 20pt;
	
}

.backgroundOfArticle {
	background-image: url("/WeTogether/web/jsp/dailyRecord/assets/img/lan.jpg");
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-position: center;
}
</style>
<title>${articleBean.articleName }</title>
</head>
<body class="backgroundOfArticle" >
	<input type="hidden" id="articleId" value="${articleBean.articleId }">
	<div class="content">
		<div class="article">
				<table align="center" style="border-style:dashed;  ;border-color: yellow;" cellpadding="0" cellspacing="0" border="1" rules="none" width="100%">
					<tr><td width="100%" align="center"><h1>${articleBean.articleName }</h1></td></tr>
					<tr><td width="80%"><hr color="grey" width="80%" align="center"></td></tr>
					<tr><td align="center">${articleBean.articleContent }</td></tr>
				
				</table>
		
		
		</div>
		<div class="comments">
		<s:action name="showCommentOfArticle" executeResult="false">
			<s:param name="articleId">${articleBean.articleId  }</s:param>
		</s:action>
			<%
				List<CommentOfArticle> comments = (List)request.getAttribute("comments");
				for(int i = 0 ;i<comments.size();i++){
					CommentOfArticle comment = comments.get(i);
			
			%>
			<p id="firstComment"></p>	
				<table align="center" cellpadding="1" cellspacing="5" border="1" rules="none" style="border-style:dashed;  border-color: yellow;"  width="100%">
					<tr>
						<td rowspan="100%" width="10%" valign="top" >
							<img src='<%=request.getContextPath()%>/web/img/photo/user<%=comment.getCommenter().getUserId() %>_2.png'>	
							<br><span style="color:red;"><%=comment.getCommenter().getNickName() %></span>					
						</td>
						<td align="right" height="20pt;"><%=comment.getSubDate() %></td>
					</tr>
					
					<tr >
						<td valign="top"><%=comment.getCommentContent() %></td>
					
					</tr>
				
				</table>
				<br>&nbsp;
				<%} %>

<!-- 				评论框 -->

			<div style="z-index: 9999999">
				<jsp:include page="/web/jsp/personalCenter/OsFaceText.jsp"></jsp:include>
			</div>

<!-- end -->
		</div>
		

	</div>

	<script>
		function submit(){
			var articleId = document.getElementById("articleId").value;
			var comment = $("#saytext").val();
// 			var comment = document.getElementById("editor2").innerHTML;
			 $.ajax({
					type : "POST",
					url : "/WeTogether/CommentArticle",
					dataType : "json",
					data : "articleId="+articleId+"&commentContent="+comment,
					success:function(date){
						alert("评论成功 ∩_∩");
						$("#saytext").val("");
						var content = "<table align=\"center\" cellpadding=\"1\" cellspacing=\"10\" border=\"1\" rules=\"none\" style=\"border-style:dashed;  border-color: yellow;\"  width=\"100%\">";
						content = content+"<tr><td rowspan=\"100%\" width=\"10%\" valign=\"top\" >";
						content = content+"<img src='/WeTogether/web/img/photo/user"+date.commentUserId+"_2.png'>";
						content = content+"<br><span style=\"color:red;\">"+date.commenterName+"</span>";
						content = content+"</td><td align=\"right\" height=\"20pt;\">"+date.commentDate+"</td></tr><tr>";
						content = content+"<td valign=\"top\">"+date.commentContent+"</td></tr></table><br>&nbsp;";
						$("#firstComment").after(content);
// 						window.location.reload();
					},
				});
			
// 			window.location.href="CommentArticle?articleId="+articleId+"&commentContent="+comment;
		}
		
		function  resetContent(){
			document.getElementById("editor2").innerHTML="";
		}
	
	</script>


</body>
</html>