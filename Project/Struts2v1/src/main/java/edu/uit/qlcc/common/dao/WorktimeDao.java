package edu.uit.qlcc.common.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import edu.uit.qlcc.common.Worktime;

public class WorktimeDao {
	public Worktime getWorktimeByDate(String empcode, String yyyyMMdd) throws SQLException{
		Worktime worktime = new Worktime();
		String call = "{cal getWorktimeByDate(?,?)}";
		Connection dbConnection = ConnectDatabase.getInstance().getConnection();
		CallableStatement cstmt = dbConnection.prepareCall(call);
		try {
			cstmt.setString(1, empcode);
			cstmt.setString(2, yyyyMMdd);
			ResultSet rs = cstmt.executeQuery();
			if (rs.next()) {
				worktime = convertToWorktime(rs);
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
		return worktime;
	}
	
	public boolean insertWorktime(Worktime worktime) throws SQLException{
		String call = "{cal insertWorktime(?,?,?,?,?,?,?,?,?,?)}";
		Connection dbConnection = ConnectDatabase.getInstance().getConnection();
		CallableStatement cstmt = dbConnection.prepareCall(call);
		try {
			cstmt.setString(1, worktime.getEmpCode());
			cstmt.setString(2, worktime.getCalYmd());
			cstmt.setString(3, worktime.getWrkClass());
			cstmt.setString(4, worktime.getStartClass());
			cstmt.setString(5, worktime.getEndClass());
			cstmt.setString(6, worktime.getStartTime());
			cstmt.setString(7, worktime.getEndTime());
			cstmt.setString(8, worktime.getNote());
			cstmt.setString(9, worktime.getEmpCode());
			cstmt.setString(10, getCurrentDate());
			int rs = cstmt.executeUpdate();
			if (rs!=0) {
				return false;
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
		return false;
	}
	
	public boolean updateWorktime(Worktime worktime) throws SQLException{
		String call = "{cal updateWorktime(?,?,?,?,?,?,?,?,?,?)}";
		Connection dbConnection = ConnectDatabase.getInstance().getConnection();
		CallableStatement cstmt = dbConnection.prepareCall(call);
		try {
			cstmt.setString(1, worktime.getEmpCode());
			cstmt.setString(2, worktime.getCalYmd());
			cstmt.setString(3, worktime.getWrkClass());
			cstmt.setString(4, worktime.getStartClass());
			cstmt.setString(5, worktime.getEndClass());
			cstmt.setString(6, worktime.getStartTime());
			cstmt.setString(7, worktime.getEndTime());
			cstmt.setString(8, worktime.getNote());
			cstmt.setString(9, worktime.getEmpCode());
			cstmt.setString(10, getCurrentDate());
			int rs = cstmt.executeUpdate();
			if (rs!=0) {
				return false;
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
		return false;
	}
	
	public boolean deleteWorktime(String comcode, String yyyyMMdd) throws SQLException{
		String call = "{cal updateWorktime(?,?,?,?,?,?,?,?,?,?)}";
		Connection dbConnection = ConnectDatabase.getInstance().getConnection();
		CallableStatement cstmt = dbConnection.prepareCall(call);
		try {
			cstmt.setString(1, comcode);
			cstmt.setString(2, yyyyMMdd);
			int rs = cstmt.executeUpdate();
			if (rs!=0) {
				return false;
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
		return false;
	}
	
	private Worktime convertToWorktime(ResultSet rSet) throws SQLException{
		Worktime worktime = new Worktime();
		worktime.setEmpCode(rSet.getString("emp_code"));
		worktime.setCalYmd(rSet.getString("cal_ymd"));
		worktime.setWrkClass(rSet.getString("wrk_class"));
		worktime.setStartClass(rSet.getString("start_class"));
		return worktime;
	}
	
	private String getCurrentDate(){
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		Calendar calendar = Calendar.getInstance();
		return dateFormat.format(calendar);
	}
}