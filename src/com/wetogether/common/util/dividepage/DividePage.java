package com.wetogether.common.util.dividepage;

import java.util.List;

public class DividePage {
	
	//总的记录数
	private Integer allRows;
	//总的页数
	private Integer totalPages;
	//当前页
	private Integer currentPage;
	//每页显示数量
	private Integer pageSize;
	//首页的url
	private String firstPageUrl;
	//上一页的url
	private String previousPageUrl;
	//下一页的url
	private String nextPageUrl;
	//尾页的url
	private String lastPageUrl;
	//当前页的内容
	private transient List<Object> currentPageContent;
	
	public  DividePage(){}
	public DividePage(int size){
		this.pageSize = size;
	}
	public DividePage(int allrow ,int currentpage ,int size){
		this.currentPage = allrow ;
		this.currentPage = currentpage;
		this.pageSize = size;
		this.totalPages = 1+(allRows/pageSize);
	}
	
	public void setAllUrl(String actionName,String pramString){
		
	}
	
	

	public String getFirstPageUrl() {
		return firstPageUrl;
	}
	public void setFirstPageUrl(String firstPageUrl) {
		this.firstPageUrl = firstPageUrl;
	}
	public String getPreviousPageUrl() {
		return previousPageUrl;
	}
	public void setPreviousPageUrl(String previousPageUrl) {
		this.previousPageUrl = previousPageUrl;
	}
	public String getNextPageUrl() {
		return nextPageUrl;
	}
	public void setNextPageUrl(String nextPageUrl) {
		this.nextPageUrl = nextPageUrl;
	}
	public String getLastPageUrl() {
		return lastPageUrl;
	}
	public void setLastPageUrl(String lastPageUrl) {
		this.lastPageUrl = lastPageUrl;
	}
	public Integer getAllRows() {
		return allRows;
	}



	public void setAllRows(Integer allRows) {
		this.allRows = allRows;
	}



	public Integer getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}



	public List<Object> getCurrentPageContent() {
		return currentPageContent;
	}



	public void setCurrentPageContent(List<Object> currentPageContent) {
		this.currentPageContent = currentPageContent;
	}

	
	
	
	

}
