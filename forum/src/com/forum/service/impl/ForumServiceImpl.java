package com.forum.service.impl;

import java.util.List;

import com.forum.bean.Forum;
import com.forum.dao.ForumDao;
import com.forum.service.ForumService;

public class ForumServiceImpl implements ForumService
{
	private ForumDao forumDao;

	private String list_all_desc = "from Forum bean order by bean.id desc";

	private String list_all_asc = "from Forum bean order by bean.id asc";

	public void setForumDao (ForumDao forumDao)
	{
		this.forumDao = forumDao;
	}

	public ForumDao getForumDao()
	{
		return this.forumDao;
	}

	public List<Forum> listForums(int start, int range)
	{
		return this.listForumDesc(start, range);
	}

	public List<Forum> listForumDesc(int start, int range)
	{
		return this.forumDao.searchForums(list_all_desc, new String[]{}, start, range);
	}

	public List<Forum> listForumAsc(int start, int range)
	{
		return this.forumDao.searchForums(list_all_asc, new String[]{}, start, range);
	}
	
	public List<Forum> listAllForums(){
		return this.forumDao.searchAllForums();
	}

	public long getForumCount()
	{
		return this.forumDao.getForumCount(list_all_desc);
	}

	public void saveForum (Forum bean)
	{
		this.forumDao.saveForum(bean);
	}
	
	public void saveForum(Forum bean, long parentId) {
		Forum parent = this.forumDao.getForum(parentId);
		bean.setParent(parent);
		parent.getChildren().add(bean);
		this.forumDao.updateForum(parent);
		this.forumDao.saveForum(bean);
	}

	public void updateForum (Forum bean)
	{
		this.forumDao.updateForum(bean);
	}

	public void deleteForum (Long id)
	{
		this.forumDao.removeForum(id);
	}

	public Forum getForum (Long id)
	{
		return this.forumDao.getForum(id);
	}

}