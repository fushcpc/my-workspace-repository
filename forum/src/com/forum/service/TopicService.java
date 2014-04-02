package com.forum.service;

import java.util.List;

import com.forum.bean.Topic;

public interface TopicService
{
	public List<Topic> listTopics(int start, int range);
	
	public List<Topic> listTopics(int start,int range,long forumId);

	public List<Topic> listTopicDesc(int start, int range);

	public List<Topic> listTopicAsc(int start, int range);

	public long getTopicCount();

	public void saveTopic (Topic bean);
	
	public void saveTopic(Topic bean,long forumId);

	public void updateTopic (Topic bean);

	public void deleteTopic (Long id);

	public Topic getTopic (Long id);
}