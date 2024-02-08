package com.anji;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/login")
public class LoginServlet extends HttpServlet
{
   public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
   {
	  RegistrationBean rb  = new LoginDAO().check(req);
	  if(rb == null)
	  {
		  
		  req.setAttribute("msg", "Invalid");
		  RequestDispatcher rd = req.getRequestDispatcher("msg.jsp");
		  rd.forward(req, res);
		    
	  }else {
		  
		  req.setAttribute("msg", "Registered Successfully");
		  RequestDispatcher rd = req.getRequestDispatcher("msg1.jsp");
		  rd.forward(req, res);
	  }
   }
}
