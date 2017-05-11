package edu.uit.qlcc.common.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.jdbc.PreparedStatement;
import edu.uit.qlcc.common.dao.inf.ICompanyDao;

public class CompanyDao implements ICompanyDao{
	public String getCompanyNameByCompanyCode(String comCode) throws SQLException {
		String sql = "select com_name from company where com_code =?";
		Connection dbConnection= null;
		dbConnection = ConnectDatabase.getInstance().getConnection();
		PreparedStatement cstmt = (PreparedStatement) dbConnection.prepareStatement(sql);
		String comName = "";
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
