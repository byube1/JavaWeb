package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;

import sun.rmi.server.Dispatcher;

/**
 * Servlet Filter implementation class filterLogin
 */
@WebFilter("/*")
public class filterLogin implements Filter {

    /**
     * Default constructor. 
     */
    public filterLogin() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		
		HttpServletRequest rq = (HttpServletRequest) request;
		HttpSession session =  rq.getSession();
		String fullname = (String) session.getAttribute("user");
		session.setMaxInactiveInterval(15);
		String user = request.getParameter("UserID");
		System.out.println(session.getMaxInactiveInterval());
		System.out.println(fullname);
		
		if(fullname == null && user == null) {
			RequestDispatcher dp = request.getRequestDispatcher("index.jsp");
			dp.forward(request, response);
		}
		else {
			chain.doFilter(request, response);		
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
