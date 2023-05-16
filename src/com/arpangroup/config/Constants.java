package com.arpangroup.config;

public class Constants {
//	public static final String DB_DRIVER = "com.mysql.jdbc.Driver";
	public static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String DB_URL = "jdbc:mysql://localhost:3306/";
	public static final String DB_NAME = "wipro_servlet";
	public static final String DB_USERNAME = "root";
	public static final String DB_PASSWORD = "";
	
	public static final String QUERY_GET_ALL_USERS = "select username, password, user_type from user";
	public static final String QUERY_GET_USER_BY_USERNAME_AND_PASSWORD = "select * from user where username=? AND password=?";
	public static final String QUERY_ADD_USER = "insert into user(username, password, user_type) values(?, ?, ?)";
	
	public static final String QUERY_GET_ALL_TRAININGS = "select * from training_details";
	public static final String QUERY_GET_TRAININGS_BY_ID = "select * from training_details where TrainingID=?";
	public static final String QUERY_ADD_TRAINING = "insert into training_details(TrainingName, StartDate, EndDate, TrainingMode, BusinessUnit, ContactPersonID) values(?, ?, ?, ?, ?, ?)";
	public static final String QUERY_DELETE_TRAINING_BY_TRAINING_NAME = "DELETE FROM training_details WHERE TrainingName = ?";
}
