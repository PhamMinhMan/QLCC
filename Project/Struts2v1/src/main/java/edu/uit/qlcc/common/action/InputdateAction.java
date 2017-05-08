package edu.uit.qlcc.common.action;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

import edu.uit.qlcc.common.Employee;
import edu.uit.qlcc.common.Global;
import edu.uit.qlcc.common.Worktime;
import edu.uit.qlcc.common.dao.impl.CompanyDao;
import edu.uit.qlcc.common.dao.impl.EmployeeDao;
import edu.uit.qlcc.common.dao.impl.WorktimeDao;

public class InputdateAction extends BaseAction implements SessionAware {
	private static final long serialVersionUID = 1L;
	private Date date;
	private Map<String, Object> session;
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
	ArrayList<Worktime> worktimes;

	public String doRegister() throws Exception {
		String empCode = (String) session.get(SESSION_EMPLOYEE_CODE);
		if (session == null || empCode == null) {
			return "session";
		}
		Date regDate = getDate();
		regDate = dateFormat.parse(dateFormat.format(regDate));
		Date curDate = new Date();
		curDate = dateFormat.parse(dateFormat.format(curDate));
		if (regDate.before(curDate)){
			addActionError("Ngày đăng kí không được sớm hơn ngày hiện tại");
			return INPUT;
		} 
		Date registerDate = getDate();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(registerDate);

		System.out.println(dateFormat.format(calendar.getTime()));
		session.put(SESSION_DATE, getDate());
		return SUCCESS;
	}

	public String doSearch() throws SQLException {
		String empCode = (String) session.get(SESSION_EMPLOYEE_CODE);
		if (session == null || empCode == null) {
			return "session";
		} 
		session.put(SESSION_DATE, getDate());
		Date regDate = getDate();
		Date curDate = new Date();
		if (regDate.compareTo(curDate) > 0){
			addActionError("Ngày tìm kiếm không được sau ngày hiện tại");
			return INPUT;
		}
		dateFormat = new SimpleDateFormat("yyyyMM");
		String searchDate = dateFormat.format(getDate());
		SearchLogic searchLogic = new SearchLogic();
		//lay worktime tat ca cac ngay trong thang
		worktimes = searchLogic.getWorktimeAllDateByMonth(empCode, searchDate);
		System.out.println(worktimes.size());
		return SUCCESS;
	}

	public String doBack() {
		return SUCCESS;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	// truyen date qua register.jsp
	public String getSdate() {
		String date = dateFormat.format(getDate());
		return date;
	}

	// truyen date qua search.jsp
	public String getSearchDate() {
		dateFormat = new SimpleDateFormat("yyyy/MM");
		String date = dateFormat.format(getDate());
		return date;
	}

	// truyen workingClassList qua jsp file
	public Map<String, String> getWorkingClassList() {
		return Global.WORKING_CLASS;
	}

	// truyen startClassList qua jsp file
	public Map<String, String> getStartClassList() {
		return Global.START_CLASS;
	}

	// truyen endClassList qua jsp file
	public Map<String, String> getEndClassList() {
		return Global.END_CLASS;
	}

	// truyen hourList qua jsp file
	public ArrayList<String> getHourList() {
		return Global.HOUR;
	}

	// truyen minuteList qua jsp file
	public ArrayList<String> getMinuteList() {
		return Global.MINUTE;
	}

	// truyen employeeName sang jsp file
	public String getEmployeeName() {
		return "Nguyễn Văn A";
	}

	// truyen companyName sang jsp file
	public String getCompanyName() {
		return "Công ty ABC";
	}

	public ArrayList<Worktime> getWorktimes() {
		return worktimes;
	}

	public void setWorktimes(ArrayList<Worktime> worktimes) {
		this.worktimes = worktimes;
	}
	
	
}
