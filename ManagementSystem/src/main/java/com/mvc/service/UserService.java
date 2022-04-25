package com.mvc.service;

import java.util.List;

import com.mvc.bean.User;

public interface UserService {

void addUser(User user);
	
	List<User> getAllUsers();
	
	User getUserById(int id);
	
	void updateUser(User user);

}
