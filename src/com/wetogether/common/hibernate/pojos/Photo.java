package com.wetogether.common.hibernate.pojos;

public class Photo {
	private Integer photoId;
	private Album albumId;
	private String photoName;
	private String photoDesc;
	private String photoSrc;
	public Integer getPhotoId() {
		return photoId;
	}
	public void setPhotoId(Integer photoId) {
		this.photoId = photoId;
	}
	public Album getAlbumId() {
		return albumId;
	}
	public void setAlbumId(Album albumId) {
		this.albumId = albumId;
	}
	public String getPhotoName() {
		return photoName;
	}
	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}
	public String getPhotoDesc() {
		return photoDesc;
	}
	public void setPhotoDesc(String photoDesc) {
		this.photoDesc = photoDesc;
	}
	public String getPhotoSrc() {
		return photoSrc;
	}
	public void setPhotoSrc(String photoSrc) {
		this.photoSrc = photoSrc;
	}
	
	
	
}
