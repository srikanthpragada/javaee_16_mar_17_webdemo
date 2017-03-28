<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h2>List of Departments</h2>
	<%
		javax.sql.rowset.CachedRowSet rs = new oracle.jdbc.rowset.OracleCachedRowSet();
		rs.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		rs.setUsername("hr");
		rs.setPassword("hr");
		rs.setCommand("select * from departments");
		rs.execute();
	%>
	<table border="1" cellpadding="5">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th></th>
		</tr>
		<%	
			while (rs.next()) {
		%>
		
		<tr>
			<td><%=rs.getString(1)%></td>
			<td><%=rs.getString(2)%></td>
			<td><a href="employees.jsp?dept=<%=rs.getString(1)%>">Employees</a></td>
		</tr>
		<%
			} // end of while
			rs.close();
		%>
	</table>

</body>
</html>