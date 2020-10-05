package s23;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebFilter(urlPatterns = { "/s23/restricted/*" })
public class FilterRestricted implements Filter {
    private static final Logger LOG = LoggerFactory.getLogger(FilterRestricted.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        if (request instanceof HttpServletRequest) {
            boolean logged = false;
            try {
                HttpSession session = ((HttpServletRequest) request).getSession();
                Boolean attribute = (Boolean) session.getAttribute("logged");
                if (attribute != null && attribute == true) {
                    logged = true;
                }

                session.setAttribute("logged", false);
            } catch (Exception ex) {
                LOG.warn(ex.getMessage());
            }

            LOG.trace("Access to restricted area is " + logged);
            if (!logged) {
                // new request, the URL is _not_ relative to the current web app
                ((HttpServletResponse) response).sendRedirect("/mdwa/s23/login.html");

                // use this to keep the original request
//                request.getRequestDispatcher("/s23/login.html").forward(request, response);

                // in both case, remember to end here the filtering
                return;
            }
        }

        chain.doFilter(request, response);
    }
}
