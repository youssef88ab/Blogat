<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
     <link rel="stylesheet" href="${pageContext.request.contextPath}/css/home.css">
    <title>Blog Posts</title>
    
</head>
<body>
    <div class="posts-container">
        <!-- Button to redirect to the Create Post page -->
        <a class="create-post-button" href="dashboard.jsp">Create Post</a> <!-- Update the URL as necessary -->

        <c:if test="${not empty posts}">
            <c:forEach var="post" items="${posts}">
                <article class="post">
                    <h2>${post.title}</h2>
                    <p>${post.content}</p>
                    <p><strong>Author ID:</strong> ${post.author}</p>
                    <p><small>Posted on: ${post.timestamp}</small></p>
                </article>
            </c:forEach>
        </c:if>

        <c:if test="${empty posts}">
            <p>No posts available.</p>
        </c:if>
    </div>
</body>
</html>
