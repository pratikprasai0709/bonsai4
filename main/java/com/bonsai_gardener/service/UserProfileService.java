package com.bonsai_gardener.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bonsai_gardener.config.DbConfig;
import com.bonsai_gardener.model.usermodell;

public class UserProfileService {  
    public static usermodell getUserById(int user_id) {
        usermodell user = null;

        try (Connection conn = DbConfig.getDbConnection()) {
            String sql = "SELECT * FROM user WHERE user_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, user_id);  // Set the user ID parameter
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                user = new usermodell();  // Changed to match the correct model name
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                user.setPhone(rs.getString("Phone"));
                user.setLocation(rs.getString("Location"));
                user.setImageUrl(rs.getString("image_url"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}
