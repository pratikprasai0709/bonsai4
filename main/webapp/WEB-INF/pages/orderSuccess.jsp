<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Order Placed Successfully</title>
    <style>
        body {
            font-family: 'Segoe UI', sans-serif;
            background-color: #f4f8fb;
            margin: 0;
            padding: 0;
        }

        .success-container {
            max-width: 600px;
            margin: 100px auto;
            background: #ffffff;
            border-radius: 12px;
            box-shadow: 0 6px 18px rgba(0, 0, 0, 0.1);
            text-align: center;
            padding: 40px;
        }

        .success-container h1 {
            color: #2e7d32;
            font-size: 32px;
            margin-bottom: 20px;
        }

        .success-container p {
            font-size: 18px;
            color: #555;
        }

        .btn-home {
            margin-top: 30px;
            padding: 12px 24px;
            background-color: #1a73e8;
            color: white;
            border: none;
            border-radius: 6px;
            font-size: 16px;
            cursor: pointer;
            text-decoration: none;
            display: inline-block;
        }

        .btn-home:hover {
            background-color: #0b55c4;
        }

        .tick {
            font-size: 70px;
            color: #4caf50;
            margin-bottom: 15px;
        }
    </style>
</head>
<body>

<jsp:include page="header.jsp" />

<div class="success-container">
    <div class="tick">&#10004;</div>
    <h1>Order Placed Successfully!</h1>
    <p>Thank you for your purchase. Your order is being processed and will be delivered soon.</p>
    <a href="${pageContext.request.contextPath}/" class="btn-home">Back to Home</a>
</div>

<jsp:include page="Footer.jsp" />

</body>
</html>