<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/plain; charset=UTF-8">
<title>Register</title>
<link rel="stylesheet" href="pages/css/register.css">
</head>
<body>
	<h1>Login Form</h1>
	<div>
		<h2>Register</h2>
		<s:form action="registerInput" method="post" theme="simple">
			<div>
				<table>
					<tr>
						<td>Company Name</td>
						<td>ABC</td>
					</tr>
					<tr>
						<td>Employee Name</td>
						<td>Lê Văn Tám</td>
						<td>Date</td>
						<td>2017/1/15</td>
					</tr>
					<tr>
						<td>Working Class</td>
						<td><s:select headerKey="-1" headerValue="Select Month"
								list="#{'1':'Value 1', '2':'Value 2', '3':'Value 3', '4':'Value 4'}"
								name="yourMonth2" value="2" /></td>
					</tr>
					<tr>
						<td>Start Time</td>
						<td>
							<%-- 						<s:doubleselect  --%> <%-- 								list="#{'1':'Value 1', '2':'Value 2', '3':'Value 3', '4':'Value 4'}" --%>
							<%-- 								name="hour" value="2" --%> <%-- 								doubleList="#{'1':'Value 1', '2':'Value 2', '3':'Value 3', '4':'Value 4'}" --%>
							<%-- 								doubleName="minute" doubleValue="3" /> --%> 
							<s:select
								headerKey="-1" headerValue="Select Month"
								list="#{'1':'Val 1', '2':'Val 2', '3':'Val 3', '4':'Val 4'}"
								name="yourMonth2" value="2" /> 
								<s:select headerKey="-1"
								headerValue="Select Month"
								list="#{'1':'Val 1', '2':'Val 2', '3':'Val 3', '4':'Val 4'}"
								name="yourMonth2" value="2" />
						</td>
						<td>Start Class</td>
						<td><s:select headerKey="-1" headerValue="Select Month"
								list="#{'1':'Value 1', '2':'Value 2', '3':'Value 3', '4':'Value 4'}"
								name="yourMonth3" value="2" /></td>
					</tr>
					<tr>
						<td>End Time</td>
						<td><s:select headerKey="-1" headerValue="Select Month"
								list="#{'1':'Val 1', '2':'Val 2', '3':'Val 3', '4':'Val 4'}"
								name="yourMonth2" value="2" /> <s:select headerKey="-1"
								headerValue="Select Month"
								list="#{'1':'Val 1', '2':'Val 2', '3':'Val 3', '4':'Val 4'}"
								name="yourMonth2" value="2" /></td>
						<td>End Class</td>
						<td><s:select headerKey="-1" headerValue="Select Month"
								list="#{'1':'Value 1', '2':'Value 2', '3':'Value 3', '4':'Value 4'}"
								name="yourMonth1" value="2" /></td>
					</tr>
					<tr>
						<td>Note</td>
						<td colspan="3"><s:textarea label="Address" name="address"
								cols="40" rows="10" /></td>
					</tr>
				</table>
				<%-- 				<s:textfield name="employee.empCode" label="Employee Code" /> --%>
				<%-- 				<s:password name="employee.empPassword" label="Password" /> --%>
			</div>
			<div>
<%-- 				<s:submit value="Back" align="left" /> --%>
				<s:submit  value="Register" align="right" />
			</div>
		</s:form>
	</div>
</body>
</html>