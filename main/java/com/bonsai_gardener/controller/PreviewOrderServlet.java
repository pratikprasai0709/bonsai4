package com.bonsai_gardener.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class PreviewOrderServlet
 */
@WebServlet("/PreviewOrder")
public class PreviewOrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String productId = request.getParameter("product_id");
        String productName = request.getParameter("product_name");
        String price = request.getParameter("price");
        String image = request.getParameter("image");

        // Validate
        if (productId == null || productName == null || price == null || image == null) {
            response.sendRedirect("product.jsp");
            return;
        }

        // Set to request scope
        request.setAttribute("product_id", productId);
        request.setAttribute("product_name", productName);
        request.setAttribute("price", price);
        request.setAttribute("image", image);

        // Forward to confirmation page
        request.getRequestDispatcher("WEB-INF/pages/ConfirmOrder.jsp").forward(request, response);
    }
}

