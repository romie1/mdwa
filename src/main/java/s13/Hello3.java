package s13;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/s13/hello3")
public class Hello3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");

		List<String> colors = Arrays.asList("blue", "yellow", "orange", "green", "black", "red", "purple");

		if (firstName.contentEquals("Romielyn") && lastName.contentEquals("Casio")) {
			request.setAttribute("registered", true);
			request.setAttribute("colors", colors);
		} else {
			request.setAttribute("registered", false);
		}

		request.getRequestDispatcher("/s13/hello3.jsp").forward(request, response);
	}
}
