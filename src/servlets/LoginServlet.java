package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		
		String uname  = request.getParameter("uname");
		String pwd  = request.getParameter("pwd");
		
		if (uname == null)
		{
			pw.write("<h1>Username is missing!</h1>");
			return;
		}
		
		if (pwd == null)
		{
			pw.write("<h1>Password is missing!</h1>");
			return;
		}
		
		
		if (uname.equals("admin") && pwd.equals("test"))
			pw.write("<h1>Logged In Successfully!</h1>");
		else
			pw.write("<h1>Invalid Login!</h1>");

	}

}
