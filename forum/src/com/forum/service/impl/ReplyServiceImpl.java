package com.forum.service.impl;

import java.util.List;

import com.forum.bean.Reply;
import com.forum.bean.Topic;
import com.forum.dao.ReplyDao;
import com.forum.dao.TopicDao;
import com.forum.service.ReplyService;

public class ReplyServiceImpl implements ReplyService
{
	private ReplyDao replyDao;
	
	private TopicDao topicDao;

	private String list_all_desc = "from Reply bean order by bean.id desc";

	private String list_all_asc = "from Reply bean order by bean.id asc";

	public void setReplyDao (ReplyDao replyDao)
	{
		this.replyDao = replyDao;
	}

	public ReplyDao getReplyDao()
	{
		return this.replyDao;
	}

	public List<Reply> listReplys(int start, int range)
	{
		return this.listReplyDesc(start, range);
	}

	public TopicDao getTopicDao() {
		return topicDao;
	}

	public void setTopicDao(TopicDao topicDao) {
		this.topicDao = topicDao;
	}

	public List<Reply> listReplyDesc(int start, int range)
	{
		return this.replyDao.searchReplys(list_all_desc, new String[]{}, start, range);
	}

	public List<Reply> listReplyAsc(int start, int range)
	{
		return this.replyDao.searchReplys(list_all_asc, new String[]{}, start, range);
	}
	
	public List<Reply> listReply(int start, int range, long topicId) {
		List<Reply> replies = this.replyDao.searchReplys("from Reply bean where bean.topic.id=? order by bean.id", String.valueOf(topicId), start, range);
		return replies;
	}

	public long getReplyCount()
	{
		return this.replyDao.getReplyCount(list_all_desc);
	}

	public void saveReply (Reply bean)
	{
		this.replyDao.saveReply(bean);
	}
	
	public void saveReply(Reply bean, long topicId) {
		this.replyDao.saveReply(bean, topicId);
	}

	public void updateReply (Reply bean)
	{
		this.replyDao.updateReply(bean);
	}

	public void deleteReply (Long id)
	{
		this.replyDao.removeReply(id);
	}

	public Reply getReply (Long id)
	{
		return this.replyDao.getReply(id);
	}

}