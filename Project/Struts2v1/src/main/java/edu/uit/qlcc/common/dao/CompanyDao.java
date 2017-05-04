package edu.uit.qlcc.common.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.uit.qlcc.common.Company;
import edu.uit.qlcc.common.Employee;

public class CompanyDao {
	public static String getCompanyNameByCompanyCode(String comCode) throws SQLException{
		String call = "{cal getNameCompanyByComcode(?)}";
		Connection dbConnection = ConnectDatabase.getInstance().getConnection();
		CallableStatement cstmt = dbConnection.prepareCall(call);
		String comName="";
		try {
			cstmt.setString(1, comCode);
			ResultSet rs = cstmt.executeQuery();
			if (rs.next()) {
				comName = rs.getString("com_name");
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

		return comName;
	}
}
