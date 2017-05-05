<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/plain; charset=UTF-8">
<title>Search</title>
<link rel="stylesheet" href="pages/css/search.css">
</head>
<body>
	<div>
		<h2>Thông tin chuyên cần theo tháng</h2>
		<s:form method="post" theme="simple">
			<div>
				<table>
					<tr>
						<td>Company Name</td>
						<td><s:property value="#session.companyname" /></td>
					</tr>
					<tr>
						<td>Employee Name</td>
						<td><s:property value="#session.empname" /></td>
						<td>Date</td>
						<td>
							<s:property value="searchDate" />
						</td>
					</tr>
				</table>
			</div>
			<div>
				<s:submit action="back" value="Back" align="left" />
				<s:submit action="print" value="Print"  />
				<s:submit action="previous" value="Previous Month"  />
				<s:submit action="next" value="Next Month"  />
			</div>
		</s:form>
	</div>
</body>
</html>