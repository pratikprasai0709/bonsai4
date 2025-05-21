package com.bonsai_gardener.service;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.bonsai_gardener.config.DbConfig;
import com.bonsai_gardener.model.usermodell;

/**
 * Service class for updating user profile information.
 * 
 * This class provides methods to update user details in the database.
 * It handles database connections and SQL exceptions gracefully.
 */
public class UpdateProfileService {
    private Connection dbConn;
    private boolean isConnectionError = false;

    /**
     * Constructor initializes the database connection.
     */
    public UpdateProfileService() {
        try {
            dbConn = DbConfig.getDbConnection();
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
            isConnectionError = true;
        }
    }

    /**
     * Updates user profile information in the database.
     * 
     * @param user The UserModel object containing updated user data.
     * @return Boolean indicating success of update. Null if connection error.
     */
    public Boolean updateUserInfo(usermodell user) {
        if (isConnectionError) {
            return null;
        }

        String updateSQL = "UPDATE user SET username = ?, email = ?, password = ?, location = ?, phone = ? WHERE user_id = ?";

        try (PreparedStatement preparedStatement = dbConn.prepareStatement(updateSQL)) {
        	preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getLocation());
            preparedStatement.setString(5, user.getPhone());
            preparedStatement.setInt(6, user.getUser_id());

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}

