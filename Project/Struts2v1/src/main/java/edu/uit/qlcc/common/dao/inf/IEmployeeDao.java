package edu.uit.qlcc.common.dao.inf;

import java.sql.SQLException;

import edu.uit.qlcc.common.Employee;

public interface IEmployeeDao {
	public boolean loginEmployee(String empcode, String password) throws SQLException;
	public Employee getEmployeeByEmpcode(String empcode) throws SQLException;
}
