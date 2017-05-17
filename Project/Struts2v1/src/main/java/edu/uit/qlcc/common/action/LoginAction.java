package edu.uit.qlcc.common.action;

import java.sql.SQLException;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

import edu.uit.qlcc.common.Company;
import edu.uit.qlcc.common.Employee;
import edu.uit.qlcc.common.dao.impl.CompanyDao;
import edu.uit.qlcc.common.dao.impl.EmployeeDao;

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
	public String execute() throws SQLException, SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException {
		String ecode = employee.getEmpCode();
		String pass = employee.getEmpPassword();
		EmployeeDao empDao = new EmployeeDao();
		if (empDao.loginEmployee(ecode, pass)) {
			session.put(SESSION_EMPLOYEE_CODE, ecode);
			EmployeeDao employeeDao = new EmployeeDao();
			Employee employee = employeeDao.getEmployeeByEmpcode(ecode);
			String empName = employee.getEmpName();
			session.put(SESSION_EMPLOYEE_NAME, empName);
			String comCode = employee.getComCode();
			CompanyDao companyDao = new CompanyDao();
			String comName = companyDao.getCompanyNameByCompanyCode(comCode);
			session.put(SESSION_COMPANY_NAME, comName);
			return SUCCESS;
		}
		return ERROR;
	}

	@Override
	public void validate() {
		boolean check = true;
		if (employee.getEmpCode().trim().length() != 4) {
			check = false;
			addFieldError("employee.empCode", getText("error.empCode"));
		}
		if (employee.getEmpPassword().trim().isEmpty()) {
			check = false;
			addFieldError("employee.empPassword", getText("error.empPassword"));
		}
		if (check) {
			String ecode = employee.getEmpCode();
			String pass = employee.getEmpPassword();
			EmployeeDao empDao = new EmployeeDao();
			try {
				if (!empDao.loginEmployee(ecode, pass)) {
					addFieldError("employee.empCode", getText("error.login"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;

	}

	// public Date getCurrentDate(){
	// return new Date();
	// }
}