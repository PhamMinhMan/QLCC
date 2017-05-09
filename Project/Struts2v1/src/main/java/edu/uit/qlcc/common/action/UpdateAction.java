package edu.uit.qlcc.common.action;

import java.util.Date;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import edu.uit.qlcc.common.Global;

public class UpdateAction extends BaseAction implements SessionAware {

	private static final long serialVersionUID = 1L;
	private Map<String, Object> session;

	public String doUpdate() throws Exception {
		String empCode = (String) session.get(SESSION_EMPLOYEE_CODE);
		Date date = (Date) session.get(SESSION_DATE);
		if (session == null || empCode == null || date == null) {
			return "session";
		}
		return SUCCESS;

	}

	public void setSession(Map<String, Object> arg0) {
		session = arg0;

	}

	// truyen workingClassList qua jsp file
	public Map<String, String> getWorkingClassList() {
		return Global.WORKING_CLASS;
	}
}