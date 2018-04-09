package com.wetogether.chatroom.service;

import java.util.List;

import com.wetogether.chatroom.dto.ChatRecordBean;
import com.wetogether.common.hibernate.pojos.ChatRecord;
import com.wetogether.common.hibernate.pojos.RecentlyConnecter;

public interface IChatService {
	//发送消息
	public void addMessage(ChatRecord c);
	//查询消息
	public List<ChatRecordBean> findMessage(Integer toId,Integer fromId);
	//更改消息
	public void updateMessage(List<Integer> messageIds);
	//添加最新联系人
	public void addRecentlyConnecter(RecentlyConnecter rc);
	//更改最新联系人状态
	public void updateRc(RecentlyConnecter rc);
	//查询最近联系人
	public List<RecentlyConnecter> findMyRc(Integer userId);
	//消息提示
	public List findMessageNotes(Integer userId);
}	
