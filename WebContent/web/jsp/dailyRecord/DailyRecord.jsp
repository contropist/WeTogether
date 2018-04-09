<%@page import="com.wetogether.personalCenter.dto.ArticleBean"%>
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
<title>XX的空间日志</title>
<script language="javascript">


</script>
<style type="text/css">
a:link {color: none} /* 未访问的链接 */
a:visited {color: none} /* 已访问的链接 */
a:hover {color: #FF00FF} /* 鼠标移动到链接上 */
a:active {color: #0000FF} /* 选定的链接 */
</style>
</head>
<body>
	<jsp:include page="/web/jsp/moudle.jsp"></jsp:include>
	<div id="content">
		<div class="leftSide">
			<!-- 			左侧边框内容 -->
		<jsp:include page="/web/jsp/LeftSide.jsp"></jsp:include>

		</div>
		<%
		ArticleVOs vo = (ArticleVOs)request.getAttribute("articleVOs");		
		Integer caId = vo.getCateroryId();
		%>
		
		
		
		<div class="articleBody">
			
			<table width="100%" class=""  border="0" rules="none" cellpadding="0" cellspacing="10">
			<tr class="categoryTr"><td colspan="100%">
				<table width="100%" align="center" border="0" rules="none" cellpadding="10" cellspacing="10">
					<tr align="center" id="articleCategoryTr">
						<td id="ca1" class="currentTd" ><a  href="#" id="ca1a" onClick="changeCategory(1,1)" >技术论文</a></td>
						<td id="ca2"><a  href="#" id="ca2a" onClick="changeCategory(1,2)"  >学习笔记</a></td>
						<td id="ca3"><a  href="#" id="ca3a" onClick="changeCategory(1,3)" >个人日志</a></td>
						<td id="ca4" ><a  href="#" id="ca4a" onClick="changeCategory(1,4)" >情感天地</a></td>
						<td id="ca5" ><a  href="#" id="ca5a" onClick="changeCategory(1,5)" >随笔</a></td>
						<td id="ca6" ><a href="#" id="ca6a" onClick="changeCategory(1,6)"  >杂文</a></td>
					</tr>	
				</table>
			</td></tr>
			<tr>
				<td colspan="100%" id="articleList">
					<table align="center"  width="100%" cellpadding="0" cellspacing="0" border="0" >
						
					<%
						for(int i = 0 ;i<vo.getBeans().size();i++){
							ArticleBean bean = vo.getBeans().get(i);
					%>	
					<!-- 						迭代出所有文章 -->

					<tr> <td align='center' width="50%" > <a href="showArticleByArticleId?article.articleId=<%=bean.getArticleId() %>" target="_blank" ><%=bean.getArticleName() %></a></td>
						<td align='center'><%=bean.getSubDate() %> </td>
						<td align='center' >
						<a href=""><span style='font-size:16px; color:#666666'>编辑</span></a>&nbsp;
						<a href="#" onClick="removeArticle(<%=bean.getArticleId()%>)"><span style='font-size:16px; color:#666666'>删除</span></a> </td>
						<td align='center'><%=bean.getCommentsCount() %>/<%=bean.getClickTime() %></td>
						</tr>

				<%
						}
				%>
					</table>
				
				</td>
			
			</tr>
				
				<tr><td colspan="100%"><hr color="blue" dir="ltr" size="3"></td></tr>
						
						
<!-- 						放分页的地方 -->
						<tr><td colspan="100%">
								<table width="100%" align="center" border="0" rules="none" cellpadding="0" cellspacing="0">
									<tr align="center">
										<td id="pageCount">当前第<%=vo.getPage().getCurrentPage() %>/<%=vo.getPage().getTotalPages()%>页</td>
										<td id="firstPage"><%=vo.getPage().getFirstPageUrl() %></td>
										<td id="previousPage"><%=vo.getPage().getPreviousPageUrl() %></td>	
										<td id="nextPage"><%=vo.getPage().getNextPageUrl() %></td>
										<td id="lastPage"><%=vo.getPage().getLastPageUrl() %></td>
									</tr>
								
								</table>
						</td></tr>
						
						<tr align="center">
						<td colspan="100%">
							<a href="/WeTogether/web/jsp/dailyRecord/newArticle.jsp?categoryId=<%=caId%>" id="newArticlePic"><img alt="New Article" src="/WeTogether/web/img/newArticle.png"></a>
						</td>
					</tr>
			</table>
					
			
			
			
		</div>
		
		
		

	</div>
</body>
</html>