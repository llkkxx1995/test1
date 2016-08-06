package com.hand.Controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String path = httpRequest.getServletPath();
		if (path.contains("login")||path.contains("index")) {
			chain.doFilter(request, response);
		}else{
			HttpSession session = httpRequest.getSession();
			String flag = (String) session.getAttribute("flag");
			if (flag==null||!flag.equals("in")) {
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}else{
				chain.doFilter(request, response);
			}
		}
		
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
