<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath()%>/web/css/bootstrap.min.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/web/css/bootstrap-responsive.min.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/web/css/unicorn.login.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/web/css/register_page.css" />
<script src="<%=request.getContextPath()%>/web/js/jquery.js"></script>
<script src="../js/register_page.js"></script>
<title>Insert title here</title>
</head>
<body style="height: 200pt;"> 
<s:action name="getAllUniversityAction" executeResult="false" />
	<div class="header">WeTogether用户注册界面</div>
	<div class="form_body">
		<s:form name="RegisterAction" action="RegisterAction">
			<div class="form_body_basic">
				<div class="form_body_basic_tittle">
					请填写以下必要的注册信息： <span style="position: relative; left: 57%;">注册对象：
						<select onChange="partyRoleChange()" id="party_role"
						name="user.userType.userTypeId"
						style="color: #CCCCCC; font-size: 18px; width: 80px; background-color: #666666;">
							<option value=1>学生</option>
							<option value=2>老师</option>
							<option value=3>其他</option>
					</select>
					</span>
					<hr>
					<p>
				</div>
			</div>
			<div class="form_body_basic_body">

				<span class="startSymbol">*</span>用户邮箱：<input type="text"
					name="user.email" id="email" placeholder="xx@xx.com"
					onChange="checkEmail()">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span
					class="startSymbol">*</span>用户帐号：<input type="text"
					name="user.userName" id="username" maxlength=20;
					onChange="checkUsername()" placeholder="Username(5-20个合法字符)"><span
					id="hasExisted" style="color: red; font-size: 12pt"></span> <br>
				<span class="startSymbol">*</span>用户密码：<input type="password"
					name="user.password" id="password" onChange="checkPassword()"
					maxlength=20 placeholder="Password(5-20个合法字符)">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<span class="startSymbol">*</span>确认密码：<input type="password"
					readonly="readonly" name="rePassword" id="rePassword" maxlength=20
					onChange="checkRepassword()" placeholder="Password(5-20个合法字符)"><span
					id="errorpwd" class="hidden_message">两次密码不一致</span>
			</div>


			<div id="form_body_detial" class="form_body_detial">
				<hr>
				<div class="form_body_detial_tittle">
					请输入个人详细信息(非必录项，注册后可完善)：
					<hr>
					<div class="form_body_detial_body">
						<div id="nameAndGenderDiv">
							中文姓名：<input type="text" name="user.chinaName"
								id="chinaName" maxlength=6 placeholder="中文姓名">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：<select name="user.gender"
								id="gerder">
								<option value=1>纯爷们</option>
								<option value=2>娘炮</option>
								<option value=3>男吊丝</option>
								<option value=4>女汉子</option>
								<option value=5>女神</option>
								<option value=6>女吊丝</option>
								<option value=7>不名生物体</option>
							</select>
						</div>
						<div id="whichUniversity">
<!-- 							所属院校：<input type="text" name="user.school" id="" -->
<!-- 								placeholder="所在学校名称"> -->
								所属院校:&nbsp;&nbsp;
								<s:select id="university" theme="simple" cssClass="input" onChange="changeUniver()"  headerKey="" headerValue="Please Select"  name="user.university.universityId" list="#request.univers"></s:select>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							所属院系：<select name="user.college.collegeId" id="colleges" headerKey="" headerValue="Please Select">
								
							</select>

						</div>
						<div id="numberAndGraduateDiv">
							学号工号：<input type="text" name="user.idNumber" id="idNumber"
								value="" placeholder="所在院校的工号或学号">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							毕业时间：<input type="text" name="user.graduateDate"
								id="graduateDate" onChange="javascript:graduate()" value="" placeholder="毕业时间YYYYMMDD">

						</div>
						<div id="birthdayAndAddressDiv">
							出生年月：<input type="text" name="user.birthdayDate"
								onChange=" javascript:birthday()" id="birthdayDate" value=""
								placeholder="出生日期YYYYMMDD">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							家庭住址：<input type="text" name="user.address" id="address" value=""
								placeholder="家庭住址">
						</div>
						<div id="mobileAndQQDiv">
							手机号码：<input type="text" name="user.mobile" id="mobile" value=""
								placeholder="13位移动手机号">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							球球号码：<input type="text" name="user.qqNumber" id="qqNumber"
								value="" placeholder="请输入QQ号码">
						</div>

					</div>
				</div>
			</div>
			<hr>
			<div align="center">
				<input type="submit" onClick="return confirmSub()" value="注册"
					class="button"> <input type="button" onClick="" value="保存"
					class="button"> <input type="button" onClick=""
					value="重置" class="button">

			</div>

		</s:form>

	</div>

</body>
</html>