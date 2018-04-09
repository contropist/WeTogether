package com.wetogether.chatroom.dao;

import java.util.List;

import com.wetogether.common.hibernate.pojos.ChatRecord;
import com.wetogether.common.hibernate.pojos.RecentlyConnecter;

public interface IChatDao {
	//发送聊天内容
	public void insertChatMessage(ChatRecord c);
	//查询未读聊天内容
	public List<ChatRecord> getUnreadMessage(Integer toUserId ,Integer formUserId);
	//更改message状态
	public void updateMessage(Integer messageId);
	//添加最近联系人
	public Boolean addRecentlyConnecter(RecentlyConnecter rc);
	
	//更改最近联系人
	public Boolean updateRecentlyConnecter(RecentlyConnecter rc);
	
	//查询某人的最近联系人
	public List<RecentlyConnecter> findMyRc(Integer userId);

	// 消息提示
	public List getMessageNote(Integer userId);
}
