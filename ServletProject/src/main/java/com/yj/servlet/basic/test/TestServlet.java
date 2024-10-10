package com.yj.servlet.basic.test;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yj.servlet.basic.request.HelloData;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet(name="testServlet",urlPatterns = "/test-serve")
public class TestServlet extends HttpServlet {
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("이닛");
		super.init(config);
	}
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("폭파");
		super.destroy();
	}
	private final ObjectMapper objectMapper= new ObjectMapper();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String [] reqData = req.getParameterValues("username");
		resp.setContentType("application/json");
		resp.setCharacterEncoding("utf-8");
		
		HelloData data= new HelloData();
		for (String string : reqData) {
			if(string.equals("testOk")) {
				data.setUsername("OK");
				data.setAge(20);
				resp.getWriter().write(objectMapper.writeValueAsString(data));
			}else {
				data.setUsername("testNo");
				data.setAge(20);
				resp.getWriter().write(objectMapper.writeValueAsString(data));
			}
		}
	}

	
}
