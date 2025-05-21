package com.bonsai_gardener.model;

public class ProductModel {
    private int productId;
    private String name;
    private String description;
    private double price;
    private String image;
    private boolean isFeatured;
    private boolean isLatest;
    private int stock;

   
	// Constructors
    public ProductModel() {}

    public ProductModel(int productId, String name, String description, double price, String image, boolean isFeatured, boolean isLatest) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.image = image;
        this.isFeatured = isFeatured;
        this.isLatest = isLatest;
        
    }

    // Getters and Setters
    public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

    public int getProductId() { return productId; }
    public void setProductId(int productId) { this.productId = productId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }

    public boolean isFeatured() { return isFeatured; }
    public void setFeatured(boolean featured) { isFeatured = featured; }

    public boolean isLatest() { return isLatest; }
    public void setLatest(boolean latest) { isLatest = latest; }
}
