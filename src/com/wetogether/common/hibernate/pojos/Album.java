package com.wetogether.common.hibernate.pojos;

import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

public class Album {
	private Integer albumId;
	private User albumOwer;
	private String albunName;
	private String albumDesc;
	private Date createTime;
	//相册封面
	private String indexPhoto;
	private Set<Photo> photos = new TreeSet<Photo>();
	
	public String getIndexPhoto() {
		return indexPhoto;
	}
	public void setIndexPhoto(String indexPhoto) {
		this.indexPhoto = indexPhoto;
	}
	public Integer getAlbumId() {
		return albumId;
	}
	public void setAlbumId(Integer albumId) {
		this.albumId = albumId;
	}
	public User getAlbumOwer() {
		return albumOwer;
	}
	public void setAlbumOwer(User albumOwer) {
		this.albumOwer = albumOwer;
	}
	public String getAlbunName() {
		return albunName;
	}
	public void setAlbunName(String albunName) {
		this.albunName = albunName;
	}
	public String getAlbumDesc() {
		return albumDesc;
	}
	public void setAlbumDesc(String albumDesc) {
		this.albumDesc = albumDesc;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Set<Photo> getPhotos() {
		return photos;
	}
	public void setPhotos(Set<Photo> photos) {
		this.photos = photos;
	}
	
}
