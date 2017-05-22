package edu.uit.qlcc.model;

public class Company extends Base implements java.io.Serializable {
	private String comCode;
	private String comName;

	public Company() {
		super();
		comCode = "";
		comName = "";
	}

	public String getComCode() {
		return comCode;
	}

	public void setComCode(String comCode) {
		this.comCode = comCode;
	}

	public String getComName() {
		return comName;
	}

	public void setComName(String comName) {
		this.comName = comName;
	}
}
