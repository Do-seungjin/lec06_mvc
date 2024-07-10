package com.gn.user.dao;

import static com.gn.commom.sql.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.gn.commom.sql.JDBCTemplate;
import com.gn.user.vo.User;

public class UserDao {
	public int createUser(User u,Connection conn) {		
		conn = JDBCTemplate.getConnection();
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			String sql = "INSERT INTO `user` (`user_id`,`user_pw`,`user_name`) VALUES (?,?,?) ";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, u.getUser_id());
			pstmt.setString(2, u.getUser_pw());
			pstmt.setString(3, u.getUser_name());
			
			result=pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				close(pstmt);
				close(conn);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public User loginUser(String id,String pw,Connection conn) {
		User u = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM `user` WHERE user_id=? AND user_pw=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				u = new User(rs.getInt("user_no"),
						rs.getString("user_id"),
						rs.getString("user_pw"),
						rs.getString("user_name"));
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return u;
		
	}
}
