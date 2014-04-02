package com.forum.action.topic;

import com.forum.service.TopicService;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class DeleteTopic extends ActionSupport{

	private long id;
	private int start;
	private int range;	
	private long forumId;
	private TopicService service;

	public void setId(long id){
		this.id = id;
	}

	public long getId(){
		return this.id;
	}

	public long getForumId() {
		return forumId;
	}

	public void setForumId(long forumId) {
		this.forumId = forumId;
	}

	public int getStart(){
		return start;
	}

	public void setStart(int start){
		this.start = start;
	}

	public int getRange(){
		return range;
	}

	public void setRange(int range){
		this.range = range;
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
		this.service.deleteTopic(id);

		return SUCCESS;
	}
}