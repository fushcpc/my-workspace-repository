package com.forum.action.reply;

import com.forum.bean.Reply;
import com.forum.service.ReplyService;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class UpdatePReply extends ActionSupport{
	private long id;	
	private ReplyService service;
	private Reply reply; 

	public void setId(long id){
		this.id = id;
	}
	public long getId(){
		return this.id;
	}
	public void setReply(Reply reply){
		this.reply = reply;
	}
	public Reply getReply(){
		return this.reply;
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
		this.reply = this.service.getReply(id);

		return SUCCESS;
	}
}