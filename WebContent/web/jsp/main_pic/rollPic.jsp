<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="com.wetogether.personalCenter.dto.*"%>
<%@page import="com.wetogether.common.hibernate.pojos.*"%>    
<%@ taglib prefix="s" uri="/struts-tags"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<style type="text/css"> 
*{ margin:0; padding:0;}
h1.tit-h1 { font-size:38px; text-align:center; margin:30px 0 15px; color:#f60;}
.go-back{ text-align:center; border-top:1px dashed #ccc; padding:10px; margin-top:20px; font-size:40px;}
.wrap{ padding:10px;}


#slide{overflow:hidden;width:900px;margin:50px auto;}
.slideul1{width:3999px;}
</style> 
<%-- <script type="text/javascript" src="http://www.wufangbo.com/demo/jquery-1.4.4.min.js"></script> --%>
<script src="<%=request.getContextPath()%>/web/js/jquery.min.js"></script>
</head>
<body>

<div class="wrap">
<h1 class="tit-h1">我的空间首页</h1>
<div id="slide"> 
	<ul class="slideul1" style="list-style:none;"> 
		<li class="slideli1" style="float:left;"> 
      		<ul class="slideul2" style="list-style:none;"> 
      		<%
      			List<Photo> photos =(List<Photo>)request.getAttribute("photos");
      				for(int i = 0 ;i<photos.size();i++){
      					Photo p = photos.get(i);
      		%>
      		<li style="float:left;margin: 5pt;"><a href="showPhotoAction?bean.page.currentPage=1&bean.album.albumId=<%=p.getAlbumId().getAlbumId()%>"><img src="<%=p.getPhotoSrc()%>" id="pic<%=p.getPhotoId() %>" style="width:200px;height:250px;" onmouseout="small('pic<%=p.getPhotoId() %>')" onmouseover="big('pic<%=p.getPhotoId() %>')" /></a></li> 
      		<%} %>
						
					</ul> 
		<li class="slideli2"></li> 
	</ul> 
</div> 
<script type="text/javascript">
var _speed=30;
var _slide = $("#slide");
var _slideli1 = $(".slideli1");
var _slideli2 = $(".slideli2");
_slideli2.html(_slideli1.html());
function Marquee(){
	if(_slide.scrollLeft() >= _slideli1.width())
		_slide.scrollLeft(0);
	else{
		_slide.scrollLeft(_slide.scrollLeft()+1);
	}
}
$(function(){
	//两秒后调用
	var sliding=setInterval(Marquee,_speed)
	_slide.hover(function() {
		//鼠标移动DIV上停止
		clearInterval(sliding);
	},function(){
		//离开继续调用
		sliding=setInterval(Marquee,_speed);
	});
});
// function big(pic){
// 	$("#"+pic).css({"width":"400px","height":"500px"});
// }
// function small(pic){
// 	$("#"+pic).css({"width":"200px","height":"250px"});
// }

</script>

    
</div>




<script type="text/javascript">
  var _gaq = _gaq || [];
  _gaq.push(['_setAccount', 'UA-20541395-2']);
  _gaq.push(['_trackPageview']);
  (function() {
    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
    ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
  })();
</script>

</body> 
</html>