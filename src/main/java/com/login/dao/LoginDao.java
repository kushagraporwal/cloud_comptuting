package com.login.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDao {
	
	String sql= "select * from newusers where username=? and password1=?";
	String url= "jdbc:mysql://localhost:3306/servletpractical";
	String username= "root";
	String password= "1234";
	
	public String username2 = "NULL";
	public String email2 = "NULL";
	public String cyear2 = "NULL";
	public String branch2 = "NULL";
	public String cgpa2 = "NULL";
	
	public boolean check(String uname, String pass)
	{
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con= DriverManager.getConnection(url, username, password);
			PreparedStatement st= con.prepareStatement(sql);
			st.setString(1, uname);
			st.setString(2, pass);
			ResultSet rs= st.executeQuery();
			if(rs.next())
			{
				username2=rs.getString("username");
				email2= rs.getString("email");
				cyear2= rs.getString("cyear");
				branch2= rs.getString("branch");
				cgpa2= rs.getString("cgpa");
				return true;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
