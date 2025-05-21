package com.bonsai_gardener.service;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bonsai_gardener.config.DbConfig;
import com.bonsai_gardener.model.CartItem;

public class CartService {

	public boolean addProductToCart(int userId, int productId, int quantity) {
        try (Connection con = DbConfig.getDbConnection()) {

            // 1️⃣ Check if a cart exists for this user
            String checkCartSQL = "SELECT cart_id FROM cart WHERE user_id = ?";
            PreparedStatement ps = con.prepareStatement(checkCartSQL);
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();

            int cartId;

            if (rs.next()) {
                cartId = rs.getInt("cart_id");
            } else {
                // 2️⃣ No cart exists → insert new cart
                String insertCartSQL = "INSERT INTO cart (user_id) VALUES (?)";
                ps = con.prepareStatement(insertCartSQL, Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, userId);
                ps.executeUpdate();

                rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    cartId = rs.getInt(1);
                } else {
                    throw new SQLException("Failed to retrieve cart_id after inserting.");
                }
            }
            
            System.out.println("Final cart_id to use: " + cartId);


            // 3️⃣ Check if product already exists in cart_items
            String checkItemSQL = "SELECT quantity FROM cart_items WHERE cart_id = ? AND product_id = ?";
            ps = con.prepareStatement(checkItemSQL);
            ps.setInt(1, cartId);
            ps.setInt(2, productId);
            rs = ps.executeQuery();

            if (rs.next()) {
                // ✅ Product already exists → update quantity
                int existingQuantity = rs.getInt("quantity");
                int newQuantity = existingQuantity + quantity;

                String updateSQL = "UPDATE cart_items SET quantity = ? WHERE cart_id = ? AND product_id = ?";
                ps = con.prepareStatement(updateSQL);
                ps.setInt(1, newQuantity);
                ps.setInt(2, cartId);
                ps.setInt(3, productId);
                ps.executeUpdate();
            } else {
                // ✅ Product doesn't exist → insert new
                String insertItemSQL = "INSERT INTO cart_items (cart_id, product_id, quantity) VALUES (?, ?, ?)";
                ps = con.prepareStatement(insertItemSQL);
                ps.setInt(1, cartId);
                ps.setInt(2, productId);
                ps.setInt(3, quantity);
                ps.executeUpdate();
            }

            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
	
	
	public List<CartItem> getCartItems(int userId) throws SQLException, ClassNotFoundException {
	    List<CartItem> cartItems = new ArrayList<>();
	    String sql = "SELECT ci.quantity, p.name, p.price, p.image " +
	                 "FROM cart_items ci " +
	                 "JOIN cart c ON ci.cart_id = c.cart_id " +
	                 "JOIN product p ON ci.product_id = p.product_id " +
	                 "WHERE c.user_id = ?";

	    try (Connection con = DbConfig.getDbConnection();
	         PreparedStatement ps = con.prepareStatement(sql)) {

	        ps.setInt(1, userId);
	        ResultSet rs = ps.executeQuery();

	        while (rs.next()) {
	            CartItem item = new CartItem();
	            item.setProductName(rs.getString("name"));
	            item.setPrice(rs.getDouble("price"));
	            item.setImage(rs.getString("image"));
	            item.setQuantity(rs.getInt("quantity"));
	            cartItems.add(item);
	        }
	    }

	    return cartItems;
	}
}
