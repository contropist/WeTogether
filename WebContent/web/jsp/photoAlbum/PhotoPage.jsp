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
<!-- 和AlbumIndex.jsp公用一个JS -->
<script src="<%=request.getContextPath()%>/web/js/AlbumIndex_page.js"></script>	
<script>
function big(pic){
	$("#"+pic).css({"width":"500px","height":"500px"});
}
function small(pic){
	$("#"+pic).css({"width":"250px","height":"250px"});
}
</script>
<title>XXX的相册</title>
</head>
<body>
<%@ include file="/web/jsp/moudle.jsp"%>
	<div id="content">
	<%
		PhotoBean bean = (PhotoBean)request.getAttribute("photoBean");
		List<Photo> photos = bean.getPhotos();
		Integer AlbumId = bean.getAlbum().getAlbumId();
	%>
		
		<div class="albumBody">
			<table cellpadding="5" cellspacing="0" border="0" >
				<tr>
				
				<td width="15%" align="left">&nbsp;</td>
					<td>
						<table border="0" cellpadding="6" cellspacing="0" >
							<tr>
								<td class="font1"><a href="showAlbumAction?albumBean.page.currentPage=1"> 
								<img src="/WeTogether/web/img/GoBack.jpg" style="width: 40px; height: 40px;">
								</a></td>
							</tr>
						</table>
					</td>
					<td >
						<table border="0" cellpadding="6" cellspacing="0" >
								<tr><td><input type="button" value="上传照片" onClick="uploadPhoto()" class="button"></td></tr>
						</table>
					</td>
					
					<td>
						<table border="0" cellpadding="6" cellspacing="0" >
								<tr><td><input type="button" value="新建相册" onClick="newAlbum()" class="button"></td></tr>
						</table>
					</td>
					
					
				
				</tr>
			
			</table>
			
			<table width="90%" border="0" cellpadding="15" cellspacing="5" align="center">
				<tr>
				<%
						for(int i = 0;i<photos.size();i++){
							if(i==4){
								break;
							}
							Photo p1 = photos.get(i);
				%>
				<td align="center"><a href="#"><img src="<%=p1.getPhotoSrc() %>" id="pic<%=p1.getPhotoId() %>" title="<%=p1.getPhotoName() %>" onmouseout="small('pic<%=p1.getPhotoId() %>')" onmouseover="big('pic<%=p1.getPhotoId() %>')" style="width:250px;height:250px;"> </a>
					<br><span><a href="#" onClick="setAlbumPage(<%=p1.getPhotoId()%>)">设为封面</a></span>
					<span><a href="#" onClick="deletePhoto(<%=p1.getPhotoId()%>)">删除</a></span>
				
				</td>
				<%} %>
				</tr>
				<%if(photos.size()>4){%>
				<tr>
				<% 
				for(int j = 4;j<photos.size();j++){
					Photo p2 = photos.get(j);
				%>
				<td align="center"><a href="#"><img src="<%=p2.getPhotoSrc() %>" id="pic<%=p2.getPhotoId() %>" title="<%=p2.getPhotoName() %>" onmouseout="small('pic<%=p2.getPhotoId() %>')" onmouseover="big('pic<%=p2.getPhotoId() %>')" style="width:250px;height:250px;"> </a>
				<br><span><a href="#" onClick="setAlbumPage(<%=p2.getPhotoId()%>)">设为封面</a></span>
				<span><a href="#" onClick="deletePhoto(<%=p2.getPhotoId()%>)">删除</a></span>
				</td>
				<%} %>
				</tr>
				<% }%>
						
			</table>
				<hr>	
				<div class="pageDivideBarOfPhoto">
				<table style="margin: 30px auto 30px 50px;" cellpadding="4"
								bgcolor="#E2E8ED">
								<tr>
									<td>
									第<s:property value="bean.page.currentPage" />/<s:property
											value="bean.page.totalPages" />页 
									</td>
									<td>
									<s:if test="%{bean.page.currentPage==1}">
									首页 上一页
									</s:if>
									    <s:elseif test="%{bean.page==null}">首页 上一页</s:elseif>
										<s:else>
											<a href="showPhotoAction?bean.page.currentPage=1&bean.album.albumId=<%=AlbumId%>">首页</a>
											<a href="showPhotoAction?bean.album.albumId=<%=AlbumId%>&bean.page.currentPage=${bean.page.currentPage-1}">上一页</a>
										</s:else>
										</td>
									<td>
									<s:if test="%{bean.page.currentPage!=bean.page.totalPages}"> 
											<a href="showPhotoAction?bean.album.albumId=<%=AlbumId%>&bean.page.currentPage=${bean.page.currentPage+1}">下一页</a> 
											<a href="showPhotoAction?bean.album.albumId=<%=AlbumId%>&bean.page.currentPage=${bean.page.totalPages}">尾页</a> 
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
		
		
		<div class="newPhotoDiv" id="uploadPhotoDiv" style="display: none;" >
		<s:form action="uploadPhotoAction" method="post" enctype="multipart/form-data"  >
<!-- 		上传图片的DIV -->
			<input type="hidden" name="albumId" value="<%=AlbumId%>">
			<table width="100%" cellpadding="0" cellspacing="0" border="0">
				<tr height="40pt;" align="center" style="background-color: grey;font-size:16pt;color:white;">
					<td>图片上传</td>
				</tr>
			</table>
			<br>
			<table cellpadding="5" cellspacing="10" border="0" width="90%" align="center">
				<tr>
					<td> <s:file name="file" label="图片1"></s:file></td>
				</tr>
				
				<tr>
					<td> <s:file name="file" label="图片2"></s:file></td>
				</tr>
				<tr>
					<td> <s:file name="file" label="图片3"></s:file></td>
				</tr>
				<tr>
					<td> <s:file name="file" label="图片4"></s:file></td>
				</tr>
			</table>
			<hr>
			<table cellpadding="5" cellspacing="0" width="100%" align="center" border="0">
				<tr>
					<td align="right"><input type="submit" class="button"  value="&nbsp;上&nbsp;传&nbsp;"></td>
					<td align="left"><input type="button" class="button" onClick="resetNewPhoto()" value="&nbsp;取&nbsp;消&nbsp;"></td>
				</tr>
			</table>
			</s:form>  
		</div>
		 
		
			
	</div>
	
	
	
	
	
<script src="<%=request.getContextPath()%>/web/js/main_page.js"></script>	
	
	
</body>
</html>

