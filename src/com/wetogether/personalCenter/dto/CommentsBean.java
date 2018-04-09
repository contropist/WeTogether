package com.wetogether.personalCenter.dto;

import java.util.Date;

import com.wetogether.common.hibernate.pojos.Comment;
import com.wetogether.common.hibernate.pojos.OriginalSignature;
import com.wetogether.common.hibernate.pojos.User;

public class CommentsBean {
	/*
	 * select * from comment where osid in( select osid from OS where userId in(
	 * select f_id from friend where userId = "id" ) ); String hql =
	 * "from Comment where osid in (select osid from OriginalSignature where userId in (select f_id from friend where userId = :id))"
	 * ;
	 */
	// 评论人
	private User commentUser;
	// 评论的个签
	private OriginalSignature os;
	// 评论内容
	private String commentContent;
	private Date commentTime;

	private int commentListSize;

	public User getCommentUser() {
		return commentUser;
	}

	public void setCommentUser(User commentUser) {
		this.commentUser = commentUser;
	}

	public OriginalSignature getOs() {
		return os;
	}

	public void setOs(OriginalSignature os) {
		this.os = os;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public Date getCommentTime() {
		return commentTime;
	}

	public void setCommentTime(Date commentTime) {
		this.commentTime = commentTime;
	}

	public int getCommentListSize() {
		return commentListSize;
	}

	public void setCommentListSize(int commentListSize) {
		this.commentListSize = commentListSize;
	}
	
	
	public void setCommentsBean(Comment comment){
		
		this.commentContent = comment.getCommentContent();
		this.commentUser = comment.getCommentUser();
		this.os = comment.getOs();
		this.commentTime = comment.getCommentTime();
	}
	
	
	
	
	
	
	
	

}
