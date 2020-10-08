package s23ex;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import s23.FilterRestricted;

/*
 SQL
     Table Services
     service_id INT service_name VARCHAR(30)
        33434      dentista
 JAVA
     JavaBean Service
         int id
         String name
     
     ServiceDAO
         getAll()
         
     ServiceReservationSvl
         DAO.getAll()
         
         serviceReservation.jsp HTML
     
     ServiceFilter su ServiceReservationSvl
         loggato OK
         altrimenti -> login
         
 	
 
 */

/**
 * Servlet implementation class Registration
 */
@WebServlet("/s23ex/registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private static final Logger LOG = LoggerFactory.getLogger(FilterRestricted.class);
	 
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String firstName = request.getParameter("firstName");
	     String lastName = request.getParameter("lastName"); 
	    
	     LOG.info("First name registered: " + firstName + " - Last name registered " + lastName);
	     
	     if ("Romielyn".contentEquals(firstName) && "Casio".contentEquals(lastName)) {
	            request.getSession().setAttribute("registered", true);
	            request.getRequestDispatcher("/s23ex/fyeo").forward(request, response);
	        } else {
	            request.getSession().setAttribute("registered", false);
	            request.getRequestDispatcher("login.html").forward(request, response);
	       }
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
