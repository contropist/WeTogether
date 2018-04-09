package com.wetogether.personalCenter.dto;

import java.util.ArrayList;
import java.util.List;

import com.wetogether.common.hibernate.pojos.User;
import com.wetogether.common.util.dividePageSize.PageSize;
import com.wetogether.common.util.dividepage.DividePage;
/*
 * 存放article的容器
 */
public class ArticleVOs {
	private DividePage page = new DividePage(PageSize.PAGESIZE_OF_ARTICLE);
	private List<ArticleBean> beans = new ArrayList<ArticleBean>();
	private transient User currentUser;
	private Integer cateroryId;
	public DividePage getPage() {
		return page;
	}
	public void setPage(DividePage page) {
		this.page = page;
	}
	public List<ArticleBean> getBeans() {
		return beans;
	}
	public void setBeans(List<ArticleBean> beans) {
		this.beans = beans;
	}
	public User getCurrentUser() {
		return currentUser;
	}
	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}
	public Integer getCateroryId() {
		return cateroryId;
	}
	public void setCateroryId(Integer cateroryId) {
		this.cateroryId = cateroryId;
	}
	
	
	
}
