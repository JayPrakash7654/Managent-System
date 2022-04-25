package com.mvc.service;

import java.util.List;

import com.mvc.bean.*;
import com.mvc.dao.*;



public class UserServiceImpl implements UserService
{

	public UserDaoImpl userdao=new UserDaoImpl();
	@Override
	public void addUser(User user) {
		 
		 userdao.addUser(user);
		
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return UserDaoImpl.getAllUsers();
	}
	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return UserDaoImpl.getUserById(id);
	}
	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		 UserDaoImpl.updateUser(user);;
	}

	
}
