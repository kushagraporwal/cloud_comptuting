package com.login.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RegisterDao {
	
	String sql= "insert into newusers values(?, ?, ?, ?, ?, ?)";
	String url= "jdbc:mysql://localhost:3306/servletpractical";
	String username= "root";
	String password= "1234";
	
	public boolean check2(String username1, String email, String cyear, String branch, String cgpa, String password1)
	{
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con= DriverManager.getConnection(url, username, password);
			PreparedStatement st= con.prepareStatement(sql);
			st.setString(1, username1);
			st.setString(2, email);
			st.setString(3, cyear);
			st.setString(4, branch);
			st.setString(5, cgpa);
			st.setString(6, password1);
			boolean rs= st.execute();
				return true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
