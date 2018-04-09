<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath()%>/web/css/bootstrap.min.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/web/css/bootstrap-responsive.min.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/web/css/fullcalendar.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/web/css/unicorn.main.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/web/css/unicorn.grey.css" class="skin-color" />
<script type="text/javascript">
	function send(url) {
		top.document.getElementsByTagName("iframe")[0].src = url + "?r="
				+ Math.random();
	}
</script>
<title>WeTogether</title>
</head>
<body>
	<div id="header">
		<h1>
			<a href="index.html">WeTogether</a>
		</h1>
	</div>
	<div id="user-nav" class="navbar navbar-inverseooopp">
		<ul class="nav btn-group">
			<li class="btn btn-inverse"><a title="" href="#"><i
					class="icon icon-user"></i> <span class="text">XXX</span></a></li>
			<li class="btn btn-inverse dropdown" id="menu-messages"><a
				href="#" data-toggle="dropdown" data-target="#menu-messages"
				class="dropdown-toggle"><i class="icon icon-envelope"></i> <span
					class="text">消息</span> <span class="label label-important">2</span>
					<b class="caret"></b></a>
				<ul class="dropdown-menu">
					<li><a class="sAdd" title="" href="#">预警信息</a></li>
					<li><a class="sInbox" title="" href="#">日志信息</a></li>
				</ul></li>
			<li class="btn btn-inverse"><a title="" href="#"><i
					class="icon icon-cog"></i> <span class="text">设置</span></a></li>
			<li class="btn btn-inverse"><a title="" href="login.html"><i
					class="icon icon-share-alt"></i> <span class="text">退出</span></a></li>
		</ul>
	</div>

	<div id="sidebar">
		<a href="#" class="visible-phone"><i class="icon icon-home"></i> 首
			页</a>
		<ul>
			<li><a href="#" onclick="send('main.html')"><i
					class="icon icon-home"></i> <span>首 页</span></a></li>
			<li class="submenu"><a href="#"><i class="icon icon-th-list"></i>
					<span>活动汇总</span> <span class="label">6</span></a>
				<ul>
					<li><a href="#">数据详细</a></li>
					<li><a href="#">数据统计</a></li>
					<li><a href="#">同期数据对比</a></li>
					<li><a href="#">地区数据对比</a></li>
					<li><a href="#">时段分段分析</a></li>
					<li><a href="#">环境分布分析</a></li>
				</ul></li>
			<li class="submenu"><a href="#"><i class="icon icon-th-list"></i>
					<span>情报中心</span> <span class="label">4</span></a>
				<ul>
					<li><a href="#">报警消息</a></li>
					<li><a href="#">设备消息</a></li>
					<li><a href="#">登陆日志</a></li>
					<li><a href="#">支付状况</a></li>
				</ul></li>
			<li class="submenu"><a href="#"><i class="icon icon-th-list"></i>
					<span>个人设置</span> <span class="label">4</span></a>
				<ul>
					<li><a href="#">个人信息设置</a></li>
					<li><a href="#">密码设置</a></li>
					<li><a href="#">预警设置</a></li>
					<li><a href="#">提醒设置</a></li>
				</ul></li>
			<li class="submenu"><a href="#"><i class="icon icon-th-list"></i>
					<span>系统管理</span> <span class="label">7</span></a>
				<ul>
					<li><a href="#">菜单管理</a></li>
					<li><a href="#">角色管理</a></li>
					<li><a href="#" onclick="send('system/WDSB.html')">用户管理</a></li>
					<li><a href="#">公告设置</a></li>
					<li><a href="#">监护关系管理</a></li>
					<li><a href="#">详细地址管理</a></li>
					<li><a href="#">设备情报管理</a></li>
				</ul></li>
				<li class="submenu"><a href="#"><i class="icon icon-th-list"></i>
					<span>系统维护</span> <span class="label">3</span></a>
				<ul>
					<li><a href="#">数据备份</a></li>
					<li><a href="#">数据还原</a></li>
					<li><a href="#">数据压缩</a></li>
				</ul></li>
			<li><a href="#"><i class="icon icon-th-list"></i> <span>帮助</span></a></li>
		</ul>
	</div>

	<div id="style-switcher">
		<i class="icon-arrow-left icon-white"></i> <span>Style:</span> <a
			href="#grey"
			style="background-color: #555555; border-color: #aaaaaa;"></a> <a
			href="#blue" style="background-color: #2D2F57;"></a> <a href="#red"
			style="background-color: #673232;"></a>
	</div>

	<div id="content">
		<iframe frameborder="0" style="width:100%;min-height:100%;" src="main.html" scrolling="yes" name="iframe">
		</iframe>
	</div>


	<script src="js/excanvas.min.js"></script>
	<script src="js/jquery.min.js"></script>
	<script src="js/jquery.ui.custom.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.flot.min.js"></script>
	<script src="js/jquery.flot.resize.min.js"></script>
	<script src="js/jquery.peity.min.js"></script>
	<script src="js/fullcalendar.min.js"></script>
	<script src="js/unicorn.js"></script>
	<script src="js/unicorn.dashboard.js"></script>
</body>
</html>