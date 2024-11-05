package com.blog.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.blog.models.Database;
import com.blog.models.Post;

@WebServlet("/home")
public class HomepageServlet extends HttpServlet 
{
	
	private static final long serialVersionUID = 1L;
       
    public HomepageServlet() 
    {
        super();
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        System.out.println("HomepageServlet doGet() called"); // Log message
        try 
        {
        	// Fetch Posts From Database 
            List<Post> postlist = Database.getPosts();
            
            // Set Data As request Attribute 
            request.setAttribute("posts", postlist); 
           
            // Forward Request To JSP
            request.getRequestDispatcher("home.jsp").forward(request, response);
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
            System.out.println("Error in Showing Post");
        }
    }

	}