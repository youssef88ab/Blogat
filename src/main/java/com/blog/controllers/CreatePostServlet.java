package com.blog.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.blog.models.Database;
import com.blog.models.Post;

@WebServlet("/CreatePost")
public class CreatePostServlet extends HttpServlet 
{
    private static final long serialVersionUID = 1L;

    public CreatePostServlet() 
    {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        // Retrieve the user ID from the session
        HttpSession session = request.getSession();
        Integer authorId = (Integer) session.getAttribute("userId");

        // If authorId is null, handle the error (user might not be logged in)
        if (authorId == null) 
        {
            response.sendRedirect("login.jsp"); // Redirect to login if not authenticated
            return;
        }
        
        String title = request.getParameter("post_title");
        String content = request.getParameter("content");
        
        // Use current timestamp for post creation
        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
        
        // Create a new Post object
        Post post = new Post(0, title, content, authorId, currentTimestamp);
        
        try {
            Database.createPost(post); // Ensure your method name is correct
            response.sendRedirect("home.jsp"); // Redirect to home after post creation
        } catch (SQLException e) {
            e.printStackTrace(); // Log the error (consider using a logger)
            response.sendRedirect("error.jsp?message=Unable to create post."); // Redirect to an error page
        }
    }
}
