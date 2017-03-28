package beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class EmployeeBean {

	private int id, salary;
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public void update() {
		
		if (id == 0 || salary == 0)
			return;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			try (Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr")) {
				PreparedStatement ps = con.prepareStatement("update employees set salary = ? where employee_id = ?");
				ps.setInt(1, salary);
				ps.setInt(2, id);

				int count = ps.executeUpdate();

				if (count == 1)
					message = "Updated Successfully!";
				else
					message = "Employee Id Not Found!";
				ps.close();
			} catch (Exception ex) {
				message = ex.getMessage();
			}
		} catch (Exception ex) {
			message = ex.getMessage();
		}
	}

}
