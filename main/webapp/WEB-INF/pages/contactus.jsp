<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/contactus.css" />
	

</head>
<body>

	<jsp:include page="header.jsp" />
    <section class="contact">
        <div class="content">
            <h2>Contact Us</h2>
            <p>Lorem ipsum, dolor sit amet consectetur adipisicing elit. Deleniti sint accusamus iure cupiditate delectus, porro similique eos ad vitae voluptatum vel, quas ab cumque magni recusandae? Quasi eaque et reprehenderit.</p>
        </div>
        <div class="container">
            <div class="contactInfo">
               <div class="box">
                    <div class="icon"><ion-icon name="location-outline"></ion-icon></ion-icon></div>
                    <div class="text">
                        <h3>Address</h3>
                        <p>32-Pepsicola Town Planning,<br>Kathmandu</p>
                    </div>
               </div> 
               <div class="box">
                    <div class="icon"><ion-icon name="call-outline"></ion-icon></ion-icon></div>
                    <div class="text">
                        <h3>Phone</h3>
                        <p>+977 987654321<br>01-4756789</p>
                    </div>
               </div> 
               <div class="box">
                    <div class="icon"><ion-icon name="mail-outline"></ion-icon></ion-icon></div>
                    <div class="text">
                        <h3>Email</h3>
                        <p>bibhuti@gmail.com</p>
                    </div>
               </div>
               <h4 class="txt">Connect with us</h4>
               <ul class="sci">
                <li><a href="#"><ion-icon name="logo-facebook"></ion-icon></a></li>
                <li><a href="#"><ion-icon name="logo-twitter"></ion-icon></a></li>
                <li><a href="#"><ion-icon name="logo-linkedin"></ion-icon></a></li>
                <li><a href="#"><ion-icon name="logo-instagram"></ion-icon></a></li>
               </ul>
            </div>
            <div class="contactForm">
              <form>
                <h2>Send Message</h2>
                <div class="inputbox">
                    <input type="text" name="" required="required">
                    <span>Full Name</span>
                </div>
                <div class="inputbox">
                    <input type="text" name="" required="required">
                    <span>Email</span>
                </div>
                <div class="inputbox">
                    <textarea required="required" ></textarea>
                    <span>Type your Message...</span>
                </div>
                <div class="inputbox">
                    <input type="submit" value="Send">
                    <span></span>
                </div>

              </form>  
            </div>
        </div>
    </section>
    <script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
    <script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script> 
</body>
</html>