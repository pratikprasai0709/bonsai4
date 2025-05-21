package com.bonsai_gardener.service;
import java.sql.Connection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.bonsai_gardener.config.DbConfig;
import com.bonsai_gardener.model.usermodell;

public class registerservice {
	private Connection dbConn;

	/**
	 * Constructor initializes the database connection.
	 */
	public registerservice() {
		try {
			this.dbConn = DbConfig.getDbConnection();
		} catch (SQLException | ClassNotFoundException ex) {
			System.err.println("Database connection error: " + ex.getMessage());
			ex.printStackTrace();
		}
	}
	
	public Boolean addUser(usermodell usermodell) {
		if (dbConn == null) {
			System.err.println("Database connection is not available.");
			return null;
		}
		
		String roleQuery = "SELECT role_id FROM role WHERE role_name = ?";
		String insertQuery = "INSERT INTO user (username, password, email, role_id, Location, phone, image_url) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";
		
		try (PreparedStatement roleStmt = dbConn.prepareStatement(roleQuery);
	             PreparedStatement insertStmt = dbConn.prepareStatement(insertQuery)) {

	            // Fetch role ID based on the role name (assuming role_name exists in roles table)
	            roleStmt.setString(1, usermodell.getrole_name()); // You might want to adjust this
	            ResultSet result = roleStmt.executeQuery();
	            int roleId = result.next() ? result.getInt("role_id") : 1;  // Default role_id to 1 if not found
	            
	            

	            // Insert user details into the users table
	            insertStmt.setString(1, usermodell.getUsername());
	            insertStmt.setString(2, usermodell.getPassword());
	            insertStmt.setString(3, usermodell.getEmail());
	            insertStmt.setInt(4, roleId);
	            insertStmt.setString(5, usermodell.getLocation());
	            insertStmt.setString(6, usermodell.getPhone());
	            insertStmt.setString(7, usermodell.getImageUrl());
	            
	            
	            System.out.println("Username: " + usermodell.getUsername());
	            System.out.println("Password: " + usermodell.getPassword());
	            System.out.println("Email: " + usermodell.getEmail());
	            System.out.println("Role Name: " + usermodell.getrole_name());
	            System.out.println("Location: " + usermodell.getLocation());
	            System.out.println("Phone: " + usermodell.getPhone());
	            System.out.println("image_url: " + usermodell.getImageUrl());
	            
	            

	            return insertStmt.executeUpdate() > 0;
	        } catch (SQLException e) {
	            System.err.println("Error during user registration: " + e.getMessage());
	            e.printStackTrace();
	            return null;
	        }
	}
	
}
