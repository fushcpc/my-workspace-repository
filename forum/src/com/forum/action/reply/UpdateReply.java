package com.forum.action.reply;

import java.sql.Timestamp;

import com.forum.bean.Reply;
import com.forum.bean.Topic;
import com.forum.bean.User;
import com.forum.service.ReplyService;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class UpdateReply extends ActionSupport{
	private ReplyService service;
	private long id;
	private String content;
	private Timestamp postTime;
	private String authorName;
	private Integer floor;
	private User author;
	private Topic topic;
	public void setId(long id){
		this.id=id;
	}
	public void setContent(String content){
		this.content=content;
	}
	public void setPostTime(Timestamp postTime){
		this.postTime=postTime;
	}
	public void setAuthorName(String authorName){
		this.authorName=authorName;
	}
	public void setFloor(Integer floor){
		this.floor=floor;
	}
	public void setAuthor(User author){
		this.author=author;
	}
	public void setTopic(Topic topic){
		this.topic=topic;
	}
	public long getId(){
		return this.id;
	}
	public String getContent(){
		return this.content;
	}
	public Timestamp getPostTime(){
		return this.postTime;
	}
	public String getAuthorName(){
		return this.authorName;
	}
	public Integer getFloor(){
		return this.floor;
	}
	public User getAuthor(){
		return this.author;
	}
	public Topic getTopic(){
		return this.topic;
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
		Reply bean = this.service.getReply(id);		
		bean.setContent(content);
		bean.setPostTime(postTime);
		bean.setAuthorName(authorName);
		bean.setFloor(floor);
		bean.setAuthor(author);
		bean.setTopic(topic);


		this.service.updateReply(bean);

		return SUCCESS;
	}
}