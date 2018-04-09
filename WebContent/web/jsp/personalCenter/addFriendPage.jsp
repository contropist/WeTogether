<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page import="java.util.*"%>
<%@page import="com.wetogether.personalCenter.dto.*"%>
<%@page import="com.wetogether.common.hibernate.pojos.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="<%=request.getContextPath()%>/web/js/jquery.js"></script>
<script src="<%=request.getContextPath()%>/web/js/addNewFriendPage.js"></script>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/web/css/moudle_page.css" />
<style type="text/css">
<!--
body {
	background-color: white;
}

.formBody {
	position: absolute;
	left: 5%;
	top: 0%;
	height:80%;
	width: 100%;
/* 	border:1px solid white; */
	/* 			background-color:#CCCCCC; */
}
-->
</style>
<title>Add New Friend</title>
<script>

function changeSerachWay(){
	var serachWay = $("#serachWay").val();
	if(serachWay==1){
		$("#jingDiv").show();
		$("#mohuDiv").hide();
	}
	if(serachWay==2){
		$("#jingDiv").hide();
		$("#mohuDiv").show();
	}
}	

function subMohu(){
	window.mohuForm.submit();
	
}

function subJing(){
	window.basicForm.submit();
}
function changeArg(a0,a1,a2){
	$("#"+a1).val("");
	$("#"+a1).attr("readonly","readonly");
	$("#"+a2).val("");
	$("#"+a2).attr("readonly","readonly");
	$("#"+a0).attr("readonly",false);
}

function addFriend(){
	var checkBox = document.getElementsByName("foundUser");
	var userIds = "";
	for(var i = 0;i<checkBox.length;i++){
		 if((checkBox[i].type=="checkbox") && (checkBox[i].checked== true))      
         {
    			userIds = userIds+checkBox[i].value+",";
         }           
	}
	
	$.ajax({
		type : "POST",
		url : "/WeTogether/addNewFriendAction",
//		dataType : "json",
		data : "userIds=" + userIds,
		success:function(date){
			alert("添加好友成功！");
		},
	});
}
</script>

</head>
<body>
<s:action name="getAllUniversityAction" executeResult="false" />
	<input type="hidden" name="searchType" value="jing">
	<div class="formBody">
		<table cellpadding="5" cellspacing="0" width="100%" align="left" border="0" class="font2">
			<tr>
				<td align="left" width="30%" ><span class="font1">选择查询方式:</span></td>
				<td align="left"><select class="input" name="serachWay" id="serachWay" size="1" class="font2" onChange="changeSerachWay()">
				<option  value="1" class="font1" >精确查询 </option>
				<option  value="2" class="font1" >条件查询</option>
			</select>	</td>
			</tr>
		</table>
		
				
		<hr width="100%" align="center">
		<%
		String searchType = (String)request.getAttribute("searchType");
		if(searchType==null||searchType.equals("jing")){
			out.println("<div id=\"jingDiv\">");
			
		}else{
	%>
		<div id="jingDiv" style="display:none;">
	<%} %>
		<form name="basicForm" action="siftingAction" method="post" >
		<table cellpadding="5" cellspacing="0" width="100%" align="left" border="0" class="font2">
			<tr>
				<td width="30%"><input checked="checked"  onClick="changeArg('userId','chinaName','nickName')" name="type" type="radio"  />&nbsp;&nbsp;用户ID&nbsp;&nbsp;&nbsp;&nbsp; </td>
					<td>
						<s:textfield theme="simple"  cssClass="searchInput" id="userId" name="user.userId" ></s:textfield>	
<!-- 					<input class="searchInput" type="text" id="userId" name="user.userId" size="22" maxlength="22"> -->
				 </td>
			</tr>
			<tr>
				<td width="30%"><input onClick="changeArg('chinaName','userId','nickName')"  name="type" type="radio"  />&nbsp;&nbsp;中文姓名&nbsp;&nbsp;</td>
				<td>
				<s:textfield theme="simple" readonly="true" cssClass="searchInput" name="user.chinaName" id="chinaName" ></s:textfield>
<!-- 				<input readonly="readonly"  class="searchInput" type="text" name="user.chinaName" id="chinaName" size="22" maxlength="22"> -->
				 </td>
			</tr>
			<tr>
				<td width="30%"><input name="type"  type="radio" onClick="changeArg('nickName','userId','chinaName')"  />&nbsp;&nbsp;用户昵称&nbsp;&nbsp;</td>
				<td>
<!-- 				<input readonly="readonly"  class="searchInput" type="text" name="user.nickName" id="nickName" size="22" maxlength="22"> -->
				<s:textfield theme="simple" readonly="true" cssClass="searchInput" name="user.nickName" id="nickName" ></s:textfield>
				 </td>
			</tr>
			<tr>
				<td colspan="100%" align="left">
					<input type="button" onClick="subJing()" class="button" value="立即查询">
					<input type="reset" class="button" value="重置查询">		
				</td>
			</tr>
		</table>
	</form>
	</div>
	
	<%
		 searchType = (String)request.getAttribute("searchType");
		if(searchType!=null&&searchType.equals("mohu")){
			out.println("<div id=\"mohuDiv\">");
			
		}else{
	%>
		<div id="mohuDiv" style="display:none;">
	<%} %>
	
			<s:form action="siftingAction" name="mohuForm" method="post" theme="simple">
			<input type="hidden" name="searchType" value="mohu">
		<table cellpadding="5" cellspacing="0" width="100%" align="left" border="0" class="font1">
			<tr>
					<td width="30%" align="left">所属院校：</td>
					<td  align="left"><s:select id="university"
						headerValue="Please Select" headerKey="1"	cssClass="input" name="user.university.universityId" list="#request.univers"></s:select>
					</td>
				</tr>
			<tr>
						<td width="30%" align="left">性别：</td>
						<td  align="left"><s:select id="" cssClass="input"
								headerValue="Please Select" headerKey="1" name="user.gender" list="#{'1':'男','2':'女','3':'不明'} "></s:select></td>
					</tr>	
			<tr>
				<td colspan="100%" align="left">
					<input type="button" class="button" onClick="subMohu()" value="立即查询">
					<input type="reset" class="button" value="重置查询">		
				</td>
			</tr>		
		</table>
		</s:form>
	</div>
	
	<div id="displayUsers">
		<table cellpadding="4" cellspacing="0" width="440pt" align="left" border="1" bordercolor="white">
			<tr height="30pt" class="trHeader1">
				<td width="20pt" align="center">&nbsp;</td>
				<td width="45pt" align="center">好友ID</td>
				<td width="75pt" align="center">中文姓名</td>
				<td width="75pt" align="center">好友昵称</td>
				<td width="105pt" align="center">毕业院校</td>
			</tr>	
			<%
				List<User> users = (List)request.getAttribute("users");
				if(users == null){
					users = new ArrayList();
				}
				if(users.size()==0){%>
					<tr height="30pt">
						<td colspan="100%" align="center" style="background-color:#F0F8FF;"><span class="font1">Record Not Found</span></td>
					</tr>
				<% }
				int row = 1;
				for(int i = 0 ;i<users.size();i++){
					if(i>4){
						break;
					}
					User u = users.get(i);
					if(row%2!=0){
			%>
			<tr height="30pt" style="background-color:#F0F8FF;" >
			<%}else{ %>
			<tr height="30pt">
			<%} %>
				<td width="20pt" align="center"><input type="checkbox" value="<%=u.getUserId()%>" name="foundUser"></td>
				<td width="45pt" align="center"><%=u.getUserId()%></td>
				<td width="75pt" align="center"><%=u.getChinaName() %></td>
				<td width="75pt" align="center"><%=u.getNickName() %></td>
				<td width="105pt" align="center">
					<%
						if(u.getUniversity()==null){
							out.print("");
						}else{
							out.println(u.getUniversity().getUniversityName());
						}
					%>
				</td>
			</tr>	
			
		
			<% }%>
		</table>
		</div>
		<table cellpadding="6" cellspacing="6" border="0" >
				<tr>
					<td><input type="button" class="button" onClick="addFriend()" value="添加好友"> </td>
					<td><input type="button" class="button" onClick="" value="换一批"> </td>
				</tr>
			</table>
</div>
	
	
	
	
</body>
</html>