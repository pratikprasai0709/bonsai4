//package com.bonsai_gardener.filter;
//
//import java.io.IOException;
//
//import com.bonsai_gardener.util.cookieutil;
//import com.bonsai_gardener.util.sessionutil;
//
//import jakarta.servlet.Filter;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.FilterConfig;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.ServletRequest;
//import jakarta.servlet.ServletResponse;
//import jakarta.servlet.annotation.WebFilter;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//@WebFilter(asyncSupported = true, urlPatterns = "/*")
//public class AuthenticationFilter implements Filter {
//
//    private static final String LOGIN = "/register";
//    private static final String REGISTER = "/register";
//    private static final String HOME = "/home";
//    private static final String ROOT = "/";
//    private static final String DASHBOARD = "/admindashboard";
//    private static final String ABOUT_US = "/AboutUs";
//    private static final String EDIT_PROFILE = "/editProfile";
//    private static final String ORDER_CONFIRMATION_PAGE = "/Orderpageconfirmation";
//    private static final String ABOUT = "/AboutUs";
//    private static final String PRODUCT = "/product";
//    private static final String CONTACTUS = "/contactus";
//    private static final String USERPROFILE = "/userprofile";
//    private static final String CART_LIST = "/cartlist";
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        // No initialization needed
//    }
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//            throws IOException, ServletException {
//
//        HttpServletRequest req = (HttpServletRequest) request;
//        HttpServletResponse res = (HttpServletResponse) response;
//        String uri = req.getRequestURI();
//
//        // Allow public access to static resources
//        if (uri.endsWith(".png") || uri.endsWith(".jpg") || uri.endsWith(".css") || uri.endsWith("/login")) {
//            chain.doFilter(request, response);
//            return;
//        }
//
//        // Check login status via session only
//        String roleFromSession = (String) sessionutil.getAttribute(req, "role_name");
//        System.out.println("Filter: role_name from session = " + roleFromSession);
//        boolean isLoggedIn = roleFromSession != null;
//        
//
//        if (isLoggedIn && "admin".equals(roleFromSession)) {
//            if (uri.endsWith(REGISTER)) {
//                res.sendRedirect(req.getContextPath() + DASHBOARD);
//            } else if (uri.endsWith(DASHBOARD) || uri.endsWith(HOME) || uri.endsWith(ROOT)) {
//                chain.doFilter(request, response);
//            } else {
//                res.sendRedirect(req.getContextPath() + DASHBOARD);
//            }
//
//        } else if (isLoggedIn && "customer".equals(roleFromSession)) {
//            if (uri.endsWith(LOGIN) || uri.endsWith(REGISTER)) {
//                res.sendRedirect(req.getContextPath() + HOME);
//            } else if (uri.endsWith(HOME) || uri.endsWith(ROOT) || uri.endsWith(ABOUT) || uri.endsWith(CONTACTUS)
//                    || uri.endsWith(EDIT_PROFILE) || uri.endsWith(USERPROFILE) || uri.endsWith(PRODUCT)) {
//                chain.doFilter(request, response);
//            } else if (uri.endsWith(DASHBOARD)) {
//            	
//                res.sendRedirect(req.getContextPath() + HOME);
//                
//            } 
//            else if (uri.contains(DASHBOARD)) {
//                // Set a session or request-level error message
//                sessionutil.setAttribute(req, "errorMessage", "Access denied: Admins only.");
//                res.sendRedirect(req.getContextPath() + HOME);
//                System.out.println("customer cannot access this page!");
//            }
//            else {
//                res.sendRedirect(req.getContextPath() + HOME);
//            }
//
//        } else {
//            // Not logged in
//            if (uri.endsWith(LOGIN) || uri.endsWith(REGISTER) || uri.endsWith(HOME) || uri.endsWith(ROOT)
//                    || uri.endsWith(PRODUCT)) {
//                chain.doFilter(request, response);
//            } 
//            else {
//                res.sendRedirect(req.getContextPath() + HOME);
//                System.out.println("User is not logged in!");
//            }
//        }
//    }
//
//    @Override
//    public void destroy() {
//        // No cleanup needed
//    }
//}
