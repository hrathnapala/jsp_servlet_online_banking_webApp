package com.obs.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	private static Connection con;
	public static Connection getDBConnection() {
		try {
			
			Class.forName("com.mysql.jdbc.Driver");	
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/online_banking?useSSL=false", "root", "");
			
		}
		catch(Exception e) {
			System.out.println(e);;
		}
		
		return con;
	}
}
