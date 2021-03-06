package com.revature.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
	//Problem this can be called many times, making many connections
	//Better to make it a singleton, one connection per run
	public static Connection getConnection() throws SQLException, IOException {
		Properties prop = new Properties(); 
		InputStream in = new FileInputStream("src/main/resources/connection.properties");
		prop.load(in);
		
		String url = prop.getProperty("url");
		String user = prop.getProperty("user");
		String password = prop.getProperty("password");
		
		return DriverManager.getConnection(url, user, password);
	}
}
