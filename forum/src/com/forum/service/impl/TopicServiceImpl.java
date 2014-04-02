package com.forum.service.impl;

import java.util.List;

import org.hibernate.Hibernate;

import com.forum.bean.Forum;
import com.forum.bean.Topic;
import com.forum.dao.ForumDao;
import com.forum.dao.TopicDao;
import com.forum.service.TopicService;

public class TopicServiceImpl implements TopicService
{
	private TopicDao topicDao;
	private ForumDao forumDao;

	private String list_all_desc = "from Topic bean order by bean.id desc";

	private String list_all_asc = "from Topic bean order by bean.id asc";

	public void setTopicDao (TopicDao topicDao)
	{
		this.topicDao = topicDao;
	}

	public TopicDao getTopicDao()
	{
		return this.topicDao;
	}

	public List<Topic> listTopics(int start, int range)
	{
		return this.listTopicDesc(start, range);
	}
	
	public void setForumDao(ForumDao forumDao) {
		this.forumDao = forumDao;
	}

	public List<Topic> listTopics(int start, int range, long forumId) {
		return this.topicDao.searchTopics("from Topic t where t.forum.id=?", forumId+"", start, range);
	}

	public List<Topic> listTopicDesc(int start, int range)
	{
		return this.topicDao.searchTopics(list_all_desc, new String[]{}, start, range);
	}

	public List<Topic> listTopicAsc(int start, int range)
	{
		return this.topicDao.searchTopics(list_all_asc, new String[]{}, start, range);
	}

	public long getTopicCount()
	{
		return this.topicDao.getTopicCount("from Topic");
	}

	public void saveTopic (Topic bean)
	{
		this.topicDao.saveTopic(bean);
	}
	
	public void saveTopic(Topic bean, long forumId) {
		Forum forum = this.forumDao.getForum(forumId);
		bean.setForum(forum);
		//Hibernate.initialize(forum);
		forum.setTopicNum(forum.getTopicNum()+1);
		forum.getTopics().add(bean);
		this.forumDao.updateForum(forum);
		this.saveTopic(bean);
	}

	public void updateTopic (Topic bean)
	{
		this.topicDao.updateTopic(bean);
	}

	public void deleteTopic (Long id)
	{
		this.topicDao.removeTopic(id);
	}

	public Topic getTopic (Long id)
	{
		return this.topicDao.getTopic(id);
	}

}