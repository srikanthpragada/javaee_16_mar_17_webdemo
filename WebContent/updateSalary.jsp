<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import="java.sql.*" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Salary</title>
</head>
<body>
	<h2>
		<%
			String id = request.getParameter("empid");
			String salary = request.getParameter("salary");

			// connect to oracle 
			Class.forName("oracle.jdbc.driver.OracleDriver");
			try (Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr")) {
				PreparedStatement ps = con.prepareStatement("update employees set salary = ? where employee_id = ?");
				ps.setString(1, salary);
				ps.setString(2, id);

				int count = ps.executeUpdate();

				if (count == 1)
					out.println("Updated Successfully!");
				else
					out.println("Employee Id Not Found!");
				ps.close();
			} catch (Exception ex) {
				out.println(ex.getMessage());
			}
		%>
	</h2>
</body>
</html>