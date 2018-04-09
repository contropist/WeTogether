function jumpPage(currentPage,categoryId){
//	var url = "showDailyRecordsAction?articleVOs.cateroryId="+categoryId+"&articleVOs.page.currentPage="+currentPage;
//	window.location = url;
	$.ajax({
		type : "POST",
		url : "/WeTogether/showDailyRecordsAction",
		dataType : "json",
		data : "articleVOs.cateroryId=" + categoryId+"&articleVOs.page.currentPage="+currentPage+"&requestType=ajax",
		success:function(date){
			var articles = date.beans;
			var articleTable = "<table align=\"center\"  width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" >";
			for(var i = 0;i<articles.length;i++){
				articleTable = articleTable+"<tr> <td align='center' width=\"50%\" > <a target=\"_blank\" href=\"showArticleByArticleId?article.articleId="+articles[i].articleId+"\" \">"+articles[i].articleName+"</a></td>";
				articleTable = articleTable+"<td align='center'>"+articles[i].subDate+"</td>";
				articleTable = articleTable+"<td align='center' >";
				articleTable = articleTable+"<a href=\"#\"><span style='font-size:16px; color:#666666'>编辑</span></a>&nbsp;";		
				articleTable = articleTable+"<a href=\"#\" onClick=\"removeArticle("+articles[i].articleId+")\"><span style='font-size:16px; color:#666666'>删除</span></a> </td>";		
				articleTable = articleTable+"<td align='center'>"+articles[i].commentsCount+"/"+articles[i].clickTime+"</td>";		
				articleTable = articleTable+"</tr>";		
			}
			articleTable = articleTable+"\<\/table\>";
			$("#articleList").html(articleTable);
			$("#pageCount").html("当前第"+date.page.currentPage+"/"+date.page.totalPages);
			$("#firstPage").html(date.page.firstPageUrl);
			$("#previousPage").html(date.page.previousPageUrl);
			$("#nextPage").html(date.page.nextPageUrl);
			$("#lastPage").html(date.page.lastPageUrl);
			$("#newArticlePic").attr("href","/WeTogether/web/jsp/dailyRecord/newArticle.jsp?categoryId="+categoryId);
		},
	});
	
}

function changeCategory(currentPage,categoryId){
	$("#articleCategoryTr").children("*").css("background-color", "#2D335B");
	var nowTdId = "ca"+categoryId;
	$("#"+nowTdId).css("background-color", "white");
	jumpPage(currentPage,categoryId);
}

function removeArticle(articleId){
	if(confirm("确定删除？")){
		$.ajax({
			type : "POST",
			url : "/WeTogether/DeleteArticle",
//			dataType : "json",
			data : "article.articleId=" + articleId,
			success:function(date){
				alert("删除成功!");
				window.location.reload();
			},
		});
	}else{
		return false;
	}
	
}


