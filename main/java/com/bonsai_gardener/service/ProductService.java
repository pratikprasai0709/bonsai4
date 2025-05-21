package com.bonsai_gardener.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bonsai_gardener.config.DbConfig;
import com.bonsai_gardener.model.ProductModel;

public class ProductService {
	 public List<ProductModel> getAllProducts() {
	        List<ProductModel> products = new ArrayList<>();
	        String sql = "SELECT * FROM product";

	        try (Connection conn = DbConfig.getDbConnection();  // ✅ Use your existing connection method
	             PreparedStatement stmt = conn.prepareStatement(sql);
	             ResultSet rs = stmt.executeQuery()) {

	            while (rs.next()) {
	                ProductModel p = new ProductModel();
	                p.setProductId(rs.getInt("product_id"));
	                p.setName(rs.getString("name"));
	                p.setDescription(rs.getString("description"));
	                p.setPrice(rs.getDouble("price"));
	                p.setImage(rs.getString("image"));
	                p.setFeatured(rs.getBoolean("is_featured"));
	                p.setLatest(rs.getBoolean("is_latest"));
	                products.add(p);
	            }

	        } catch (SQLException | ClassNotFoundException e) {
	            e.printStackTrace();
	        }

	        return products;
	    }
	 
	 public List<ProductModel> searchProductsByName(String keyword) {
		    List<ProductModel> products = new ArrayList<>();
		    String sql = "SELECT * FROM product WHERE LOWER(name) LIKE ?";

		    try (Connection conn = DbConfig.getDbConnection();
		         PreparedStatement stmt = conn.prepareStatement(sql)) {

		        stmt.setString(1, "%" + keyword.toLowerCase() + "%");
		        ResultSet rs = stmt.executeQuery();

		        while (rs.next()) {
		            ProductModel p = new ProductModel();
		            p.setProductId(rs.getInt("product_id"));
		            p.setName(rs.getString("name"));
		            p.setDescription(rs.getString("description"));
		            p.setPrice(rs.getDouble("price"));
		            p.setImage(rs.getString("image"));
		            p.setFeatured(rs.getBoolean("is_featured"));
		            p.setLatest(rs.getBoolean("is_latest"));
		            products.add(p);
		        }

		    } catch (SQLException | ClassNotFoundException e) {
		        e.printStackTrace();
		    }

		    return products;
		}
	 
	 
	 public boolean addProduct(ProductModel product) {
		    String sql = "INSERT INTO product (name, description, price, image, is_featured, is_latest, stock) "
		               + "VALUES (?, ?, ?, ?, ?, ?, ?)";

		    try (Connection conn = DbConfig.getDbConnection();
		         PreparedStatement stmt = conn.prepareStatement(sql)) {

		        stmt.setString(1, product.getName());
		        stmt.setString(2, product.getDescription());
		        stmt.setDouble(3, product.getPrice());
		        stmt.setString(4, product.getImage());
		        stmt.setBoolean(5, product.isFeatured());
		        stmt.setBoolean(6, product.isLatest());
		        stmt.setInt(7, product.getStock()); 

		        int rows = stmt.executeUpdate();
		        return rows > 0;

		    } catch (SQLException | ClassNotFoundException e) {
		        e.printStackTrace();
		        return false;
		    }
		}
	 
	 
	 public boolean updateProduct(ProductModel product) {
		    String sql = "UPDATE product SET name = ?, description = ?, price = ?, stock = ? WHERE product_id = ?";

		    try (Connection conn = DbConfig.getDbConnection();
		         PreparedStatement stmt = conn.prepareStatement(sql)) {

		        stmt.setString(1, product.getName());
		        stmt.setString(2, product.getDescription());
		        stmt.setDouble(3, product.getPrice());
		        stmt.setInt(4, product.getStock());
		        stmt.setInt(5, product.getProductId());

		        int rows = stmt.executeUpdate();
		        return rows > 0;

		    } catch (SQLException | ClassNotFoundException e) {
		        e.printStackTrace();
		        return false;
		    }
		}

	 
}
    
    
    

