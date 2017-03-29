package tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import oracle.jdbc.rowset.OracleCachedRowSet;

public class Jobs2Handler  extends SimpleTagSupport {
    private int minsal, maxsal;
    
    // it represents minsal attribute 
	public void setMinsal(int minsal) {
		this.minsal = minsal;
	}
	
	// it represents maxsal attribute 
	public void setMaxsal(int maxsal) {
		this.maxsal = maxsal;
	}


	@Override
	public void doTag() throws JspException, IOException {
		
		JspWriter out = getJspContext().getOut();
		
		out.println("<h3>List Of Jobs</h3>");
		out.println("<table border='1'><tr><th>Title</th><th>Min Salary </th></tr>");
		try {
			OracleCachedRowSet crs = new OracleCachedRowSet();
			crs.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
			crs.setUsername("hr");
			crs.setPassword("hr");
			crs.setCommand("select * from jobs where min_salary >= ? and max_salary <= ?");
			crs.setInt(1, minsal);
			crs.setInt(2, maxsal);
			crs.execute();

			while (crs.next()) {
				out.println("<tr><td>" + crs.getString("job_title") + "</td><td>" +
			                 crs.getString("min_salary") + "</td></tr>");
			}

			out.println("</table>");
			crs.close();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		 
	}
	
	

}
