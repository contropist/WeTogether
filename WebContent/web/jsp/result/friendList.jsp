<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<s:iterator value="friends" var="friend">
		<!-- 						迭代出所有好友到好友列表 -->

		<li id="${friend.friendUser.userId}">
<%-- 		<a href="#?friendId=${friend.friendUser.userId}" onClick="openFriendMessagePage(${friend.friendUser.userId})"  style="font-size: 20pt;"> <s:property value="#friend.friendUser.nickName" /></a>  --%>
<%-- 			<a href="http://localhost:8080/WeTogether/web/jsp/ChatRoom/chatRoom.jsp?friendId=${friend.friendUser.userId}"   style="float:none;" >管理</a> --%>
		<table cellpadding="3" cellspacing="3" width="100%" align="center" border="0" >
			<tr>
				<td width="70%" align="left"><a href="#" onClick="openFriendMessagePage(${friend.friendUser.userId})"  style="font-size: 12pt;"> <s:property value="#friend.friendUser.nickName" /></a> </td>
				<td align="left"><input type="button" value="ChatNow"  class="button" onClick="chatNow(${friend.friendUser.userId})"></td>
			</tr>
		
		</table>
		
		</li>

	</s:iterator>
</body>
</html>