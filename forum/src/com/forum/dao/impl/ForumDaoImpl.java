package com.forum.dao.impl;

import java.util.List;

import com.forum.bean.Forum;
import com.forum.dao.ForumDao;
import com.happycoding.utils.GenericDao;

public class ForumDaoImpl extends GenericDao<Forum> implements ForumDao
{
	public void saveForum(Forum bean){
		storeObj(bean);
	}

	public void saveForum(List<Forum> beans){
		storeObjs(beans);
	}

	public Forum getForum(long id){
		return retrieveObj(Forum.class,id);
	}

	public void removeForum(long id){
		removeObj(Forum.class,id);
	}

	public void removeForum(Forum bean){
		removeObj(Forum.class,bean.getId());
	}

	public void removeForums(List<Long> ids){
		removeObjs(Forum.class,ids);
	}

	public void updateForum(Forum bean){
		updateObj(bean);
	}

	public void updateForums(List<Forum> beans){
		updateObjs(beans);
	}

	public long getForumCount(String queryString){
		return retrieveObjsCount(queryString);
	}

	public long getForumCount(String queryString,String value){
		return retrieveObjsCount(queryString,value);
	}

	public long getForumCount(String queryString,String[] value){
		return retrieveObjsCount(queryString,value);
	}

	public Forum searchForum(String queryString){
		return retrieveObj(queryString);
	}

	public Forum searchForum(String queryString,String value){
		return retrieveObj(queryString,value);
	}

	public Forum searchForum(String queryString,String[] value){
		return retrieveObj(queryString,value);
	}


	public List<Forum> searchForums(String queryString){
		return retrieveObjs(queryString);
	}
	
	public List<Forum> searchAllForums(){
		return this.searchForums("from Forum bean where bean.parent is null");
	}

	public List<Forum> searchForums(String queryString,String value){
		return retrieveObjs(queryString,value);
	}

	public List<Forum> searchForums(String queryString,String[] values){
		return retrieveObjs(queryString,values);
	}

	public List<Forum> searchForums(String queryString,String value,int first,int max){
		return retrieveObjs(queryString,value,first,max);
	}

	public List<Forum> searchForums(String queryString,String[] value,int first,int max){
		return retrieveObjs(queryString,value,first,max);
	}
}