package com.forum.service.impl;

import java.util.List;

import com.forum.bean.User;
import com.forum.dao.UserDao;
import com.forum.service.UserService;

public class UserServiceImpl implements UserService
{
	private UserDao userDao;

	private String list_all_desc = "from User bean order by bean.id desc";

	private String list_all_asc = "from User bean order by bean.id asc";

	public void setUserDao (UserDao userDao)
	{
		this.userDao = userDao;
	}

	public UserDao getUserDao()
	{
		return this.userDao;
	}

	public List<User> listUsers(int start, int range)
	{
		return this.listUserDesc(start, range);
	}

	public List<User> listUserDesc(int start, int range)
	{
		return this.userDao.searchUsers(list_all_desc, new String[]{}, start, range);
	}

	public List<User> listUserAsc(int start, int range)
	{
		return this.userDao.searchUsers(list_all_asc, new String[]{}, start, range);
	}

	public long getUserCount()
	{
		return this.userDao.getUserCount(list_all_desc);
	}

	public void saveUser (User bean)
	{
		this.userDao.saveUser(bean);
	}

	public void updateUser (User bean)
	{
		this.userDao.updateUser(bean);
	}

	public void deleteUser (Long id)
	{
		this.userDao.removeUser(id);
	}

	public User getUser (Long id)
	{
		return this.userDao.getUser(id);
	}

}