package edu.uit.qlcc.common.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDatabase {
	private static ConnectDatabase instance = null;
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static ConnectDatabase getInstance() {
		if (null == instance)
			instance = new ConnectDatabase();
		return instance;
	}

	public Connection getConnection() {
		Connection connection = null;
		try {
			String url = "jdbc:mysql://localhost:3306/qlcc";
			String username = "root";
			String password = "P@ssword";
			connection = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
}
