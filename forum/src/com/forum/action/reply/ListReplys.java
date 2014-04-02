package com.forum.action.reply;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.forum.bean.Reply;
import com.forum.service.ReplyService;
import com.happycoding.utils.Page;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class ListReplys extends ActionSupport{

	private int start;
	private int range;
	private String pageInfo;
	private List<Reply> list;
	private ReplyService service;

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
	public void setList(List<Reply> list){
		this.list = list;
	}
	public List<Reply> getList(){
		return this.list;
	}
	public String getPageInfo(){
		return pageInfo;
	}
	public void setPageInfo(String pageInfo){
		this.pageInfo = pageInfo;
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
		if(0 == this.range){
			this.range = 10;
		}		
		long count = this.service.getReplyCount(); 

		this.pageInfo = Page.getPageInfo(ServletActionContext.getRequest(), "", start, range, count);

		this.list = this.service.listReplys(start, range);

		return SUCCESS;
	}
}