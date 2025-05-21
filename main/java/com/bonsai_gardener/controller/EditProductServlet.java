package com.bonsai_gardener.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.bonsai_gardener.model.ProductModel;
import com.bonsai_gardener.service.ProductService;

/**
 * Servlet implementation class EditProductServlet
 */
@WebServlet("/EditProductServlet")
public class EditProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int productId = Integer.parseInt(request.getParameter("productId"));
            String name = request.getParameter("productName");
            String description = request.getParameter("description");
            double price = Double.parseDouble(request.getParameter("price"));
            int stock = Integer.parseInt(request.getParameter("stock"));

            ProductModel product = new ProductModel();
            product.setProductId(productId);
            product.setName(name);
            product.setDescription(description);
            product.setPrice(price);
            product.setStock(stock);

            ProductService productService = new ProductService();
            boolean updated = productService.updateProduct(product);

            if (updated) {
            	request.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(request, response);
            } else {
                System.out.print("update failed");
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.print("Something went wrong");
            response.sendRedirect("admin-dashboard.jsp?edit=error");
        }
    }
}
