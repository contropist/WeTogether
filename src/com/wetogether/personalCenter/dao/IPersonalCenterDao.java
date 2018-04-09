package com.wetogether.personalCenter.dao;

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
import com.wetogether.personalCenter.dto.ArticleVOs;
import com.wetogether.personalCenter.dto.CommentsBean;
import com.wetogether.personalCenter.dto.OSsBean;
import com.wetogether.personalCenter.dto.PhotoBean;

public interface IPersonalCenterDao {
	public void insertNewFriend(Friend friend);
	public void insertNewComment(Comment comment);
	public void insertNewOs(OriginalSignature os);
	
	public List<Friend> findAllFriends(Integer currentUserId);
	public List<Friend> findMyFriendByName(String name,Integer currentUserId);
	public OSsBean findAllOssOfMyFriends(User currentUser,OSsBean oSsBean);
	public OSsBean findAllOssOfMine(User currentUser,OSsBean oSsBean);
	
	
	public OriginalSignature  findOSById(Integer id);
	public void addNewCommentToOs(Comment comment);
	//赞说说
	public Integer zanOs(ZanTable zan);
	//删除说说
	public void deleteOS(OriginalSignature os);
	
	public User findUserById(Integer userId);
	public Friend findFriendByFriendUserId(Integer id,Integer myId);
	
	
	
	public CommentsBean findAllComments(Integer currentUserId);
	
	//---------------------------------------------------
	public void insertNewArticle(Article article);
	public Article findArticle(Article article);
	public List<Article> findAllArticles(ArticleVOs vo);
	//留言
	public void insertBbs(BBS bbs);
	public List<BBS> getBBSs(Integer userId);
	//新建相册
	public void insertAlbum(Album album);
	//查询当前页的相册
	public List findAllAlbum(AlbumBean bean);
	//上传图片
	public void insertPhoto(Photo p);
	//查询出url未赋值的图片信息
	public List<Photo> findDefaltUrlPhoto(Integer albumId);
	//update photo
	public void updatePhoto(Photo p);
	//查询出当前页的所有图片
	public List<Photo> findAllPhoto(PhotoBean bean);
	//查询所有图片
	public List<Photo> myAllPhotos(Integer userId);
	//主键查询图片
	public Photo findPhotoByID(Integer photoId);
	//主键查询相册
	public Album findAlbumByID(Integer albumId);
	//设置封面
	public void updateAlbumIndex(Album a);
	//删除图片
	public void deletePhoto(Photo p);
	
	
	//评论文章
	public void addCommentToArticle(CommentOfArticle c);
	//删除文章
	public void removeArticle(Integer articleId);
	//更改点击次数
	public void updateArticle(Article a);
	//获取评论
	public List<CommentOfArticle> getComments(Integer aId);
	
	
	//动态提醒信息
	public void addDynamicMessage(DynamicMessage dm);
	//获取动态信息
	public List<DynamicMessage> getDm(DynamicMessage d);
	//更改消息状态
	public void updateDm(Integer userId);
}		
