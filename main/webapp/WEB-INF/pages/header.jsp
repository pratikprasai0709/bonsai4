<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/header.css" />
</head>
<body>
    <div class="header">
        <div class="header-container">
            <div class="navbar">
                <div class="logo">
                    
                    <img src="${pageContext.request.contextPath}/images/bg.png" alt="Bonsai" width="70px">
                </div>
                <div class="search-container">
                    <form action="${pageContext.request.contextPath}/search" method="get" class="search-form">
                        <input type="text" name="query" placeholder="search anything" />
                        <button type="submit">
                            <img src="${pageContext.request.contextPath}/images/icon-1971133_640.png" />
                            
                        </button>
                    </form>
                </div>
                <nav>
                    <ul>
                        <li><a href="${pageContext.request.contextPath}/home">Home</a></li>
                    <li><a href="${pageContext.request.contextPath}/product">Product</a></li>
                    <li><a href="${pageContext.request.contextPath}/AboutUs">About us</a></li>
                    <li><a href="${pageContext.request.contextPath}/contactus">Contact us</a></li>
                    <li><a href="${pageContext.request.contextPath}/register">Account</a></li>
                    </ul>
                </nav>
                
                <!-- Existing cart icon -->
				<img src="${pageContext.request.contextPath}/images/shopping-cart.png" alt="Cart" width="30px" height="30px" style="margin-right: 15px;">
				
				<!-- New user icon -->
				<a href ="${pageContext.request.contextPath}/userprofile"><img src="${pageContext.request.contextPath}/images/usericon.png" alt="User" width="30px" height="30px"></a>
				
            </div>
        </div>
    </div>
</body>
</html>