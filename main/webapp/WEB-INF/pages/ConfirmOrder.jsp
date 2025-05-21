<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Confirm Order</title>
    <style>
        /* Your original CSS remains the same */
        .confirm-container {
            max-width: 700px;
            margin: 50px auto;
            padding: 30px;
            border: 1px solid #e0e0e0;
            border-radius: 10px;
            background-color: #f9f9f9;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
            font-family: 'Segoe UI', sans-serif;
        }

        .confirm-title {
            text-align: center;
            font-size: 28px;
            margin-bottom: 25px;
            color: #1a237e;
        }

        .product-image {
            display: block;
            margin: 0 auto 20px auto;
            width: 300px;
            border-radius: 8px;
            border: 1px solid #ccc;
        }

        .product-info {
            text-align: center;
            font-size: 18px;
            color: #333;
            margin-bottom: 12px;
        }

        .product-info span {
            font-weight: bold;
        }

        .quantity-wrapper {
            display: flex;
            justify-content: center;
            align-items: center;
            gap: 10px;
            margin: 20px 0;
        }

        .quantity-wrapper button {
            width: 40px;
            height: 40px;
            font-size: 20px;
            background-color: #1a73e8;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        .quantity-wrapper input {
            width: 60px;
            height: 38px;
            text-align: center;
            font-size: 18px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        .confirm-button {
            display: block;
            width: 200px;
            margin: 30px auto 0 auto;
            padding: 12px;
            font-size: 16px;
            background-color: #1a73e8;
            color: white;
            border: none;
            border-radius: 6px;
            cursor: pointer;
        }
    </style>
</head>
<body>

<jsp:include page="header.jsp" />

<%
    String productId = (String) request.getAttribute("product_id");
    String productName = (String) request.getAttribute("product_name");
    String price = (String) request.getAttribute("price");
    String image = (String) request.getAttribute("image");
    String imagePath = request.getContextPath() + image;
%>

<div class="confirm-container">
    <div class="confirm-title">Confirm Your Order</div>

    <img class="product-image" src="<%= imagePath %>" alt="<%= productName %>">
    <div class="product-info"><span>Product:</span> <%= productName %></div>
    <div class="product-info"><span>Unit Price:</span> $<%= price %></div>
    <div class="product-info"><span>Total Price:</span> $<span id="totalPrice"><%= price %></span></div>

    <form action="ConfirmOrder" method="post">
        <!-- ✅ Hidden fields for submission -->
        <input type="hidden" name="product_id" value="<%= productId %>">
        <input type="hidden" name="product_name" value="<%= productName %>">
        <input type="hidden" name="price" value="<%= price %>">
        <input type="hidden" name="image" value="<%= image %>">
        <input type="hidden" name="action" value="confirm" />

        <!-- ✅ Quantity -->
        <label class="product-info"><span>Quantity:</span></label>
        <div class="quantity-wrapper">
            <button type="button" onclick="decreaseQty()">−</button>
            <input type="number" id="quantity" name="quantity" min="1" value="1" readonly>
            <button type="button" onclick="increaseQty()">+</button>
        </div>

        <button type="submit" class="confirm-button">Confirm Order</button>
    </form>
</div>

<jsp:include page="Footer.jsp" />

<!-- ✅ JavaScript for live total price update -->
<script>
    const unitPrice = parseFloat("<%= price %>");
    const qtyInput = document.getElementById("quantity");
    const totalPriceEl = document.getElementById("totalPrice");

    function updateTotal() {
        const quantity = parseInt(qtyInput.value);
        const total = unitPrice * quantity;
        totalPriceEl.textContent = total.toFixed(2);
    }

    function increaseQty() {
        qtyInput.value = parseInt(qtyInput.value) + 1;
        updateTotal();
    }

    function decreaseQty() {
        if (parseInt(qtyInput.value) > 1) {
            qtyInput.value = parseInt(qtyInput.value) - 1;
            updateTotal();
        }
    }
</script>

</body>
</html>
