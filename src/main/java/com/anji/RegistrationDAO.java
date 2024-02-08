package com.anji;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.http.HttpServletRequest;

public class RegistrationDAO 
{
	int k=0;
	
    public int registration(HttpServletRequest req) 
    {
    	try 
    	{
    		
    		Connection con = DBConnection.getConnection();
        	PreparedStatement select =  con.prepareStatement("insert into UserRegistration values(?,?,?,?,?,?)");
    	    select.setString(1, req.getParameter("username"));
    	    select.setString(2, req.getParameter("firstName"));
    	    select.setString(3, req.getParameter("lastName"));
    	    select.setString(4, req.getParameter("email"));    	    
    	    select.setLong(5,Long.parseLong(req.getParameter("phno")));
    	    select.setString(6,req.getParameter("password"));
    	    
    	    k = select.executeUpdate();
  	      	
		} catch (Exception e) {
			  e.printStackTrace();
		}
    	
    	return k;
    }
}
