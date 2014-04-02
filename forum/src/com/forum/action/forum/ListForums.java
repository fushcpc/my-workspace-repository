package com.forum.action.forum;

import java.util.List;

import com.forum.bean.Forum;
import com.forum.service.ForumService;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class ListForums extends ActionSupport{

	private List<Forum> list;
	private ForumService service;

	public void setList(List<Forum> list){
		this.list = list;
	}
	public List<Forum> getList(){
		return this.list;
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

		this.list = this.service.listAllForums();//此方法只返回根版面,不想改名字多写一个方法了

		return SUCCESS;
	}
}