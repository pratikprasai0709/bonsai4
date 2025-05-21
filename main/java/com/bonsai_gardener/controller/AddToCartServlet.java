package com.bonsai_gardener.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.bonsai_gardener.service.CartService;

/**
 * Servlet implementation class AddToCartServlet
 */
@WebServlet("/AddToCart")
public class AddToCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	System.out.println("AddToCartServlet triggered");

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user_id") == null) {
        	request.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(request, response);
        	return;
        }

        int userId = (int) session.getAttribute("user_id");
        int productId = Integer.parseInt(request.getParameter("product_id"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        CartService cartService = new CartService();
        boolean success = cartService.addProductToCart(userId, productId, quantity);

        if (success) {
        	response.sendRedirect("viewCart");
        } else {
            request.setAttribute("error", "Failed to add product to cart.");
            request.getRequestDispatcher("/product").forward(request, response);
        }
    }
    
    
}
