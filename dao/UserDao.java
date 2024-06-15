package com.dao;

import java.util.ArrayList;

import com.model.User;

public interface UserDao {
	public void addOrUpdateUser(User u);

	public ArrayList<User> viewAllUser();

	public void deleteUser(int id);

	public User getById(int id);

}
