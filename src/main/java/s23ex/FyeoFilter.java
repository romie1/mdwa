package s23ex;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import s23.FilterRestricted;

@WebFilter(urlPatterns = {"/s23ex/fyeo", "/s23/fyeo.jsp"})
public class FyeoFilter implements Filter {
	 private static final Logger LOG = LoggerFactory.getLogger(FilterRestricted.class);
	 
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		LOG.info("access to filter");
		if(request instanceof HttpServletRequest) {
			boolean registered = false;
			try {
				HttpSession session = ((HttpServletRequest) request).getSession();
				Boolean attribute = (Boolean) session.getAttribute("registered"); 
                if (attribute != null && attribute == true) {
                    registered = true;
                }

                session.setAttribute("registered", false);
			}catch(Exception e) {
				LOG.warn(e.getMessage());
			}
			
			 if (!registered) {
				 request.getRequestDispatcher("/s23/login.jsp").forward(request, response);
				 return;
			 }
		}else {
			request.getRequestDispatcher("/s23/login.jsp").forward(request, response);;
	        	return;
		}
		
		
		chain.doFilter(request, response);
	}

}
