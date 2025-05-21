package com.bonsai_gardener.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;

import com.bonsai_gardener.model.ProductModel;
import com.bonsai_gardener.service.ProductService;
import com.bonsai_gardener.util.ImageUtil;

/**
 * Servlet implementation class addproduct
 */
@WebServlet("/addproduct")

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
maxFileSize = 1024 * 1024 * 10,      // 10MB
maxRequestSize = 1024 * 1024 * 50)   // 50MB


public class addproduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addproduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    try {
	    	System.out.println("Starting product upload...");
	        // Step 1: Extract form fields
	        String name = request.getParameter("name");
	        String description = request.getParameter("description");
	        double price = Double.parseDouble(request.getParameter("price"));
	        int quantity = Integer.parseInt(request.getParameter("quantity"));
	        int isFeatured = Integer.parseInt(request.getParameter("is_featured"));
	        int isLatest = Integer.parseInt(request.getParameter("is_latest"));
	        Part imagePart = request.getPart("image");
	        
	        System.out.println("✅ Form data received");

	        // Step 2: Upload image
	        ImageUtil imageUtil = new ImageUtil();
	        String imageFileName = imageUtil.uploadImage(imagePart, "products", request);

	        // Step 3: Check if upload was successful
	        if (imageFileName == null) {
	            request.setAttribute("error", "Image upload failed.");
	            request.getRequestDispatcher("/WEB-INF/pages/admin-error.jsp").forward(request, response);
	            return;
	        }
	        
	        System.out.println("Image uploaded as: " + imageFileName);

	        // Step 4: Prepare product model
	        ProductModel product = new ProductModel();
	        product.setName(name);
	        product.setDescription(description);
	        product.setPrice(price);
	        product.setStock(quantity);
	        product.setImage(imageFileName); // Save image name to DB
	        product.setFeatured(isFeatured == 1);
	        product.setLatest(isLatest == 1);

	        // Step 5: Save to DB
	        ProductService productService = new ProductService();
	        boolean success = productService.addProduct(product);

	        if (success) {
	        	System.out.println(" Product added to database");
	            response.sendRedirect("adminDashboard.jsp"); // redirect on success
	        } else {
	        	System.out.println("❌ Failed to insert product in DB");
	            request.setAttribute("error", "Failed to add product to database.");
	            request.getRequestDispatcher("/WEB-INF/pages/admin-error.jsp").forward(request, response);
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	        request.setAttribute("error", "Something went wrong.");
	        request.getRequestDispatcher("/WEB-INF/pages/admin-error.jsp").forward(request, response);
	    }
	}

}
