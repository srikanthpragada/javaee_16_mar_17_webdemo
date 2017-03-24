package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/selectCity")
public class SelectCityServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  String city = request.getParameter("city");
		  
		  Cookie c = new Cookie("city", city);
		  c.setMaxAge(  24 * 60 * 60);
		  
		  response.addCookie(c);
		  response.getWriter().println("Saved City");
	  
	}

}
