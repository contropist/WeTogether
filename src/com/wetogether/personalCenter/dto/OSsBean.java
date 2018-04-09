package com.wetogether.personalCenter.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.wetogether.common.hibernate.pojos.OriginalSignature;
import com.wetogether.common.util.dividepage.DividePage;

public class OSsBean {

	
	
	//注意此处一定要New一个。否则空指针
	private DividePage page = new DividePage();
	private List<OriginalSignature> oss = new ArrayList<OriginalSignature>();


	public DividePage getPage() {
		return page;
	}

	public void setPage(DividePage page) {
		this.page = page;
	}

	public List<OriginalSignature> getOss() {
		return oss;
	}

	public void setOss(List<OriginalSignature> oss) {
		this.oss = oss;
	}






	
	
	
	
}
