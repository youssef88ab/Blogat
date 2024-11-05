<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/dashboard.css">
    <title>Document</title>
</head>
<body>
    <div class="post">
        <div class="profile-header">
            <h4>Username</h4>
        </div>
        <form action="CreatePost" method="post">
            <input    type="text"   name="post_title" placeholder="Post Title">
            <textarea id="content"  name="content" rows="4" cols="50" placeholder="Enter your content here..." required></textarea>
            <input    type="submit" value="POST">
        </form>
    </div>
</body>
</html>
    