package com.forum.action.forum;

import com.forum.bean.Forum;
import com.forum.service.ForumService;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class UpdateForum extends ActionSupport{
	private ForumService service;
	private long id;
	private String name;
	private String description;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setService(ForumService service) {
		this.service = service;
	}

	@Override
	public void validate(){
	
	}

	@Override
	public String execute() throws Exception{
		Forum bean = this.service.getForum(id);		
		bean.setName(name);
		bean.setDescription(description);

		this.service.updateForum(bean);

		return SUCCESS;
	}
}