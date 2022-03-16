package com.login;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.login.dao.LoginDao;
import com.login.dao.RegisterDao;

/**
 * Servlet implementation class Register
 */
public class Register extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username1= request.getParameter("txt");
		String email= request.getParameter("email");
		String password1= request.getParameter("pswd");
		String cgpa= request.getParameter("cgpa");
		String branch= request.getParameter("branch");
		String cyear= request.getParameter("cyear");
		
		RegisterDao dao= new RegisterDao();
		if(dao.check2(username1, email, cyear, branch, cgpa, password1))
		{
			response.sendRedirect("login.jsp");
		}
		else
		{
			response.sendRedirect("register.jsp");
		}
	}

}
