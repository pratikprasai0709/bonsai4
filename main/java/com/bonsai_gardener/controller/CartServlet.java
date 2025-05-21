//package com.bonsai_gardener.controller;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//
//import java.io.IOException;
//import java.sql.SQLException;
//import java.util.List;
//
//import com.bonsai_gardener.model.CartItem;
//import com.bonsai_gardener.service.CartService;
//
///**
// * Servlet implementation class CartServlet
// */
//@WebServlet("/Cart")
//public class CartServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public CartServlet() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		// ✅ Check for logged-in user
//        HttpSession session = request.getSession(false);
//        if (session == null || session.getAttribute("user_id") == null) {
//            response.sendRedirect("login.jsp");
//            return;
//        }
//
//        int userId = (int) session.getAttribute("user_id");
//
//        try {
//            // ✅ Create service and fetch cart items
//        	CartService cartService = new CartService();
////            List<CartItem> cartItems = cartService.getCartItems(userId);
//
//            // ✅ Set as request attribute and forward to JSP
////            request.setAttribute("cartItems", cartItems);
//            request.getRequestDispatcher("WEB-INF/pages/viewCart.jsp").forward(request, response);
//        } catch (SQLException e) {
//            e.printStackTrace();
//            request.setAttribute("error", "Error fetching cart items.");
//            request.getRequestDispatcher("WEB-INF/pages/viewCart.jsp").forward(request, response);
//        }
//        }
//	
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}
//
//}
