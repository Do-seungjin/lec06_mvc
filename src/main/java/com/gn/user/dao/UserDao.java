package com.gn.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.gn.commom.sql.JDBCTemplate;
import com.gn.user.vo.User;

public class UserDao {
	public int createUser(User u,Connection conn) {		
		conn = JDBCTemplate.getConnection();
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			String sql = "INSERT INTO user (user_id,user_pw,user_name) VALUES (?,?,?) ";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, u.getUser_id());
			pstmt.setString(2, u.getUser_pw());
			pstmt.setString(3, u.getUser_name());
			
			result=pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
