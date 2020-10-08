package s23ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import s23.restricted.RestrictedHello;

/**
 * Servlet implementation class Fyeo
 */
@WebServlet("/s23ex/fyeo")
public class Fyeo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private static final Logger LOG = LoggerFactory.getLogger(RestrictedHello.class);
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOG.info("enter Fyeo Servlet");
		
		HttpSession session = request.getSession();
		Boolean registered = (Boolean) session.getAttribute("registered");
		
		LOG.info("registered "+ registered.toString());
		
		if( registered == true) {
			request.getRequestDispatcher("/s23/fyeo.jsp").forward(request, response);
		}
		
		String logout = request.getParameter("logout");
		
		if(logout.contentEquals("true")) {
			session.invalidate();
			request.getRequestDispatcher("/s23/logout.jsp").forward(request, response);
		}
		
//		if(registered == false){
//		session.invalidate();
//		request.getRequestDispatcher("/s23/logout.jsp").forward(request, response);
//		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
