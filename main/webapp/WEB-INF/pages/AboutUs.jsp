<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>About Us</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/About.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css" integrity="sha512-Evv84Mr4kqVGRNSgIGL/F/aIDqQb7xQ2vcrdIwxfjThSH8CSR7PBEakCr51Ck+w+/U6swU2Im1vVX0SVk9ABhg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>
<jsp:include page="header.jsp" />
<div class="Main">               <!--Creating a main class-->
                     
        <h1>ABOUT US</h1>

        <div class="team">
            <div class="team_member">
                <div class="teamimg">
                    <img src="${pageContext.request.contextPath}/images/image1.png" alt="image of person">
                </div>
                <h3>Pratik Parsai</h3>
                <p class="role">Full-stack developer</p>
                <p>Hello, I'm Pratik Parsai, currently studying at Islington College. I have experience in both frontend and backend development, and I’m proficient in Java and Python. I am also one of the founding members of Bonsai Garden.</p> 
                <div>
                    <a href="" target="_blank">
                    <i class="fa-brands fa-linkedin"></i>
                    </a>
                    <a href="https://www.instagram.com/prasai_pratik/" target="_blank">
                    <i class="fa-brands fa-instagram"></i>
                    </a>
                </div>
            </div>

    
            <div class="team_member">
                <div class="teamimg">
                    <img src="${pageContext.request.contextPath}/images/image4.png" alt="image of person">
                </div>
                <h3>Bhusan Bohara</h3>
                <p class="role">Full-stack developer</p>
                <p>Hello, I'm Bhusan Bohara, currently studying at Islington College. I have experience in both frontend and backend development, and I'm proficient in Java and Python. I am also one of the founding members of Bonsai Garden.</p>
                <div>
                    <a href="https://www.linkedin.com/in/bhusan-bohara-00bb85280/" target="_blank">
                    <i class="fa-brands fa-linkedin"></i>
                    </a>
                    <a href="https://www.instagram.com/bhushan_bohara/" target="_blank">
                    <i class="fa-brands fa-instagram"></i>
                    </a>
                </div>
            </div>


            <div class="team_member">
                <div class="teamimg">
                    <img src="${pageContext.request.contextPath}/images/image2.png" alt="image of person">
                </div>
                <h3>Bibhuti Karki</h3>
                <p class="role">Full-stack developer</p>
                <p>Hello, I'm Bibhuti Karki, currently studying at Islington College. I have experience in both frontend and backend development, and I'm proficient in Java and Python. I am also one of the founding members of Bonsai Garden.</p>
                <div>
                    <a href="https://www.linkedin.com/in/bibhuti-karki-5a3928284/" target="_blank">
                    <i class="fa-brands fa-linkedin"></i>
                    </a>
                    <a href="https://www.instagram.com/bibhutihehehehe/" target="_blank">
                    <i class="fa-brands fa-instagram"></i>
                    </a>
                </div>
            </div>


            <div class="team_member">
                <div class="teamimg">
                    <img src="${pageContext.request.contextPath}/images/image3.png" alt="image of person">
                </div>
                <h3>Bipin Kumar Thapa</h3>
                <p class="role">Full-stack developer</p>
                <p>Hello, I'm Bipin Kumar Thapa, currently studying at Islington College. I have experience in both frontend and backend development, and I'm proficient in Java and Python. I am also one of the founding members of Bonsai Garden.</p>
                <div>
                    <a href="https://www.linkedin.com/in/bipin-kumar-thapa-333645284/" target="_blank">
                    <i class="fa-brands fa-linkedin"></i>
                    </a>
                    <a href="https://www.instagram.com/bipinbikramthapa/" target="_blank">
                    <i class="fa-brands fa-instagram"></i>
                    </a>
                </div>
            </div>

			<div class="team_member">
                <div class="teamimg">
                    <img src="${pageContext.request.contextPath}/images/" alt="image not found">
                </div>
                <h3>Khubeb Mohammed</h3>
                <p class="role">Full-stack developer</p>
                <p>Hello, I'm Khubeb Mohammed, currently studying at Islington College. I have experience in both frontend and backend development, and I'm proficient in Java and Python. I am also one of the founding members of Bonsai Garden.</p>
                <div>
                    <a href="https://www.linkedin.com/" target="_blank">
                    <i class="fa-brands fa-linkedin"></i>
                    </a>
                    <a href="https://www.instagram.com/" target="_blank">
                    <i class="fa-brands fa-instagram"></i>
                    </a>
                </div>
            </div>

            

        </div>
    </div>
    
    <jsp:include page="Footer.jsp" />
</body>
</html>