<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/signup.css">
    <title>SignUp</title>
</head>
<body>
    <div class="left-side">
        <form action="register" method="post">
            <h1 id="title">Sign Up to BlogAt</h1> <br>
            Name*<input     type="text"     name="username" id="" placeholder="Enter your name"   required>
            Email*<input    type="text"     name="email"    id="" placeholder="Enter your email"  required>
            Password*<input type="password" name="password" id="" placeholder="Create a password" required>
            <input type="submit" value="SignUp" id="submit">
            <p>Already have an account? </p><a href="login.jsp">Log In</a>
        </form>
    </div>
    <div class="right-side">
        <img src="images/login.jpg" alt="">
    </div>
</body>
</html>