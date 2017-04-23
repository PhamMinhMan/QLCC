package edu.uit.qlcc.common.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDao {
	public boolean loginEmployee(String empcode, String password) throws SQLException {
		String call = "{cal loginEmployee(?,?)}";
		Connection dbConnection = ConnectDatabase.getInstance().getConnection();
		CallableStatement cstmt = dbConnection.prepareCall(call);
		Boolean result = false;
		try {
			cstmt.setString(1, empcode);
			cstmt.setString(2, password);
			ResultSet rs = cstmt.executeQuery();
			if (rs.next()) {
				result = true;
			}
		} catch (SQLException e) {
		} finally {
			// Closing the CallableStatement object
			if (cstmt != null) {
				cstmt.close();
				cstmt = null;
			}

			// Closing the Connection object
			if (dbConnection != null) {
				dbConnection.close();
				dbConnection = null;
			}
		}
		return result;
	}
}
