package com.forum.action.forum;

import com.forum.bean.Forum;
import com.forum.service.ForumService;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class UpdatePForum extends ActionSupport{
	private long id;	
	private ForumService service;
	private Forum forum; 

	public void setId(long id){
		this.id = id;
	}
	public long getId(){
		return this.id;
	}
	public void setForum(Forum forum){
		this.forum = forum;
	}
	public Forum getForum(){
		return this.forum;
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
		this.forum = this.service.getForum(id);

		return SUCCESS;
	}
}