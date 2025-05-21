package com.bonsai_gardener.service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.bonsai_gardener.config.DbConfig;
import com.bonsai_gardener.model.OrderModel;
import com.bonsai_gardener.model.customermodel;


public class adminservice {

	public List<customermodel> getAllCustomers() {
        List<customermodel> customers = new ArrayList<>();
        String query = "SELECT * FROM user";

        try (Connection conn = DbConfig.getDbConnection();
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                customermodel customer = new customermodel();
                customer.setUser_id(rs.getInt("user_id"));
                customer.setUsername(rs.getString("username"));
                customer.setEmail(rs.getString("email"));
                customer.setLocation(rs.getString("location"));
                customer.setPhone(rs.getString("phone"));
                customers.add(customer);
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace(); // Consider using logging in production
        }

        return customers;
    }
	
	
	public List<OrderModel> getAllOrdersWithCustomerNames() {
	    List<OrderModel> orderList = new ArrayList<>();
	    String sql = "SELECT o.order_id, o.user_id, o.order_date, o.total_amount, o.status, u.username AS customer_name " +
	                 "FROM orders o INNER JOIN user u ON o.user_id = u.user_id ORDER BY o.order_date DESC";

	    try (Connection conn = DbConfig.getDbConnection();
	         PreparedStatement stmt = conn.prepareStatement(sql);
	         ResultSet rs = stmt.executeQuery()) {

	        while (rs.next()) {
	            OrderModel order = new OrderModel();
	            order.setOrderId(rs.getInt("order_id"));
	            order.setUserId(rs.getInt("user_id"));
	            order.setOrderDate(rs.getDate("order_date"));
	            order.setTotalAmount(rs.getDouble("total_amount"));
	            order.setStatus(rs.getString("status"));
	            order.setCustomerName(rs.getString("customer_name"));
	            orderList.add(order);
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return orderList;
	}

}