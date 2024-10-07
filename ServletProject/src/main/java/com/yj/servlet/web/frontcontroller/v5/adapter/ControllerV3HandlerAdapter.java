package com.yj.servlet.web.frontcontroller.v5.adapter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.yj.servlet.web.frontcontroller.ModelView;
import com.yj.servlet.web.frontcontroller.v3.ControllerV3;
import com.yj.servlet.web.frontcontroller.v5.MyHandlerAdapter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ControllerV3HandlerAdapter implements MyHandlerAdapter {

	@Override
	public boolean supports(Object handler) {
		// TODO Auto-generated method stub
		
		return (handler instanceof ControllerV3);
	}

	@Override
	public ModelView handle(HttpServletRequest req, HttpServletResponse resp,Object handler) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ControllerV3 controllerV3= (ControllerV3) handler;
		Map<String, String> paramMap = new HashMap<>();	
		req.getParameterNames().asIterator()
		.forEachRemaining(paramName -> paramMap.put(paramName, req.getParameter(paramName)));
		ModelView mView=controllerV3.process(paramMap);
		return mView;
	}

}
