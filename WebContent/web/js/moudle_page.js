//定义xmlHttpRequest对象;	
var xmlHttpRequest;
//获得所有还有所在的li的数组
var friendsLiList = document.getElementById("friendsUl").getElementsByTagName(
		"li");
// 创建xmlHttpRequest对象的方法;
function createXMLHttpRequest() {
	if (window.ActiveXObject) {
		xmlHttpRequest = new ActiveXObject("Microsoft.XMLHTTP");
	} else if (window.XMLHttpRequest) {
		xmlHttpRequest = new XMLHttpRequest();
	}
}

// 搜索好友调用此方法
function friendTips() {

//	var url = "http://localhost:8080/WeTogether/";
	var content = document.getElementById("searchFrend").value;
	//url = url + "SearchFriendsAction?tipsName=" + content;
  var url = "SearchFriendsAction?tipsName=" + content;  
	createXMLHttpRequest();
	xmlHttpRequest.onreadystatechange = friendTipsStateChange;
	xmlHttpRequest.open("GET", url, true);
	xmlHttpRequest.send(null);
}

// 搜索好友每次请求状态改变时调用此方法
function friendTipsStateChange() {
	if (xmlHttpRequest.readyState == 4) {
		if (xmlHttpRequest.status == 200) {
			var indexOfLi = xmlHttpRequest.responseText.split(",");
			// 如果id的id能和返回的用户结果匹配就显示，否则就隐藏
			var count = 0;
			for (var a = 1; a < friendsLiList.length; a++) {
				var exited = false;
				for (var i = 0; i < indexOfLi.length; i++) {
					if (friendsLiList[a].id == indexOfLi[i]) {
						exited = true;
						count++;
						// friendsLiList[a].style.display="";
					}

				}
				if (exited) {
					friendsLiList[a].style.display = "";
				} else {
					friendsLiList[a].style.display = "none";
				}

			}
			//这里写的有问题，count==1 还是等于0的问题
			if (count == 1) {
				document.getElementById("null_Record").style.display = "";
			} else {
				document.getElementById("null_Record").style.display = "none";
			}

		}

	}

}



//打开添加好友页面
function addNewFriend(){
	 window.open('/WeTogether/web/jsp/personalCenter/addFriendPage.jsp','addNewFriend',   'height=500,   width=500,   top=180,   left=340,   toolbar=no,   menubar=no,   scrollbars=no, resizable=no, location=no,   status=no'); 
}

//打开好友信息面板
function openFriendMessagePage(friendId){
	window.open('getUserMessage?userId='+friendId,'addNewFriend',   'height=380,   width=580,   top=180,   left=380,   toolbar=no,   menubar=no, titlebar=no   scrollbars=no, resizable=no, location=no,   status=no');
}

//打开聊天面板
function chatNow(userId){
//	window.location.href="/WeTogether/web/jsp/ChatRoom/chatRoom.jsp?friendId="+userId;
	window.location.href="ChatNow?friendId="+userId;
}




