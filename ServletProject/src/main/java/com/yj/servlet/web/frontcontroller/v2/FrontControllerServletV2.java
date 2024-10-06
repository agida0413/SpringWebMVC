package com.yj.servlet.web.frontcontroller.v2;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;

import com.yj.servlet.web.frontcontroller.MyView;
import com.yj.servlet.web.frontcontroller.v1.controller.MemberFormControllerV1;
import com.yj.servlet.web.frontcontroller.v1.controller.MemberListControllerV1;
import com.yj.servlet.web.frontcontroller.v1.controller.MemberSaveControllerV1;
import com.yj.servlet.web.frontcontroller.v2.controller.MemberFormControllerV2;
import com.yj.servlet.web.frontcontroller.v2.controller.MemberListControllerV2;
import com.yj.servlet.web.frontcontroller.v2.controller.MemberSaveControllerV2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet(name="frontControllerServletV2", urlPatterns = "/front-controller/v2/*")
public class FrontControllerServletV2 extends HttpServlet {
	private Map<String, ControllerV2> controllerMap = new HashMap<>();
	
	public FrontControllerServletV2(){
		controllerMap.put("/front-controller/v2/members/new-form",new MemberFormControllerV2());
		controllerMap.put("/front-controller/v2/members/save",new MemberSaveControllerV2());
		controllerMap.put("/front-controller/v2/members",new MemberListControllerV2());
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI(); 
		ControllerV2 controller=controllerMap.get(url);
			if(controller==null) {
				resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
				return;
			}
	MyView myView=	controller.process(req, resp);
		
	myView.render(req, resp);
	}

}
