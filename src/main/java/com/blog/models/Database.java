package com.blog.models;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;


public class Database {

    // Database Info
    private static final String url = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String dbusername = "SYSTEM";
    private static final String dbpassword = "youssef3334AB";

    // Load the driver once
    static 
    {
        try 
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("Oracle JDBC Driver Registered!");
        } 
        
        catch (ClassNotFoundException e) {
            System.out.println("Error loading Oracle JDBC Driver: " + e.getMessage());
        }
    }

    public static Connection getConnection() throws SQLException 
    {
        return DriverManager.getConnection(url, dbusername, dbpassword);
    }

    public static User getUserByUsernameAndPassword(String username, String password) {
        String sql = "SELECT id, username, password FROM users WHERE username = ? AND password = ?";
        
        try (
            Connection connection = getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql)
        ) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);

            System.out.println("Connected to Database and Executing Query.");

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"), "");
                }
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
        return null;
    }

    public static boolean isUserExist(String username, String email) throws SQLException 
    {
        String sql = "SELECT username, email FROM users WHERE username = ? OR email = ?";
        
        try (
            Connection connection = getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql)
        ) {
            pstmt.setString(1, username);
            pstmt.setString(2, email);
            System.out.println("Connected to Database and Executing Query.");

            try (ResultSet rs = pstmt.executeQuery()) {
                return rs.next(); // Returns true if a result is found
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
            throw e; // Rethrow the exception to handle it at a higher level if needed
        }
    }
    
    public static void createUser(String name, String password, String email) throws SQLException {
        String sql = "INSERT INTO users (username, password, email) VALUES (?, ?, ?)";
        
        try (Connection connection = getConnection(); PreparedStatement pstmt = connection.prepareStatement(sql)) 
        {
            
            pstmt.setString(1, name);
            pstmt.setString(2, password);
            pstmt.setString(3, email);
            System.out.println("Connected to database and executing query.");

            int rowsAffected = pstmt.executeUpdate(); // Execute the INSERT query

            if (rowsAffected > 0) {
                System.out.println("User created successfully.");
            } else {
                System.out.println("User creation failed.");
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
            throw e; // Rethrow to allow higher-level handling if needed
        }
    }

    public static List<Post> getPosts() throws SQLException {
        List<Post> postList = new ArrayList<>();
        String sql = "SELECT * FROM posts";

        try (Connection connection = getConnection(); 
             PreparedStatement pstmt = connection.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            System.out.println("Connected to Database and Executing Query.");

            while (rs.next()) {
                int id = rs.getInt("POST_ID");
                String title = rs.getString("TITLE");
                String content = rs.getString("CONTENT");
                int author = rs.getInt("USER_ID");
                String shortDescription = rs.getString("SHORTDESCRIPTION");
                java.sql.Timestamp timestamp = rs.getTimestamp("CREATED_AT");
                String categorie = rs.getString("CATEGORIE");

                Post post = new Post(id, title, content, author, timestamp , shortDescription , categorie);
                postList.add(post);
            }

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
            throw e; // Rethrow the exception to handle it at a higher level if needed
        }
        return postList;
    }

    public static void createPost(Post post) throws SQLException
    {
    	String sql = "INSERT INTO posts(TITLE , CONTENT , USER_ID , CREATED_AT ) values ( ? , ? , ? , ? )";
    	
    	try (Connection connection = getConnection(); PreparedStatement pstmt = connection.prepareStatement(sql)) 
    	{
    		pstmt.setString(1 , post.getTitle());
    		pstmt.setString(2 , post.getContent());
    		pstmt.setInt(3 , post.getAuthor());
    		pstmt.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
    		System.out.println("Connected to database and executing query.");
    		
    		 int rowsAffected = pstmt.executeUpdate(); // Execute the INSERT query

             if (rowsAffected > 0) { System.out.println("Post created successfully.");}
             else { System.out.println("Post creation failed."); }
    	}
    	catch (SQLException e)
    	{
            System.out.println("Database error: " + e.getMessage());
            throw e; // Rethrow to allow higher-level handling if needed
    	}
    	
    }
    
}