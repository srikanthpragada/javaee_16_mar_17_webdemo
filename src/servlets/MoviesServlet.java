package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/movies")
public class MoviesServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// find out city through cookie
		String city = null;

		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();

		Cookie[] cookies = request.getCookies();

		if (cookies != null) {
			for (Cookie c : request.getCookies()) {
				if (c.getName().equals("city")) {
					city = c.getValue();
					writer.write("<h2>List of Movies in city  " + city + "</h2>");
					writer.write("<a href='selectcity.html'>Change City </a>");
					return;
				}
			}
		}
		
		// city not found
		response.sendRedirect("selectcity.html");

	}

}
