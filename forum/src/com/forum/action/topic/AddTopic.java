package com.forum.action.topic;

import java.sql.Timestamp;

import com.forum.bean.Forum;
import com.forum.bean.Topic;
import com.forum.bean.User;
import com.forum.service.ForumService;
import com.forum.service.TopicService;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings({ "serial" })
public class AddTopic extends ActionSupport
{
	private TopicService service;
	private ForumService forumService;
	private long forumId;
	private String subject;
	private String content;
	private String authorName;
	private Timestamp postTime;
	private User author;
	public void setSubject(String subject){
		this.subject=subject;
	}
	public void setContent(String content){
		this.content=content;
	}
	public void setAuthorName(String authorName){
		this.authorName=authorName;
	}
	public void setPostTime(Timestamp postTime){
		this.postTime=postTime;
	}
	public void setAuthor(User author){
		this.author=author;
	}
	public String getSubject(){
		return this.subject;
	}
	public String getContent(){
		return this.content;
	}
	public String getAuthorName(){
		return this.authorName;
	}
	public long getForumId() {
		return forumId;
	}
	public void setForumId(long forumId) {
		this.forumId = forumId;
	}
	public Timestamp getPostTime(){
		return this.postTime;
	}
	public ForumService getForumService() {
		return forumService;
	}
	public void setForumService(ForumService forumService) {
		this.forumService = forumService;
	}
	public User getAuthor(){
		return this.author;
	}

	public void setService(TopicService service){
		this.service = service;
	}
	public TopicService getService(){
		return this.service;
	}
	public Topic getReadyBean(){
		Topic bean = new Topic();
		bean.setSubject(subject);
		bean.setContent(content);
		bean.setAuthorName(authorName);
		bean.setPostTime(new Timestamp(System.currentTimeMillis()));
//		Forum forum = forumService.getForum(forumId);
//		bean.setForum(forum);
//		forum.getTopics().add(bean);
//		this.forumService.updateForum(forum);
		bean.setAuthor(author);

		return bean;
	}

	@Override
	public void validate(){
	
	}	

	@Override
	public String execute() throws Exception
	{
		Topic bean = this.getReadyBean();


		this.service.saveTopic(bean,forumId);
		return SUCCESS;
	}
}