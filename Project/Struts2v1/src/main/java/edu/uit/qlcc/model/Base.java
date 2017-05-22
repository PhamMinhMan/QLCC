package edu.uit.qlcc.model;

public class Base {
	private String createCode;
	private String createDate;
	private String updateCode;
	private String updateDate;
	private String flagDelete;

	public Base() {
		super();
		createCode = "";
		createDate = "";
		updateCode = "";
		updateDate = "";
		flagDelete = "";
	}

	public String getCreateCode() {
		return createCode;
	}

	public void setCreateCode(String createCode) {
		this.createCode = createCode;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getUpdateCode() {
		return updateCode;
	}

	public void setUpdateCode(String updateCode) {
		this.updateCode = updateCode;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public String getFlagDelete() {
		return flagDelete;
	}

	public void setFlagDelete(String flagDelete) {
		this.flagDelete = flagDelete;
	}
}
