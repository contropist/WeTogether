package com.wetogether.personalCenter.dto;

import java.util.ArrayList;
import java.util.List;

import com.wetogether.common.hibernate.pojos.Photo;
import com.wetogether.common.util.dividePageSize.PageSize;
import com.wetogether.common.util.dividepage.DividePage;

public class PhotoBean extends BaseBean {
	private DividePage page = new DividePage(PageSize.PAGESIZE_OF_PHOTO);
	private List<Photo> photos = new ArrayList<Photo>();
	public DividePage getPage() {
		return page;
	}
	public void setPage(DividePage page) {
		this.page = page;
	}
	public List<Photo> getPhotos() {
		return photos;
	}
	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}
	
	
}
