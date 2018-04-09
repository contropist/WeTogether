package com.wetogether.common.hibernate.pojos;

import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

public class Article {
	private Integer articleId;
	private String articleName;
	private String articleContent;
	private Date subDate;
	//点击次数
	private Integer clickTime;
	private User articleOwerId;
	private ArticleCategory articleCategory;
	private Set<CommentOfArticle> comments = new TreeSet<CommentOfArticle>();
	private Set<DynamicMessage> dms = new TreeSet<DynamicMessage>();
	public Integer getArticleId() {
		return articleId;
	}
	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}
	
	public Integer getClickTime() {
		return clickTime;
	}
	public void setClickTime(Integer clickTime) {
		this.clickTime = clickTime;
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
	public Date getSubDate() {
		return subDate;
	}
	public void setSubDate(Date subDate) {
		this.subDate = subDate;
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
	public Set<DynamicMessage> getDms() {
		return dms;
	}
	public void setDms(Set<DynamicMessage> dms) {
		this.dms = dms;
	}

	
	
}
