package com.bonsai_gardener.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bonsai_gardener.config.DbConfig;
import com.bonsai_gardener.model.usermodell;

public class LoginService {

	private Connection dbConn;
	private boolean isConnectionError = false;

	public LoginService() {
		try {
			dbConn = DbConfig.getDbConnection();
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
			isConnectionError = true;
		}
	}

	public Boolean loginUser(usermodell usermodell) {
		if (isConnectionError) {
			System.out.println("Connection Error!");
			return null;
		}

		String query = "SELECT username, password FROM user WHERE username = ?";
		try (PreparedStatement stmt = dbConn.prepareStatement(query)) {
			stmt.setString(1, usermodell.getUsername());
			ResultSet result = stmt.executeQuery();

			if (result.next()) {
				return validatePassword(result, usermodell);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return false;
	}

	private boolean validatePassword(ResultSet result, usermodell usermodell) throws SQLException {
		String dbUsername = result.getString("username");
		String dbPassword = result.getString("password");

		return dbUsername.equals(usermodell.getUsername())
				&& dbPassword.equals(usermodell.getPassword());
	}

	public usermodell getUserByUsernameAndPassword(String username, String password) {
		if (isConnectionError) {
			System.out.println("Connection Error!");
			return null;
		}

		usermodell user = null;

		String sql = """
			SELECT u.*, r.role_name 
			FROM user u
			JOIN role r ON u.role_id = r.role_id
			WHERE u.username = ? AND u.password = ?
		""";

		System.out.println("Executing SQL for login:");
		System.out.println("Query: SELECT u.*, r.role_name FROM user u JOIN role r ON u.role_id = r.role_id WHERE u.username = ? AND u.password = ?");
		System.out.println("Parameters -> username: " + username + ", password: " + password);

		try (PreparedStatement stmt = dbConn.prepareStatement(sql)) {
			stmt.setString(1, username);
			stmt.setString(2, password);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				user = new usermodell();
				user.setUser_id(rs.getInt("user_id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setPhone(rs.getString("phone"));
				user.setLocation(rs.getString("location"));
				user.setrole_name(rs.getString("role_name"));
				
			    System.out.println("User found. Username: " + user.getUsername());
				System.out.println("User found. role_name: " + user.getrole_name());
			} else {
				System.out.println("No matching user found in database.");
			}
		} catch (SQLException e) {
			System.out.println("SQL Exception occurred while querying login credentials.");
			e.printStackTrace();
		}
		return user;
	}
	
	public boolean isConnectionError() {
	    return isConnectionError;
	}
}
