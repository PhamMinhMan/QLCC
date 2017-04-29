package edu.uit.qlcc.common.action;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

public class RegisterAction extends BaseAction implements SessionAware {
	private static final long serialVersionUID = 1L;
	private Map<String, Object> session;
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

	@Override
	public String execute() throws Exception {
		if (session == null || session.get(SESSION_EMPLOYEE_CODE) == null || session.get(SESSION_DATE) == null) {
			return "session";
		}
		String empCode = (String) session.get(SESSION_EMPLOYEE_CODE);
		Date registerDate = (Date) session.get(SESSION_DATE);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(registerDate);
		System.out.println(empCode + " man");
		System.out.println(dateFormat.format(calendar.getTime()));
		return "success";
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
