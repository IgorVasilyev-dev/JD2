package by.it_academy.jd2.controller.web.filters;

public class SecurityFilter {

//    private FilterConfig filterConfig;
//
//    @Override
//    public void init(FilterConfig filterConfig) {
//        this.filterConfig = filterConfig;
//    }
//
//    @Override
//    public void destroy() {
//        filterConfig = null;
//    }
//
//    @Override
//    public void doFilter(ServletRequest sReq, ServletResponse sResp,
//                         FilterChain filterChain) throws IOException, ServletException {
//        if (filterConfig.getInitParameter("active").equalsIgnoreCase("true")) {
//            HttpServletRequest req = (HttpServletRequest) sReq;
//            HttpServletResponse resp = (HttpServletResponse) sResp;
//            HttpSession session = req.getSession();
//            if (session != null && session.getAttribute("user") != null) {
//                filterChain.doFilter(sReq, sResp);
//            } else {
//                resp.sendRedirect(req.getContextPath() + "/signIn");
//            }
//        } else {
//            filterChain.doFilter(sReq, sResp);
//        }
//    }
}
