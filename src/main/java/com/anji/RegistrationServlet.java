package com.anji;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@SuppressWarnings("serial")
@WebServlet("/reg")
public class RegistrationServlet extends HttpServlet
{
   public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException 
   {
	  res.setContentType("text/html");
	  PrintWriter p = res.getWriter();

	  int k= new RegistrationDAO().registration(req);
	  if(k>0)
	  {
		  req.setAttribute("msg", "Registered Successfully");
		  RequestDispatcher rd = req.getRequestDispatcher("msg.jsp");
		  rd.forward(req, res);
	  }
	  
	  
   }
   
}
