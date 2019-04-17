package com.hibernate.jdbc.demo;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {

	public static void main(String[] args) {
		try{
			
			String jdbcurl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&ServerTimezone=UTC";
			String user ="hbstudent";
			String password = "hbstudent";
			Connection conn = DriverManager.getConnection(jdbcurl,user,password);
			System.out.println(conn.isValid(0));
			System.out.println("Connection successful!");
			
		}
		catch(Exception e){
			e.printStackTrace();
			
		}

	}

}
