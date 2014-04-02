package com.forum.service;

import java.util.List;

import com.forum.bean.Forum;

public interface ForumService
{
	public List<Forum> listForums(int start, int range);

	public List<Forum> listForumDesc(int start, int range);

	public List<Forum> listForumAsc(int start, int range);
	
	public List<Forum> listAllForums();

	public long getForumCount();

	public void saveForum (Forum bean);
	public void saveForum(Forum bean,long parentId);

	public void updateForum (Forum bean);

	public void deleteForum (Long id);

	public Forum getForum (Long id);
}