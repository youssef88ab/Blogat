package com.blog.models;

import java.security.Timestamp;

public class Post 
{
	private int id;
	private String title;
	private String content;
	private int author;
	private java.sql.Timestamp timestamp;
	
	// Getters ;
	public int getId()              {return this.id;}
	public String getTitle()        {return this.title;}
	public String getContent()      {return this.content;}
	public int getAuthor()       {return this.author;}
	public java.sql.Timestamp gettimestamp() {return this.timestamp;}
	
	// Setters ; 
	public void setTitle(String title)     {this.title = title;}
	public void setContent(String content) {this.title = content;}
	public void setAuthor(int author)   {this.author = author;}
	public void setTimestamp(java.sql.Timestamp timestamp) {this.timestamp = timestamp;}
	
	// Constructor 
	public Post(int id , String title , String content , int author , java.sql.Timestamp timestamp2)
	{
		this.id = id ;
		this.title = title;
		this.author = author;
		this.content = content;
		this.timestamp = timestamp2;
	}
	
}
