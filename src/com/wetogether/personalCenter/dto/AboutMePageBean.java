package com.wetogether.personalCenter.dto;

import java.util.ArrayList;
import java.util.List;

import com.wetogether.common.util.dividePageSize.PageSize;
import com.wetogether.common.util.dividepage.DividePage;

public class AboutMePageBean {
	//注意此处一定要New一个。否则空指针
		private DividePage page = new DividePage(PageSize.PAGESIZE_OF_ABOUT_ME);
		private List<AboutMeBean> dms = new ArrayList<AboutMeBean>();
		public DividePage getPage() {
			return page;
		}
		public void setPage(DividePage page) {
			this.page = page;
		}
		public List<AboutMeBean> getDms() {
			return dms;
		}
		public void setDms(List<AboutMeBean> dms) {
			this.dms = dms;
		}
		
		
		

}
