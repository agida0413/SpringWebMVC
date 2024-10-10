package com.yj.basic.practice;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

@WebServlet(name="mydis",urlPatterns = "/test")
public class MyDispatcherServlet extends HttpServlet{
private static final Map<String, String> map = new HashMap<>();

MyDispatcherServlet(){
	
}
	


}
