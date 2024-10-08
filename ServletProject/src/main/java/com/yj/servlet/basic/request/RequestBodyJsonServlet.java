package com.yj.servlet.basic.request;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.springframework.util.StreamUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet(name="requestBodyJsonServlet" , urlPatterns = "/json-servlet")
public class RequestBodyJsonServlet extends HttpServlet{

	private ObjectMapper objectMapper=new ObjectMapper();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletInputStream inputStream=req.getInputStream();
		String messageBody=StreamUtils.copyToString(inputStream,StandardCharsets.UTF_8);
		System.out.println(messageBody);
		
	HelloData helloData=objectMapper.readValue(messageBody,HelloData.class);
		
	System.out.println(helloData.getUsername());
	System.out.println(helloData.getAge());
	}

	
}
