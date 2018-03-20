package com.niit.dao;

import java.util.List;

import com.niit.model.User;

public interface UserDao {

	public boolean addUser(User user);
	public boolean updateUser(User user);
	public boolean deleteUser(User user);
	public User getUser(int userId);
	public List<User> listUsers();
}
