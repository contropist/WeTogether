<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.wetogether.common.util.PubUtil.DateFormater"%>
<%@page import="java.text.Format"%>
<%@page import="java.util.*"%>
<%@page import="com.wetogether.personalCenter.dto.*"%>
<%@page import="com.wetogether.common.hibernate.pojos.*"%>	
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath()%>/web/css/main_page.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/web/css/my_center.css" />
<script src="<%=request.getContextPath()%>/web/js/myCenter_page.js"></script>
<title>我的好友动态</title>
<style>
.editor {
	height:20pt;
	width:400pt;
	resize: vertical;
	overflow: auto;
	border: 1px solid silver;
	border-radius: 5px;
	box-shadow: inset 0 0 10px silver;
	color:blue;
}
.commentArea{
	background-color:#8470FF;
	border-style:dotted;
	box-shadow:7px 7px 15px #CCCCCC;
/* 	border-radius:50px; */
	color:white;
}

</style>
</head>
<body>
	<jsp:include page="/web/jsp/moudle.jsp"></jsp:include>
	<div id="content">
		<div class="leftSide">
			<!-- 			左侧边框内容 -->
		<jsp:include page="/web/jsp/LeftSide.jsp"></jsp:include>

		</div>

		<div class="ossBody">
				<%
					List oss = ((OSsBean)request.getAttribute("allOSsBean")).getOss();
					String thisOsTime;
					for(int i = 0;i<oss.size();i++){
						OriginalSignature os = (OriginalSignature)oss.get(i);
						thisOsTime = DateFormater.getTimeOrDate(os.getOsSubmitDate()); 
				%>
					<table cellpadding="10" cellspacing="2" width="95%" border="1" rules="none" style="border-style:dashed;" bordercolor="#428bca" align="center">
						<tr >
						<td rowspan='3' valign='top' style="color:red;">
						<a href="">
						<img src='<%=request.getContextPath()%>/web/img/photo/user<%=os.getOsOwer().getUserId() %>_2.png' title="点击访问他的空间" onClick="toHisSpace(<%=os.getOsOwer().getUserId()%>)">
						</a>
						<%=os.getOsOwer().getUserName() %></td>	
						
						</tr>
					
						<tr>
							<td><%=os.getOsContent() %></td>
<%-- 						<td>${os.osContent }</td> --%>
						</tr>
					<tr ><td align='right' width='95%'>
<%-- 					${os.osSubmitDate}	 --%>
						<%=thisOsTime %>&nbsp;
						<a href='##' onClick="zanOs(<%=os.getOriginalSignatureId()%>)">赞(<span id="zanSize<%=os.getOriginalSignatureId() %>"><%=os.getZans().size()%></span>)</a>&nbsp;&nbsp;&nbsp;&nbsp;
						<a href='##' onClick="showCommentArea(<%=os.getOriginalSignatureId()%>)">评论(<span id="commentsSize<%=os.getOriginalSignatureId() %>"><%=os.getComments().size() %></span>)</a>
						</td>
					</tr>
<!-- 					下面这个tr是评论区，一般是隐藏的 -->
					<tr id="CommentsArea<%=os.getOriginalSignatureId() %>" style="display: none;">
						<td colspan="100%" align="center">
							<table  width="100%" align="center" cellpadding="0" cellspacing="0" border="0" rules="none" class="commentArea" bordercolor="#428bca"  >
								<%
// 									List osComments = os.getComments();
									Set osComments = os.getComments();
									Iterator it = osComments.iterator();
									if(osComments.size()==0){
								%>
								<tr id="noComment<%=os.getOriginalSignatureId() %>">
									<td width="100%" align="center">
										暂无评论
									</td>
								<tr>
								<%
								}else{
								%>
									<tr>
										<td>
											<%
											while(it.hasNext()){
												Comment comment = (Comment)it.next();
												String commentTime = DateFormater.getTimeOrDate(comment.getCommentTime());
											%>
											<table cellpadding="0" cellspacing="0" width="100%" border="0" rules="none"   align="center">
												<tr>
													<td rowspan="3"  valign='top' align="center" style="color: red;"><img
														src='<%=request.getContextPath()%>/web/img/photo/user<%=comment.getCommentUser().getUserId() %>_3.png'><%=comment.getCommentUser().getUserName() %></td>
												</tr>

												<tr>
													<td><%=comment.getCommentContent()%></td>
												</tr>
												<tr>
													<td align='right' width='95%'>
														<%=commentTime %>
													</td>
												</tr>
	

									</table>
									<hr width="100%" color="white">
											<%} %>
										</td>
									</tr>
								<%} %>
								
								<tr id="newCommentTr<%=os.getOriginalSignatureId()%>">
									<td width="100%" align="center">
										<textarea class="editor" id="newComment<%=os.getOriginalSignatureId()%>">
										
										</textarea>

										<input class="button" type="button" value="快速评论" onClick="subComment(<%=os.getOriginalSignatureId()%>)">
									</td>
								<tr>
							</table>
						
						</td>
					</tr>
					</table>
					<br>
					<%} %>
			
			
			
			
			
		</div>




<div class="pageDivide">
			
				<table style="margin: 30px auto 30px 50px;" cellpadding="4"
								bgcolor="#E2E8ED">
								<tr>
									<td>
									第<s:property value="allOSsBean.page.currentPage" />/<s:property
											value="allOSsBean.page.totalPages" />页 
									</td>
									<td>
									<s:if test="%{allOSsBean.page.currentPage==1}">
									首页 上一页
									</s:if>
									    <s:elseif test="%{allOSsBean.page==null}">首页 上一页</s:elseif>
										<s:else>
											<a href="showFriendOSsAction?allOSsBean.page.currentPage=1">首页</a>
											<a href="showFriendOSsAction?allOSsBean.page.currentPage=${allOSsBean.page.currentPage-1}">上一页</a>
										</s:else>
										</td>
									<td>
									<s:if test="%{allOSsBean.page.currentPage!=allOSsBean.page.totalPages}"> 
											<a href="showFriendOSsAction?allOSsBean.page.currentPage=${allOSsBean.page.currentPage+1}">下一页</a> 
											<a href="showFriendOSsAction?allOSsBean.page.currentPage=${allOSsBean.page.totalPages}">尾页</a> 
 										</s:if> 
 										<s:else> 
										下一页 尾页
 										</s:else> 
										</td>
								</tr>
							</table>
			
			</div>
		

	</div>
</body>
</html>