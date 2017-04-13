package jsf;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.sql.RowSet;
import javax.sql.rowset.CachedRowSet;

import oracle.jdbc.rowset.OracleCachedRowSet;

@ManagedBean
public class EmployeesBean {

	// employees property
	public RowSet getEmployees() {
		try {
			CachedRowSet rs = new OracleCachedRowSet();
			rs.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
			rs.setUsername("hr");
			rs.setPassword("hr");
			rs.setCommand("select * from employees");
			rs.execute();
			return rs;
		} catch (Exception ex) {
			System.out.println(ex);
			return null;
		}
	}
/*
	// names property
	public List<String> getNames() {
		try {
			CachedRowSet rs = new OracleCachedRowSet();
			ArrayList<String> names = new ArrayList<>();
			rs.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
			rs.setUsername("hr");
			rs.setPassword("hr");
			rs.setCommand("select * from employees");
			rs.execute();
			while( rs.next())
			{
				names.add( rs.getString("first_name"));
			}
			return names;
		} catch (Exception ex) {
			System.out.println(ex);
			return null;
		}
	}

	
	// names property
		public List<Employee> getAllEmployees() {
			try {
				CachedRowSet rs = new OracleCachedRowSet();
				ArrayList<Employee> emps = new ArrayList<>();
				rs.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
				rs.setUsername("hr");
				rs.setPassword("hr");
				rs.setCommand("select * from employees");
				rs.execute();
				while( rs.next())
				{
					Employee e = new Employee();
					e.setId( rs.getInt("employee_id"));
					e.setSalary( rs.getInt("salary"));
					e.setName ( rs.getString("first_name"));
					emps.add(e);
				}
				return emps;
			} catch (Exception ex) {
				System.out.println(ex);
				return null;
			}
		}
		
		*/

}
