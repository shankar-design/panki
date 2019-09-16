package com.cjc;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB_connection 
{
public Connection get_connection() {
	
Connection connection=null;
try
    {
	Class.forName("com.mysql.jdbc.Driver");
	connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
   
    }catch (Exception e) {
		System.out.println(e);
	}
return connection;
  }
}