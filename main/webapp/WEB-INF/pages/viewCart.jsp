<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.bonsai_gardener.model.CartItem" %>
<%
    List<CartItem> cartItems = (List<CartItem>) request.getAttribute("cartItems");
    double total = 0;
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Your Shopping Cart</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/cart.css" />
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f4f4f4;
            margin: 0;
            padding: 20px;
        }

        .cart-container {
            max-width: 1000px;
            margin: auto;
            background: white;
            padding: 20px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }

        h2 {
            text-align: center;
            color: #333;
            margin-bottom: 30px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        table th, table td {
            text-align: center;
            padding: 12px;
            border-bottom: 1px solid #ddd;
        }

        table th {
            background-color: #2196F3;
            color: white;
        }

        table img {
            width: 60px;
            height: auto;
            border-radius: 5px;
        }

        .total {
            text-align: right;
            font-size: 1.2em;
            margin-top: 20px;
        }

        
    </style>
</head>
<body>

<jsp:include page="header.jsp" />

<div class="cart-container">
    <h2>Your Shopping Cart</h2>

    <%
        if (cartItems == null || cartItems.isEmpty()) {
    %>
        <p>Your cart is empty. <a href="<%= request.getContextPath() %>/product">Shop Now</a></p>
    <%
        } else {
    %>

    <table>
        <tr>
            <th>Product</th>
            <th>Image</th>
            <th>Quantity</th>
            <th>Price</th>
            <th>Subtotal</th>
        </tr>
        <%
            for (CartItem item : cartItems) {
                double subtotal = item.getPrice() * item.getQuantity();
                total += subtotal;
        %>
        <tr>
            <td><%= item.getProductName() %></td>
            <td><img src="<%= request.getContextPath() + item.getImage() %>" alt="product" /></td>
            <td><%= item.getQuantity() %></td>
            <td>$<%= String.format("%.2f", item.getPrice()) %></td>
            <td>$<%= String.format("%.2f", subtotal) %></td>
        </tr>
        <%
            }
        %>
    </table>

    <div class="total">
        <strong>Total:</strong> $<%= String.format("%.2f", total) %>
        <br/>
        <form action="PreviewOrder" method="post">
        </form>
    </div>
    <% } %>
</div>

<jsp:include page="Footer.jsp" />
</body>
</html>
