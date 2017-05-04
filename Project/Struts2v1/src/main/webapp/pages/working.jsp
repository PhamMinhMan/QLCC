<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"	language="java"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/plain; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="pages/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="pages/js/register.js"></script>
</head>
<body>
	<div class="common">
		<table>
			<tr>
				<td>Company Name</td>
<%-- 				<td><s:property value="companyName" /></td> --%>
					<td><s:property value="#session.companyname" /></td>
			</tr>
			<tr>
				<td>Employee Name</td>
<%-- 				<td><s:property value="employeeName" /></td> --%>
				<td><s:property value="#session.empname" /></td>
				<td>Date</td>
				<td>
					<%--<s:property value="#session.date" /> --%> <s:property
						value="sdate" />
				</td>
			</tr>
			<tr>
				<td>Working Class</td>
				<td>
					<s:fielderror fieldName="worktime.wrkClass"></s:fielderror>
					<s:select list="workingClassList" name="worktime.wrkClass"
						value="01" id="workingclass"/></td>
			</tr>
			<tr>
				<td>Start Time</td>
				<td>
					<s:fielderror fieldName="starttime_hh"></s:fielderror>
					<s:select list="hourList" name="starttime_hh" value="" id="starttime_hh"/>
					<s:select list="minuteList" name="starttime_mm" value="" id="starttime_mm"/></td>
				<td>Start Class</td>
				<td>
					<s:fielderror fieldName="worktime.startClass"></s:fielderror>
					<s:select list="startClassList" name="worktime.startClass"
						value="00" id="startclass"/></td>
			</tr>
			<tr>
				<td>End Time</td>
				<td>
					<s:fielderror fieldName="endtime_hh"></s:fielderror>
					<s:select list="hourList" name="endtime_hh" value="" id="endtime_hh"/> <s:select
						list="minuteList" name="endtime_mm" value="" id="endtime_mm"/></td>
				<td>End Class</td>
				<td>
					<s:fielderror fieldName="worktime.endClass"></s:fielderror>
					<s:select list="endClassList" name="worktime.endClass" value="00" id="endclass"/></td>
			</tr>
			<tr>
				<td>Note</td>
				<td colspan="3"><s:textarea name="worktime.note"
						cols="65" rows="8" onKeyDown="limitText(this,200);"
						onKeyUp="limitText(this,200);" /></td>
			</tr>
		</table>
	</div>
</body>
</html>