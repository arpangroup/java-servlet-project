package com.arpangroup.db;

import java.sql.Connection;
import java.sql.DriverManager;

import com.arpangroup.config.Constants;

public class ConnectionFactory {
	private static ConnectionFactory instance = new ConnectionFactory();
//	public static final String DB_DRIVER = "com.mysql.jdbc.Driver";
	public static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String DB_URL = "jdbc:mysql://localhost:3306/";
	public static final String DB_NAME = "wipro_servlet";
	public static final String DB_USERNAME = "root";
	public static final String DB_PASSWORD = "";
	
	private ConnectionFactory() {
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
	
	 public Connection createConnection() {
		 Connection connection = null;
		 try{
			 connection = DriverManager.getConnection(DB_URL +  DB_NAME, DB_USERNAME, DB_PASSWORD);
		 } catch (Exception e) {
			 System.out.println("ERROR: Unable to Connect to Database.");
		 }
		 return connection;
	 }   
	 
	 public static Connection getConnection() {
		 return instance.createConnection();
	 }
}
