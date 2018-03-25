package com.itjava.register;

import java.sql.SQLException;

public class UserService {
	public User login(String username,String password) {
		UserDao dao=new UserDao();
		User user=null;
		try {
			user= dao.getUserByUsernameAndPwd(username, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	public int regist(User user) throws SQLException {
		// TODO Auto-generated method stub
		UserDao dao=new UserDao();
		
		return dao.addUser(user);
	}

}
