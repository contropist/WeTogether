package com.wetogether.chatroom.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.wetogether.chatroom.dao.IChatDao;
import com.wetogether.chatroom.dto.ChatRecordBean;
import com.wetogether.chatroom.service.IChatService;
import com.wetogether.common.hibernate.pojos.ChatRecord;
import com.wetogether.common.hibernate.pojos.RecentlyConnecter;

public class ChatServiceHibernateImpl implements IChatService {
	private IChatDao chatDao;

	//发送消息
	@Override
	public void addMessage(ChatRecord c) {
		c.setMessageStatus(1);
		c.setSentTime(new Date());
		this.chatDao.insertChatMessage(c);
		
	}

	
	//查询消息
	@Override
	public List<ChatRecordBean> findMessage(Integer toId, Integer fromId) {
		List<ChatRecord> chats = this.chatDao.getUnreadMessage(toId, fromId);
		List<ChatRecordBean> beans = new ArrayList<ChatRecordBean>();
		for(ChatRecord chat : chats){
			ChatRecordBean cb = new ChatRecordBean();
			cb.setAll(chat);
			beans.add(cb);
		}
		
		return beans;
	}

	//更改消息
	@Override
	public void updateMessage(List<Integer> messageIds) {
			
		for(Integer i : messageIds){
			this.chatDao.updateMessage(i);
		}	
		
	}
	
	
	
//添加最近联系人
	@Override
	public void addRecentlyConnecter(RecentlyConnecter rc) {
		if(!this.chatDao.addRecentlyConnecter(rc)){
			this.updateRc(rc);
		}
		
	}

//更改最近联系人
	@Override
	public void updateRc(RecentlyConnecter rc) {
		this.chatDao.updateRecentlyConnecter(rc);	
		
	}

//查询最近联系人
	@Override
	public List<RecentlyConnecter> findMyRc(Integer userId) {
		return this.chatDao.findMyRc(userId);
	}
	
	// 获取消息提示
	@Override
	public List findMessageNotes(Integer userId) {
		return this.chatDao.getMessageNote(userId);
	}


	public IChatDao getChatDao() {
		return chatDao;
	}

	public void setChatDao(IChatDao chatDao) {
		this.chatDao = chatDao;
	}
	
	
}
