package com.wetogether.personalCenter.service;

import java.util.List;

import com.wetogether.common.hibernate.pojos.Album;
import com.wetogether.common.hibernate.pojos.Article;
import com.wetogether.common.hibernate.pojos.BBS;
import com.wetogether.common.hibernate.pojos.Comment;
import com.wetogether.common.hibernate.pojos.CommentOfArticle;
import com.wetogether.common.hibernate.pojos.DynamicMessage;
import com.wetogether.common.hibernate.pojos.Friend;
import com.wetogether.common.hibernate.pojos.OriginalSignature;
import com.wetogether.common.hibernate.pojos.Photo;
import com.wetogether.common.hibernate.pojos.User;
import com.wetogether.common.hibernate.pojos.ZanTable;
import com.wetogether.personalCenter.dto.AlbumBean;
import com.wetogether.personalCenter.dto.ArticleBean;
import com.wetogether.personalCenter.dto.ArticleVOs;
import com.wetogether.personalCenter.dto.OSsBean;
import com.wetogether.personalCenter.dto.PhotoBean;

public interface IPersonalCenterServices {
		public List<Friend> findAllFriends(Integer currentId);
		public List<Integer> returnFindFriendIdList(String name,Integer id);
		
		public OSsBean findAllOSofMyFriend(User user,OSsBean oSsBean);
		public OSsBean findAllOSsOfMine(User user,OSsBean oSsBean);
		
		
		public User findUserById(Integer userId);
		public Integer addNewFriend(Friend friend,User currentUser);
		public Friend findFriendMessage(Friend friend,User currentUser);
		
		public void addNewOs(User currentUser,OriginalSignature os);
		//删除说说
		public void deleteOS(OriginalSignature os);
		public OriginalSignature findOSbyId(OriginalSignature os);
		public void addNewCommentToOs(Comment comment);
		public Integer addZanToOs(ZanTable zan);
		
		//--------------------------------------------------
		public void addNewArticle(Article article);
		public ArticleBean findArticle(Article article);
		public ArticleVOs FindAllArticle(ArticleVOs vo);
		
		//留言
		public void addBbs(BBS bbs);
		public List<BBS> getBBSs(Integer userId);
		//新建相册
		public void addNewAlbum(Album album);
		//查询当前页的相册
		public AlbumBean findAllAlbum(AlbumBean bean);
		//上传图片
		public void addNewPhoto(Photo p);
		//查询出url未赋值的photo
		public List<Photo> findDefaultUrlPhoto(Integer albumId);
		//update photo
		public void updatePhoto(Photo p);
		//查询当前页的图片
		public PhotoBean findAllPhoto(PhotoBean bean);
		//设置封面
		public void updateAlbum(Integer photoId);
		//删除图片
		public void deletePhoto(Integer photoId);
		//当前用户的所有图片
		public List<Photo> allMyPhotos(Integer userId);
		
		//评论文章
		public void addCommentToArticle(CommentOfArticle c);
		//获取评论
		public List<CommentOfArticle> getComments(Integer aId);
		//删除文章
		public void deleteArticle(Integer articleId);
		//更改点击次数
		public void updateArticle(Article a);
		
		//动态提醒信息
		public void addDynamicMessage(DynamicMessage dm);
		//更改动态信息状态
		public void updateDm(Integer userId);
		//查找动态信息
		public List<DynamicMessage> getDms(DynamicMessage dm);
		
}
