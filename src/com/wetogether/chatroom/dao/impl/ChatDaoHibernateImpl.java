package com.wetogether.chatroom.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.wetogether.chatroom.dao.IChatDao;
import com.wetogether.common.hibernate.pojos.ChatRecord;
import com.wetogether.common.hibernate.pojos.RecentlyConnecter;

public class ChatDaoHibernateImpl implements IChatDao {
	private HibernateTemplate hibernateTemplate;
	//发送消息
	@Override
	public void insertChatMessage(ChatRecord c) {
		this.hibernateTemplate.save(c);
		
	}
	
	//查询消息
	@SuppressWarnings("unchecked")
	@Override
	public List<ChatRecord> getUnreadMessage(Integer toUserId,Integer fromUserId) {
		String hql = "from ChatRecord c where c.fromUser.userId=:fId and c.toUser.userId=:tId and c.messageStatus = 1";
		String [] paras = {"fId","tId"};
		Object [] values = {fromUserId,toUserId};
		return this.hibernateTemplate.findByNamedParam(hql, paras, values);
		
	}

	//更改消息
	@Override
	public void updateMessage(Integer messageIds) {
	ChatRecord c = this.hibernateTemplate.get(ChatRecord.class, messageIds);
	c.setMessageStatus(0);
	}
	
	
	//插入最近联系人
	@Override
	public Boolean addRecentlyConnecter(RecentlyConnecter rc) {
		String hql1 = "from RecentlyConnecter r where r.whose.userId=:wId and r.users.userId=:uId";
		String [] paras = {"wId","uId"};
		Object [] values = {rc.getWhose().getUserId(),rc.getUsers().getUserId()};
		@SuppressWarnings("unchecked")
		List<RecentlyConnecter> flag = this.hibernateTemplate.findByNamedParam(hql1, paras, values);
		if(flag.size()==0){
			this.hibernateTemplate.save(rc);
			return true;
		}else{
			return false;
		}
		
	}
	
	
	
	//更改最近联系人
	@Override
	public Boolean updateRecentlyConnecter(RecentlyConnecter rc) {
		String hql1 = "from RecentlyConnecter r where r.whose.userId=:wId and r.users.userId=:uId";
		String [] paras = {"wId","uId"};
		Object [] values = {rc.getWhose().getUserId(),rc.getUsers().getUserId()};
		@SuppressWarnings("unchecked")
		List<RecentlyConnecter> flag = this.hibernateTemplate.findByNamedParam(hql1, paras, values);
		RecentlyConnecter rc1 = flag.get(0);
		rc1.setLastConnectTime(rc.getLastConnectTime());
		return true;
	}

	
	//查询最近联系人	
	@SuppressWarnings("unchecked")
	@Override
	public List<RecentlyConnecter> findMyRc(Integer userId) {
		String hql = "from RecentlyConnecter r where r.whose.userId =:uId order by r.lastConnectTime desc";
		return this.hibernateTemplate.findByNamedParam(hql, "uId", userId);
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	
	//获得消息提示
			@Override
		public List getMessageNote(Integer userId) {
			String hql = "select c.fromUser, count(*) from ChatRecord c where c.toUser.userId =:uId and c.messageStatus=1 group by c.fromUser";

			return hibernateTemplate.findByNamedParam(hql, "uId", userId);
		}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	
	
}
