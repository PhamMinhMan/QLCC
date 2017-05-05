<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"
	language="java"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/plain; charset=UTF-8">
<sx:head />
<title>Input Date</title>
</head>
<body>
	<h1>Input Date</h1>


	<s:form>
		<tr>
			<td>Company Name:</td>
			<td><s:property value="#session.companyname" /></td>
		</tr>
		<tr>
			<td>Employee Name:</td>
			<td><s:property value="#session.empname" /></td>
		</tr>

		<sx:datetimepicker name="date" label="Date"
			displayFormat="dd-MM-yyyy" value="%{'today'}"/>

		<s:submit action="back" key="back" method="doBack"/>
		<s:submit action="search" key="search" method="doSearch"/>
		<s:submit action="register" key="register" method="doRegister"/>
	</s:form>
</body>
</html>