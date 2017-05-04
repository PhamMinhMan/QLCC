package edu.uit.qlcc.common.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

import edu.uit.qlcc.common.Employee;
import edu.uit.qlcc.common.Global;
import edu.uit.qlcc.common.dao.CompanyDao;
import edu.uit.qlcc.common.dao.EmployeeDao;

public class InputdateAction extends BaseAction implements SessionAware {
	private static final long serialVersionUID = 1L;
	private Date date;
	private Map<String, Object> session;
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

	public String doRegister() throws Exception {
		if (session == null || session.get(SESSION_EMPLOYEE_CODE) == null) {
			return "session";
		}
		String empCode = (String) session.get(SESSION_EMPLOYEE_CODE);
		Date registerDate = getDate();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(registerDate);

		System.out.println(dateFormat.format(calendar.getTime()));
		session.put(SESSION_DATE, getDate());
//		EmployeeDao employeeDao = new EmployeeDao();
//		Employee employee= employeeDao.getEmployeeByEmpcode(empCode);
//		session.put(SESSION_EMPLOYEE_NAME, employee.getEmpName());
//		String comName = CompanyDao.getCompanyNameByCompanyCode(employee.getComCode());
//		session.put(SESSION_COMPANY_NAME, comName);
		
		session.put(SESSION_EMPLOYEE_NAME, "Nguyễn Văn A");
		session.put(SESSION_COMPANY_NAME, "Công ty ABC");
		return SUCCESS;
	}

	public String doSearch() {
		session.put(SESSION_DATE, getDate());
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

	//truyen date qua register.jsp
	public String getSdate() {
		String date = dateFormat.format(getDate());
		return date;
	}
	
	
	//truyen date qua search.jsp
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
	
	//truyen employeeName sang jsp file
	public String getEmployeeName(){
		return "Nguyễn Văn A";
	}
	
	//truyen companyName sang jsp file
		public String getCompanyName(){
			return "Công ty ABC";
		}
}
