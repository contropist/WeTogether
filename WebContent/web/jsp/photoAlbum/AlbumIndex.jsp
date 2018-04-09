<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>	
<%@page import="com.wetogether.personalCenter.dto.*"%>
<%@page import="com.wetogether.personalCenter.vo.*"%>
<%@page import="com.wetogether.common.hibernate.pojos.*"%>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath()%>/web/css/main_page.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/web/css/AlbumIndex_page.css" />
<script src="<%=request.getContextPath()%>/web/js/AlbumIndex_page.js"></script>	

<title>个人主页</title>
</head>
<body>
<%@ include file="/web/jsp/moudle.jsp"%>
	<div id="content">
		<div class="leftSide">

				<jsp:include page="/web/jsp/LeftSide.jsp"></jsp:include>
		</div>
		
		
		<div class="albumBody">
			<table cellpadding="5" cellspacing="0" border="0" >
				<tr>
					<td >
						<table border="0" cellpadding="6" cellspacing="0" >
								<tr><td><input type="button" value="上传照片" class="button"></td></tr>
						</table>
					</td>
					
					<td>
						<table border="0" cellpadding="6" cellspacing="0" >
								<tr><td><input type="button" value="新建相册" onClick="newAlbum()" class="button"></td></tr>
						</table>
					</td>
					
					<td>
						<table border="0" cellpadding="6" cellspacing="0" >
							<tr><td><input type="button" value="批量管理" class="button"></td></tr>
						</table>
					</td>
				
				</tr>
			
			</table>
			
			<table width="90%" border="0" cellpadding="15" cellspacing="5" align="center" id="albumTable">
				<tr>
				<%
					AlbumBean bean = (AlbumBean)request.getAttribute("albumBean");
						for(int i = 0;i<bean.getAlbums().size();i++){
							if(i==4){
								break;
							}
							AlbumVo vo = bean.getAlbums().get(i);
				%>
				<td align="center"><a href="showPhotoAction?bean.page.currentPage=1&bean.album.albumId=<%=vo.getAlbumId() %>">
					<img src="<%=vo.getIndexPhoto() %>" title="<%=vo.getAlbumDesc() %>" style="width:150px;height:150px;"></a>
					<br><%=vo.getAlbunName() %>(<%=vo.getPhotos().size() %>)
				</td>
				<%} %>
				</tr>
				<%if(bean.getAlbums().size()>4){%>
				<tr>
				<% 
				for(int j = 4;j<bean.getAlbums().size();j++){
					AlbumVo vo2 = bean.getAlbums().get(j);
				%>
				<td align="center"><a href="showPhotoAction?bean.page.currentPage=1&bean.album.albumId=<%=vo2.getAlbumId() %>" >
				<img src="<%=vo2.getIndexPhoto() %>" title="<%=vo2.getAlbumDesc() %>"  style="width:150px;height:150px;"></a>
				<br>
				<%=vo2.getAlbunName() %>(<%=vo2.getPhotos().size() %>)
				</td>
				<%} %>
				</tr>
				<% }%>
						
			</table>
				<hr>	
				<div class="pageDivideBar">
				<table style="margin: 30px auto 30px 50px;" cellpadding="4"
								bgcolor="#E2E8ED">
								<tr>
									<td>
									第<s:property value="albumBean.page.currentPage" />/<s:property
											value="albumBean.page.totalPages" />页 
									</td>
									<td>
									<s:if test="%{albumBean.page.currentPage==1}">
									首页 上一页
									</s:if>
									    <s:elseif test="%{albumBean.page==null}">首页 上一页</s:elseif>
										<s:else>
											<a href="showAlbumAction?albumBean.page.currentPage=1">首页</a>
											<a href="showAlbumAction?albumBean.page.currentPage=${albumBean.page.currentPage-1}">上一页</a>
										</s:else>
										</td>
									<td>
									<s:if test="%{albumBean.page.currentPage!=albumBean.page.totalPages}"> 
											<a href="showAlbumAction?albumBean.page.currentPage=${albumBean.page.currentPage+1}">下一页</a> 
											<a href="showAlbumAction?albumBean.page.currentPage=${albumBean.page.totalPages}">尾页</a> 
 										</s:if> 
 										<s:else> 
										下一页 尾页
 										</s:else> 
										</td>
								</tr>
							</table>
						</div>	
		</div>
	
	
		
		<div class="newAlnumDiv" id="newAlnumDiv" style="display: none;">
<!-- 		新建相册的DIV -->
			<table width="100%" cellpadding="0" cellspacing="0" border="0">
				<tr height="40pt;" align="center" style="background-color: grey;font-size:16pt;color:white;">
					<td>创建相册</td>
				</tr>
			</table>
			<br>
			<table cellpadding="5" cellspacing="10" border="0" width="90%" align="center">
				<tr>
					<td width="30%" align="left" class="font1">相册名称：</td>
					<td width="70%"><input id="newAlbumName" type="text" name="newAlbumName" size="20" maxlength="20" placeholder="请输入相册名称"></td>
				</tr>
				<tr>
					<td width="30%" align="left" class="font1" valign="top">相册描述：</td>
					<td>
						<textarea id="newAlbumDesc" onInput="return checkTextareaLength()"  name="newAlbumDesc" style="width: 206px;height: 93px;"></textarea>
					</td>
				</tr>
			</table>
			<hr>
			<table cellpadding="5" cellspacing="0" width="100%" align="center" border="0">
				<tr>
					<td align="right"><input type="button" class="button" onClick="subNewAlbum()" value="&nbsp;确&nbsp;定&nbsp;"></td>
					<td align="left"><input type="button" class="button" onClick="resetNewAlbum()" value="&nbsp;取&nbsp;消&nbsp;"></td>
				</tr>
			</table>
		</div>
		
		
			
	</div>
	
	
	
	
	
<script src="<%=request.getContextPath()%>/web/js/main_page.js"></script>	
	
	
</body>
</html>

