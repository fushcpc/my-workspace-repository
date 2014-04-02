package com.forum.action.user;

import java.sql.Timestamp;
import java.util.Set;

import com.forum.bean.User;
import com.forum.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class UpdateUser extends ActionSupport{
	private UserService service;
	private long id;
	private String username;
	private String password;
	private String nickName;
	private Boolean active;
	private Timestamp registerTime;
	private String activeString;
	private String email;
	private Set topics;
	private Set replies;
	private Set forums;
	public void setId(long id){
		this.id=id;
	}
	public void setUsername(String username){
		this.username=username;
	}
	public void setPassword(String password){
		this.password=password;
	}
	public void setNickName(String nickName){
		this.nickName=nickName;
	}
	public void setActive(Boolean active){
		this.active=active;
	}
	public void setRegisterTime(Timestamp registerTime){
		this.registerTime=registerTime;
	}
	public void setActiveString(String activeString){
		this.activeString=activeString;
	}
	public void setEmail(String email){
		this.email=email;
	}
	public void setTopics(Set topics){
		this.topics=topics;
	}
	public void setReplies(Set replies){
		this.replies=replies;
	}
	public void setForums(Set forums){
		this.forums=forums;
	}
	public long getId(){
		return this.id;
	}
	public String getUsername(){
		return this.username;
	}
	public String getPassword(){
		return this.password;
	}
	public String getNickName(){
		return this.nickName;
	}
	public Boolean getActive(){
		return this.active;
	}
	public Timestamp getRegisterTime(){
		return this.registerTime;
	}
	public String getActiveString(){
		return this.activeString;
	}
	public String getEmail(){
		return this.email;
	}
	public Set getTopics(){
		return this.topics;
	}
	public Set getReplies(){
		return this.replies;
	}
	public Set getForums(){
		return this.forums;
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
		User bean = this.service.getUser(id);		
		bean.setUsername(username);
		bean.setPassword(password);
		bean.setNickName(nickName);
		bean.setActive(active);
		bean.setRegisterTime(registerTime);
		bean.setActiveString(activeString);
		bean.setEmail(email);
		bean.setTopics(topics);
		bean.setReplies(replies);
		bean.setForums(forums);


		this.service.updateUser(bean);

		return SUCCESS;
	}
}