package com.yj.servlet.web.frontcontroller.v2.controller;

import java.io.IOException;

import com.yj.servlet.web.frontcontroller.MyView;
import com.yj.servlet.web.frontcontroller.v2.ControllerV2;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MemberFormControllerV2 implements ControllerV2{
	@Override
	public MyView process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		return new MyView("/WEB-INF/views/new-form.jsp");

		
	}
}
