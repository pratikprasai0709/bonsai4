<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Bonsai Admin Dashboard</title>
  
  <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;600&display=swap" rel="stylesheet" />
  <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
  <style>
    * {
      margin: 0;
      padding: 0;
      box-sizing: border-box;
      font-family: 'Inter', sans-serif;
    }
    body {
      background-color: #f7f8fa;
      color: #333;
      display: flex;
      height: 100vh;
    }
    .sidebar {
      width: 220px;
      background-color: #ffffff;
      border-right: 1px solid #e0e0e0;
      padding: 30px 20px;
    }
    .sidebar h2 {
      margin-bottom: 30px;
      color: #4caf50;
      font-size: 1.2em;
    }
    .sidebar nav a {
      display: block;
      padding: 12px 10px;
      color: #333;
      text-decoration: none;
      border-radius: 8px;
      margin-bottom: 10px;
      transition: background 0.3s;
      cursor: pointer;
    }
    .sidebar nav a:hover {
      background-color: #e8f5e9;
      color: #4caf50;
    }
    .main {
      flex: 1;
      padding: 30px;
      overflow-y: auto;
    }
    .header {
      font-size: 1.5em;
      margin-bottom: 20px;
    }
    .stats {
      display: flex;
      gap: 20px;
      margin-bottom: 30px;
      flex-wrap: wrap;
    }
    .card {
      background-color: #fff;
      padding: 20px;
      border-radius: 12px;
      flex: 1 1 200px;
      box-shadow: 0 2px 4px rgba(0,0,0,0.05);
    }
    .card h3 {
      margin-bottom: 10px;
      font-size: 1em;
      color: #777;
    }
    .card p {
      font-size: 1.4em;
      font-weight: bold;
    }
    .section {
      background-color: #fff;
      padding: 20px;
      border-radius: 12px;
      box-shadow: 0 2px 4px rgba(0,0,0,0.05);
      margin-bottom: 30px;
      display: none;
    }
    .section.active {
      display: block;
    }
    table {
      width: 100%;
      border-collapse: collapse;
      margin-top: 10px;
    }
    th, td {
      text-align: left;
      padding: 12px;
      border-bottom: 1px solid #eee;
    }
    th {
      color: #4caf50;
      background-color: #f1f8f4;
    }
    form label {
      display: block;
      margin-top: 10px;
      font-weight: 600;
    }
    form input, form button {
      width: 100%;
      padding: 10px;
      margin-top: 5px;
      border: 1px solid #ccc;
      border-radius: 6px;
    }
    form button {
      background-color: #4caf50;
      color: white;
      font-weight: bold;
      cursor: pointer;
      margin-top: 15px;
    }
    .low-stock-list {
      list-style: none;
      padding-left: 0;
      color: #d32f2f;
      font-weight: 500;
      line-height: 1.8em;
    }
    .low-stock-list li {
      background-color: #fff3f3;
      padding: 10px;
      border: 1px solid #ffcdd2;
      border-radius: 6px;
      margin-bottom: 8px;
    }
    .low-stock-list .product-name {
      font-weight: bold;
    }
    @media (max-width: 768px) {
      .sidebar {
        display: none;
      }
    }
  </style>
</head>
<body>
  <aside class="sidebar">
    <h2>Bonsai Admin</h2>
    <nav>
      <a onclick="showSection('overview')">Overview</a>
      <a onclick="showSection('add')">Add Product</a>
      <a onclick="showSection('edit')">Edit Product</a>
      <a onclick="showSection('remove')">Remove Product</a>
      <a onclick="showSection('orders')">Orders</a>
      <a onclick="showSection('customers')">Customers</a>
    </nav>
  </aside>

  <main class="main">
    <div class="header">Good Morning, Admin!</div>

    <!-- Overview -->
    <section id="overview" class="section active">
      <div class="stats">
        <div class="card"><h3>Total Products</h3><p><c:out value="${totalProducts}" /></p></div>
        <div class="card"><h3>Completed Orders</h3><p><c:out value="${completedOrders}" /></p></div>
        <div class="card"><h3>Canceled Orders</h3><p><c:out value="${canceledOrders}" /></p></div>
      </div>

      <div class="charts" style="display: flex; flex-wrap: wrap; gap: 20px; justify-content: space-between;">
        <div style="flex: 1 1 300px; max-width: 350px;">
          <h4 style="margin-bottom: 10px; color: #4caf50;">Sales Overview</h4>
          <canvas id="barChart"></canvas>
        </div>
        <div style="flex: 1 1 300px; max-width: 350px;">
          <h4 style="margin-bottom: 10px; color: #4caf50;">Product Share</h4>
          <canvas id="pieChart"></canvas>
        </div>
      </div>

      <div style="margin-top: 20px;">
        <h3 style="margin-bottom: 10px; color: #d32f2f;">Low Stock Alerts</h3>
        <ul class="low-stock-list">
          <c:forEach var="product" items="${lowStockProducts}">
            <li><span class="product-name"><c:out value="${product.name}" /></span> – Only <strong><c:out value="${product.stock}" /></strong> left in stock</li>
          </c:forEach>
        </ul>
      </div>
    </section>

    <!-- Add Product -->
    <section id="add" class="section">
      <h3>Add Product</h3>
	      <form action="addproduct" method="post" enctype="multipart/form-data">
			  <label>Product Name</label>
			  <input type="text" name="name" required>
			
			  <label>Description</label>
			  <input type="text" name="description" required>
			
			  <label>Price</label>
			  <input type="number" step="0.01" name="price" required>
			  
			  <label>Quantity</label>
				<input type="number" name="quantity" required>
			  
			
			  <label>Image</label>
			  <input type="file" name="image" accept="image/*" required>
			
			  <label>Is Featured?</label>
			  <select name="is_featured">
			    <option value="1">Yes</option>
			    <option value="0" selected>No</option>
			  </select>
			
			  <label>Is Latest?</label>
			  <select name="is_latest">
			    <option value="1">Yes</option>
			    <option value="0" selected>No</option>
			  </select>
			
			  <button type="submit">Add Product</button>
		</form>


    </section>

    <!-- Edit Product -->
    <section id="edit" class="section">
      <h3>Edit Product</h3>
      <form action="EditProductServlet" method="post">
  <label>Product ID</label>
  <input type="text" name="productId" required>

  <label>Update Name</label>
  <input type="text" name="productName" placeholder="Update name">

  <label>Update Description</label>
  <input type="text" name="description" placeholder="Update description">

  <label>Update Price</label>
  <input type="number" name="price" step="0.01" placeholder="Update price">

  <label>Update Stock</label>
  <input type="number" name="stock" placeholder="Update stock">

  <button type="submit">Save Changes</button>
</form>

    </section>

    <!-- Remove Product -->
    <section id="remove" class="section">
      <h3>Remove Product</h3>
      <form action="RemoveProductServlet" method="post">
        <label>Product ID</label>
        <input type="text" name="productId" placeholder="Enter product ID to remove" required>
        <button type="submit">Remove Product</button>
      </form>
    </section>

    <!-- Orders -->
    <section id="orders" class="section">
      <h3>Orders</h3>
      <table>
        <thead>
          <tr><th>Order ID</th><th>Customer</th><th>Date</th><th>Status</th><th>Total</th></tr>
        </thead>
        <tbody>
          <c:forEach var="order" items="${orders}">
			    <tr>
			        <td><c:out value="${order.orderId}" /></td>
			        <td><c:out value="${order.customerName}" /></td>
			        <td><c:out value="${order.orderDate}" /></td>
			        <td><c:out value="${order.status}" /></td>
			        <td><c:out value="${order.totalAmount}" /></td>
			    </tr>
			</c:forEach>
        </tbody>
      </table>
    </section>

    <!-- Customers -->
    <section id="customers" class="section">
      <h3>Customers</h3>
      <table>
        <thead>
          <tr><th>Customer ID</th><th>Name</th><th>Email</th><th>Location</th><th>Phone</th></tr>
        </thead>
        <tbody>
          <c:forEach var="customer" items="${customers}">
            <tr>
              <td><c:out value="${customer.user_id}" /></td>
              <td><c:out value="${customer.username}" /></td>
              <td><c:out value="${customer.email}" /></td>
              <td><c:out value="${customer.location}" /></td>
              <td><c:out value="${customer.phone}" /></td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
    </section>
  </main>

  <script>
    function showSection(id) {
      document.querySelectorAll('.section').forEach(section => {
        section.classList.remove('active');
      });
      document.getElementById(id).classList.add('active');
    }

    new Chart(document.getElementById('barChart').getContext('2d'), {
      type: 'bar',
      data: {
        labels: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun'],
        datasets: [{
          label: 'Monthly Sales ($)',
          data: [1200, 1900, 3000, 2500, 3200, 2900],
          backgroundColor: '#4caf50'
        }]
      },
      options: {
        responsive: true,
        scales: {
          y: { beginAtZero: true }
        }
      }
    });

    new Chart(document.getElementById('pieChart').getContext('2d'), {
      type: 'pie',
      data: {
        labels: ['Ficus Bonsai', 'Jade Bonsai', 'Juniper Bonsai'],
        datasets: [{
          label: 'Product Share',
          data: [45, 25, 30],
          backgroundColor: ['#4caf50', '#81c784', '#a5d6a7']
        }]
      },
      options: {
        responsive: true
      }
    });
  </script>
</body>
</html>











