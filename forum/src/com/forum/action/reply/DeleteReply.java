package com.forum.action.reply;

import com.forum.service.ReplyService;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class DeleteReply extends ActionSupport{

	private long id;
	private int start;
	private int range;	
	private ReplyService service;

	public void setId(long id){
		this.id = id;
	}

	public long getId(){
		return this.id;
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

	public void setService(ReplyService service){
		this.service = service;
	}

	public ReplyService getService(){
		return this.service;
	}

	@Override
	public void validate(){
	
	}

	@Override
	public String execute() throws Exception{
		this.service.deleteReply(id);

		return SUCCESS;
	}
}