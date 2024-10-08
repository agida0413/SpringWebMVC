package com.yj.servlet.web.frontcontroller.v4;

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
import com.yj.servlet.web.frontcontroller.v4.controller.MemberFormControllerV4;
import com.yj.servlet.web.frontcontroller.v4.controller.MemberListControllerV4;
import com.yj.servlet.web.frontcontroller.v4.controller.MemberSaveControllerV4;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet(name="frontControllerServletV4", urlPatterns = "/front-controller/v4/*")
public class FrontControllerServletV4 extends HttpServlet {
	private Map<String, ControllerV4> controllerMap = new HashMap<>();
	
	public FrontControllerServletV4(){
		controllerMap.put("/front-controller/v4/members/new-form",new MemberFormControllerV4());
		controllerMap.put("/front-controller/v4/members/save",new MemberSaveControllerV4());
		controllerMap.put("/front-controller/v4/members",new MemberListControllerV4());
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI(); 
		ControllerV4 controller=controllerMap.get(url);
			if(controller==null) {
				resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
				return;
			}
		//paramMap	
		Map<String, String> paramMap = new HashMap<>();	
		Map<String, Object> model = new HashMap<>();
		
		req.getParameterNames().asIterator()
		.forEachRemaining(paramName -> paramMap.put(paramName, req.getParameter(paramName)));
			
		String path = controller.process(paramMap,model);
		
	//뷰 리졸버 	
	String viewName = path;
	MyView myView=	new MyView("/WEB-INF/views/"+viewName+".jsp");
	myView.render(model,req, resp);
	}

}
