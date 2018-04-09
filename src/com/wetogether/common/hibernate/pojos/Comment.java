package com.wetogether.common.hibernate.pojos;

import java.util.Date;


//个签评论
public class Comment {
	
		private Integer commentId;
		//评论人
		private User commentUser;
		//评论的个签
		private OriginalSignature os;
		//评论的照片
		private Photo photoId;
		//评论的文章
		private Article articleId;
		//评论内容
		private String commentContent;
		private Date commentTime;
		
		
		public Photo getPhotoId() {
			return photoId;
		}
		public void setPhotoId(Photo photoId) {
			this.photoId = photoId;
		}
		public Article getArticleId() {
			return articleId;
		}
		public void setArticleId(Article articleId) {
			this.articleId = articleId;
		}
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
		public Integer getCommentId() {
			return commentId;
		}
		public void setCommentId(Integer commentId) {
			this.commentId = commentId;
		}
		
		
		
		
}
