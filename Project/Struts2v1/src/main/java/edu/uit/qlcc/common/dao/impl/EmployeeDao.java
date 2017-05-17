package edu.uit.qlcc.common.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

import edu.uit.qlcc.common.Employee;
import edu.uit.qlcc.common.dao.inf.IEmployeeDao;

public class EmployeeDao implements IEmployeeDao{
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
	

	public Employee getEmployeeByEmpcode(String empcode) throws SQLException{
		Employee employee = new Employee();
		String sql = "select * from employee where emp_code =? and flag_delete ='0'";
		Connection dbConnection = ConnectDatabase.getInstance().getConnection();
		PreparedStatement cstmt = (PreparedStatement) dbConnection.prepareStatement(sql);
		try {
			cstmt.setString(1, empcode);
			ResultSet rs = cstmt.executeQuery();
			if (rs.next()) {
				employee = convertToEmployee(rs);
			}
		} catch (SQLException e) {
		} finally {
			if (cstmt != null) {
				cstmt.close();
				cstmt = null;
			}
			if (dbConnection != null) {
				dbConnection.close();
				dbConnection = null;
			}
		}
		return employee;
	}
	
	private Employee convertToEmployee(ResultSet rSet) throws SQLException{
		Employee employee = new Employee();
		employee.setEmpCode(rSet.getString("emp_code"));
		employee.setEmpName(rSet.getString("emp_name"));
		employee.setComCode(rSet.getString("com_code"));
		employee.setFlagDelete(rSet.getString("flag_delete"));
		return employee;
	}
}
