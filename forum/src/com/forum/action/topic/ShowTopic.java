package com.forum.action.topic;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.forum.bean.Reply;
import com.forum.bean.Topic;
import com.forum.service.ReplyService;
import com.forum.service.TopicService;
import com.happycoding.utils.Page;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author DavidChen(陈基明) Email: cjmiou@gmail.com
 * @version 2010-5-4 下午04:58:40
 */
@SuppressWarnings("serial")
public class ShowTopic extends ActionSupport {
	private long topicId;
	private int start;
	private int range;
	private String pageInfo;
	private TopicService service;
	private ReplyService replyService;
	private Topic topic;
	private List<Reply> replies;

	public long getTopicId() {
		return topicId;
	}

	public void setTopicId(long topicId) {
		this.topicId = topicId;
	}

	public TopicService getService() {
		return service;
	}

	public void setService(TopicService service) {
		this.service = service;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public String getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(String pageInfo) {
		this.pageInfo = pageInfo;
	}

	public ReplyService getReplyService() {
		return replyService;
	}

	public void setReplyService(ReplyService replyService) {
		this.replyService = replyService;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public List<Reply> getReplies() {
		return replies;
	}

	public void setReplies(List<Reply> replies) {
		this.replies = replies;
	}

	@Override
	public String execute() throws Exception {
		if (0 == this.range) {
			this.range = 10;
		}
		this.topic = this.service.getTopic(topicId);
		this.topic.setViewNum(topic.getViewNum() + 1);
		this.service.updateTopic(topic);
		this.replies = this.replyService.listReply(start, 10000, topicId);
		long count = this.replies.size();

		this.pageInfo = Page.getPageInfo(ServletActionContext.getRequest(), "",
				start, range, count);

		return SUCCESS;
	}
}
