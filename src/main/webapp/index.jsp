<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/home.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900&family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Roboto+Condensed&family=Roboto:wght@300&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />
    <script src="https://kit.fontawesome.com/afb6f7a51e.js" crossorigin="anonymous"></script>
    <title>Blog Posts</title>
</head>
<body>
    <section>
        <div class="parent">
            <div class="div1"><img id="logo" src="images/logo.png" alt="logo"></div>
            <div class="div2">
                <nav class="nav-categories">
                    <ul>
                        <li>Hotel</li>
                        <li>LifeStyle</li>
                        <li>Travel</li>
                        <li>Tech</li>
                    </ul>
                </nav>
            </div>
            <div class="div3">
                <input type="search" placeholder="Search Destination..." id="search-bar">
            </div>
            <div class="div4">
                <div class="login-signup">
                    <a href="<%= request.getContextPath() %>/login" id="login">Login</a>
                    <a href="<%= request.getContextPath() %>/signup" id="signup">Sign Up</a>
                </div>
            </div>
            <div class="div5"></div>
            <div class="div6">
                <div class="profile-info">
                    <img src="images/profile-image.jpg" alt="Profile Image" id="profile-image">
                    <h3 id="username"><%= request.getAttribute("username") != null ? request.getAttribute("username") : "Guest" %></h3>
                </div>
                <div class="post-info">
                    <p id="date-info"><%= new java.text.SimpleDateFormat("dd MMM yyyy").format(new java.util.Date()) %></p>
                    <span class="separator">•</span>
                    <p id="post-time">10 mins read</p>
                </div>
            </div>
            <div class="div7">
                <div class="left-section">
                    <a id="hero-category">Destination</a>
                    <h2 id="hero-title">${posts[0].title}</h2>
                    <p id="hero-description">Lorem ipsum dolor sit amet consectetur adipisicing elit voluptate pariatur non at maxime.</p>
                </div>
            </div>
        </div>
    </section>

    <section class="blogs">
        <div class="welcome">
            <h2>Blog</h2>
            <p>Lorem ipsum dolor sit vitae asperiores odit. Eius, autem.</p>
        </div>
        <div class="categories">
            <a href="#">All</a>
            <a href="#">Destination</a>
            <a href="#">Culinary</a>
            <a href="#">LifeStyle</a>
            <a href="#">Tips & Hacks</a>
            <a href="#">Tech</a>
        </div>

        <!-- Blog cards -->
       
    </section>

    <footer>
        <div class="parent-footer">
            <div class="footer-div1">
                <img src="images/logo.png" alt="">   
                <p>Stay curious, stay connected. Follow us for more!</p> 
            </div>
            <div class="footer-div2">
                <ul>
                    <li style="font-weight: bold; color: white;">About</li>
                    <li>About Us</li>
                    <li>Blog</li>
                    <li>Career</li>
                </ul>
            </div>
            <div class="footer-div3"> 
                <ul>
                    <li style="font-weight: bold; color: white;">Support</li>
                    <li>Contact Us</li>
                    <li>Return</li>
                    <li>FAQ</li>
                </ul>
            </div>
            <div class="footer-div4">
                <h3>Get Updates</h3>
                <form action="<%= request.getContextPath() %>/subscribe" method="post">
                    <input type="text" name="email" id="email-input" placeholder="Enter Your Email">
                    <input type="submit" value="Subscribe" id="subscribe">
                </form>     
            </div>
            <div class="footer-div5">
                <p id="rights">&copy; <%= java.time.Year.now() %> Blogat. All rights reserved.</p>
            </div>
            <div class="footer-div8"> 
                <div class="social-icons">
                    <i class="fa-brands fa-instagram"></i>
                    <i class="fa-brands fa-x-twitter"></i>
                    <i class="fa-brands fa-facebook"></i>
                    <i class="fa-brands fa-discord"></i>
                    <i class="fa-brands fa-tiktok"></i>
                </div>
                <div class="footer-links">
                    <a href="#">Privacy Policy</a>
                    <a href="#">Terms Of Service</a>
                </div>
            </div>
        </div>
    </footer>
</body>
</html>
