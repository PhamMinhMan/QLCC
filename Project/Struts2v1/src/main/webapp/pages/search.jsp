<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/plain; charset=UTF-8">
<title>Search</title>
<link rel="stylesheet"
	href="src/main/webapp/pages/css/bootstrap.min.css">
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
						<td><s:property value="searchDate" /></td>
					</tr>
				</table>
			</div>

			<div>
				<div class="col-xs-8 col-xs-offset-2 well">
					<table class="table table-scroll table-striped">
						<thead>

							<tr>
								<th></th>
								<th>Day</th>
								<th>Working</th>
								<th>Start Class</th>
								<th>End Class</th>
								<th>Start Time</th>
								<th>End Time</th>
								<th>Note</th>
								<th></th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<s:iterator value="worktimes" status="stt">
								<tr>
									<td>1</td>
									<td>Andrew</td>
									<td>Jackson</td>
									<td>Washington</td>
									<td>1</td>
									<td>Andrew</td>
									<td>Jackson</td>
									<td>Washington</td>
									<td>1</td>
									<td>Andrew</td>
								</tr>
							</s:iterator>
							
							<tr>
								<td>2</td>
								<td>Thomas</td>
								<td>Marion</td>
								<td>Jackson</td>
								<td>2</td>
								<td>Thomas</td>
								<td>Marion</td>
								<td>Jackson</td>
								<td>2</td>
								<td>Thomas</td>
							</tr>
							<tr>
								<td>3</td>
								<td>Benjamin</td>
								<td>Warren</td>
								<td>Lincoln</td>
								<td>3</td>
								<td>Benjamin</td>
								<td>Warren</td>
								<td>Lincoln</td>
								<td>3</td>
								<td>Benjamin</td>
							</tr>
							<tr>
								<td>4</td>
								<td>Grant</td>
								<td>Wayne</td>
								<td>Union</td>
								<td>4</td>
								<td>Grant</td>
								<td>Wayne</td>
								<td>Union</td>
								<td>4</td>
								<td>Grant</td>
							</tr>
							<tr>
								<td>5</td>
								<td>John</td>
								<td>Adams</td>
								<td>Marshall</td>
								<td>5</td>
								<td>John</td>
								<td>Adams</td>
								<td>Marshall</td>
								<td>5</td>
								<td>John</td>
							</tr>
							<tr>
								<td>6</td>
								<td>Morgan</td>
								<td>Lee</td>
								<td>Lake</td>
								<td>5</td>
								<td>John</td>
								<td>Adams</td>
								<td>Marshall</td>
								<td>5</td>
								<td>John</td>
							</tr>
							<tr>
								<td>7</td>
								<td>John</td>
								<td>Henry</td>
								<td>Brown</td>
								<td>5</td>
								<td>John</td>
								<td>Adams</td>
								<td>Marshall</td>
								<td>5</td>
								<td>John</td>
							</tr>
							<tr>
								<td>8</td>
								<td>William</td>
								<td>Jacob</td>
								<td>Orange</td>
								<td>5</td>
								<td>John</td>
								<td>Adams</td>
								<td>Marshall</td>
								<td>5</td>
								<td>John</td>
							</tr>
							<tr>
								<td>9</td>
								<td>Kelly</td>
								<td>Davidson</td>
								<td>Taylor</td>
								<td>5</td>
								<td>John</td>
								<td>Adams</td>
								<td>Marshall</td>
								<td>5</td>
								<td>John</td>
							</tr>
							<tr>
								<td>10</td>
								<td>Colleen</td>
								<td>Hurst</td>
								<td>Randolph</td>
								<td>5</td>
								<td>John</td>
								<td>Adams</td>
								<td>Marshall</td>
								<td>5</td>
								<td>John</td>
							</tr>
							<tr>
								<td>11</td>
								<td>Rhona</td>
								<td>Herrod</td>
								<td>Cumberland</td>
								<td>5</td>
								<td>John</td>
								<td>Adams</td>
								<td>Marshall</td>
								<td>5</td>
								<td>John</td>
							</tr>
							<tr>
								<td>12</td>
								<td>Jane</td>
								<td>Paul</td>
								<td>Marshall</td>
								<td>5</td>
								<td>John</td>
								<td>Adams</td>
								<td>Marshall</td>
								<td>5</td>
								<td>John</td>
							</tr>
							<tr>
								<td>13</td>
								<td>Ashton</td>
								<td>Fox</td>
								<td>Calhoun</td>
								<td>5</td>
								<td>John</td>
								<td>Adams</td>
								<td>Marshall</td>
								<td>5</td>
								<td>John</td>
							</tr>
							<tr>
								<td>14</td>
								<td>Garrett</td>
								<td>John</td>
								<td>Madison</td>
								<td>5</td>
								<td>John</td>
								<td>Adams</td>
								<td>Marshall</td>
								<td>5</td>
								<td>John</td>
							</tr>
							<tr>
								<td>15</td>
								<td>Fredie</td>
								<td>Winters</td>
								<td>Washington</td>
								<td>5</td>
								<td>John</td>
								<td>Adams</td>
								<td>Marshall</td>
								<td>5</td>
								<td>John</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<div>
				<s:submit action="back" value="Back" align="left" />
				<s:submit action="print" value="Print" />
				<s:submit action="previous" value="Previous Month" />
				<s:submit action="next" value="Next Month" />
			</div>
		</s:form>
	</div>
</body>
</html>