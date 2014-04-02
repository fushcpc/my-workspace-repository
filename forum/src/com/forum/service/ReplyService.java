package com.forum.service;

import java.util.List;

import com.forum.bean.Reply;

public interface ReplyService
{
	public List<Reply> listReplys(int start, int range);

	public List<Reply> listReplyDesc(int start, int range);

	public List<Reply> listReplyAsc(int start, int range);
	
	public List<Reply> listReply(int start ,int range,long topicId);

	public long getReplyCount();

	public void saveReply (Reply bean);
	public void saveReply (Reply bean,long topicId);

	public void updateReply (Reply bean);

	public void deleteReply (Long id);

	public Reply getReply (Long id);
}