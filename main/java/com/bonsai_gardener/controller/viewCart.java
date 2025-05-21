package com.bonsai_gardener.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import com.bonsai_gardener.model.CartItem;
import com.bonsai_gardener.service.CartService;

/**
 * Servlet implementation class viewCart
 */
@WebServlet("/viewCart")
public class viewCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user_id") == null) {
            response.sendRedirect("register.jsp");
            return;
        }

        int userId = (int) session.getAttribute("user_id");
        System.out.println("ViewCartServlet user_id = " + userId); // ✅ Add this

        try {
            CartService cartService = new CartService();
            List<CartItem> cartItems = cartService.getCartItems(userId);
            System.out.println("Fetched cart items: " + cartItems.size()); // ✅ Log size
            request.setAttribute("cartItems", cartItems);
            request.getRequestDispatcher("/WEB-INF/pages/viewCart.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
