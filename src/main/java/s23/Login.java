package s23;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/s23/login")
public class Login extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger LOG = LoggerFactory.getLogger(Login.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String user = request.getParameter("user");
        String password = request.getParameter("password");

        LOG.trace("user is " + user);

        // don't do that! any password should be encrypted and stored in a safe place!
        if ("superuser".equals(user) && "fido".equals(password)) {
            request.getSession().setAttribute("logged", true);
            request.getRequestDispatcher("/index.html").forward(request, response);
        } else {
            request.getSession().setAttribute("logged", false);
            request.getRequestDispatcher("login.html").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
