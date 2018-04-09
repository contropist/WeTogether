function checkTextareaLength() {
	var content = document.getElementById("newAlbumDesc").value;
	if (content.length > 280) {
		document.getElementById("newAlbumDesc").value = content.substring(0, 280);
		return false;
	}

}


function newAlbum(){
	$("#newAlbumName").val("");
	$("#newAlbumDesc").val("");
	$("#newAlnumDiv").toggle();
}

function uploadPhoto(){
	$("#uploadPhotoDiv").toggle();
}


function subNewAlbum(){
	var newAlbumName = $("#newAlbumName").val();
	var newAlbumDesc = $("#newAlbumDesc").val();
	if(newAlbumName==""||newAlbumName.replace(/\s+/g,"")==""){
		alert("相册名不能为空!");
		return false;
	}
	$.ajax({
		type : "POST",
		url : "/WeTogether/addNewAlbum",
//		dataType : "json",
		data : "album.albunName=" + newAlbumName+"&album.albumDesc="+newAlbumDesc,
		success:function(date){
			alert("创建相册成功！");
			window.location.reload();
		},
	});
}


function  resetNewPhoto(){
	$("#uploadPhotoDiv").hide();
}

function  resetNewAlbum(){
	$("#newAlbumName").val("");
	$("#newAlbumDesc").val("");
	$("#newAlnumDiv").hide();
}

function batchDelete(){
	var albums = $("#album");
	for(var i = 0;i<albums.length;i++){
		alert("ins");
		albums[i].show();
	}
}
//设置封面
function setAlbumPage(photoId){
	$.ajax({
		type : "POST",
		url : "/WeTogether/setAlbumIndex",
//		dataType : "json",
		data : "photoId=" + photoId,
		success:function(date){
			alert("设置成功！");
//			window.location.reload();
		},
	});
	
	
}

function deletePhoto(photoId){
	$.ajax({
		type : "POST",
		url : "/WeTogether/deletePhoto",
//		dataType : "json",
		data : "photoId=" + photoId,
		success:function(date){
			alert("删除成功！");
			window.location.reload();
		},
	});
	

}


