<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Search Results - Bonsai Garden</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        .container {
            width: 90%;
            max-width: 1200px;
            margin: 40px auto;
        }

        h2 {
            color: #2c3e50;
            margin-bottom: 20px;
            text-align: center;
        }

        .product-grid {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
            gap: 20px;
        }

        .product-card {
            background: #ffffff;
            border-radius: 10px;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.08);
            padding: 20px;
            text-align: center;
            transition: transform 0.2s ease-in-out;
        }

        .product-card:hover {
            transform: translateY(-5px);
        }

        .product-card img {
            width: 100%;
            max-height: 180px;
            object-fit: contain;
            margin-bottom: 15px;
            border-radius: 8px;
        }

        .product-card h3 {
            color: #1a1a1a;
            font-size: 18px;
            margin-bottom: 10px;
        }

        .product-card p {
            color: #555;
            font-size: 14px;
            margin: 5px 0;
        }

        .no-results {
            text-align: center;
            font-size: 18px;
            color: #888;
            margin-top: 40px;
        }
        .btn {
		    padding: 8px 14px;
		    background-color: #28a745;
		    color: white;
		    border: none;
		    cursor: pointer;
		    border-radius: 6px;
		    margin: 6px 4px 0;
		    transition: background-color 0.3s ease;
		}
        
        
        
		.btn.cart {
		    background-color: #007bff;
		}
		
		.btn:hover {
		    background-color: #218838;
		}
		
		.btn.cart:hover {
		    background-color: #0069d9;
		}

        @media (max-width: 600px) {
            .product-card {
                padding: 15px;
            }
        }
    </style>
</head>
<body>
	<jsp:include page="header.jsp" />
    <div class="container">
        <h2>🔍 Search Results</h2>

        <c:choose>
            <c:when test="${not empty results}">
                <div class="product-grid">
                    <c:forEach var="product" items="${results}">
                        <div class="product-card">
    <img src="${pageContext.request.contextPath}${product.image}" alt="${product.name}" />
    <h3>${product.name}</h3>
    <p>${product.description}</p>
    <div class="rating">
        <i class="fa fa-star"></i><i class="fa fa-star"></i>
        <i class="fa fa-star"></i><i class="fa fa-star"></i>
        <i class="fa fa-star-o"></i>
    </div>
    <p><strong>$${product.price}</strong></p>

    <!-- Buy Now -->
    <form action="PreviewOrder" method="post">
        <input type="hidden" name="product_id" value="${product.productId}" />
        <input type="hidden" name="product_name" value="${product.name}" />
        <input type="hidden" name="price" value="${product.price}" />
        <input type="hidden" name="image" value="${product.image}" />
        <input type="hidden" name="quantity" value="1" />
        <button class="btn" type="submit">Buy Now</button>
    </form>

    <!-- Add to Cart -->
    <form action="AddToCart" method="post">
        <input type="hidden" name="product_id" value="${product.productId}" />
        <input type="hidden" name="quantity" value="1" />
        <button class="btn cart" type="submit">Add to Cart</button>
    </form>
</div>

                    </c:forEach>
                </div>
            </c:when>
            <c:otherwise>
                <div class="no-results">
                    😕 No products found matching your search.
                </div>
            </c:otherwise>
        </c:choose>
    </div>
    <jsp:include page="Footer.jsp" />
</body>
</html>