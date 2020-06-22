package com.ssc.shop.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssc.shop.model.UserInfo;

/**
 *
 * @author SURAJ CHANDEL
 */
public interface UserDao {

	public void insertUser(UserInfo user) throws SQLException;

	 public UserInfo getUserById(Integer userId);
	 
	 public UserInfo checkLogin(String email,String password);
	 
	 public List<UserInfo> getAllUsers();
	 
	 public void updateUser(UserInfo user);
	 
	 public void deleteUser(Integer userId);
}
