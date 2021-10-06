package com.core;

import java.sql.*;

public class DB {
	private static Connection conn;
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException  {
		/*
		if (conn != null && conn instanceof Connection) {
			return conn;
		}
		*/
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/madang";
		String user = "root";
		String password = "aA!12345";
		conn = DriverManager.getConnection(url, user, password);
		
		return conn;		
	}
}