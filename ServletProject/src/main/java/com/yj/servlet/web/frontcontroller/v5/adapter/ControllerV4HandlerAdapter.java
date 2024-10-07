package com.yj.servlet.web.frontcontroller.v5.adapter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.yj.servlet.web.frontcontroller.ModelView;
import com.yj.servlet.web.frontcontroller.v4.ControllerV4;
import com.yj.servlet.web.frontcontroller.v5.MyHandlerAdapter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ControllerV4HandlerAdapter implements MyHandlerAdapter{

	@Override
	public boolean supports(Object handler) {
		// TODO Auto-generated method stub
		return (handler instanceof ControllerV4);
	}

	@Override
	public ModelView handle(HttpServletRequest req, HttpServletResponse resp, Object handler)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ControllerV4 controllerV4 = (ControllerV4)handler;
		Map<String, String> paramMap = new HashMap<>();	
		Map<String, Object> model = new HashMap<>();
		
		req.getParameterNames().asIterator()
		.forEachRemaining(paramName -> paramMap.put(paramName, req.getParameter(paramName)));
		String viewName=	controllerV4.process(paramMap, model);
		
		ModelView mView = new ModelView(viewName);
		mView.setModel(model);
		return mView;
	}

}
