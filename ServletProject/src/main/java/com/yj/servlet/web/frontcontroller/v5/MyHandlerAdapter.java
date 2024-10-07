package com.yj.servlet.web.frontcontroller.v5;

import java.io.IOException;

import com.yj.servlet.web.frontcontroller.ModelView;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface MyHandlerAdapter {

	boolean supports(Object handler);
	ModelView handle(HttpServletRequest req,HttpServletResponse resp,Object handler) throws ServletException,IOException; 
}
