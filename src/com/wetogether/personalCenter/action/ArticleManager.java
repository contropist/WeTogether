package com.wetogether.personalCenter.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.wetogether.common.hibernate.pojos.Article;
import com.wetogether.common.hibernate.pojos.CommentOfArticle;
import com.wetogether.common.hibernate.pojos.OriginalSignature;
import com.wetogether.common.hibernate.pojos.User;
import com.wetogether.common.util.CodeCst;
import com.wetogether.personalCenter.dto.ArticleBean;
import com.wetogether.personalCenter.dto.ArticleVOs;
import com.wetogether.personalCenter.dto.CommentOfArticleBean;
import com.wetogether.personalCenter.service.IPersonalCenterServices;

public class ArticleManager extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IPersonalCenterServices iPersonalCenterServices;
	
	//定义articleBean对象
	private ArticleBean  articleBean;
	
	//定义article对象
	private Article article;
	
	//定义ArticleVOs对象
	private ArticleVOs articleVOs;
	
	//定义存放在session中的user
	private  User sessionUser = (User)	ActionContext.getContext().getSession().get(CodeCst.SESSION_USER_NAME);
	//获得请求类型，普通方式还是ajax方式
	private String requestType;
	//获得request对象
	private HttpServletRequest request = ServletActionContext.getRequest();
	// 定义response输出流对象
	private PrintWriter pw;
	// 定义JSON对象
	private Gson gson = new GsonBuilder().create();
	
	//评论
	private CommentOfArticle comment;
	
	private Integer articleId;
	
	private String commentContent;
	
	//评论文章
	public String comment() throws IOException{
		comment = new CommentOfArticle();
		Article a = new Article();
		a.setArticleId(articleId);
		comment.setArticleId(a);
		// 转换表情代码为图片路径
		String text = this.commentContent;
		String reg = "\\[em_([0-9]*)\\]";
		String rep = "<img src='/WeTogether/web/img/face/$1.gif' border='0'> ";
		String after = text.replaceAll(reg, rep);
		comment.setCommentContent(after);
		// end
		
		comment.setCommenter(sessionUser);
		comment.setSubDate(new Date());
		this.iPersonalCenterServices.addCommentToArticle(comment);
		CommentOfArticleBean bean = new CommentOfArticleBean();
		bean.setAll(comment);
		String result = gson.toJson(bean);
		pw = ServletActionContext.getResponse().getWriter();
		pw.write(result);
		pw.close();
		return null;
	}
	
	//获取评论
	public String getComments(){
		List<CommentOfArticle> comments = this.iPersonalCenterServices.getComments(articleId); 
		request.setAttribute("comments", comments);
		return null;
	}
	
	//add new article
	public String addNewArticle() throws IOException{
		article.setArticleOwerId(sessionUser);
		iPersonalCenterServices.addNewArticle(article);
		OriginalSignature os = new OriginalSignature();
		StringBuffer osContent =  new StringBuffer();
		osContent.append("<span style='color:grey;'>发表了新文章：《"+article.getArticleName()+"》</span><br>");
		String temp = null;
		if(article.getArticleContent().length()>60){
			 temp = article.getArticleContent().substring(0, 60)+"...";
		}else{
			temp = article.getArticleContent();
		}
		osContent.append("<a target=\"_blank\" href='showArticleByArticleId?article.articleId="+article.getArticleId()+"'>");
		osContent.append(temp+"</a>");
		os.setOsContent(osContent.toString());
		this.iPersonalCenterServices.addNewOs(getSessionUser(), os);
		pw = ServletActionContext.getResponse().getWriter();
		pw.write("OK");
		pw.close();
		return null;
	}
	//查询到指定文章
	public String findArticle(){
		if(articleBean==null){
			articleBean  = new ArticleBean();
		}
		
		articleBean = iPersonalCenterServices.findArticle(article);
		// 查到文章后点击数加1
		this.iPersonalCenterServices.updateArticle(article);
		
		return SUCCESS;
	}
	//查询当前用户的指定分类的所有文章
	public String findAllArticle() throws IOException{
		//为了避免空指针，当发出没有参数的请求时返回类型为1的第一页的文章
		if(articleVOs==null){
			articleVOs = new ArticleVOs();
			articleVOs.setCateroryId(1);
			articleVOs.getPage().setCurrentPage(1);
		}
		articleVOs.setCurrentUser(sessionUser);
		articleVOs = iPersonalCenterServices.FindAllArticle(articleVOs);
		request.setAttribute("articleVOs", articleVOs);
		//普通方式
		if(requestType==null){
			
			return SUCCESS;
		}else{//ajax方式
			pw = ServletActionContext.getResponse().getWriter();
			String vo = gson.toJson(articleVOs);
			pw.write(vo);
			pw.close();
			return SUCCESS;
		}
		
	}
	
	public String deleteArticle() throws IOException{
		this.iPersonalCenterServices.deleteArticle(article.getArticleId());
		pw = ServletActionContext.getResponse().getWriter();
		pw.write("OK");
		pw.close();
		return null;
	}
	
	
	
	public ArticleBean getArticleBean() {
		return articleBean;
	}




	public ArticleVOs getArticleVOs() {
		return articleVOs;
	}
	public void setArticleVOs(ArticleVOs articleVOs) {
		this.articleVOs = articleVOs;
	}
	public void setArticleBean(ArticleBean articleBean) {
		this.articleBean = articleBean;
	}




	public Article getArticle() {
		return article;
	}




	public void setArticle(Article article) {
		this.article = article;
	}




	public User getSessionUser() {
		return sessionUser;
	}
	public void setSessionUser(User sessionUser) {
		this.sessionUser = sessionUser;
	}
	public PrintWriter getPw() {
		return pw;
	}
	public void setPw(PrintWriter pw) {
		this.pw = pw;
	}
	public Gson getGson() {
		return gson;
	}
	public void setGson(Gson gson) {
		this.gson = gson;
	}
	public IPersonalCenterServices getiPersonalCenterServices() {
		return iPersonalCenterServices;
	}
	public void setiPersonalCenterServices(
			IPersonalCenterServices iPersonalCenterServices) {
		this.iPersonalCenterServices = iPersonalCenterServices;
	}
	public String getRequestType() {
		return requestType;
	}
	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}
	public HttpServletRequest getRequest() {
		return request;
	}
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public CommentOfArticle getComment() {
		return comment;
	}

	public void setComment(CommentOfArticle comment) {
		this.comment = comment;
	}

	public Integer getArticleId() {
		return articleId;
	}

	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	
	
	
	
	
	
	
}
