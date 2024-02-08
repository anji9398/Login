package com.anji;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginDAO 
{
	RegistrationBean rb = null;
   public RegistrationBean check(HttpServletRequest req)
   {
	   
	   try 
	   {
		 Connection con = DBConnection.getConnection();
		 PreparedStatement select = con.prepareStatement("select * from UserRegistration where USERNAME=? and PASSWORD=?");
		 select.setString(1, req.getParameter("username"));
		 select.setString(2, req.getParameter("password"));
		 
		 ResultSet rs = select.executeQuery();
		 
		 while(rs.next())
		 {
			rb = new  RegistrationBean();
			rb.setuName(rs.getString(1));
			rb.setfName(rs.getString(2));
			rb.setlName(rs.getString(3));
			rb.setMailId(rs.getString(4));
			rb.setPhno( Long.parseLong(rs.getString(5)));
			rb.setPassword(rs.getString(6));
			
		 }
		 
		   
		   
		   
	   } catch (Exception e) {
		   e.printStackTrace();
	   }
	  return rb;
	   
	 
   }
}
