package com.login;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.login.dao.LoginDao;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uname= request.getParameter("uname");
		String pass= request.getParameter("pass");
		
		LoginDao dao= new LoginDao();
		if(dao.check(uname, pass))
		{
			HttpSession session= request.getSession();
			session.setAttribute("username3", dao.username2);
			session.setAttribute("email3", dao.email2);
			session.setAttribute("cyear3", dao.cyear2);
			session.setAttribute("branch3", dao.branch2);
			session.setAttribute("cgpa3", dao.cgpa2);
			response.sendRedirect("welcome.jsp");
		}
		else
		{
			response.sendRedirect("login.jsp");
		}
	}

	
}
