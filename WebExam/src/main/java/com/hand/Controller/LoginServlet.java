package com.hand.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hand.service.UserServiceImp;

public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private UserServiceImp userService = new UserServiceImp();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
           
		//…Ë÷√±‡¬Î
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		boolean result = userService.queryCustomer(name);
		if (result) {
			HttpSession session = request.getSession();
			session.setAttribute("flag", "in");
			request.getRequestDispatcher("main.jsp").forward(request, response);
		}else{
			request.setAttribute("error", "µ«¬Ω ß∞‹");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
	}
	
	
	

}
