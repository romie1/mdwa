package s13;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/s13/hello")
public class Hello extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");

		String url;

		if (firstName.contentEquals("Romielyn") & lastName.contentEquals("Casio")) {
			url = "/s13/hello.jsp";
		} else {
			url = "/s13/unknown2.jsp";
		}

		request.getRequestDispatcher(url).forward(request, response);
	}
}
