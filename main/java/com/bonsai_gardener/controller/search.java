package com.bonsai_gardener.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.bonsai_gardener.model.ProductModel;
import com.bonsai_gardener.service.ProductService;

/**
 * Servlet implementation class search
 */
@WebServlet("/search")
public class search extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductService productService;

    @Override
    public void init() {
        productService = new ProductService(); // assuming no DAO, directly handles DB
    }
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public search() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String keyword = request.getParameter("query");

        if (keyword != null && !keyword.trim().isEmpty()) {
            List<ProductModel> results = productService.searchProductsByName(keyword);
            request.setAttribute("results", results);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/pages/search.jsp");
        dispatcher.forward(request, response);
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
