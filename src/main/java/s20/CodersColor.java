package s20;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet implementation class CodersColor
 */
@WebServlet("/s20/codersColor")
public class CodersColor extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOG = LoggerFactory.getLogger(CodersSrv.class);
	
	@Resource(name = "jdbc/me")
	private DataSource ds;
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOG.trace("called");
		String color =  request.getParameter("color");
        try (CoderDao dao = new CoderDao(ds)) {
            request.setAttribute("codersColor", dao.getAllByColorLambda(color));
            request.getRequestDispatcher("/s20/codersColor.jsp").forward(request, response);
        }
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
