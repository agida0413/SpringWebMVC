package com.yj.servlet.web.frontcontroller;

import java.io.IOException;
import java.util.Map;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MyView {
	private String viewPath;
	
	public MyView(String viewPath) {
		this.viewPath=viewPath;
	}

public void render(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
	RequestDispatcher dispatcher=req.getRequestDispatcher(viewPath);
	dispatcher.forward(req, resp);
}
public void render(Map<String,Object> model,HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
	
	model.forEach((key,value) -> req.setAttribute(key, value));
	RequestDispatcher dispatcher=req.getRequestDispatcher(viewPath);
	dispatcher.forward(req, resp);
}
}
