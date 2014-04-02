package com.forum.service;

import java.util.List;

import com.forum.bean.User;

public interface UserService
{
	public List<User> listUsers(int start, int range);

	public List<User> listUserDesc(int start, int range);

	public List<User> listUserAsc(int start, int range);

	public long getUserCount();

	public void saveUser (User bean);

	public void updateUser (User bean);

	public void deleteUser (Long id);

	public User getUser (Long id);
}