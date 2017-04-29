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
	<div>
		<h2>Register</h2>
		<s:form  method="post" theme="simple">
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
						<td>
							<%--<s:property value="#session.date" /> --%> 
							<s:property value="registerDate" />
						</td>
					</tr>
					<tr>
						<td>Working Class</td>
						<td><s:select list="workingClassList" name="workingclass"
								value="01" /></td>
					</tr>
					<tr>
						<td>Start Time</td>
						<td>
							<s:select
								list="hourList" name="starttime_hh" value="" /> <s:select
								list="minuteList" name="starttime_mm" value="" />
						</td>
						<td>Start Class</td>
						<td><s:select list="startClassList" name="startclass"
								value="00" /></td>
					</tr>
					<tr>
						<td>End Time</td>
						<td><s:select list="hourList" name="endtime_hh" value="" />
							<s:select list="minuteList" name="endtime_mm" value="" /></td>
						<td>End Class</td>
						<td><s:select list="endClassList" name="endclass" value="00" /></td>
					</tr>
					<tr>
						<td>Note</td>
						<td colspan="3"><s:textarea label="Address" name="address"
								cols="40" rows="10" /></td>
					</tr>
				</table>
			</div>
			<div>
				<s:submit action="back" value="Back" align="left" />
				<s:submit action="registerInput" value="Register" align="right" />
			</div>
		</s:form>
	</div>
</body>
</html>