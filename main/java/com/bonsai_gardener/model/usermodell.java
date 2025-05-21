package com.bonsai_gardener.model;


public class usermodell {
	 private int user_id; 
     private String username;
     private String password;
     private String email;
     private int role_id;
     private String role_name;
     private String Location;
     private String Phone;
     private String imageUrl;
     
     public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public usermodell() {
     	
     }
     
     public usermodell(String username, String password, String role_name)
     {
     	this.username = username;
     	this.password = password;
     	this.role_name = role_name;
     }
     
     public usermodell(int user_id, String username, String password, String email, int role_id, String role_name, String Location, String Phone)
     {
    	 super();
    	 this.user_id = user_id;
    	 this.username = username;
    	 this.password = password;
    	 this.email = email;
    	 this.role_id = role_id;
    	 this.role_name = role_name;
    	 this.Location = Location;
    	 this.Phone = Phone;
     }

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	
	public String getrole_name() {
		return role_name;
	}
	
	public void setrole_name(String role_name) {
		this.role_name = role_name;
	}

	public void add(usermodell customer) {
		// TODO Auto-generated method stub
		
	}
     
     

}
