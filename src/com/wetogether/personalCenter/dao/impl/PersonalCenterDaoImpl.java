package com.wetogether.personalCenter.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateTemplate;

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
import com.wetogether.personalCenter.dao.IPersonalCenterDao;
import com.wetogether.personalCenter.dto.AlbumBean;
import com.wetogether.personalCenter.dto.ArticleVOs;
import com.wetogether.personalCenter.dto.CommentsBean;
import com.wetogether.personalCenter.dto.OSsBean;
import com.wetogether.personalCenter.dto.PhotoBean;

public class PersonalCenterDaoImpl implements IPersonalCenterDao {
	private HibernateTemplate hibernateTemplate;

	
//添加新好友
	@Override
	public void insertNewFriend(Friend friend) {
		hibernateTemplate.save(friend);
		
		
	}
	
	//新建相册
	@Override
	public void insertAlbum(Album album) {
		this.hibernateTemplate.save(album);	
		
	}


	@Override
	public void insertNewComment(Comment comment) {
		// TODO Auto-generated method stub
		
	}

	//插入新说说
	@Override
	public void insertNewOs(OriginalSignature os) {
		this.hibernateTemplate.save(os);
	}

	
	//获得当前用户下的所有好友信息
	@Override
	public List<Friend> findAllFriends(Integer currentUserId) {
		String hql  = "from Friend f where f.currentUser.userId=:userId";
		@SuppressWarnings("unchecked")
		List<Friend> friends = hibernateTemplate.findByNamedParam(hql, "userId", currentUserId) ;
		return friends;
	}


	@Override
	public CommentsBean findAllComments(Integer currentUserId) {
		// TODO Auto-generated method stub
		return null;
	}

	
	//通过姓名关键字搜索当前用户的好友（用于AJAX）
	@Override
	public List<Friend> findMyFriendByName(String name,Integer currendUserId) {
		String hql = "from Friend f where f.currentUser.userId=:userId and f.friendUser.userName like :name";
		String [] para = {"userId","name"};
		Object[] val = {currendUserId,name+"%"};
		@SuppressWarnings("unchecked")
		List<Friend> friends = hibernateTemplate.findByNamedParam(hql, para, val);
		
		
		 return friends;
	}
	
	
	//查询当前用户好友的所有说说（order by time）
	@Override
	public OSsBean findAllOssOfMyFriends(User currentUser,OSsBean oSsBean) {
//		List<Friend> friends = this.findAllFriends(currentUser.getUserId());	
		String hql = "from OriginalSignature o where o.osOwer.userId in "+
					"(select f.friendUser.userId from Friend f where f.currentUser.userId =:currentUserId)"+
					"order by o.osSubmitDate desc";
		Session session	 = hibernateTemplate.getSessionFactory().openSession();
		Query q =  session.createQuery(hql);
		
		q.setParameter("currentUserId", currentUser.getUserId());
		//获得记录总数
		List<OriginalSignature> oss = q.list();
		//计算总共多少页
		oSsBean.getPage().setTotalPages((oss.size()/oSsBean.getPage().getPageSize())+1);

		q.setFirstResult((oSsBean.getPage().getCurrentPage()-1)<<3);
		q.setMaxResults(oSsBean.getPage().getPageSize());
		oss = q.list();
		oSsBean.setOss(oss);
		session.close();
		return oSsBean;
	}
	
	
//查询当前用户自身的所有说说（order by time）
	@SuppressWarnings("unchecked")
	@Override
	public OSsBean findAllOssOfMine(User currentUser,OSsBean oSsBean) {
		String hql = "from OriginalSignature o where o.osOwer.userId =:id order by o.osSubmitDate desc  ";
		Session session	 = hibernateTemplate.getSessionFactory().openSession();
		Query q =  session.createQuery(hql);
		
		q.setParameter("id", currentUser.getUserId());
		//获得记录总数
		List<OriginalSignature> oss = q.list();
		//计算总共多少页
		oSsBean.getPage().setTotalPages((oss.size()/oSsBean.getPage().getPageSize())+1);

		q.setFirstResult((oSsBean.getPage().getCurrentPage()-1)<<3);
		q.setMaxResults(oSsBean.getPage().getPageSize());
		oss = q.list();
		oSsBean.setOss(oss);
		session.close();
		return oSsBean;
	}
	
	
	
	//上传图片
	@Override
	public void insertPhoto(Photo p) {
		this.hibernateTemplate.save(p);
	}
	
	
	//查询出url未赋值的photo
	@SuppressWarnings("unchecked")
	@Override
	public List<Photo> findDefaltUrlPhoto(Integer id) {
		String hql = "from Photo p where p.albumId.albumId=:id and p.photoSrc=:src";
		String [] paras = {"id","src"};
		Object [] values = {id,CodeCst.PHOTO_DEFAULT_URL};
		return this.hibernateTemplate.findByNamedParam(hql, paras, values);
	}

	
	//update photo
	@Override
	public void updatePhoto(Photo p) {
			Photo photo = this.hibernateTemplate.get(Photo.class, p.getPhotoId());
			photo.setAlbumId(p.getAlbumId());
			photo.setPhotoDesc(p.getPhotoDesc());
			photo.setPhotoName(p.getPhotoName());
			photo.setPhotoSrc(p.getPhotoSrc());
			this.hibernateTemplate.update(photo);
		
	}
	//查询当前页的所有相册
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Photo> findAllPhoto(PhotoBean bean) {
		String hql = "from Photo p where p.albumId.albumId=:abId order by p.photoId desc";
		Session session	 = hibernateTemplate.getSessionFactory().openSession();
		Query q =  session.createQuery(hql.toString());
		q.setParameter("abId", bean.getAlbum().getAlbumId());
		// 获得记录总数
		Integer allrows = q.list().size();
		bean.getPage().setAllRows(allrows);
		// 计算总共多少页
		int pageSize = bean.getPage().getPageSize();
		if (allrows != 0 && allrows % pageSize == 0) {
			bean.getPage().setTotalPages(allrows / pageSize);
		} else {
			bean.getPage().setTotalPages((allrows / pageSize) + 1);
		}
		q.setFirstResult((bean.getPage().getCurrentPage()-1)*(bean.getPage().getPageSize()));
		q.setMaxResults(bean.getPage().getPageSize());
		List result = q.list();
		session.close();
		return result;
	}

	//获得当前用户的所有图片
	@Override
	public List<Photo> myAllPhotos(Integer userId) {
		String hql = "from Photo p where p.albumId.albumId in (select a.albumId from Album a where a.albumOwer.userId=:id) order by p.photoId desc";
		@SuppressWarnings("unchecked")
		List<Photo> photos = this.hibernateTemplate.findByNamedParam(hql, "id", userId);
		return photos;
	}

	//查询当前页的相册
	@Override
	public List<Album> findAllAlbum(AlbumBean bean) {
		String hql = "from Album a where a.albumOwer.userId=:id order by a.createTime desc";	
		Session session	 = hibernateTemplate.getSessionFactory().openSession();
		Query q =  session.createQuery(hql.toString());
		
		q.setParameter("id", bean.getUser().getUserId());
		//获得记录总数
		Integer allrows = q.list().size();
		bean.getPage().setAllRows(allrows);
		//计算总共多少页
		int pageSize = bean.getPage().getPageSize();
		if(allrows!=0&&allrows%pageSize==0){
			bean.getPage().setTotalPages(allrows/pageSize);
		}else{
			bean.getPage().setTotalPages((allrows/pageSize)+1);
		}

		q.setFirstResult((bean.getPage().getCurrentPage()-1)*(bean.getPage().getPageSize()));
		q.setMaxResults(bean.getPage().getPageSize());
		List result = q.list();
		session.close();
		return result;
	}

	//通过userId 查找User
	@Override
	public User findUserById(Integer userId) {
		String hql = "from User u where u.userId = :userId";
		@SuppressWarnings("unchecked")
		List<User>users = hibernateTemplate.findByNamedParam(hql, "userId", userId);
		if(users.size()>0){
			return users.get(0);
		}
		return null;
	}

	
//	通过好友ID查询好友
	@Override
	public Friend findFriendByFriendUserId(Integer id,Integer myId) {
		String hql = "from Friend f where f.currentUser.userId=:myId and f.friendUser.userId=:id";
		String [] para = {"myId","id"};
		Object [] values = {myId,id};
		@SuppressWarnings("unchecked")
		List<Friend>  f = hibernateTemplate.findByNamedParam(hql, para, values);
		if(f.size()!=0){
			return f.get(0);
		}
		return null;
		
	}

	
//通过OS ID找到对应的OS	
	@Override
	public OriginalSignature findOSById(Integer id) {
		return hibernateTemplate.get(OriginalSignature.class, id);
	}

	//add new article
	@Override
	public void insertNewArticle(Article article) {
		hibernateTemplate.save(article);
	}

	//赞说说
	@Override
	public Integer zanOs(ZanTable zan) {
		String hql = "from ZanTable z where z.os.originalSignatureId=:osid and z.zanUser.userId=:userId";
		String [] parasVar = {"osid","userId"};
		Object [] values = {zan.getOs().getOriginalSignatureId(),zan.getZanUser().getUserId()};
		List zans = this.hibernateTemplate.findByNamedParam(hql,parasVar,values);
		if(zans.size()>0){
			return CodeCst.ZAN_ALREADY;
		}
		this.hibernateTemplate.save(zan);
		return CodeCst.ZAN_SUCCESS;
	}
	
	//删除说说
	@Override
	public void deleteOS(OriginalSignature os) {
		OriginalSignature targetOs = this.hibernateTemplate.get(OriginalSignature.class, os.getOriginalSignatureId());
		this.hibernateTemplate.delete(targetOs);
		
	}

	//查询指定文章
	@Override
	public Article findArticle(Article article) {
		return hibernateTemplate.get(Article.class, article.getArticleId());
	}

	//查询当前用户的对应分类下的所有文章
	@SuppressWarnings("unchecked")
	@Override
	public List<Article> findAllArticles(ArticleVOs vo) {
		StringBuffer hql = new StringBuffer();
		hql.append("from Article o where o.articleOwerId.userId =:id and ");
		hql.append("o.articleCategory.categoryId =:caId order by o.subDate desc ");
		Session session	 = hibernateTemplate.getSessionFactory().openSession();
		Query q =  session.createQuery(hql.toString());
		
		q.setParameter("id", vo.getCurrentUser().getUserId());
		q.setParameter("caId", vo.getCateroryId());
		//获得记录总数
		List<Article> articles = q.list();
		//计算总共多少页
		int allrows = articles.size();
		int pageSize = vo.getPage().getPageSize();
		if(allrows!=0&&allrows%pageSize==0){
			vo.getPage().setTotalPages(allrows/pageSize);
		}else{
			vo.getPage().setTotalPages((allrows/pageSize)+1);
		}

		q.setFirstResult((vo.getPage().getCurrentPage()-1)*(vo.getPage().getPageSize()));
		q.setMaxResults(vo.getPage().getPageSize());
		articles = q.list();
		session.close();
		return articles;
	}


	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	//给OS插入评论
	@Override
	public void addNewCommentToOs(Comment comment) {
		hibernateTemplate.save(comment);
	}
//留言
	@Override
	public void insertBbs(BBS bbs) {
		this.hibernateTemplate.save(bbs);
	}
	
	//主键查图片
	@Override
	public Photo findPhotoByID(Integer photoId) {
		Photo p = this.hibernateTemplate.get(Photo.class,photoId);
		return p;
	}
	
	//查找留言	
	@SuppressWarnings("unchecked")
	@Override
	public List<BBS> getBBSs(Integer userId) {
		String hql = "from BBS b where b.bbsOwer.userId =:id order by b.subDate desc ";
		return this.hibernateTemplate.findByNamedParam(hql, "id", userId);
	}

	//主键查相册
	@Override
	public Album findAlbumByID(Integer albumId) {
		Album a = this.hibernateTemplate.get(Album.class, albumId);
		return a;
	}

	//设置封面
	@Override
	public void updateAlbumIndex(Album a) {
		Album album = this.findAlbumByID(a.getAlbumId());
		album.setIndexPhoto(a.getIndexPhoto());
		this.hibernateTemplate.update(album);
		
	}
//删除图片
	@Override
	public void deletePhoto(Photo p) {
		this.hibernateTemplate.delete(p);
		
	}

	//评论文章
	@Override
	public void addCommentToArticle(CommentOfArticle c) {
		this.hibernateTemplate.save(c);
	}

	//获取评论
	@SuppressWarnings("unchecked")
	@Override
	public List<CommentOfArticle> getComments(Integer aId) {
		String hql = "from CommentOfArticle c where c.articleId.articleId =:id order by c.subDate desc";
		return this.hibernateTemplate.findByNamedParam(hql, "id", aId);
	}

	//动态提醒信息
	@Override
	public void addDynamicMessage(DynamicMessage dm) {
		this.hibernateTemplate.save(dm);
	}
	//获取动态信息
	@Override
	public List<DynamicMessage> getDm(DynamicMessage d) {
		String hql = "from DynamicMessage d where d.toWho.userId =:uId and d.messageStatus=1";
		return this.hibernateTemplate.findByNamedParam(hql, "uId", d.getToWho().getUserId());
	}
	//更改消息状
	@Override
	public void updateDm(Integer userId) {
		String hql = "from DynamicMessage d  where d.toWho.userId=:uId";
		List<DynamicMessage> list = this.hibernateTemplate.findByNamedParam(hql, "uId", userId);
		for(int i = 0;i<list.size();i++){
			DynamicMessage d = list.get(i);
			d.setMessageStatus(0);
			this.hibernateTemplate.update(d);
		}
	}


	//删除文章
	public void removeArticle(Integer articleId){
		Article a = this.hibernateTemplate.get(Article.class, articleId);
		this.hibernateTemplate.delete(a);
	}
	//更改点击次数
	public void updateArticle(Article a){
		Article b = this.hibernateTemplate.get(Article.class, a.getArticleId());
		b.setClickTime(b.getClickTime()+1);
		this.hibernateTemplate.update(b);
	}

	

	
	

}
