<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import="java.sql.*" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Salary</title>
</head>
<body>

	<h2>Update Salary</h2>

	<form action="updateSalary3.jsp" method="get">
		Employee ID <br /> <input type="number" name="id" value="${param.id}"
			required="required" />
		<p />
		New Salary <br /> <input type="number" name="salary"
			value="${param.salary}" required="required" />
		<p />
		<input type="submit" value="Update Salary" />
	</form>


	<jsp:useBean class="beans.EmployeeBean" id="empBean" scope="page" />
	<jsp:setProperty property="*" name="empBean" />
	
	<%
		empBean.update();
	%>

	<h3>${empBean.message}</h3>


</body>
</html>