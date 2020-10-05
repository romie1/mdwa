package s10;

import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/s10/checker")
public class Checker extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger LOG = LoggerFactory.getLogger(Checker.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	//nella request c'è parametro user e salvalo nella variabile user
    	//parametri arrivano dall'esterno
        String user = request.getParameter("user");
        LOG.debug("called for user [" + user + "]");
        //loop sui caratteri di user e li butto dentro il set. se ci sono duplicati, prendo solo uno ed essendo un treeset, si ordina automaticamente
        //String non è iterabile, quindi devo fare user.toCharArray()
        Set<Character> set = new TreeSet<>();
        if (user != null) {
            for (char c : user.toCharArray()) {
                set.add(Character.toLowerCase(c));
            }
        }
        //attributi servono a me per lavorare nel controller
        //nella request ci sono gli attributi (hashtable) chiave stringa e valore arbitrario.
        request.setAttribute("set", set);

        RequestDispatcher rd = request.getRequestDispatcher("/s10/checker.jsp");
        rd.forward(request, response);

        // same as above, in a compact way
        // request.getRequestDispatcher("/s10/checker.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
