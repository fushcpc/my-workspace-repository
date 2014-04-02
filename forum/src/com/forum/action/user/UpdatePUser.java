package com.forum.action.user;

import com.forum.bean.User;
import com.forum.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class UpdatePUser extends ActionSupport{
	private long id;	
	private UserService service;
	private User user; 

	public void setId(long id){
		this.id = id;
	}
	public long getId(){
		return this.id;
	}
	public void setUser(User user){
		this.user = user;
	}
	public User getUser(){
		return this.user;
	}
	public void setService(UserService service){
		this.service = service;
	}
	public UserService getService(){
		return this.service;
	}


	@Override
	public void validate(){
	
	}

	@Override
	public String execute() throws Exception{
		this.user = this.service.getUser(id);

		return SUCCESS;
	}
}