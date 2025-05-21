package com.bonsai_gardener.controller;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import jakarta.servlet.http.HttpSession;

import com.bonsai_gardener.model.usermodell;
import com.bonsai_gardener.service.UserProfileService;
import com.bonsai_gardener.util.sessionutil;

/**
 * Servlet implementation class userprofile
 */
@WebServlet("/userprofile")
public class userprofile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userprofile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		HttpSession session = request.getSession(false); // don't create new session
		System.out.println("Session user_id: " + session.getAttribute("user_id"));
		
		
	    if (session == null || session.getAttribute("user_id") == null) {
	        // User not logged in
	    	request.getRequestDispatcher("WEB-INF/pages/register.jsp").forward(request, response); // or error.jsp
	        return;
	    }

	    // If user is logged in
	    int user_id = (Integer) session.getAttribute("user_id");

	    usermodell user = UserProfileService.getUserById(user_id);

	    if (user != null) {
	        request.setAttribute("user", user);
	        request.getRequestDispatcher("WEB-INF/pages/userprofile.jsp").forward(request, response);
	    } else {
	        response.sendRedirect("error.jsp");
	    }
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
