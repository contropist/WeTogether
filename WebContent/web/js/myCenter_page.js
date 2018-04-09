// 限制个性签名的长度
function checkTextareaLength() {
	var content = document.getElementById("textArea").value;
	if (content.length > 280) {
		document.getElementById("textArea").value = content.substring(0, 280);
		return false;
	}

}

// 提交最新说说（OS）Ajax实现
function submit() {
	var osContent = $("#saytext").val();
	if(osContent==""||osContent.replace(/\s+/g,"")==""){
		alert("内容不能为空  ￣へ￣");
		return false;
	}
	$.ajax({
		type : "POST",
		url : "/WeTogether/InsertMyNewOsAction",
//		dataType : "json",
		data : "os.osContent=" + osContent,
		success:function(date){
			alert("发布成功！O(∩_∩)O哈！");
			$("#saytext").val("");
			window.location.reload();
		},
	});
}


//赞说说
function zanOs(osId){
	$.ajax({
		type : "POST",
		url : "/WeTogether/zanOsAction",
		dataType : "json",
		data : "zan.os.originalSignatureId="+osId,
		success:function(date){
			if(date==0){
				alert("你以赞过! ￣へ￣");
			}else{
				var str = "zanSize"+osId;
				$("#"+str).text(parseInt($("#"+str).text())+1);
				alert("点赞完毕 O(∩_∩)O");
			}
		},
	});
}
//打开或隐藏评论区
function showCommentArea(osId) {
	var str = "CommentsArea"+osId;
	$("#"+str).toggle();
}

function subComment(osId){
	var str0 = "newComment"+osId
	var commentContent = $("#"+str0).val();
	commentContent = commentContent.replace(/\s+/g,"");
	if(commentContent==""){
		alert("内容不能为空哦  ╰_╯");
		return false;
	}
	$.ajax({
		type : "POST",
		url : "/WeTogether/newCommentToOs",
//		dataType : "json",
		data : "comment.commentContent=" + commentContent+"&comment.os.originalSignatureId="+osId,
		success:function(date){
			alert("评论成功  ∩_∩");
			$("#"+str0).val("");
			var nowTime = new Date();
			var newComment = "<tr><td><table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\" rules=\"none\"   align=\"center\">";
			newComment = newComment+"<tr><td rowspan=\"3\"  valign='top' align=\"center\" style=\"color: red;\"><img src='http://localhost:8080\/WeTogether\/web\/img\/photo\/user"+$("#sessionUserId").val()+"_3.png'>"+$("#sessionUserName").val()+"</td></tr>";
			newComment = newComment+"<tr><td>"+commentContent+"</td></tr><tr><td align='right' width='95%'>"+nowTime.getFullYear()+"-"+nowTime.getMonth()+"-"+nowTime.getDay()+nowTime.getHours()+":"+nowTime.getMinutes()+"</td></tr>";
			newComment = newComment+"</table><hr width=\"100%\" color=\"white\"></td></tr>";
			var str1 ="newCommentTr"+osId;
			$("#"+str1).before(newComment);
			var str2 = "noComment"+osId;
			$("#"+str2).hide();
//			$("#commentsSize").text($("#commentsSize")+1);
			var str3 = "commentsSize"+osId;
			$("#"+str3).text(parseInt($("#"+str3).text())+1);
			
		},
	});
	
}

//------------------------------------------------------------------------------
//留言板用到的js
function submitMyBBs(){
	var bbsContent = document.getElementById("textArea").value;
	if(bbsContent==""||bbsContent.replace(/\s+/g,"")==""){
		alert("内容不能为空!");
		return false;
	}
	$.ajax({
		type : "POST",
		url : "/WeTogether/InsertBbs",
//		dataType : "json",
		data : "bbs.bbsCotent=" + osContent,
		success:function(date){
			alert("留言成功 ∩_∩");
			window.location.reload();
		},
	});
}

//删除OS
function removeOS(osId){
	if(confirm("确定删除？")){
		$.ajax({
			type : "POST",
			url : "/WeTogether/removeOS",
//			dataType : "json",
			data : "os.originalSignatureId=" + osId,
			success:function(date){
				alert("删除成功 ∩_∩");
				var osTableId = "OS"+osId;
				$("#"+osTableId).slideUp("slow");
//				window.location.reload();
			},
		});
	}else{
		return false;
	}
	
}

function toHisSpace(userId){
	var url="toHisIndexPage?userId="+userId;
	 window.open(url,'XXXX',   '   toolbar=no,   menubar=yes,   scrollbars=yes, resizable=yes, location=yes,   status=yes'); 
//	window.location.href="toHisIndexPage?userId="+userId;
}
