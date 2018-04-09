$(document).ready(function() {

	
	//userId change事件 ajax调用后台返回查到的好友
	$("#userId").change(function() {
		$.ajax({
			type : "POST",
			url : "http://localhost:8080/WeTogether/findUserByIdAction",
			data : "user.userId=" + $("#userId").val(),
			success:function(date){
				if(date==""){
					$("#searchResult").html("Not Fund Record");
				}else{
					var user = JSON.parse(date);
					$("#searchResult").html("<table style='width:100%;'><tr align='center'><td>好友ID<//td><td>好友昵称<//td><td>中文姓名<//td><//tr><tr align='center'><td>"+
							user.userId+"<//td><td>"+user.userName+"<//td>"+"<td>"+user.chinaName+"<//td>"+
							"<td><input type='button' id='addButton' onClick='addNewFriend()'   value='添加'><//td></tr><//table>");
				}
				
			}
		});
		

	});
	
	
	
	

});



//Add new Friend
function addNewFriend(){
	$.ajax({
		type : "POST",
		url : "http://localhost:8080/WeTogether/addNewFriendAction",
		data : "friend.friendUser.userId=" + $("#userId").val(),
		success:function(date){
			alert(date);
		}
	});
}



















