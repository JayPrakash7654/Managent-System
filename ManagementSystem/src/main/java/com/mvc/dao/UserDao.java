package com.mvc.dao;

import java.util.List;
import com.mvc.bean.User;

public interface UserDao {
 
	List<User> get();
	
	User get(int id);
	
	boolean save(User user);
	
	boolean delete(int id);
	
	boolean update(User user);

}
