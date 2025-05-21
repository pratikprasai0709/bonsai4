<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/register.css" />
</head>
<body>
	<jsp:include page="header.jsp" />

<!-- account page -->
    <div class="account-page">
        <div class="container">
            <div class="row">
                <div class="col-2">
                    <img src="${pageContext.request.contextPath}/images/bonsai-2202769_640.png" alt="Bonsai" width="100%">
                </div>

                <div class="col-2">
                    <div class="form-container">
                        <div class="form-btn">
                            <span onclick = "login()">Login</span>
                            <span onclick = "register()">Register</span>
                            <hr id="indicator">
                        </div>

                        <!-- form -->
                         <form id="LoginForm" class="formm" method = "post" action="${pageContext.request.contextPath}/login">
                            <input type="text" name ="username" placeholder="Username">
                            <input type="password" name ="password" placeholder="password">
                            
                            <p style ="color:red">${errorMessage}</p>
                            <button type="submit" class="btn">Login</button>
                            
                         </form>

                         <form id="RegForm" class="formm" method = "post" action="${pageContext.request.contextPath}/register" enctype="multipart/form-data">
                         	
                            <input type="text" name ="username" placeholder="Username">
                            <input type="email" name ="email" placeholder="email">
                            <input type="password" name ="password" placeholder="password">
                            <input type="text" name ="Location" placeholder="location">
                            <input type="number" name ="Phone" placeholder="phone number">
                            
                            <label for="profileImage" style="margin-top: 10px;">Upload Profile Image</label>
    						<input type="file" name="profileImage" accept="image/*" required>
                            
                            <p style ="color:red">${errorMessage}</p>
                            
                            <button type="submit" class="btn">Register</button>

                         </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
    <jsp:include page="Footer.jsp" />
    
<!-- js for  toggle-->

    <script>
        var LoginForm = document.getElementById("LoginForm");
        var RegForm = document.getElementById("RegForm");
        var indicator = document.getElementById("indicator");

        function register() {
        	RegForm.style.display = "block";
            RegForm.style.transform = "translateX(0px)";
            LoginForm.style.transform = "translateX(0px)";
            LoginForm.style.display = "none";
            indicator.style.transform = "translateX(100px)";
        }

        function login() {
        	RegForm.style.display = "none";
        	LoginForm.style.display = "block";
            RegForm.style.transform = "translateX(300px)";
            LoginForm.style.transform = "translateX(300px)";
            indicator.style.transform = "translateX(0px)";
        }


    </script>
    
    

</body>
</html>