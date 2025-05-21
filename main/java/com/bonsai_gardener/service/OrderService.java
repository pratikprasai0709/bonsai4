package com.bonsai_gardener.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.bonsai_gardener.config.DbConfig;
import com.bonsai_gardener.model.OrderModel;

public class OrderService {

    public boolean insertOrder(int userId, LocalDate orderDate, double totalAmount, String status) {
        String sql = "INSERT INTO orders (user_id, order_date, total_amount, status) VALUES (?, ?, ?, ?)";

        try (Connection conn = DbConfig.getDbConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, userId);
            stmt.setDate(2, java.sql.Date.valueOf(orderDate));
            stmt.setDouble(3, totalAmount);
            stmt.setString(4, status);

            return stmt.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    
    
}




