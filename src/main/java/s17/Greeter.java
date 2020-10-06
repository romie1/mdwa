package s17;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.Duration;
import java.time.LocalTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/s17/greeter")
public class Greeter extends HttpServlet {
    private static final long serialVersionUID = 1L; //identifica in modo univoco la versione di Greeter
    private static final Logger LOG = LoggerFactory.getLogger(Greeter.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        LOG.trace("called");
        
        HttpSession session = request.getSession();
        //primo accesso start è null
        LocalTime start = (LocalTime) session.getAttribute("start");
       
//        Object o = session.getAttribute("start");
//        LocalTime start;
//        if (o instanceof LocalTime) {
//        	start = (LocalTime) o;
//        	
//        }else {
//        	LOG.error("!!!");
//        	return;
//        }
        
        Duration duration;
        if (start == null) {
            duration = Duration.ZERO;
            session.setAttribute("start", LocalTime.now());
        } else {
            duration = Duration.between(start, LocalTime.now());
        }
        
        //utente non mi ha passato parameter done
        if (request.getParameter("done") == null) {
            request.setAttribute("duration", duration);
            request.getRequestDispatcher("/s17/greeter.jsp").forward(request, response);
        } else {
        	//utente mi ha passato parameter done e quindi termino la session
            session.invalidate();

            response.setContentType("text/html");
            response.setCharacterEncoding("utf-8");
            try (PrintWriter writer = response.getWriter()) {
                writer.println("<!DOCTYPE html><html>");
                writer.println("<head><meta charset=\"utf-8\">");
                writer.println("<title>So long</title></head>");
                writer.println("<body><h1>Goodbye</h1>");
                writer.println("<p>You worked on this stuff for " + duration.getSeconds() + " seconds</p>");
                writer.println("</body></html>");
            }
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
