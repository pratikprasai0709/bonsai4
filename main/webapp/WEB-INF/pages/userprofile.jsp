<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>User Profile - Bonsai E-commerce</title>
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;600&display=swap" rel="stylesheet">
    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: 'Inter', sans-serif;
            background-color: #f3f4f6;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
        }
        .card {
            background-color: #fff;
            border-radius: 1rem;
            box-shadow: 0 10px 25px rgba(0, 0, 0, 0.1);
            width: 90%;
            max-width: 800px;
            padding: 2rem;
        }
        .profile-header {
            display: flex;
            flex-direction: column;
            align-items: center;
            gap: 1rem;
        }
        .profile-img {
            width: 120px;
            height: 120px;
            border-radius: 50%;
            object-fit: cover;
            border: 3px solid #4caf50;
        }
        .profile-name {
            font-size: 1.5rem;
            font-weight: 600;
        }
        .profile-email {
            color: #6b7280;
            margin-bottom: 1.5rem;
        }
        .info-grid {
            display: grid;
            grid-template-columns: 1fr 1fr;
            gap: 1.5rem;
            margin-top: 1rem;
        }
        .info-item p {
            margin: 0;
        }
        .info-label {
            color: #9ca3af;
            font-size: 0.875rem;
        }
        .info-value {
            font-size: 1rem;
            font-weight: 500;
        }
        .actions {
            margin-top: 2rem;
            display: flex;
            gap: 1rem;
            justify-content: center;
        }
        .btn {
            padding: 0.75rem 1.5rem;
            border: none;
            border-radius: 0.5rem;
            font-weight: 500;
            cursor: pointer;
        }
        .btn-primary {
            background-color: #4caf50;
            color: white;
        }
    </style>
</head>
<body>
    <c:choose>
        <c:when test="${not empty user}">
            <div class="card">
                <div class="profile-header">
                	
                	<img class="profile-img" 
     src="${pageContext.request.contextPath}${user.imageUrl}" 
     alt="Profile Image" 
     onerror="this.src='${pageContext.request.contextPath}/images/userprofileimages/default.png'" />


                	




                	
                	
                	
                    <div class="profile-name">${user.username}</div>
                    <div class="profile-email">${user.email}</div>
                </div>
                <div class="info-grid">
                    <div class="info-item">
                        <p class="info-label">Phone</p>
                        <p class="info-value">${user.phone}</p>
                    </div>
                    <div class="info-item">
                        <p class="info-label">Location</p>
                        <p class="info-value">${user.location}</p>
                    </div>
                </div>
                <div class="actions">
				    <a href="${pageContext.request.contextPath}/editProfile" class="btn btn-primary">Edit Profile</a>
				</div>


            </div>
        </c:when>
        <c:otherwise>
            <p>User profile not found.</p>
        </c:otherwise>
    </c:choose>
</body>
</html>
