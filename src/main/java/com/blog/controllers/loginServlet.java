package com.blog.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.blog.models.Database;
import com.blog.models.User;


@WebServlet("/login")
public class loginServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

    public loginServlet() 
    {
        super();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String Username = request.getParameter("Username");
		String Password = request.getParameter("Password");
		
		User user = Database.getUserByUsernameAndPassword(Username, Password);
		if (user != null) 
		{
			 	HttpSession session = request.getSession();
	            session.setAttribute("user", user);
	            session.setAttribute("username", user.GetUsername());
	            session.setAttribute("userId", user.GetId());
	            response.sendRedirect("home");
		}
		else
		{
			response.sendRedirect("login.jsp?error=Invalid credentials");
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	{
		try {
			response.sendRedirect("login.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
