package edu.uit.qlcc.common.action;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

public class SearchAction extends BaseAction implements SessionAware {
	private static final long serialVersionUID = 1L;
	private Map<String, Object> session;
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM");

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
		return "success";
	}
	public String doPrevious() throws Exception {
		String empCode = (String) session.get(SESSION_EMPLOYEE_CODE);
		Date registerDate = (Date) session.get(SESSION_DATE);
		if (session == null || empCode == null || registerDate == null) {
			return "session";
		}
		return "success";
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
}
