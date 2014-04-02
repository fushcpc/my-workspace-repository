package com.forum.dao.impl;

import java.util.List;

import com.forum.bean.Topic;
import com.forum.dao.TopicDao;
import com.happycoding.utils.GenericDao;

public class TopicDaoImpl extends GenericDao<Topic> implements TopicDao
{
	public void saveTopic(Topic bean){
		storeObj(bean);
	}

	public void saveTopic(List<Topic> beans){
		storeObjs(beans);
	}

	public Topic getTopic(long id){
		return retrieveObj(Topic.class,id);
	}

	public void removeTopic(long id){
		removeObj(Topic.class,id);
	}

	public void removeTopic(Topic bean){
		removeObj(Topic.class,bean.getId());
	}

	public void removeTopics(List<Long> ids){
		removeObjs(Topic.class,ids);
	}

	public void updateTopic(Topic bean){
		updateObj(bean);
	}

	public void updateTopics(List<Topic> beans){
		updateObjs(beans);
	}

	public long getTopicCount(String queryString){
		return retrieveObjsCount(queryString);
	}

	public long getTopicCount(String queryString,String value){
		return retrieveObjsCount(queryString,value);
	}

	public long getTopicCount(String queryString,String[] value){
		return retrieveObjsCount(queryString,value);
	}

	public Topic searchTopic(String queryString){
		return retrieveObj(queryString);
	}

	public Topic searchTopic(String queryString,String value){
		return retrieveObj(queryString,value);
	}

	public Topic searchTopic(String queryString,String[] value){
		return retrieveObj(queryString,value);
	}


	public List<Topic> searchTopics(String queryString){
		return retrieveObjs(queryString);
	}

	public List<Topic> searchTopics(String queryString,String value){
		return retrieveObjs(queryString,value);
	}

	public List<Topic> searchTopics(String queryString,String[] values){
		return retrieveObjs(queryString,values);
	}

	public List<Topic> searchTopics(String queryString,String value,int first,int max){
		return retrieveObjs(queryString,value,first,max);
	}

	public List<Topic> searchTopics(String queryString,String[] value,int first,int max){
		return retrieveObjs(queryString,value,first,max);
	}
}