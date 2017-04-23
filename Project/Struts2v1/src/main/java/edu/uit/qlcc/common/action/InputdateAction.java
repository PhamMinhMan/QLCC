package edu.uit.qlcc.common.action;

import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

public class InputdateAction extends BaseAction implements SessionAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map<String,Object> session;
	@Override
	public String execute() throws Exception {
		String empCode = (String) session.get(SESSION_EMPLOYEE_CODE);
		System.out.println(empCode);
		return SUCCESS;
	}
	
	public void setSession(Map<String, Object> session) {
		this.session = session;		
	}
}
