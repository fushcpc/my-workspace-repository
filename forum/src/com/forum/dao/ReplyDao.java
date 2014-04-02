package com.forum.dao;

import java.util.List;

import com.forum.bean.Reply;

public interface ReplyDao
{
	public void saveReply(Reply bean);
	public void saveReply(List<Reply> beans);
	public void saveReply(Reply bean, long topicId);
	public Reply getReply(long id);
	public void removeReply(long id);
	public void removeReply(Reply bean);
	public void removeReplys(List<Long> ids);
	public void updateReply(Reply bean);
	public void updateReplys(List<Reply> beans);
	public long getReplyCount(String queryString);
	public long getReplyCount(String queryString,String value);
	public long getReplyCount(String queryString,String[] value);
	public Reply searchReply(String queryString);
	public Reply searchReply(String queryString,String value);
	public Reply searchReply(String queryString,String[] value);
	public List<Reply> searchReplys(String queryString);
	public List<Reply> searchReplys(String queryString,String value);
	public List<Reply> searchReplys(String queryString,String[] values);
	public List<Reply> searchReplys(String queryString,String value,int first,int max);
	public List<Reply> searchReplys(String queryString,String[] value,int first,int max);
}