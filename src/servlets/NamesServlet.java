package servlets;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NamesServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String filename = this.getServletConfig().getInitParameter("filename");
		String pfile = this.getServletContext().getRealPath(filename); // Physical path
		
        Path  path = Paths.get(pfile);
        StringBuffer output = new StringBuffer("<ul>");
		try {
			Files.lines(path).forEach( line ->  output.append("<li>" + line + "</li>"));
			
			output.append("</ul>");
			response.setContentType("text/html");
			response.getWriter().write(output.toString());
		} catch (Exception ex) {
			System.out.println(ex);
		}

	}

}
