function jumpPage(currentPage,categoryId){
	var userId = $("#userId").val();
	$.ajax({
		type : "POST",
		url : "/WeTogether/getAllDaliyRecords",
		dataType : "json",
		data : "articleVOs.cateroryId=" + categoryId+"&articleVOs.page.currentPage="+currentPage+"&requestType=ajax&userId="+userId,
		success:function(date){
			var articles = date.beans;
			var articleTable = "<table align=\"center\"  width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" >";
			for(var i = 0;i<articles.length;i++){
				articleTable = articleTable+"<tr> <td align='center' width=\"50%\" > <a href=\"showArticleByArticleId?article.articleId="+articles[i].articleId+"\" \">"+articles[i].articleName+"</a></td>";
				articleTable = articleTable+"<td align='center'>"+articles[i].subDate+"</td>";
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
		},
	});
	
}

function changeCategory(currentPage,categoryId){
	$("#articleCategoryTr").children("*").css("background-color", "#2D335B");
	var nowTdId = "ca"+categoryId;
	$("#"+nowTdId).css("background-color", "white");
	jumpPage(currentPage,categoryId);
}