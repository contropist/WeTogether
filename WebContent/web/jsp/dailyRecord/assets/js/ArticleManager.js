function submitArticle(categoryId) {
	var caId = categoryId;
	var articleTitle = $("#editor2").html();
	var articleContent = $("#editor").html();
//	var url="http://localhost:8080/WeTogether/insertArticleAction?article.articleName="+articleTitle+"&article.articleContent="+articleContent+"&article.articleCategory.categoryId="+caId;
//	url=encodeURI(encodeURI(url));
//	  window.location = url;
	  $.ajax({
		  beforeSend: function(){
			$("#beforeSend").text("<img src='/WeTogether/web/img/spinner.gif' />");
			},
			complete: function(){
			// Handle the complete event
			},
			type : "POST",
			url : "/WeTogether/insertArticleAction",
//			dataType : "json",
			data : "article.articleName="+articleTitle+"&article.articleContent="+articleContent+"&article.articleCategory.categoryId="+caId,
			success:function(date){
				alert("发布成功");
				window.location.reload();
			},
		
		});
}
 function resetArticleContent(){
	 $("#editor").text("");
 }
 
 function closeWindow(){
	 window.close();
 }