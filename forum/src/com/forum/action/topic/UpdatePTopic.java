package com.forum.action.topic;

import com.forum.bean.Topic;
import com.forum.service.TopicService;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class UpdatePTopic extends ActionSupport{
	private long id;	
	private TopicService service;
	private Topic topic; 
	private long forumId;

	public long getForumId() {
		return forumId;
	}
	public void setForumId(long forumId) {
		this.forumId = forumId;
	}
	public void setId(long id){
		this.id = id;
	}
	public long getId(){
		return this.id;
	}
	public void setTopic(Topic topic){
		this.topic = topic;
	}
	public Topic getTopic(){
		return this.topic;
	}
	public void setService(TopicService service){
		this.service = service;
	}
	public TopicService getService(){
		return this.service;
	}


	@Override
	public void validate(){
	
	}

	@Override
	public String execute() throws Exception{
		this.topic = this.service.getTopic(id);
		return SUCCESS;
	}
}