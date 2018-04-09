var username;
var password;
var email;
var rePassword;
var xmlHttpRequest;


function confirmSub(){
	username = document.getElementById("username").value;
	email = document.getElementById("email").value;
	password = document.getElementById("password").value;
		if(confirm("确认注册?")){
			if(email==""){
				alert("邮箱格式不正确");
				return false;
			}
			if(username==""){
				alert("用户名格式不合法");
				return false;
			}
			if(password==""){
				alert("密码格式不正确");
				return false;
			}
			
			
			return true;
		}
		return false;
}



// 创建xmlHttpRequest对象
function createXMLHttpRequest() {
	if (window.ActiveXObject) {
		xmlHttpRequest = new ActiveXObject("Microsoft.XMLHTTP");
	} else if (window.XMLHttpRequest)
		xmlHttpRequest = new XMLHttpRequest();
}


// 改变角色时隐藏或者显示某些表单内容
function partyRoleChange() {
	var partyRoleCode = document.getElementById("party_role").value;
	// alert(partyRoleCode );
	switch (partyRoleCode) {
	case "1":
		document.getElementById("form_body_detial").style.display = "";
		document.getElementById("whichUniversity").style.display = "";
		document.getElementById("numberAndGraduateDiv").style.display = "";
		document.getElementById("personalWordDiv").style.display = "";
		break;
	case "2":
		document.getElementById("form_body_detial").style.display = "";
		document.getElementById("whichUniversity").style.display = "none";
		document.getElementById("numberAndGraduateDiv").style.display = "none";
		document.getElementById("personalWordDiv").style.display = "none";
		break;
	case "3":
		document.getElementById("form_body_detial").style.display = "none";
		break;

	}
}

// 检测用户名是否合法
function checkUsername() {
	username = document.getElementById("username").value;
	var nameReg = new RegExp("\\w{5,20}");
	if (!nameReg.test(username)) {
		document.getElementById("username").value = "";
		alert("用户名格式不合法");
		
		return false;
	} else {
		var url = "CheckUsername?username=" + username;
		createXMLHttpRequest();
		xmlHttpRequest.onreadystatechange = stateChange;
		xmlHttpRequest.open("POST",url, true);
		xmlHttpRequest.send(null);

	}
}


//检测请求状态的改变
function stateChange() {
	if (xmlHttpRequest.readyState == 4) {
		if (xmlHttpRequest.status == 200) {
			if (xmlHttpRequest.responseText == "faile") {
				document.getElementById("username").value = "";
				document.getElementById("hasExisted").innerHTML ="&nbsp;用户名已存在";
				document.getElementById("username").focus();
			} else {
				document.getElementById("hasExisted").innerHTML = "&nbsp;恭喜，该用户名可用";
			}
		}
	}

}

// 检测用户邮箱是否合法

function checkEmail() {
	var email = document.getElementById("email").value;
	var emailReg = new RegExp("\\w{3,20}@\\w+\\.(com|org|cn|net|qcd)");
	if (!emailReg.test(email)) {
		document.getElementById("email").value = "";
		alert("邮箱格式不正确");
		return false;
	}
}

// 检测密码是否合法
function checkPassword() {
	document.getElementById("rePassword").readOnly = true;
	var password = document.getElementById("password").value;
	var passwordReg = new RegExp("\\w{5,20}");
	if (!passwordReg.test(password)) {
		document.getElementById("password").value = "";
		document.getElementById("rePassword").value = "";
		alert("密码格式不正确");
		return false;
	} else {
		// if (document.getElementById("rePassword").value != "") {
		// if (repassword != password) {
		// document.getElementById("errorpwd").style.display = "inline";
		// document.getElementById("rePassword").value = "";
		// } else {
		// document.getElementById("errorpwd").style.display = "none";
		// }
		// }
		document.getElementById("rePassword").readOnly = false;
	}

}

// 检测重复密码是否正确
function checkRepassword() {
	var repassword = document.getElementById("rePassword").value;
	var password = document.getElementById("password").value;
	if (repassword != password) {
		document.getElementById("errorpwd").style.display = "inline";
		document.getElementById("rePassword").value = "";
	} else {
		document.getElementById("errorpwd").style.display = "none";
	}

}

// 以下是非必录项
// 检测出生日期是否合法
function birthday() {
	var birthdayDate = document.getElementById("birthdayDate").value;
	var birthdayReg = new RegExp(
			"(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})(((0[13578]|1[02])(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)(0[1-9]|[12][0-9]|30))|(02(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))0229) ");
	if (!birthdayReg.test(birthdayDate)) {
		document.getElementById("birthdayDate").value = "";
		alert("出生日期输入格式不正确");
		return false;
	}
	var year = birthdayDate.substring(0, 4);
	var month = birthdayDate.substring(4, 6);
	var day = birthdayDate.substring(6, 8);
	if (year > 2010 || year < 1920) {
		alert("出生年份不合法！");
		document.getElementById("birthdayDate").focus();
		return false;
	}

	document.getElementById("birthdayDate").value = year + "/" + month + "/"
			+ day;
}

//毕业时间
function graduate(){
	var graduateDate = document.getElementById("graduateDate").value;
	var graduateReg = new RegExp(
			"(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})(((0[13578]|1[02])(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)(0[1-9]|[12][0-9]|30))|(02(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))0229) ");
	if (!graduateReg.test(graduateDate)) {
		document.getElementById("graduateDate").value = "";
		alert("毕业时间输入格式不正确");
		return false;
	}
	var year = graduateDate.substring(0, 4);
	var month = graduateDate.substring(4, 6);
	var day = graduateDate.substring(6, 8);
	if (year > 2020 || year < 1980) {
		alert("毕业年份不合法！");
		document.getElementById("graduateDate").focus();
		return false;
	}

	document.getElementById("graduateDate").value = year + "/" + month + "/"
			+ day;
}


//jquery
$(document).ready(function(){
	//University change事件
	$("#university").change(function(){
		$("#colleges").empty();
		var uniKey = $("#university").val();
		$.ajax({
			type : "POST",
			url : "getAllCollegeAction",
			data : "university.universityId=" + uniKey,
			success:function(date){
				var colleges = JSON.parse(date);
				for(var key in colleges){
					$("#colleges").append("<option value="+key+">"+colleges[key]+"</option>");
				}	
			}
		});
	});
});













