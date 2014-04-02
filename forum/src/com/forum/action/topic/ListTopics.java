package com.forum.action.topic;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.forum.bean.Topic;
import com.forum.service.TopicService;
import com.happycoding.utils.Page;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class ListTopics extends ActionSupport{

	private int start;
	private int range;
	private long forumId;
	private String pageInfo;
	private List<Topic> list;
	private TopicService service;

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
	public long getForumId() {
		return forumId;
	}
	public void setForumId(long forumId) {
		this.forumId = forumId;
	}
	public void setList(List<Topic> list){
		this.list = list;
	}
	public List<Topic> getList(){
		return this.list;
	}
	public String getPageInfo(){
		return pageInfo;
	}
	public void setPageInfo(String pageInfo){
		this.pageInfo = pageInfo;
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
		if(0 == this.range){
			this.range = 20;
		}		
		long count = this.service.getTopicCount(); 
		this.pageInfo = Page.getPageInfo(ServletActionContext.getRequest(), "?forumId="+forumId, start, range, count);
		this.list = this.service.listTopics(start, range,forumId);
		return SUCCESS;
	}
}