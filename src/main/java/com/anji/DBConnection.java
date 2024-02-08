package com.anji;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection 
{
	
	static Connection con = null;
	   static
	   {  
			try {
				Class.forName(DBInfo.DRIVER);
				con = DriverManager.getConnection(DBInfo.URL, DBInfo.USERNAME, DBInfo.PASSWORD);

			} catch (Exception e) {
				e.printStackTrace();
			}
	   }
	   
	   public static Connection getConnection()
	   {
		   return con;
	   }
	   
	   
}
