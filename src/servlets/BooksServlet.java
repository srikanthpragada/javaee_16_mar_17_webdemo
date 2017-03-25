package servlets;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/books")
public class BooksServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String title = request.getParameter("title");
		
		// add title to books collection in session
		HttpSession session  = request.getSession();
		ArrayList<String> books  = (ArrayList<String>) session.getAttribute("books");
		
		if (books == null)
		{
			books = new ArrayList<String>();
			session.setAttribute("books",books);
		}
		
		books.add(title);
		
		// display all books
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		pw.write("<h2>Books </h2>");
		
		for(String book : books)
			pw.write( book + "<p/>");
		
		
		
		
	}

}
