package com.yj.servlet.web.frontcontroller.v2;

import java.io.IOException;

import com.yj.servlet.web.frontcontroller.MyView;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface ControllerV2 {
	MyView process(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException;
}
