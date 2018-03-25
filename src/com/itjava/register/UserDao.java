package com.itjava.register;

//import java.sql.SQLException;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;



public class UserDao {

	public User getUserByUsernameAndPwd(String username,String password) throws Exception {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
		
		String sql="select * from user where username = ? and password = ?";	
		
		User user=qr.query(sql,new BeanHandler<>(User.class), username,password);
		
		return user;
	}

	public int addUser(User user) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
		String sql="insert into user (username,password,email,name,sex,birthday,hobby) values(?,?,?,?,?,?,?)";
		return qr.update(sql, user.getUsername(),user.getPassword(),user.getEmail(),user.getName(),user.getBirthday(),user.getHobby());
	}

}
