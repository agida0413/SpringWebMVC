package com.yj.servlet.web.frontcontroller.v3;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;

import com.yj.servlet.web.frontcontroller.ModelView;
import com.yj.servlet.web.frontcontroller.MyView;
import com.yj.servlet.web.frontcontroller.v1.controller.MemberFormControllerV1;
import com.yj.servlet.web.frontcontroller.v1.controller.MemberListControllerV1;
import com.yj.servlet.web.frontcontroller.v1.controller.MemberSaveControllerV1;
import com.yj.servlet.web.frontcontroller.v2.controller.MemberFormControllerV2;
import com.yj.servlet.web.frontcontroller.v2.controller.MemberListControllerV2;
import com.yj.servlet.web.frontcontroller.v2.controller.MemberSaveControllerV2;
import com.yj.servlet.web.frontcontroller.v3.controller.MemberFormControllerV3;
import com.yj.servlet.web.frontcontroller.v3.controller.MemberListControllerV3;
import com.yj.servlet.web.frontcontroller.v3.controller.MemberSaveControllerV3;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet(name="frontControllerServletV3", urlPatterns = "/front-controller/v3/*")
public class FrontControllerServletV3 extends HttpServlet {
	private Map<String, ControllerV3> controllerMap = new HashMap<>();
	
	public FrontControllerServletV3(){
		controllerMap.put("/front-controller/v3/members/new-form",new MemberFormControllerV3());
		controllerMap.put("/front-controller/v3/members/save",new MemberSaveControllerV3());
		controllerMap.put("/front-controller/v3/members",new MemberListControllerV3());
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI(); 
		ControllerV3 controller=controllerMap.get(url);
			if(controller==null) {
				resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
				return;
			}
		//paramMap	
		Map<String, String> paramMap = new HashMap<>();	
		req.getParameterNames().asIterator()
		.forEachRemaining(paramName -> paramMap.put(paramName, req.getParameter(paramName)));
			
		ModelView mv = controller.process(paramMap);
		
	//뷰 리졸버 	
	String viewName = mv.getViewName();
	MyView myView=	new MyView("/WEB-INF/views/"+viewName+".jsp");
	myView.render(mv.getModel(),req, resp);
	}

}
