package edu.uit.qlcc.common.action;

import java.sql.SQLException;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import edu.uit.qlcc.common.Employee;
import edu.uit.qlcc.common.dao.EmployeeDao;

public class LoginAction extends BaseAction implements ModelDriven<Object>, SessionAware {
	private static final long serialVersionUID = 1L;
	private Map<String, Object> session;
	Employee employee = new Employee();

	public Object getModel() {
		return employee;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String execute() throws SQLException {
		String ecode = employee.getEmpCode();
		String pass = employee.getEmpPassword();
		EmployeeDao empDao = new EmployeeDao();
		if (empDao.loginEmployee(ecode, pass)) {
			//Map<String, Object> session = ActionContext.getContext().getSession();
			// HttpSession session =
			// ServletActionContext.getRequest().getSession();
			session.put(SESSION_EMPLOYEE_CODE, ecode);
			return SUCCESS;
		}
		return ERROR;
	}

	@Override
	public void validate() {
		// if("".equals(employee.getEmpCode())){
		// addFieldError("employee.empCode", getText("error.empCode"));
		// }
		// if("".equals(employee.getEmpPassword())){
		// addFieldError("employee.empPassword", getText("error.empPassword"));
		// }
		// String ecode = employee.getEmpCode();
		// String pass = employee.getEmpPassword();
		// EmployeeDao empDao = new EmployeeDao();
		// try {
		// if (!empDao.loginEmployee(ecode, pass)){
		// addFieldError("employee.empCode",getText("error.login"));
		// }
		// } catch (SQLException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;

	}

//	public Date getCurrentDate(){
//		return new Date();
//	}
}