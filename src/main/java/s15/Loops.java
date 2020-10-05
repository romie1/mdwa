package s15;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dd.User;

/**
 * Servlet implementation class ListUsers
 */
@WebServlet("/s15/loops")
public class Loops extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger LOG = LoggerFactory.getLogger(Loops.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        LOG.trace("called");

        User[] users = new User[] { new User("Alpha", 1), new User("Beta", 2), new User("Gamma", 3) };
        request.setAttribute("users", users);

        Double[] values = new Double[12]; // ...
        for (int i = 0; i < values.length; i++) {
            values[i] = Math.random();
        }
        request.setAttribute("values", values);

        String names = "bob,tom,bill";
        request.setAttribute("names", names);

        request.getRequestDispatcher("/s15/loops.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
