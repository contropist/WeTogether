<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.wetogether.common.hibernate.pojos.User"%>
<%@ taglib prefix="s" uri="/struts-tags" %>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="assets/js/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/web/css/centerMoudle.css" />
<style type="text/css" media="screen">
.personalWord {
	width: 86%;
	color:red;
	background-color: red;
}

.cutPhotoBody {
	position: absolute;
	top: 40pt;
	left: 140pt;
	z-index: 101;
	display: none;
}

#flashContent {
	width: 100%;
	height: 100%;
}
.messageBody{
	position:relative;
	margin:10pt;
}
</style>
<script type="text/javascript" src="<%=request.getContextPath()%>/web/jsp/MessageManager/swfobject.js"></script>
<title>个人主页</title>
</head>
<body>
<%@ include file="/web/jsp/moudle.jsp"%>

<s:action name="getAllUniversityAction" executeResult="false" />
<%
	User user = (User)request.getAttribute("user");
	if(user.getUniversity()==null){
		University uni = new University();
		uni.setUniversityId(1);
		user.setUniversity(uni);
	}
	Integer univerId = user.getUniversity().getUniversityId();
	String message = (String)request.getAttribute("message");
	if(message!=null){
		String content = "<script>alert('"+message+"')</script>";
		out.println(content);
	}
%>

<s:action name="getColleges" executeResult="false" >
	<s:param name="university.universityId"><%=univerId %></s:param>
</s:action>
	<div id="content">

		<div class="cutPhotoBody" id="cutPhotoBody" >
			<table border="1" width="10%" style="background-color: #CCCCCC;">
				<tr>
					<td>
						<div style="position: absolute; left: 200pt; top: 100pt;"
							id="altContent"></div>
					</td>
				</tr>


			</table>
		</div>
		<!-- 		<div> -->
<!-- 			<input type="button" onclick="swfobject.getObjectById('FaustCplus').jscall_updateAvatar();" value="JS Call Upload"/> -->
<!-- 		</div> -->
<!-- 		<div id="avatar_priview"></div> -->

		
		<script type="text/javascript">
		
		//控制图片剪切器的隐显，以及更换头像后立即显示新头像
		function changePhoto(clickType){
			$("#cutPhotoBody").toggle();
			if(clickType=="afterSuccess"){
				window.location.reload();
			}
			
		}

			function uploadevent(status){
			     status += '';
				 switch(status){

					case '1':
						alert('头像上传成功！');
						changePhoto("afterSuccess");
// 						var time = new Date().getTime();
// 						document.getElementById('avatar_priview').innerHTML = "头像1 : <img src='1.png?" + time + "'/> <br/> 头像2: <img src='2.png?" + time + "'/><br/> 头像3: <img src='3.png?" + time + "'/><br/> 原图: <img src='src.png?" + time + "'/>";
					break;

					case '2':
						if(confirm('js call upload')){
							return 1;
						}else{
							return 0;
						}
					break;

					case '-1':
						alert('cancel!');
						window.location.href = "#";
					break;
					case '-2':
						alert('upload failed!');
						window.location.href = "#";
					break;

					default:
						alert(typeof(status) + ' ' + status);
				} 
			}

			var flashvars = {
			  "jsfunc":"uploadevent",
			  "pid":"75642723",
			  "uploadSrc":true,
			  "showBrow":true,
			  "showCame":true,
			  "uploadUrl":"/WeTogether/web/jsp/MessageManager/upload.jsp"
			};

			var params = {
				menu: "false",
				scale: "noScale",
				allowFullscreen: "true",
				allowScriptAccess: "always",
				wmode:"transparent",
				bgcolor: "#FFFFFF"
			};

			var attributes = {
				id:"FaustCplus"
			};

			swfobject.embedSWF("/WeTogether/web/jsp/MessageManager/FaustCplus.swf", "altContent", "650", "500", "9.0.0", "/WeTogether/web/jsp/MessageManager/expressInstall.swf", flashvars, params, attributes);

		</script>
	
		
		<div class="messageBody">

		<s:form action="modifyMyDetailMessage" method="post" theme="simple">
<!-- 		显示头像的table -->
			<table cellpadding="0" width="15%" align="left" border="1" bordercolor="green" rules="none" cellspacing="0">
				<tr>
					<td id="photoArea"  align="left"><img  src="/WeTogether/web/img/photo/user${user.userId }_1.png" alt="请先上传头像" /></td>
				</tr>
				<tr>
					<td width="100%" align="center"><input class="button" value="点击更换头像" type="button" onclick="changePhoto()" /></td>
				</tr>
			</table>

			<table  cellpadding="5" width="85%" align="right" border="1" rules="none" bordercolor="green" cellspacing="0">
			
				<tr>
					<td>
						<table cellpadding="0" width="100%" align="center" border="0" cellspacing="0">
							<tr align="center" style="color:#428bca;font-size:14pt;">
								<td width="20%" >帐号：</td>
								<td width="30%" align="left"><s:textfield readonly="true" cssClass="searchInput"  maxlength="19" type="text" id="" name="user.userName"  size="25"  /></td>
								<td width="20%">账户ID:</td>
								<td width="30%" align="left">
								<s:textfield cssClass="searchInput"  maxlength="19" type="text" id="" readonly="true" name="user.userId" size="25"  />
								</td>
							</tr>
						</table>
					</td>
				</tr>

				<tr>
					<td>
						<table cellpadding="0" width="100%" align="center" border="0" cellspacing="0">
							<tr align="center" style="color:#428bca;font-size:14pt;">
								<td width="20%" >中文姓名：</td>
								<td width="30%" align="left"><s:textfield cssClass="searchInput"  maxlength="19" type="text" id="" name="user.chinaName" size="25"  /></td>
								<td width="20%">昵称:</td>
								<td width="30%" align="left">
								<s:textfield cssClass="searchInput"  maxlength="19" type="text" id="" name="user.nickName" size="25"  />
								</td>
							</tr>
						</table>
					</td>
				</tr>
				
				<tr>
					<td>
						<table cellpadding="0" width="100%" align="center" border="0" cellspacing="0">
							<tr align="center" style="color:#428bca;font-size:14pt;">
								<td width="20%" >邮箱地址：</td>
								<td width="30%" align="left"><s:textfield cssClass="searchInput"  maxlength="19" type="text" id="" name="user.email" size="25"  /></td>
								<td width="20%">学号/工号:</td>
								<td width="30%" align="left">
								<s:textfield cssClass="searchInput"  maxlength="19" type="text" id="" name="user.idNumber" size="25"  />
								</td>
							</tr>
						</table>
					</td>
				</tr>
				
				
				<tr>
					<td>
						<table cellpadding="0" width="100%" align="center" border="0" cellspacing="0">
							<tr align="center" style="color:#428bca;font-size:14pt;">
								<td width="20%" >所属院校：</td>
								<td width="30%" align="left">
									<s:select id="university" cssClass="input" onChange="changeUniver()"    name="user.university.universityId" list="#request.univers"></s:select>
								</td>
								<td width="20%">所在学院:</td>
								<td width="30%" align="left">
								<%
// 									Map<Integer,String> colleges = new HashMap<Integer,String>();
// 									if(user.getUniversity()==null){
// 										University uni = new University();
// 										uni.setUniversityId(1);
// 										user.setUniversity(uni);
// 									}
// 									Iterator it = user.getUniversity().getColleges().iterator();
// 									while(it.hasNext()){
// 										College college = (College)it.next();
// 										colleges.put(college.getCollegeId(), college.getCollegeName());
// 									}
// 									request.setAttribute("colleges", colleges);		
									
								%>
								<s:select id="colleges" cssClass="input"  name="user.college.collegeId" list="#request.colleges"></s:select>
<%-- 								<select name="user.college.collegeId" class="input"  id="colleges" > --%>
<!-- 									<option></option> -->
<%-- 								</select> --%>
								</td>
							</tr>
						</table>
					</td>
				</tr>
				
				<tr>
					<td>
						<table cellpadding="0" width="100%" align="center" border="0" cellspacing="0">
							<tr align="center" style="color:#428bca;font-size:14pt;">
								<td width="20%" >生日：</td>
								<td width="30%" align="left">
									<s:textfield cssClass="searchInput"  maxlength="19" type="text" id="" name="user.birthday" size="25"  />
								</td>
								<td width="20%">毕业时间:</td>
								<td width="30%" align="left">
								<s:textfield cssClass="searchInput"  maxlength="19" type="text" id="" name="user.graduateDate" size="25"  />
								</td>
							</tr>
						</table>
					</td>
				</tr>
				
				
				
				<tr>
					<td>
						<table cellpadding="0" width="100%" align="center" border="0" cellspacing="0">
							<tr align="center" style="color:#428bca;font-size:14pt;">
								<td width="20%" >电话：</td>
								<td width="30%" align="left">
									<s:textfield cssClass="searchInput"  maxlength="19" type="text" id="" name="user.mobile" size="25"  />
								</td>
								<td width="20%">QQ号码:</td>
								<td width="30%" align="left">
								<s:textfield cssClass="searchInput"  maxlength="19" type="text" id="" name="user.qqNumber" size="25"  />
								</td>
							</tr>
						</table>
					</td>
				</tr>
				
				
				<tr>
					<td>
						<table cellpadding="0" width="100%" align="center" border="0" cellspacing="0">
							<tr align="center" style="color:#428bca;font-size:14pt;">
								<td width="20%" >性别：</td>
								<td width="30%" align="left">
									<s:select id="" cssClass="input"    headerValue="Please Select"  name="user.gender" list="#{'1':'男','2':'女','3':'不明'} "></s:select>
								</td>
								<td width="20%">家庭住址:</td>
								<td width="30%" align="left">
								<s:textfield cssClass="searchInput"  maxlength="19" type="text" id="" name="user.address" size="25"  />
								</td>
							</tr>
						</table>
					</td>
				</tr>
				
				<tr>
					<td>
						<table cellpadding="0" width="100%" align="center" border="0" cellspacing="0">
							<tr align="center" style="color:#428bca;font-size:14pt;">
								<td width="20%">个性宣言:</td>
								<td width="80%" align="left" colspan="3">
								<s:textfield cssClass="personalWord"  maxlength="190" type="text" id="" name="user.personalWord" size="125"  />
								</td>
							</tr>
						</table>
					</td>
				</tr>
				
				
				<tr>
					<td>
						<table cellpadding="0" width="100%" align="center" border="0" cellspacing="0">
							<tr align="center" style="color:#428bca;font-size:14pt;">
								<td colspan="100%" align="center"><s:submit value="提交信息" theme="simple" cssClass="button"></s:submit>
								</td>
							</tr>
						</table>
					</td>
				</tr>
				
				
				
			</table>


		</s:form>
	</div>

	</div>
<script type="text/javascript">
function changeUniver(){
	$("#colleges").empty();
	var uniKey = $("#university").val();
	$.ajax({
		type : "POST",
		url : "getAllCollegeAction",
		dataType : "json",
		data : "university.universityId=" + uniKey,
		success:function(date){
			for(var key in date){
				$("#colleges").append("<option value="+key+">"+date[key]+"</option>");
			}	
		}
	});
}
</script>	
	
</body>
