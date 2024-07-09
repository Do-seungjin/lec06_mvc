package com.gn.user.service;

import java.sql.Connection;

import com.gn.commom.sql.JDBCTemplate;
import com.gn.user.dao.UserDao;
import com.gn.user.vo.User;



public class UserService {
	public int createUser(User u) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new UserDao().createUser(u,conn);
		return result;
	}
}
