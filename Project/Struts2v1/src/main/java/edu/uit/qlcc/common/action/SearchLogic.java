package edu.uit.qlcc.common.action;

import java.sql.SQLException;
import java.util.ArrayList;

import edu.uit.qlcc.common.Worktime;
import edu.uit.qlcc.common.dao.impl.WorktimeDao;


public class SearchLogic {
	public ArrayList<Worktime> getWorktimeAllDateByMonth(String empcode, String yyyyMM) throws SQLException{
		ArrayList<Worktime> allworktimes = new ArrayList<Worktime>();//ket qua tra ve
		WorktimeDao worktimeDao = new WorktimeDao();
		//danh sach worktime theo thang lay tu database
		ArrayList<Worktime> worktimes = worktimeDao.getWorktimeByMonth(empcode, yyyyMM);
		
		//can danh sach worktime tat ca cac ngay trong thang, database khong co thi hien thi rong
		// TODO
		
		//allworktimes = ...
		return allworktimes;
	}

	public SearchLogic() {
		super();
		// TODO Auto-generated constructor stub
	}
}
