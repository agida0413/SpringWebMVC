package com.yj.servlet.basic.response;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet(name="responseHeaderServlet", urlPatterns = "/response-headerUrl")
public class ResponseHeaderServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//status-line
		//resp.setStatus(HttpServletResponse.SC_OK);
		resp.setStatus(HttpServletResponse.SC_FOUND);
		resp.setHeader("Content-Type","text/plain;charset=utf-8");
		resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		resp.setHeader("Pragma", "no-cache");
		resp.setHeader("my-header", "hello");
		//resp.setHeader("Location", "/basic/hello-form.html");
		resp.sendRedirect("/basic/hello-form.html");
		Cookie cookie= new Cookie("test", "dsss");
		cookie.setMaxAge(600);
		resp.addCookie(cookie);
		PrintWriter writer= resp.getWriter();
		writer.write("하이");
	}

	
}
