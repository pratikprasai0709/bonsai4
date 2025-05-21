package com.bonsai_gardener.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.bonsai_gardener.model.usermodell;
import com.bonsai_gardener.service.LoginService;
import com.bonsai_gardener.util.cookieutil;
import com.bonsai_gardener.util.sessionutil;

@WebServlet("/login")
public class login extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final LoginService loginService;

    public login() {
        super();
        this.loginService = new LoginService();
        System.out.println("LoginService initialized. isConnectionError = " + this.loginService.isConnectionError());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	System.out.println("LoginServlet doPost() triggered");
    	
        String errorMessage = null;

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        System.out.println("Submitted Username: " + username);
        System.out.println("Submitted Password: " + password);
        
        System.out.println("Calling loginService.getUserByUsernameAndPassword() for username: " + username);
        usermodell user = loginService.getUserByUsernameAndPassword(username, password);
        System.out.println("LoginService returned user: " + user);

        if (user != null) {
            System.out.println("Login: role_name = " + user.getrole_name());
            System.out.println("Login: username = " + user.getUsername());
            System.out.println("Login: role_name = " + user.getrole_name());
            
            HttpSession session = request.getSession(true);
            sessionutil.setAttribute(request, "user_id", user.getUser_id());
            sessionutil.setAttribute(request, "username", user.getUsername());
            sessionutil.setAttribute(request, "role_name", user.getrole_name());
            
            
            System.out.println("Session set: role_name = " + session.getAttribute("role_name"));
            System.out.println("Session set: username = " + session.getAttribute("username"));
            System.out.println("Session ID = " + session.getId());
            
            cookieutil.addCookie(response, "role_name", user.getrole_name(), 3600); // 1-hour cookie

            if ("admin".equalsIgnoreCase(user.getrole_name())) {
                response.sendRedirect(request.getContextPath() + "/admindashboard");
            } else {
                response.sendRedirect(request.getContextPath() + "/home");
            }

        } else {
            System.out.println("Login failed: user is null");
            handleLoginFailure(request, response);
        }
    }

    private void handleLoginFailure(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String errorMessage = "User credential mismatch. Please try again!";
        request.setAttribute("error", errorMessage);
        request.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(request, response);
    }
    
    

}
