package servlets;

import java.io.FileReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NamesServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String filename = this.getServletConfig().getInitParameter("filename");
		String file = this.getServletContext().getRealPath(filename); // Physical path
		

		try {
			FileReader fr = new FileReader(file);

		} catch (Exception ex) {
			System.out.println(ex);
		}

	}

}
