package com.cg.CustomerRegistration.DAL;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import ExceptionPackage.CustomException;

public class DBconnectionsetup {
	
	private static DBconnectionsetup set=null;
	
	
	private DBconnectionsetup() {
	
		
	}
	
	
	public static DBconnectionsetup getinstance()
	{
		if(set==null) {
			set=new DBconnectionsetup();
		}
	
		return set; 
	}
	public Connection getConnect() {
	
		Connection con=null;
	    try {
	
		FileInputStream fr=new FileInputStream("resource\\Oracle.properties");
		Properties p=new Properties();
		p.load(fr);
		String url=p.getProperty("jdbc.url");
		String user=p.getProperty("jdbc.user");
		String password=p.getProperty("jdbc.password");
		con=DriverManager.getConnection("jdbc:oracle:thin:@:1521:xe","system","Capgemini123");
	    }
	    catch(Exception e) {
	    	throw new CustomException("DB Connection");
	    }
		
		return con;
	}

}
