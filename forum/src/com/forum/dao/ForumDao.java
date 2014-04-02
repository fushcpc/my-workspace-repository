package com.forum.dao;

import java.util.List;

import com.forum.bean.Forum;

public interface ForumDao
{
	public void saveForum(Forum bean);
	public void saveForum(List<Forum> beans);
	public Forum getForum(long id);
	public void removeForum(long id);
	public void removeForum(Forum bean);
	public void removeForums(List<Long> ids);
	public void updateForum(Forum bean);
	public void updateForums(List<Forum> beans);
	public long getForumCount(String queryString);
	public long getForumCount(String queryString,String value);
	public long getForumCount(String queryString,String[] value);
	public Forum searchForum(String queryString);
	public Forum searchForum(String queryString,String value);
	public Forum searchForum(String queryString,String[] value);
	public List<Forum> searchAllForums();
	public List<Forum> searchForums(String queryString);
	public List<Forum> searchForums(String queryString,String value);
	public List<Forum> searchForums(String queryString,String[] values);
	public List<Forum> searchForums(String queryString,String value,int first,int max);
	public List<Forum> searchForums(String queryString,String[] value,int first,int max);
}