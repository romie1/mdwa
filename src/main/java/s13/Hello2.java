package s13;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/s13/hello2")
public class Hello2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		
		if (firstName.contentEquals("Romielyn") && lastName.contentEquals("Casio")) {
			request.setAttribute("registered", true);	
		} else {
			request.setAttribute("registered", false);	
		}
			

		request.getRequestDispatcher("/s13/hello2.jsp").forward(request, response);
	}
}
