package com.bonsai_gardener.controller;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import jakarta.servlet.http.HttpSession;


import com.bonsai_gardener.model.usermodell;
import com.bonsai_gardener.service.UpdateProfileService;

/**
 * Servlet implementation class UpdateProfileServlet
 */
@WebServlet("/UpdateProfileServlet")
public class UpdateProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher("WEB-INF/pages/editProfile.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	HttpSession session = request.getSession(false);
    if (session == null || session.getAttribute("user_id") == null) {
    	request.getRequestDispatcher("WEB-INF/pages/register.jsp").forward(request, response);  // Redirect to login if session doesn't exist
        return;
    }
    
 // Get user ID from session
    int userId = (Integer) session.getAttribute("user_id");

    // Get the updated user details from the form
    String username = request.getParameter("username");
    String email = request.getParameter("email");
    String password = request.getParameter("password");
    String location = request.getParameter("Location");
    String phone = request.getParameter("Phone");

    // Create usermodell object
    usermodell user = new usermodell(userId, username, password, email, 1, null, location, phone);
    
    // Update user details in the database
    UpdateProfileService updateService = new UpdateProfileService();
    Boolean updateSuccess = updateService.updateUserInfo(user);
    
 // If update was successful, redirect to the user profile page
    if (updateSuccess != null && updateSuccess) {
        session.setAttribute("user", user);  // Update session with the new user details
        request.getRequestDispatcher("WEB-INF/pages/userprofile.jsp").forward(request, response);  // Redirect to the profile page
    } else {
        // If there was an error, set an error message and forward to the edit profile page
        request.setAttribute("errorMessage", "There was an error updating your profile. Please try again.");
        request.getRequestDispatcher("WEB-INF/pages/editProfile.jsp").forward(request, response);
    }
    
		
	}

}
