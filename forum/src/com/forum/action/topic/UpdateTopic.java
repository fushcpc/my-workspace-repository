package com.forum.action.topic;

import java.sql.Timestamp;
import java.util.Set;

import com.forum.bean.Forum;
import com.forum.bean.Topic;
import com.forum.bean.User;
import com.forum.service.TopicService;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class UpdateTopic extends ActionSupport{
	private TopicService service;
	private long id;
	private String subject;
	private String content;
	private String authorName;
	private Timestamp postTime;
	private long replyNum;
	private long viewNum;
	private Forum forum;
	private User author;
	private Timestamp lastReplyTime;
	private Set replies;
	public void setId(long id){
		this.id=id;
	}
	public void setSubject(String subject){
		this.subject=subject;
	}
	public void setContent(String content){
		this.content=content;
	}
	public void setAuthorName(String authorName){
		this.authorName=authorName;
	}
	public void setPostTime(Timestamp postTime){
		this.postTime=postTime;
	}
	public void setReplyNum(long replyNum){
		this.replyNum=replyNum;
	}
	public void setViewNum(long viewNum){
		this.viewNum=viewNum;
	}
	public void setForum(Forum forum){
		this.forum=forum;
	}
	public void setAuthor(User author){
		this.author=author;
	}
	public void setLastReplyTime(Timestamp lastReplyTime){
		this.lastReplyTime=lastReplyTime;
	}
	public void setReplies(Set replies){
		this.replies=replies;
	}
	public long getId(){
		return this.id;
	}
	public String getSubject(){
		return this.subject;
	}
	public String getContent(){
		return this.content;
	}
	public String getAuthorName(){
		return this.authorName;
	}
	public Timestamp getPostTime(){
		return this.postTime;
	}
	public long getReplyNum(){
		return this.replyNum;
	}
	public long getViewNum(){
		return this.viewNum;
	}
	public Forum getForum(){
		return this.forum;
	}
	public User getAuthor(){
		return this.author;
	}
	public Timestamp getLastReplyTime(){
		return this.lastReplyTime;
	}
	public Set getReplies(){
		return this.replies;
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
		Topic bean = this.service.getTopic(id);		
		bean.setSubject(subject);
		bean.setContent(content);
		bean.setAuthorName(authorName);
		bean.setPostTime(postTime);
		bean.setReplyNum(replyNum);
		bean.setViewNum(viewNum);
		bean.setForum(forum);
		bean.setAuthor(author);
		bean.setLastReplyTime(lastReplyTime);
		bean.setReplies(replies);


		this.service.updateTopic(bean);

		return SUCCESS;
	}
}