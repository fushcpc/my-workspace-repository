package com.forum.dao.impl;

import java.util.List;

import org.hibernate.Hibernate;

import com.forum.bean.Forum;
import com.forum.bean.Reply;
import com.forum.bean.Topic;
import com.forum.dao.ReplyDao;
import com.happycoding.utils.GenericDao;

public class ReplyDaoImpl extends GenericDao<Reply> implements ReplyDao
{
	public void saveReply(Reply bean){
		storeObj(bean);
	}

	public void saveReply(List<Reply> beans){
		storeObjs(beans);
	}
	
	public void saveReply(Reply bean, long topicId) {
		Topic topic =(Topic) getHibernateTemplate().get(Topic.class, topicId);
		//Hibernate.initialize(topic);
		topic.getReplies().add(bean);
		topic.setReplyNum(topic.getReplyNum()+1);
		Forum forum = topic.getForum();
		forum.setReplyNum(forum.getReplyNum()+1);
		getHibernateTemplate().update(forum);
		bean.setTopic(topic);
		this.saveReply(bean);
		getHibernateTemplate().update(topic);
	}

	public Reply getReply(long id){
		return retrieveObj(Reply.class,id);
	}

	public void removeReply(long id){
		removeObj(Reply.class,id);
	}

	public void removeReply(Reply bean){
		removeObj(Reply.class,bean.getId());
	}

	public void removeReplys(List<Long> ids){
		removeObjs(Reply.class,ids);
	}

	public void updateReply(Reply bean){
		updateObj(bean);
	}

	public void updateReplys(List<Reply> beans){
		updateObjs(beans);
	}

	public long getReplyCount(String queryString){
		return retrieveObjsCount(queryString);
	}

	public long getReplyCount(String queryString,String value){
		return retrieveObjsCount(queryString,value);
	}

	public long getReplyCount(String queryString,String[] value){
		return retrieveObjsCount(queryString,value);
	}

	public Reply searchReply(String queryString){
		return retrieveObj(queryString);
	}

	public Reply searchReply(String queryString,String value){
		return retrieveObj(queryString,value);
	}

	public Reply searchReply(String queryString,String[] value){
		return retrieveObj(queryString,value);
	}


	public List<Reply> searchReplys(String queryString){
		return retrieveObjs(queryString);
	}

	public List<Reply> searchReplys(String queryString,String value){
		return retrieveObjs(queryString,value);
	}

	public List<Reply> searchReplys(String queryString,String[] values){
		return retrieveObjs(queryString,values);
	}

	public List<Reply> searchReplys(String queryString,String value,int first,int max){
		return retrieveObjs(queryString,value,first,max);
	}

	public List<Reply> searchReplys(String queryString,String[] value,int first,int max){
		return retrieveObjs(queryString,value,first,max);
	}
}