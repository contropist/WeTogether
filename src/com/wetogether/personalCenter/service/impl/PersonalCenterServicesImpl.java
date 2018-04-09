package com.wetogether.personalCenter.service.impl;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Date;
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
import com.wetogether.common.util.CodeCst;
import com.wetogether.common.util.dividePageSize.PageSize;
import com.wetogether.common.util.personalcenterOpes.AddNewFriendResult;
import com.wetogether.personalCenter.dao.IPersonalCenterDao;
import com.wetogether.personalCenter.dto.AlbumBean;
import com.wetogether.personalCenter.dto.ArticleBean;
import com.wetogether.personalCenter.dto.ArticleVOs;
import com.wetogether.personalCenter.dto.OSsBean;
import com.wetogether.personalCenter.dto.PhotoBean;
import com.wetogether.personalCenter.service.IPersonalCenterServices;
import com.wetogether.personalCenter.vo.AlbumVo;

public class PersonalCenterServicesImpl implements IPersonalCenterServices {
	private IPersonalCenterDao pcDao;

	@Override
	public List<Friend> findAllFriends(Integer currentId) {
		
		return pcDao.findAllFriends(currentId);
	}


	//返回搜索好友提示的好友ID数组（AJAX）
	@Override
	public List<Integer> returnFindFriendIdList(String name,Integer currentUserId) {
		List<Friend> friends = pcDao.findMyFriendByName(name,currentUserId);	 
		List<Integer> friendIds = new ArrayList<Integer>();
		for(Friend f : friends){
			friendIds.add(f.getFriendUser().getUserId());
		}
		
		return friendIds;
	}
	
	


//插入当前用户新说说（AJAX）
	@Override
	public void addNewOs(User currentUser,OriginalSignature os) {
		os.setOsOwer(currentUser);
		os.setOsSubmitDate(new Date());
		pcDao.insertNewOs(os);
		
	}

	//通过id查找User
	@Override
	public User findUserById(Integer userId) {
		return pcDao.findUserById(userId);
	}


	

	//删除说说
	@Override
	public void deleteOS(OriginalSignature os) {
		this.pcDao.deleteOS(os);
		
	}


	//添加新好友
	@Override
	public Integer addNewFriend(Friend friend,User currentUser) {
		List<Friend> fs = pcDao.findAllFriends(currentUser.getUserId());
		boolean found = false;
		for(int i = 0;i<fs.size();i++){
			if(fs.get(i).getFriendUser().getUserId()==friend.getFriendUser().getUserId()){
				found = true;
			}
		}
		
		//Can not add myself as my friend
		if(friend.getFriendUser().getUserId()==currentUser.getUserId()){
			return AddNewFriendResult.FRIEND_SAME_SELF;
		}
		if(!found){
			friend.setAddDate(new Date());
			pcDao.insertNewFriend(friend);
			return AddNewFriendResult.FRIEND_ADD_SUCCESS;
		}
		
		return AddNewFriendResult.FRIEND_EXISTED;
	}


	
	
	
	//留言
@Override
	public void addBbs(BBS bbs) {
		bbs.setSubDate(new Date());
		this.pcDao.insertBbs(bbs);
		
	}



//查找留言
@Override
public List<BBS> getBBSs(Integer userId) {
	return this.pcDao.getBBSs(userId);
}


//赞说说
@Override
	public Integer addZanToOs(ZanTable zan) {
		return pcDao.zanOs(zan);
	}


	//通过传进来的包含好友ID的friend对象查找到好友的详细信息
	@Override
	public Friend findFriendMessage(Friend friend,User currentUser) {
		return pcDao.findFriendByFriendUserId(friend.getFriendUser().getUserId(),currentUser.getUserId());
	}
	
	//返回所有当前用户的好友说说
	@Override
	public OSsBean findAllOSofMyFriend(User user,OSsBean oSsBean) {
		oSsBean.getPage().setPageSize(PageSize.PAGESIZE_OF_FRIENDOSS);
		return pcDao.findAllOssOfMyFriends(user,oSsBean);
	}
	

	//找到当前用户的所有OS
	@Override
	public OSsBean findAllOSsOfMine(User user,OSsBean oSsBean) {
		//设置每页显示的OS数目
		oSsBean.getPage().setPageSize(PageSize.PAGESIZE_OF_MYOSS);
		return pcDao.findAllOssOfMine(user,oSsBean);
	}

	
	@Override
//找到具体的某一条OS
	public OriginalSignature findOSbyId(OriginalSignature os) {
		return pcDao.findOSById(os.getOriginalSignatureId());
	}

	@Override
	public void addNewArticle(Article article) {
		//转码
//		try {
//			article.setArticleContent(URLDecoder.decode(article.getArticleContent(),"UTF-8"));
//			article.setArticleName(URLDecoder.decode(article.getArticleName(),"UTF-8"));
//		} catch (UnsupportedEncodingException e) {
//			System.out.println("文章内容转码失败@ com.wetogether.personalCenter.service.impl 133行");
//		}
		article.setClickTime(0);
		article.setSubDate(new Date());
		pcDao.insertNewArticle(article);
	}

	//查询到指定文章
	@Override
	public ArticleBean findArticle(Article article) {
		Article targetArticle =  pcDao.findArticle(article);
		ArticleBean articleBean = new ArticleBean();
		articleBean.setAll(targetArticle);
		 return articleBean;
	}
	
	//查询当前用户的对应分类下的所有文章
	@Override
	public ArticleVOs FindAllArticle(ArticleVOs vo) {
		List<Article> articles = pcDao.findAllArticles(vo);
		for(Article a : articles){
			ArticleBean bean = new ArticleBean();
			bean.setAll(a);
			vo.getBeans().add(bean);
		}
		int curPage  =vo.getPage().getCurrentPage();
		int totalPage = vo.getPage().getTotalPages();
		int categoryId  = vo.getCateroryId();
		
		StringBuffer firstUrl = new StringBuffer();
		StringBuffer previousUrl = new StringBuffer();
		StringBuffer nextUrl = new StringBuffer();
		StringBuffer lastUrl = new StringBuffer();
		
		firstUrl.append("<a href=\"#\" onClick=\"jumpPage(");  
		firstUrl.append(1);
		firstUrl.append(",");
		firstUrl.append(categoryId);
		firstUrl.append(")\">首页</a>");
		
		nextUrl.append("<a href=\"#\" onClick=\"jumpPage(");  
		nextUrl.append(curPage+1);
		nextUrl.append(",");
		nextUrl.append(categoryId);
		nextUrl.append(")\">下一页</a>");
		
    	previousUrl.append("<a href=\"#\" onClick=\"jumpPage(");  
		previousUrl.append(curPage-1);
		previousUrl.append(",");
		previousUrl.append(categoryId);
		previousUrl.append(")\">上一页</a>");
		
		lastUrl.append("<a href=\"#\" onClick=\"jumpPage(");  
    	lastUrl.append(totalPage);
    	lastUrl.append(",");
    	lastUrl.append(categoryId);
    	lastUrl.append(")\">尾页</a>");
    	
    	if(totalPage<=1){
    		firstUrl.delete(0, firstUrl.length());
			firstUrl.append("首页"); 
			
			previousUrl.delete(0, previousUrl.length());
			previousUrl.append("上一页");
			
			
			nextUrl.delete(0, nextUrl.length());
			nextUrl.append("下一页");
			
			lastUrl.delete(0, lastUrl.length());
			lastUrl.append("尾页");
		}else{
			if(curPage==1){
				firstUrl.delete(0, firstUrl.length());
				firstUrl.append("首页"); 
				
				previousUrl.delete(0, previousUrl.length());
				previousUrl.append("上一页");
			}
			if(curPage==totalPage){
				nextUrl.delete(0, nextUrl.length());
				nextUrl.append("下一页");
				
				lastUrl.delete(0, lastUrl.length());
				lastUrl.append("尾页");
			}
		}
    	
    	
		
		
		
		vo.getPage().setFirstPageUrl(firstUrl.toString());
		vo.getPage().setPreviousPageUrl(previousUrl.toString());
		vo.getPage().setNextPageUrl(nextUrl.toString());
		vo.getPage().setLastPageUrl(lastUrl.toString());
		
		
		return vo;
	}


	

	public IPersonalCenterDao getPcDao() {
		return pcDao;
	}


	public void setPcDao(IPersonalCenterDao pcDao) {
		this.pcDao = pcDao;
	}


	//添加OS的新评论
	@Override
	public void addNewCommentToOs(Comment comment) {
		comment.setCommentTime(new Date());
		pcDao.addNewCommentToOs(comment);
	}

	//新建相册
	@Override
	public void addNewAlbum(Album album) {
		album.setCreateTime(new Date());
		album.setIndexPhoto(CodeCst.ALBUM_INDEX_PAGE);
		this.pcDao.insertAlbum(album);
	}


	//查询当前页的相册
	@Override
	public AlbumBean findAllAlbum(AlbumBean bean) {
		@SuppressWarnings("unchecked")
		List<Album> albums = this.pcDao.findAllAlbum(bean);
		for(Album a : albums ){
			AlbumVo vo = new AlbumVo();
			vo.setAll(a);
			bean.getAlbums().add(vo);
		}
		return bean;
	}

//上传图片
	@Override
	public void addNewPhoto(Photo p) {
		this.pcDao.insertPhoto(p);
	}

	//查询出url未赋值的photo
	@Override
	public List<Photo> findDefaultUrlPhoto(Integer albumId) {
		return this.pcDao.findDefaltUrlPhoto(albumId);
	}

	//update photo
	@Override
	public void updatePhoto(Photo p) {
		this.pcDao.updatePhoto(p);
	}

//查询当前页的图片
	@SuppressWarnings("unchecked")
	@Override
	public PhotoBean findAllPhoto(PhotoBean bean) {
		@SuppressWarnings("rawtypes")
		List flag = this.pcDao.findAllPhoto(bean);
		bean.setPhotos(flag);
		return bean;
	}

	//设置封面
	@Override
	public void updateAlbum(Integer photoId) {
		Photo p = this.pcDao.findPhotoByID(photoId);
		Album a = this.pcDao.findAlbumByID(p.getAlbumId().getAlbumId());
		a.setIndexPhoto(p.getPhotoSrc());
		this.pcDao.updateAlbumIndex(a);
	}

//删除图片
	@Override
	public void deletePhoto(Integer photoId) {
		Photo p = this.pcDao.findPhotoByID(photoId);
		this.pcDao.deletePhoto(p);
	}

//当前用户的所有图片
	@Override
	public List<Photo> allMyPhotos(Integer userId) {
		return this.pcDao.myAllPhotos(userId);
	}


	//评论文章
	@Override
	public void addCommentToArticle(CommentOfArticle c) {
		c.setSubDate(new Date());
		this.pcDao.addCommentToArticle(c);
	}

//获取评论
	@Override
	public List<CommentOfArticle> getComments(Integer aId) {
		return this.pcDao.getComments(aId);
	}

	//动态提醒信息
	@Override
	public void addDynamicMessage(DynamicMessage dm) {
		dm.setMessageTime(new Date());
		this.pcDao.addDynamicMessage(dm);
		
	}

//更改消息状态
	@Override
	public void updateDm(Integer userId) {
		this.pcDao.updateDm(userId);
	}

//获取动态消息
	@Override
	public List<DynamicMessage> getDms(DynamicMessage dm) {
		return this.pcDao.getDm(dm);
	}

	//删除文章
	public void deleteArticle(Integer articleId){
		this.pcDao.removeArticle(articleId);	
	}
	//更改点击次数
	public void updateArticle(Article a){
		this.pcDao.updateArticle(a);
	}
	







	
	
	
}
