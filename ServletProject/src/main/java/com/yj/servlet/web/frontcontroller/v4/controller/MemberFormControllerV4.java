package com.yj.servlet.web.frontcontroller.v4.controller;

import java.util.Map;

import com.yj.servlet.web.frontcontroller.ModelView;
import com.yj.servlet.web.frontcontroller.v3.ControllerV3;
import com.yj.servlet.web.frontcontroller.v4.ControllerV4;

public class MemberFormControllerV4 implements ControllerV4{

	@Override
	public String process(Map<String, String> paramMap, Map<String, Object> model) {
		// TODO Auto-generated method stub
		return "new-form";
	}

}
