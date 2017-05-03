package edu.uit.qlcc.common.action;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

import edu.uit.qlcc.common.Worktime;
import edu.uit.qlcc.common.dao.WorktimeDao;

public class RegisterAction extends BaseAction implements SessionAware {
	private static final long serialVersionUID = 1L;
	private Map<String, Object> session;
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
	Worktime worktime = new Worktime();
	private String starttime_hh;
	private String starttime_mm;
	private String endtime_hh;
	private String endtime_mm;

	public String doRegister1() throws Exception {
		if (session == null || session.get(SESSION_EMPLOYEE_CODE) == null || session.get(SESSION_DATE) == null) {
			return "session";
		}
		String empCode = (String) session.get(SESSION_EMPLOYEE_CODE);
		Date registerDate = (Date) session.get(SESSION_DATE);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(registerDate);
		System.out.println(worktime.getWrkClass());
		System.out.println(worktime.getStartClass());
		System.out.println(worktime.getEndClass());
		System.out.println(worktime.getNote());
		dateFormat = new SimpleDateFormat("yyyyMMdd");
		String sdate = dateFormat.format(calendar.getTime());
		System.out.println(sdate);
		worktime.setCalYmd(sdate);
		worktime.setEmpCode(empCode);
		String starttime = getStarttime_hh() + getStarttime_mm();
		starttime = starttime != null ? starttime : "";
		worktime.setStartTime(starttime);
		String endtime = getEndtime_hh() + getEndtime_mm();
		endtime = endtime != null ? endtime : "";
		worktime.setEndTime(endtime);
		
		// WorktimeDao worktimeDao = new WorktimeDao();
		// worktimeDao.insertWorktime(worktime);
		return SUCCESS;
	}

	public String doBack() {
		if (session == null || session.get(SESSION_EMPLOYEE_CODE) == null || session.get(SESSION_DATE) == null) {
			return "session";
		}
		System.out.println("Back");
		return SUCCESS;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public Worktime getWorktime() {
		return worktime;
	}

	public void setWorktime(Worktime worktime) {
		this.worktime = worktime;
	}

	public String getStarttime_hh() {
		return starttime_hh;
	}

	// nhan starttime_hh tu jsp
	public void setStarttime_hh(String starttime_hh) {
		this.starttime_hh = starttime_hh;
	}

	public String getStarttime_mm() {
		return starttime_mm;
	}

	// nhan starttime_mm tu jsp
	public void setStarttime_mm(String starttime_mm) {
		this.starttime_mm = starttime_mm;
	}

	public String getEndtime_hh() {
		return endtime_hh;
	}

	// nhan endtime_hh tu jsp
	public void setEndtime_hh(String endtime_hh) {
		this.endtime_hh = endtime_hh;
	}

	public String getEndtime_mm() {
		return endtime_mm;
	}

	// nhan endtime_mm tu jsp
	public void setEndtime_mm(String endtime_mm) {
		this.endtime_mm = endtime_mm;
	}

}
