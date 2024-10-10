package com.yj.servlet.web.frontcontroller.v1.controller;

import java.io.IOException;

import com.yj.servlet.web.frontcontroller.v1.ControllerV1;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MemberFormControllerV1 implements ControllerV1{

	@Override
	public void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String viewPath="/WEB-INF/views/new-form.jsp";
		RequestDispatcher dispatcher=req.getRequestDispatcher(viewPath);
		dispatcher.forward(req, resp);
	}

}
