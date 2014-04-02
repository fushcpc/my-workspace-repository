package com.forum.dao.impl;

import java.util.List;

import com.forum.bean.User;
import com.forum.dao.UserDao;
import com.happycoding.utils.GenericDao;

public class UserDaoImpl extends GenericDao<User> implements UserDao
{
	public void saveUser(User bean){
		storeObj(bean);
	}

	public void saveUser(List<User> beans){
		storeObjs(beans);
	}

	public User getUser(long id){
		return retrieveObj(User.class,id);
	}

	public void removeUser(long id){
		removeObj(User.class,id);
	}

	public void removeUser(User bean){
		removeObj(User.class,bean.getId());
	}

	public void removeUsers(List<Long> ids){
		removeObjs(User.class,ids);
	}

	public void updateUser(User bean){
		updateObj(bean);
	}

	public void updateUsers(List<User> beans){
		updateObjs(beans);
	}

	public long getUserCount(String queryString){
		return retrieveObjsCount(queryString);
	}

	public long getUserCount(String queryString,String value){
		return retrieveObjsCount(queryString,value);
	}

	public long getUserCount(String queryString,String[] value){
		return retrieveObjsCount(queryString,value);
	}

	public User searchUser(String queryString){
		return retrieveObj(queryString);
	}

	public User searchUser(String queryString,String value){
		return retrieveObj(queryString,value);
	}

	public User searchUser(String queryString,String[] value){
		return retrieveObj(queryString,value);
	}


	public List<User> searchUsers(String queryString){
		return retrieveObjs(queryString);
	}

	public List<User> searchUsers(String queryString,String value){
		return retrieveObjs(queryString,value);
	}

	public List<User> searchUsers(String queryString,String[] values){
		return retrieveObjs(queryString,values);
	}

	public List<User> searchUsers(String queryString,String value,int first,int max){
		return retrieveObjs(queryString,value,first,max);
	}

	public List<User> searchUsers(String queryString,String[] value,int first,int max){
		return retrieveObjs(queryString,value,first,max);
	}
}