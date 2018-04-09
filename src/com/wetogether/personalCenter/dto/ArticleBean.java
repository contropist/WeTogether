package com.wetogether.personalCenter.dto;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.wetogether.common.hibernate.pojos.Article;
import com.wetogether.common.hibernate.pojos.ArticleCategory;
import com.wetogether.common.hibernate.pojos.CommentOfArticle;
import com.wetogether.common.hibernate.pojos.User;
import com.wetogether.common.util.PubUtil.DateFormater;

public class ArticleBean {
	private Integer articleId;
	private String articleName;
	private String articleContent;
	private String subDate;
	//点击次数
	private Integer clickTime;
	//评论次数
	private Integer commentsCount;
	private transient User articleOwerId;
	private transient ArticleCategory articleCategory;
	private transient Set<CommentOfArticle> comments = new TreeSet<CommentOfArticle>();
	
	
	public void setAll(Article article){
		this.articleId = article.getArticleId();
		this.articleName = article.getArticleName();
		this.articleContent = article.getArticleContent();
		this.subDate = DateFormater.formater(article.getSubDate(), DateFormater.DATETIME4);
		this.clickTime = article.getClickTime();
		this.articleOwerId = article.getArticleOwerId();
		this.comments = article.getComments();
		this.articleCategory = article.getArticleCategory();
		this.commentsCount = this.comments.size();
	}


	public Integer getArticleId() {
		return articleId;
	}


	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}


	public String getArticleName() {
		return articleName;
	}


	public void setArticleName(String articleName) {
		this.articleName = articleName;
	}


	public String getArticleContent() {
		return articleContent;
	}


	public void setArticleContent(String articleContent) {
		this.articleContent = articleContent;
	}


	public String getSubDate() {
		return subDate;
	}


	public void setSubDate(String subDate) {
		this.subDate = subDate;
	}


	public Integer getClickTime() {
		return clickTime;
	}


	public void setClickTime(Integer clickTime) {
		this.clickTime = clickTime;
	}


	public Integer getCommentsCount() {
		return commentsCount;
	}


	public void setCommentsCount(Integer commentsCount) {
		this.commentsCount = commentsCount;
	}


	public User getArticleOwerId() {
		return articleOwerId;
	}


	public void setArticleOwerId(User articleOwerId) {
		this.articleOwerId = articleOwerId;
	}


	public ArticleCategory getArticleCategory() {
		return articleCategory;
	}


	public void setArticleCategory(ArticleCategory articleCategory) {
		this.articleCategory = articleCategory;
	}


	public Set<CommentOfArticle> getComments() {
		return comments;
	}


	public void setComments(Set<CommentOfArticle> comments) {
		this.comments = comments;
	}



	
	
	
	
	
	
	
	

}
