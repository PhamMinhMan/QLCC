package edu.uit.qlcc.common.action;

import java.sql.SQLException;
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

import edu.uit.qlcc.common.Worktime;

public class SearchAction extends BaseAction implements SessionAware {
	private static final long serialVersionUID = 1L;
	private String searchDate = "";
	private Map<String, Object> session;
	private String dateMonth;
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM");
	ArrayList<Worktime> worktimes = new ArrayList<Worktime>();
	
	

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
	
	public String doDelete(){
		String empCode = (String) session.get(SESSION_EMPLOYEE_CODE);
		Date registerDate = (Date) session.get(SESSION_DATE);
		if (session == null || empCode == null || registerDate == null) {
			return "session";
		}
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext()
                .get(ServletActionContext.HTTP_REQUEST);
		System.out.println(request.getParameter("dateMonth"));
		return SUCCESS;
	};

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
	
	private void updateSessionDateAndWorktimeList(String empCode, int month, int year) throws ParseException, SQLException{
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
}
