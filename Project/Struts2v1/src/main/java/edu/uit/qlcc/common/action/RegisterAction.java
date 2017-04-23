package edu.uit.qlcc.common.action;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

public class RegisterAction extends BaseAction implements SessionAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map<String,Object> session;
	@Override
	public String execute() throws Exception {
		String empCode = (String) session.get(SESSION_EMPLOYEE_CODE);
		System.out.println(empCode+" man");
		return "success";
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;		
	}
}
