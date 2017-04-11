package rest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.rowset.CachedRowSet;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.google.gson.Gson;

import oracle.jdbc.rowset.OracleCachedRowSet;

@Path("/jobs")
public class JobsService {

	@GET
	@Produces("application/json")
	public String getJobs() {

		try (CachedRowSet rs = new OracleCachedRowSet()) {
			rs.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
			rs.setUsername("hr");
			rs.setPassword("hr");
			rs.setCommand("select * from jobs");
			rs.execute();
			ArrayList<Job> jobs = new ArrayList<>();
			while (rs.next()) {
				Job j = new Job(rs.getString("job_title"), rs.getInt("min_salary"));
				jobs.add(j);
			}
			Gson gson = new Gson();
			return gson.toJson(jobs);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}

	@GET
	@Path("{id}")
	@Produces("application/json")
	public String getJob(@PathParam("id") String id) {
		try (CachedRowSet rs = new OracleCachedRowSet()) {
			rs.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
			rs.setUsername("hr");
			rs.setPassword("hr");
			rs.setCommand("select * from jobs where job_id = ?");
			rs.setString(1, id);
			rs.execute();

			if (rs.next()) {
				Gson gson = new Gson();
				Job job = new Job(rs.getString("job_title"), rs.getInt("min_salary"));
				return gson.toJson(job);
			} else {
				throw new NotFoundException();
			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}

	@DELETE
	@Path("{id}")
	public void deleteJob(@PathParam("id") String id) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr");
			PreparedStatement ps = con.prepareStatement("delete from jobs where job_id = ?");
			ps.setString(1, id);

			int count = ps.executeUpdate();
			if (count != 1)
				throw new NotFoundException();

		} catch (SQLException | ClassNotFoundException ex) {
			System.out.println(ex.getMessage());
			throw new InternalServerErrorException(ex.getMessage());

		} // catch

	} // deleteJob

}
