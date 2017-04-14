package jsf;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.sql.RowSet;
import javax.sql.rowset.CachedRowSet;

import oracle.jdbc.rowset.OracleCachedRowSet;

@ManagedBean
public class EmployeesBean {

	private int empid;
	private boolean historyFound;
	private CachedRowSet history;

	public boolean isHistoryFound() {
		return historyFound;
	}

	public void setHistoryFound(boolean historyFound) {
		this.historyFound = historyFound;
	}

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		// System.out.println("Employee id : " + empid);
		this.empid = empid;
	}

	public CachedRowSet getHistory() {
		return history;
	}

	// Action controller
	public String getJobHistory() {
		try {
			CachedRowSet rs = new OracleCachedRowSet();
			rs.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
			rs.setUsername("hr");
			rs.setPassword("hr");
			rs.setCommand(
					"select to_char(start_date,'dd-mon-yyyy') start_date, to_char(end_date,'dd-mon-yyyy') end_date, job_title, department_name from job_history join jobs using (job_id) join departments using (department_id) where employee_id = ?");
			rs.setInt(1, empid);
			rs.execute();
			if (rs.next())
				historyFound = true;
			else
				historyFound = false;

			// System.out.println(historyFound);

			rs.beforeFirst();

			history = rs;
			return null;

		} catch (Exception ex) {
			System.out.println(ex);
			return null;
		}
	}

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
	 * // names property public List<String> getNames() { try { CachedRowSet rs
	 * = new OracleCachedRowSet(); ArrayList<String> names = new ArrayList<>();
	 * rs.setUrl("jdbc:oracle:thin:@localhost:1521:XE"); rs.setUsername("hr");
	 * rs.setPassword("hr"); rs.setCommand("select * from employees");
	 * rs.execute(); while( rs.next()) { names.add( rs.getString("first_name"));
	 * } return names; } catch (Exception ex) { System.out.println(ex); return
	 * null; } }
	 */

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
			while (rs.next()) {
				Employee e = new Employee();
				e.setId(rs.getInt("employee_id"));
				e.setSalary(rs.getInt("salary"));
				e.setName(rs.getString("first_name"));
				emps.add(e);
			}
			return emps;
		} catch (Exception ex) {
			System.out.println(ex);
			return null;
		}
	}

}
