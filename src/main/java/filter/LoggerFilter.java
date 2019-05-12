package filter;

import javax.servlet.*;
import java.io.IOException;

public class LoggerFilter implements Filter {
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("log: a request is coming");
        System.out.println(servletRequest.getRemoteHost());
        filterChain.doFilter(servletRequest, servletResponse);
    }

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void destroy() {

    }
}
