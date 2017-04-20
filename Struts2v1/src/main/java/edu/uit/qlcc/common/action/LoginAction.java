package edu.uit.qlcc.common.action;

import java.sql.SQLException;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import edu.uit.qlcc.common.Employee;
import edu.uit.qlcc.common.dao.EmployeeDao;

public class LoginAction extends ActionSupport implements ModelDriven<Object>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	public String execute() throws SQLException{
		String ecode = employee.getEmpCode();
		String pass = employee.getEmpPassword();
		EmployeeDao empDao = new EmployeeDao();
		if (empDao.loginEmployee(ecode, pass)){
			return SUCCESS;
		}
		else{
			addActionError(getText("error.login"));
		}
		return INPUT;
	}

	@Override
	public void validate() {
		if("".equals(employee.getEmpCode())){
			addFieldError("employee.empCode", getText("error.empCode"));
		}
		if("".equals(employee.getEmpPassword())){
			addFieldError("employee.empPassword", getText("error.empPassword"));
		}
		String ecode = employee.getEmpCode();
		String pass = employee.getEmpPassword();
		EmployeeDao empDao = new EmployeeDao();
		try {
			if (!empDao.loginEmployee(ecode, pass)){
				addFieldError("employee.empCode",getText("error.login"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}