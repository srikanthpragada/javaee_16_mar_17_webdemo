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

	<form action="updateSalary2.jsp" method="get">
		Employee ID <br /> <input type="number" name="empid" value="${param.empid}"
			required="required" />
		<p />
		New Salary <br /> <input type="number" name="salary" value="${param.salary}"
			required="required" />
		<p />
		<input type="submit" value="Update Salary" />
	</form> 
	
	<h3>
		<%
			String id = request.getParameter("empid");
		
		    if (id == null)  // direct request or first request 
		         return;
		    
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
	</h3>
</body>
</html>