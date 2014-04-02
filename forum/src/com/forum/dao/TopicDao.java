package com.forum.dao;

import java.util.List;

import com.forum.bean.Topic;

public interface TopicDao
{
	public void saveTopic(Topic bean);
	public void saveTopic(List<Topic> beans);
	public Topic getTopic(long id);
	public void removeTopic(long id);
	public void removeTopic(Topic bean);
	public void removeTopics(List<Long> ids);
	public void updateTopic(Topic bean);
	public void updateTopics(List<Topic> beans);
	public long getTopicCount(String queryString);
	public long getTopicCount(String queryString,String value);
	public long getTopicCount(String queryString,String[] value);
	public Topic searchTopic(String queryString);
	public Topic searchTopic(String queryString,String value);
	public Topic searchTopic(String queryString,String[] value);
	public List<Topic> searchTopics(String queryString);
	public List<Topic> searchTopics(String queryString,String value);
	public List<Topic> searchTopics(String queryString,String[] values);
	public List<Topic> searchTopics(String queryString,String value,int first,int max);
	public List<Topic> searchTopics(String queryString,String[] value,int first,int max);
}