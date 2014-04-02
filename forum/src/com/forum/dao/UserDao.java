package com.forum.dao;

import java.util.List;

import com.forum.bean.User;

public interface UserDao
{
	public void saveUser(User bean);
	public void saveUser(List<User> beans);
	public User getUser(long id);
	public void removeUser(long id);
	public void removeUser(User bean);
	public void removeUsers(List<Long> ids);
	public void updateUser(User bean);
	public void updateUsers(List<User> beans);
	public long getUserCount(String queryString);
	public long getUserCount(String queryString,String value);
	public long getUserCount(String queryString,String[] value);
	public User searchUser(String queryString);
	public User searchUser(String queryString,String value);
	public User searchUser(String queryString,String[] value);
	public List<User> searchUsers(String queryString);
	public List<User> searchUsers(String queryString,String value);
	public List<User> searchUsers(String queryString,String[] values);
	public List<User> searchUsers(String queryString,String value,int first,int max);
	public List<User> searchUsers(String queryString,String[] value,int first,int max);
}