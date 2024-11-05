package com.blog.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

import com.blog.models.Database;


@WebServlet("/register")
public class registerServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       

    public registerServlet() 
    {
        super();   
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String Name     = request.getParameter("username");
		String Email    = request.getParameter("email");
		String Password = request.getParameter("password");
	
		try 
		{
			if (Database.isUserExist(Name, Email))
			{
				// I will add it later okay ? 
			}
			
			else 
			{
				Database.createUser(Name, Password, Email);
				HttpSession session = request.getSession();
	            session.setAttribute("username", Name);
	            response.sendRedirect("registersucces.jsp");
			}
		}
		catch (SQLException e) 
		{
			System.out.println(e.getMessage());
		}
		
	}

}
