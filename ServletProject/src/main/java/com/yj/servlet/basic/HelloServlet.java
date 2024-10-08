package com.yj.servlet.basic;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet(name="helloServlet" ,urlPatterns = "/hello")
public class HelloServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Helloservlet.service");
		System.out.println("req="+request);
		System.out.println("res="+response);
		String username= request.getParameter("user");
		System.out.println(request.getParameter("user"));
		response.setContentType("text/plain");
		response.setCharacterEncoding("utf-8");
		response.getWriter().write("hello "+username);
	}

}
