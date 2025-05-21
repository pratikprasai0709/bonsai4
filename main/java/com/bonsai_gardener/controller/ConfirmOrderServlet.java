package com.bonsai_gardener.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.time.LocalDate;

import com.bonsai_gardener.service.OrderService;

/**
 * Servlet implementation class ConfirmOrderServlet
 */
@WebServlet("/ConfirmOrder")
public class ConfirmOrderServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ConfirmOrderServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // ✅ Get the action type
    	String productId = request.getParameter("product_id");
        String productName = request.getParameter("product_name");
        String priceStr = request.getParameter("price");
        String image = request.getParameter("image"); // ✅ Right here
        String quantityStr = request.getParameter("quantity");

        // Validate inputs
        if (productId == null || productName == null || priceStr == null || image == null || quantityStr == null) {
            request.setAttribute("error", "Product information is missing.");
            request.getRequestDispatcher("WEB-INF/pages/ConfirmOrder.jsp").forward(request, response);
            return;
        }

        try {
            double price = Double.parseDouble(priceStr);
            int quantity = Integer.parseInt(quantityStr);
            double totalAmount = price * quantity;

            // Replace this with actual session-based user ID
            HttpSession session = request.getSession();
            Integer userId = (Integer) session.getAttribute("user_id");
            LocalDate orderDate = LocalDate.now();
            String status = "Pending";

            // Call service to insert
            OrderService orderService = new OrderService();
            boolean success = orderService.insertOrder(userId, orderDate, totalAmount, status);

            if (success) {
                //response.sendRedirect("orderSuccess.jsp");
                request.getRequestDispatcher("WEB-INF/pages/orderSuccess.jsp").forward(request, response);
            } else {
                request.setAttribute("error", "Failed to place order. Try again.");
                request.getRequestDispatcher("WEB-INF/pages/ConfirmOrder.jsp").forward(request, response);
            }

        } catch (NumberFormatException e) {
            request.setAttribute("error", "Invalid price or quantity.");
            request.getRequestDispatcher("WEB-INF/pages/ConfirmOrder.jsp").forward(request, response);
        }
    }
}