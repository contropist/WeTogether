package com.wetogether.personalCenter.dto;

import com.wetogether.common.hibernate.pojos.CommentOfArticle;
import com.wetogether.common.util.PubUtil.DateFormater;

public class CommentOfArticleBean {
	private Integer articleId;
	private Integer commentUserId;
	private String commenterName;
	private String commentDate;
	private String commentContent;
	public void setAll(CommentOfArticle a){
		this.articleId = a.getArticleId().getArticleId();
		this.commentUserId = a.getCommenter().getUserId();
		this.commenterName = a.getCommenter().getNickName();
		this.commentDate = DateFormater.formater(a.getSubDate(), DateFormater.DATETIME4);
		this.commentContent = a.getCommentContent();
	}
	public Integer getCommentUserId() {
		return commentUserId;
	}
	public void setCommentUserId(Integer commentUserId) {
		this.commentUserId = commentUserId;
	}
	public String getCommenterName() {
		return commenterName;
	}
	public void setCommenterName(String commenterName) {
		this.commenterName = commenterName;
	}
	public String getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(String commentDate) {
		this.commentDate = commentDate;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	public Integer getArticleId() {
		return articleId;
	}
	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}
	
}
