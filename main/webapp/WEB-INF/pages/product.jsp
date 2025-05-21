<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.bonsai_gardener.model.ProductModel" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Bonsai Products</title>

    <!-- ✅ Include CSS -->
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/Product.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>

<body>
<jsp:include page="header.jsp" />

<!-- 🌟 Featured Products -->
<div class="small-container">
    <h2>Featured Products</h2>
    <div class="row">
        <%
            List<ProductModel> products = (List<ProductModel>) request.getAttribute("products");
            if (products != null) {
                for (ProductModel p : products) {
                    if (p.isFeatured()) {
        %>
        <div class="col-3">
            <div class="product-card">
                <img src="<%= request.getContextPath() + p.getImage() %>" />

                
                
                

                <h4><%= p.getName() %></h4>
                <p><%= p.getDescription() %></p>
                <div class="rating">
                    <i class="fa fa-star"></i><i class="fa fa-star"></i>
                    <i class="fa fa-star"></i><i class="fa fa-star"></i>
                    <i class="fa fa-star-o"></i>
                </div>
                <p>$<%= p.getPrice() %></p>
                <form action="PreviewOrder" method="post">
                    <input type="hidden" name="product_id" value="<%= p.getProductId() %>" />
                    <input type="hidden" name="product_name" value="<%= p.getName() %>" />
                    <input type="hidden" name="price" value="<%= p.getPrice() %>" />
                    <input type="hidden" name="image" value="<%= p.getImage() %>" />
                    <input type="hidden" name="quantity" value="1" />
                    <button class="btn" type="submit">Buy Now</button>
                </form>
                <form action="AddToCart" method="post">
                    <input type="hidden" name="product_id" value="<%= p.getProductId() %>" />
                    <input type="hidden" name="quantity" value="1" />
                    <button class="btn cart" type="submit">Add to Cart</button>
                </form>
            </div>
        </div>
        <%
                    }
                }
            }
        %>
    </div>
</div>

<!-- 🕒 Latest Products -->
<div class="small-container">
    <h2>Latest Products</h2>
    <div class="row">
        <%
            if (products != null) {
                for (ProductModel p : products) {
                    if (p.isLatest()) {
        %>
        <div class="col-3">
            <div class="product-card">
				<img src="<%= request.getContextPath() + p.getImage() %>" alt="<%= p.getName() %>">
				<p><%= request.getContextPath() + p.getImage() %></p>
				

                <h4><%= p.getName() %></h4>
                <p><%= p.getDescription() %></p>
                <div class="rating">
                    <i class="fa fa-star"></i><i class="fa fa-star"></i>
                    <i class="fa fa-star"></i><i class="fa fa-star"></i>
                    <i class="fa fa-star-o"></i>
                </div>
                <p>$<%= p.getPrice() %></p>
                <form action="PreviewOrder" method="post">
                    <input type="hidden" name="product_id" value="<%= p.getProductId() %>" />
                    <input type="hidden" name="product_name" value="<%= p.getName() %>" />
                    <input type="hidden" name="price" value="<%= p.getPrice() %>" />
                    <input type="hidden" name="image" value="<%= p.getImage() %>" />
                    <button class="btn" type="submit">Buy Now</button>
                </form>
                <form action="AddToCart" method="post">
                    <input type="hidden" name="product_id" value="<%= p.getProductId() %>" />
                    <input type="hidden" name="quantity" value="1" />
                    <button class="btn cart" type="submit">Add to Cart</button>
                </form>
            </div>
        </div>
        <%
                    }
                }
            }
        %>
    </div>
</div>

<jsp:include page="Footer.jsp" />
</body>
</html>
