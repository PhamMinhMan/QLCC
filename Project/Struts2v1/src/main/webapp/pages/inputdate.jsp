<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<sx:head />
<title>Input Date</title>
</head>
<body>
	<h1>Input Date</h1>


	<s:form action="inputdate" method="post">

		<tr>
			<td>Company Name:</td>
			<td>XXXXXXXXXXX</td>
		</tr>
		<tr>
			<td>Employee Name:</td>
			<td>YYYYYYYYYYY</td>
		</tr>


		<sx:datetimepicker name="inputdate" label="Date"
			displayFormat="dd-MM-yyyy" value="todayDate" />


		<s:submit action="back" key="Back" />
		<s:submit action="search" key="Search" />
		<s:submit action="register" key="Register" />
	</s:form>
</body>
</html>