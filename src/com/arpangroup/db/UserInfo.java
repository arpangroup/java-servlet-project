package com.arpangroup.db;

public class UserInfo {
	private String username;
	private String password;
	private String userType;

	public UserInfo() {
	}
	
	public UserInfo(String username, String password, String userType) {
		super();
		this.username = username;
		this.password = password;
		this.userType = userType;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}

	@Override
	public String toString() {
		return "{username=" + username + ", userType=" + userType + "}";
	}
	
	
	
	

}
