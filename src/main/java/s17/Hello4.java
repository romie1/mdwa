package s17;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * ESERCIZIO DA FINIRE
 * Esercizio4: aggiungere session e scrivere se è loggato o no. 
	se riconosce nome utente, mettere session e booleano a true. se nella session è già registered, non devo fare controllo. attributo registered e  
	vai nella jsp nella session, si controlla se c'è attributo registered. cif sull'attributo della sessione, se c'è dici che è già registrat, 
	se non c'è ti fa registrare <- nel hello.html diventa jsp per uscire, pulsante per logout
 * @author romie
 *
 */
@WebServlet("/s17/hello4")
public class Hello4 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		
		HttpSession session = request.getSession();
		Boolean alreadyRegistered = (Boolean) session.getAttribute("alreadyRegistered");
		
		if(alreadyRegistered != null && alreadyRegistered == false && "Romielyn".contentEquals(firstName) && "Casio".contentEquals(lastName)) {
			session.setAttribute("alreadyRegistered", false);
			session.setAttribute("firstName", firstName);
			session.setAttribute("lastName", lastName);
			
			request.getRequestDispatcher("/s17/hello4.jsp").forward(request, response);
		}else {
			session = request.getSession(true);
			session.setAttribute("alreadyRegistered", true);
			request.getRequestDispatcher("/s17/hello4.jsp").forward(request, response);
		}
		
	}
}
