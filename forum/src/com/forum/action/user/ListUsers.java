package com.forum.action.user;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.forum.bean.User;
import com.forum.service.UserService;
import com.happycoding.utils.Page;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class ListUsers extends ActionSupport {

	private int start;
	private int range;
	private String pageInfo;
	private List<User> list;
	private UserService service;

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

	public void setList(List<User> list) {
		this.list = list;
	}

	public List<User> getList() {
		return this.list;
	}

	public String getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(String pageInfo) {
		this.pageInfo = pageInfo;
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
		if (0 == this.range) {
			this.range = 10;
		}
		long count = this.service.getUserCount();
		this.pageInfo = Page.getPageInfo(ServletActionContext.getRequest(), "",
				start, range, count);

		this.list = this.service.listUsers(start, range);

		return SUCCESS;
	}
}