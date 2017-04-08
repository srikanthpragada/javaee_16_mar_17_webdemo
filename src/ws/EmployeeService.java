package ws;


import java.util.ArrayList;
import javax.jws.*;
import javax.sql.rowset.CachedRowSet;
import oracle.jdbc.rowset.OracleCachedRowSet;

@WebService(serviceName = "EmployeeService")
public class EmployeeService {
	@WebMethod
	public ArrayList<Employee> getEmployees() {
		try (CachedRowSet rs = new OracleCachedRowSet()) {
			rs.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
			rs.setUsername("hr");
			rs.setPassword("hr");
			rs.setCommand("select * from employees");
			rs.execute();
			ArrayList<Employee> el = new ArrayList<>();
			while (rs.next()) {
				Employee e = new Employee();
				e.setId(rs.getString("employee_id"));
				e.setName(rs.getString("first_name"));
				e.setSalary(rs.getDouble("salary"));
				el.add(e);
			}
			return el;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}

	@WebMethod
	public Employee getDetails(@WebParam(name = "empid") String empid) {
		try (CachedRowSet rs = new OracleCachedRowSet()) {
			rs.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
			rs.setUsername("hr");
			rs.setPassword("hr");
			rs.setCommand("select * from employees	 where employee_id=?");

			rs.setString(1, empid);
			rs.execute();

			if (rs.next()) {
				Employee e = new Employee();
				e.setId(rs.getString("employee_id"));
				e.setName(rs.getString("first_name"));
				e.setSalary(rs.getDouble("salary"));
				return e;
			} else {
				return null;
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}
}
