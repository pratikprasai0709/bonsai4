<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Edit Profile - Bonsai E-commerce</title>
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
    .form-header {
      text-align: center;
      margin-bottom: 2rem;
    }
    .form-header h2 {
      font-size: 1.5rem;
      font-weight: 600;
    }
    .form-group {
      margin-bottom: 1.5rem;
    }
    label {
      display: block;
      font-size: 0.875rem;
      color: #6b7280;
      margin-bottom: 0.5rem;
    }
    input[type="text"],
    input[type="email"],
    input[type="password"] {
      width: 100%;
      padding: 0.75rem;
      border: 1px solid #d1d5db;
      border-radius: 0.5rem;
      font-size: 1rem;
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
    .btn-secondary {
      background-color: #9ca3af;
      color: white;
    }
    .error-message {
      color: red;
      text-align: center;
      margin-bottom: 1rem;
    }
  </style>
</head>
<body>
  <div class="card">
    <div class="form-header">
      <h2>Edit Profile</h2>
    </div>

    <c:if test="${not empty errorMessage}">
      <div class="error-message">${errorMessage}</div>
    </c:if>

    <form action="UpdateProfileServlet" method="post">
      
      <input type="hidden" name="user_id" value="${currentUser.user_id}" />
      <input type="hidden" name="role_id" value="${currentUser.role_id}" />

      <div class="form-group">
        <label for="username">Username</label>
        <input type="text" name="username" id="username" value="${currentUser.username}" required />
      </div>

      <div class="form-group">
        <label for="email">Email</label>
        <input type="email" name="email" id="email" value="${currentUser.email}" required />
      </div>

      <div class="form-group">
        <label for="password">Password</label>
        <input type="password" name="password" id="password" value="${currentUser.password}" required />
      </div>
      
      <div class="form-group">
        <label for="Location">Location</label>
        <input type="text" name="Location" id="Location" value="${currentUser.location}" required />
      </div>

      <div class="form-group">
        <label for="Phone">Phone</label>
        <input type="text" name="Phone" id="Phone" value="${currentUser.phone}" required />
      </div>

      <div class="actions">
        <<button type="submit" class="btn btn-primary">Save Changes</button>
        <a href="${pageContext.request.contextPath}/userprofile" class="btn btn-secondary">Cancel</a>
      </div>
    </form>
  </div>
</body>
</html>