package edu.uit.qlcc.common.action;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;

import edu.uit.qlcc.common.Global;
import edu.uit.qlcc.common.Worktime;
import edu.uit.qlcc.common.dao.impl.WorktimeDao;

public class SearchAction extends BaseAction implements SessionAware {
	private static final long serialVersionUID = 1L;
	private String searchDate = "";
	private Map<String, Object> session;
	private String dateMonth;
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM");
	ArrayList<Worktime> worktimes = new ArrayList<Worktime>();
	Worktime wrktime = new Worktime();
	
	public String getDateMonth() {
		return dateMonth;
	}

	public void setDateMonth(String dateMonth) {
		this.dateMonth = dateMonth;
	}

	public String doBack() throws Exception {
		String empCode = (String) session.get(SESSION_EMPLOYEE_CODE);
		Date registerDate = (Date) session.get(SESSION_DATE);
		if (session == null || empCode == null || registerDate == null) {
			return "session";
		}
		return "success";
	}

	public String doNext() throws Exception {
		String empCode = (String) session.get(SESSION_EMPLOYEE_CODE);
		Date registerDate = (Date) session.get(SESSION_DATE);
		if (session == null || empCode == null || registerDate == null) {
			return "session";
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(registerDate);
		int month = cal.get(Calendar.MONTH) + 1;
		int year = cal.get(Calendar.YEAR);
		month++;
		if (month > 12) {
			month = 1;
			year++;
		}
		updateSessionDateAndWorktimeList(empCode, month, year);
		return "success";
	}

	public String doPrevious() throws Exception {
		String empCode = (String) session.get(SESSION_EMPLOYEE_CODE);
		Date registerDate = (Date) session.get(SESSION_DATE);
		if (session == null || empCode == null || registerDate == null) {
			return "session";
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(registerDate);
		int month = cal.get(Calendar.MONTH) + 1;
		int year = cal.get(Calendar.YEAR);
		month--;
		if (month < 1) {
			month = 12;
			year--;
		}
		updateSessionDateAndWorktimeList(empCode, month, year);
		return "success";
	}

	public String doDelete() throws SQLException, ParseException {
		String empCode = (String) session.get(SESSION_EMPLOYEE_CODE);
		Date date = (Date) session.get(SESSION_DATE);
		if (session == null || empCode == null || date == null) {
			return "session";
		}
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext()
				.get(ServletActionContext.HTTP_REQUEST);
		String dateofmonth = request.getParameter("dateMonth");
		dateFormat = new SimpleDateFormat("yyyyMM");
		String yyyyMM = dateFormat.format(date);
		if (dateofmonth.length() == 1)
			dateofmonth = "0" + dateofmonth;
		String yyyyMMdd = yyyyMM + dateofmonth;
		boolean result = new WorktimeDao().deleteWorktime(empCode, yyyyMMdd);
		if(result){
			worktimes = new SearchLogic().getWorktimeAllDateByMonth(empCode, yyyyMM);
			return SUCCESS;
		}
		return ERROR;
	};

	public String doUpdate() throws Exception {
		String empCode = (String) session.get(SESSION_EMPLOYEE_CODE);
		Date date = (Date) session.get(SESSION_DATE);
		if (session == null || empCode == null || date == null) {
			return "session";
		}
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext()
				.get(ServletActionContext.HTTP_REQUEST);
		
		String dateofmonth = request.getParameter("dateMonth");
		dateFormat = new SimpleDateFormat("yyyyMM");
		String yyyyMM = dateFormat.format(date);
		if (dateofmonth.length() == 1)
			dateofmonth = "0" + dateofmonth;
		String yyyyMMdd = yyyyMM + dateofmonth;
		dateFormat = new SimpleDateFormat("yyyyMMdd");
		date = dateFormat.parse(yyyyMMdd);
		session.put(SESSION_DATE, date);
		wrktime = new WorktimeDao().getWorktimeByDate(empCode, yyyyMMdd);
		return SUCCESS;
	}

	public ArrayList<Worktime> getWorktimes() {
		return worktimes;
	}

	// truyen date qua search.jsp
	public String getSearchDate() {
		Date d = (Date) session.get(SESSION_DATE);
		dateFormat = new SimpleDateFormat("yyyy/MM");
		String date = dateFormat.format(d);
		return date;
	}

	public String doPrint() throws Exception {
		String empCode = (String) session.get(SESSION_EMPLOYEE_CODE);
		Date registerDate = (Date) session.get(SESSION_DATE);
		if (session == null || empCode == null || registerDate == null) {
			return "session";
		}
		return "success";
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	private void updateSessionDateAndWorktimeList(String empCode, int month, int year)
			throws ParseException, SQLException {
		String sMonth = String.valueOf(month);
		if (sMonth.length() == 1) {
			sMonth = "0" + sMonth;
		}
		String sYear = String.valueOf(year);
		String yyyyMM = sYear + sMonth;
		dateFormat = new SimpleDateFormat("yyyyMM");
		Date d = dateFormat.parse(yyyyMM);
		session.put(SESSION_DATE, d);
		SearchLogic searchLogic = new SearchLogic();
		worktimes = searchLogic.getWorktimeAllDateByMonth(empCode, yyyyMM);
	}

	public String getSdate() {
		dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		return dateFormat.format(session.get(SESSION_DATE));
	}

	// truyen workingClassList qua jsp file
	public Map<String, String> getWorkingClassList() {
		return Global.WORKING_CLASS;
	}
	
	public ArrayList<String> getHourList() {
		return Global.HOUR;
	}

	// truyen minuteList qua jsp file
	public ArrayList<String> getMinuteList() {
		return Global.MINUTE;
	}
	public Map<String, String> getStartClassList() {
		return Global.START_CLASS;
	}
	// truyen endClassList qua jsp file
	public Map<String, String> getEndClassList() {
		return Global.END_CLASS;
	}
	public String getWorkingClassDefault() {
		return wrktime.getWrkClass();
	}
	public String getStartClassDefault() {
		return wrktime.getStartClass();
	}
	public String getEndClassDefault() {
		return wrktime.getEndClass();
	}
	public String getNoteDefault() {
		return wrktime.getNote();
	}
	public String getStarttime_hh_default() {
		return wrktime.getStartTime().substring(0,2);
	}
	public String getStarttime_mm_default() {
		return wrktime.getStartTime().substring(2);
	}
	public String getEndtime_hh_default() {
		return wrktime.getEndTime().substring(0,2);
	}

	public String getEndtime_mm_default() {
		System.out.println(wrktime.getEndTime().substring(2));
		return wrktime.getEndTime().substring(2);
	}
}
