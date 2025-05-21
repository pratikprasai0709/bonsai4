package com.bonsai_gardener.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.bonsai_gardener.model.OrderModel;
import com.bonsai_gardener.model.customermodel;
import com.bonsai_gardener.service.OrderService;
import com.bonsai_gardener.service.adminservice;

/**
 * Servlet implementation class admindashboard
 */
@WebServlet("/admindashboard")
public class admindashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public admindashboard() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		adminservice adminService = new adminservice();
		// Fetch customer list
        List<customermodel> customerList = adminService.getAllCustomers();

        // Set customers in request scope
        request.setAttribute("customers", customerList);
        
        
        List<OrderModel> orderList = adminService.getAllOrdersWithCustomerNames();
		request.setAttribute("orders", orderList);

        // ✅ (Optional) Dashboard stats
//        int totalProducts = adminService.getTotalProductCount(); 
//        int completedOrders = adminService.getCompletedOrdersCount(); 
//        int canceledOrders = adminService.getCanceledOrdersCount(); // 
//        
//
//        request.setAttribute("totalProducts", totalProducts);
//        request.setAttribute("completedOrders", completedOrders);
//        request.setAttribute("canceledOrders", canceledOrders);
        
		request.getRequestDispatcher("/WEB-INF/pages/admindashboard.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
