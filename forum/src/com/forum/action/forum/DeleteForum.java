package com.forum.action.forum;

import com.forum.service.ForumService;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class DeleteForum extends ActionSupport{

	private long id;
	private ForumService service;

	public void setId(long id){
		this.id = id;
	}

	public long getId(){
		return this.id;
	}

	public void setService(ForumService service){
		this.service = service;
	}

	public ForumService getService(){
		return this.service;
	}

	@Override
	public void validate(){
	
	}
	@Override
	public String execute() throws Exception{
		this.service.deleteForum(id);
		return SUCCESS;
	}
}