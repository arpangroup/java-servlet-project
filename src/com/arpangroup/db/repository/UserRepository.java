package com.arpangroup.db.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.arpangroup.config.Constants;
import com.arpangroup.db.ConnectionFactory;
import com.arpangroup.db.DbUtil;
import com.arpangroup.db.UserInfo;

public class UserRepository {	
	private Connection con;
    private PreparedStatement st;
    
	public UserInfo getUserInfoByUsernameAndPasword(String username, String password){
		ResultSet rs = null;
		try {
			con = ConnectionFactory.getConnection();
			st = con.prepareStatement(Constants.QUERY_GET_USER_BY_USERNAME_AND_PASSWORD);			
			st.setString(1, username);
			st.setString(2, password);
			rs = st.executeQuery();
			if(rs.next()) {
				 UserInfo userInfo = new UserInfo(rs.getString("username"), rs.getString("password"), rs.getString("user_type"));
			     return userInfo;
			} 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(rs);
			DbUtil.close(con);
			DbUtil.close(st);
		}
		return null;
	}
	
	public UserInfo addUserInfo(UserInfo user){
		try {
			con = ConnectionFactory.getConnection();
			st = con.prepareStatement(Constants.QUERY_GET_USER_BY_USERNAME_AND_PASSWORD);
			st.setString(1, user.getUsername());
			st.setString(2, user.getPassword());
			st.setString(3, user.getUserType());
			
			st.executeUpdate();
	        return user;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(con);
			DbUtil.close(st);
		}
		return null;
	}
	
	public List<UserInfo> addUsers(List<UserInfo> users){
		users.forEach(u -> addUserInfo(u));
		return users;
	}
	

	public List<UserInfo> getAllUsers(){
		List<UserInfo> users = new ArrayList<UserInfo>();
		ResultSet rs = null;
		try {
			con = ConnectionFactory.getConnection();
			st = con.prepareStatement(Constants.QUERY_GET_ALL_USERS);
			rs = st.executeQuery();
			while(rs.next()) {
				 UserInfo userInfo = new UserInfo(rs.getString("username"), rs.getString("password"), rs.getString("user_type"));
				 users.add(userInfo);
			} 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(rs);
			DbUtil.close(con);
			DbUtil.close(st);
		}
		return users;
	}

}
