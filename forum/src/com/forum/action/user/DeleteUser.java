package com.forum.action.user;

import com.forum.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class DeleteUser extends ActionSupport {

	private long id;
	private int start;
	private int range;
	private UserService service;

	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return this.id;
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

	public void setService(UserService service) {
		this.service = service;
	}

	public UserService getService() {
		return this.service;
	}

	@Override
	public void validate() {

	}

	@Override
	public String execute() throws Exception {
		this.service.deleteUser(id);
		return SUCCESS;
	}
}