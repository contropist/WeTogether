package com.wetogether.personalCenter.dto;

import java.util.ArrayList;
import java.util.List;

import com.wetogether.common.util.dividePageSize.PageSize;
import com.wetogether.common.util.dividepage.DividePage;
import com.wetogether.personalCenter.vo.AlbumVo;

public class AlbumBean extends BaseBean {
	private DividePage page = new DividePage(PageSize.PAGESIZE_OF_ALBUM);
	private List<AlbumVo> albums = new ArrayList<AlbumVo>();
	public DividePage getPage() {
		return page;
	}
	public void setPage(DividePage page) {
		this.page = page;
	}
	public List<AlbumVo> getAlbums() {
		return albums;
	}
	public void setAlbums(List<AlbumVo> albums) {
		this.albums = albums;
	}
	
	
}
