package com.wetogether.personalCenter.dto;

import com.wetogether.common.hibernate.pojos.DynamicMessage;
import com.wetogether.common.util.PubUtil.DateFormater;

public class AboutMeBean {
	private String content;

	public void madeContent(DynamicMessage dm){
		StringBuffer newContent = new StringBuffer();
		String fromWhoName = dm.getFromWho().getNickName();
		Integer typeId = dm.getMessageType().getMessageTypeId();
		String typeName = dm.getMessageType().getMessageTypenName();
		String subTime = DateFormater.formater(dm.getMessageTime(), DateFormater.DATETIME4);
		newContent.append("<p class='font1'><span style='color:red' >"+fromWhoName+"</span>在&nbsp&nbsp"+subTime+"&nbsp&nbsp"+typeName+":");
		switch(typeId){
			case 1:
				
		}
		newContent.append("</p>");
	}
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
}
