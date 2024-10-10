package com.yj.servlet.basic.request;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet(name="requestParamServlet" , urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("전체 파라미터 조회");
		req.getParameterNames().asIterator()
		 	.forEachRemaining(paramName -> System.out.println(paramName+"="+req.getParameter(paramName)));
	
		System.out.println("이름이 같은 복수파라미터");
		String[] usernames= req.getParameterValues("user");
		for (String string : usernames) {
			System.out.println(string);
		}
	resp.getWriter().write("ok");
	}
	
}
