package by.it_academy.jd2.web.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(displayName = "SecurityFilter")
public class SecurityFilter implements Filter {

    private FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    @Override
    public void destroy() {
        filterConfig = null;
    }

    @Override
    public void doFilter(ServletRequest sReq, ServletResponse sResp,
                         FilterChain filterChain) throws IOException, ServletException {
        if (filterConfig.getInitParameter("active").equalsIgnoreCase("true")) {
            HttpServletRequest req = (HttpServletRequest) sReq;
            HttpServletResponse resp = (HttpServletResponse) sResp;
            HttpSession session = req.getSession();
            if (session != null && session.getAttribute("user") != null) {
                filterChain.doFilter(sReq, sResp);
            } else {
                resp.sendRedirect(req.getContextPath() + "/signIn");
            }
        } else {
            filterChain.doFilter(sReq, sResp);
        }
    }
}
