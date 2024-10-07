package com.yj.servlet.basic.response;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yj.servlet.basic.request.HelloData;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name="jsonServlet",urlPatterns = "/response-json")
public class ResponseJsonServlet extends HttpServlet {

	private final ObjectMapper objectMapper= new ObjectMapper();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		resp.setCharacterEncoding("utf-8");
		
		HelloData helloData=new HelloData();
		helloData.setUsername("김");
		helloData.setAge(20);
		
		String result= objectMapper.writeValueAsString(helloData);
				
		resp.getWriter().write(result);
		
	}

}
