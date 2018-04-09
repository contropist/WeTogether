<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.wetogether.common.util.PubUtil.DateFormater"%>     
<%@page import="java.util.*"%>
<%@page import="com.wetogether.common.hibernate.pojos.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="<%=request.getContextPath()%>/web/js/jquery.min.js"></script>	
<style>

#editor {
	resize: vertical;
	overflow: auto;
	border: 1px solid silver;
	border-radius: 5px;
	min-height: 100px;
	box-shadow: inset 0 0 10px silver;
	padding: 1em;
	font-size: 15pt;
	color:white;
} 
#editor2 {
	resize: vertical;
	overflow: auto;
	border: 1px solid silver;
	border-radius: 5px;
	min-height: 10px;
	width:88%;
	box-shadow: inset 0 0 10px silver;
	padding: 1em;
	margin-bottom: 10pt;
/* 	font-size: 20pt; */
	
}
.commentContent{
	position: absolute;
	height: auto;
	top: 20%;
	width: 60%;
	left: 20%;
}

.bbsContent{
	position:relative;
	top:10%;
	resize: vertical;
	overflow: auto;
	border: 1px solid silver;
	border-radius: 5px;
	min-height: 10px;
	width:88%;
	box-shadow: inset 0 0 10px silver;
	padding: 1em;
	margin-bottom: 10pt;
/* 	font-size: 20pt; */
}

</style>
<title>XXX的留言板</title>
</head>
<body>
	<jsp:include page="/web/othersSpace/moudle2.jsp"></jsp:include>

	<div class="commentContent">
			<div style="z-index: 9999999">
				<jsp:include page="/web/jsp/personalCenter/OsFaceText.jsp"></jsp:include>
			</div>
	
			<div class="bbsContent">
				<%
					List<BBS> bbss = (List)request.getAttribute("bbss");
					Integer size = bbss.size();
					for(int i = 0 ; i<bbss.size();i++){
					BBS bbs = bbss.get(i);
					String date = DateFormater.formater(bbs.getSubDate(), DateFormater.DATETIME4);
				%>
			
				<table cellpadding="5" cellspacing="5" id="editor" width="100%" align="left" border="1" rules="none">
					<tr>
						<td rowspan="3" valign="top">
							<a href="">
								<img src='<%=request.getContextPath()%>/web/img/photo/user<%=bbs.getCommenter().getUserId() %>_2.png' title="点击访问他的空间" onClick="toHisSpace(<%=bbs.getCommenter().getUserId()%>)" >
							</a>
						<br><span style="color:red;"><%=bbs.getCommenter().getNickName() %></span>									
						
						</td>
					</tr>
					<tr height="20pt" style="font-size:12pt;color:grey;">
						<td width="50%">&nbsp;</td>
						<td width="30%" align="right"><%=date %></td>
						<td width="20%" align="right">第<%out.print(size-i); %>楼</td>
					</tr>
					<tr>
						<td colspan="100%" align="left"><%=bbs.getBbsCotent() %></td>
					</tr>
				
				</table>
				<br>&nbsp;<br>
				
				<%} %>
			</div>
	
	</div>

	<script>
	function submit(){
		var userId = document.getElementById("sessionUserId").value;
		var content = $("#saytext").val();
		if(content==""||content.replace(/\s+/g,"")==""){
			alert("留言内容不能为空  ￣へ￣");
			return false;
		}
			 $.ajax({
					type : "POST",
					url : "/WeTogether/InsertBbs",
// 					dataType : "json",
					data : "userId="+userId+"&bbs.bbsCotent="+content,
					success:function(date){
						alert("留言成功");
						window.location.reload();
					},
				});
			
// 			window.location.href="CommentArticle?articleId="+articleId+"&commentContent="+comment;
		}
		
		function  resetContent(){
			document.getElementById("editor2").innerHTML="";
		}
		
		function toHisSpace(userId){
			var url="toHisIndexPage?userId="+userId;
			 window.open(url,'XXXX',   '   toolbar=yes,   menubar=yes,   scrollbars=yes, resizable=yes, location=yes,   status=no'); 
//			window.location.href="toHisIndexPage?userId="+userId;
		}
	
	</script>

	
</body>
</html>