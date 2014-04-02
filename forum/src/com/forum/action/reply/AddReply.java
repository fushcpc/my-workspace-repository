package com.forum.action.reply;

import java.sql.Timestamp;

import com.forum.bean.Reply;
import com.forum.bean.Topic;
import com.forum.bean.User;
import com.forum.service.ReplyService;
import com.forum.service.TopicService;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings({ "serial" })
public class AddReply extends ActionSupport
{
	private ReplyService service;
	private String content;
	private Timestamp postTime;
	private String authorName;
	private Integer floor;
	private User author;
	private long topicId;
	private TopicService topicService;
	private long forumId;
	
	public ReplyService getService() {
		return service;
	}

	public void setService(ReplyService service) {
		this.service = service;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getPostTime() {
		return postTime;
	}

	public void setPostTime(Timestamp postTime) {
		this.postTime = postTime;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public Integer getFloor() {
		return floor;
	}

	public void setFloor(Integer floor) {
		this.floor = floor;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public long getForumId() {
		return forumId;
	}

	public void setForumId(long forumId) {
		this.forumId = forumId;
	}

	public long getTopicId() {
		return topicId;
	}

	public void setTopicId(long topicId) {
		this.topicId = topicId;
	}

	public TopicService getTopicService() {
		return topicService;
	}

	public void setTopicService(TopicService topicService) {
		this.topicService = topicService;
	}

	public Reply getReadyBean(){
		Reply bean = new Reply();
		bean.setContent(content);
		bean.setPostTime(new Timestamp(System.currentTimeMillis()));
		bean.setAuthorName(authorName);
		bean.setFloor(floor);
		bean.setAuthor(author);

		return bean;
	}

	@Override
	public void validate(){
	
	}	

	@Override
	public String execute() throws Exception
	{
		Reply bean = this.getReadyBean();
		this.service.saveReply(bean,topicId);
		return SUCCESS;
	}
}