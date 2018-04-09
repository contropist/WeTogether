package com.wetogether.personalCenter.vo;

import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

import com.wetogether.common.hibernate.pojos.Album;
import com.wetogether.common.hibernate.pojos.Photo;
import com.wetogether.common.hibernate.pojos.User;
import com.wetogether.common.util.PubUtil.DateFormater;

public class AlbumVo {
	private Integer albumId;
	private User albumOwer;
	private String albunName;
	private String albumDesc;
	private String createTime;
	//相册封面
	private String indexPhoto;
	private Set<Photo> photos = new TreeSet<Photo>();
	
	public void setAll(Album album){
		this.albumId = album.getAlbumId();
		this.albumDesc = album.getAlbumDesc();
		this.albumOwer = album.getAlbumOwer();
		this.albunName = album.getAlbunName();
		this.indexPhoto = album.getIndexPhoto();
		this.createTime = DateFormater.formater(album.getCreateTime(), DateFormater.DATETIME2);
		this.photos = album.getPhotos();
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

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getIndexPhoto() {
		return indexPhoto;
	}

	public void setIndexPhoto(String indexPhoto) {
		this.indexPhoto = indexPhoto;
	}

	public Set<Photo> getPhotos() {
		return photos;
	}

	public void setPhotos(Set<Photo> photos) {
		this.photos = photos;
	}
	
	
}
