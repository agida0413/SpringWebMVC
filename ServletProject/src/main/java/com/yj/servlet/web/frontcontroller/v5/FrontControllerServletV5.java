package com.yj.servlet.web.frontcontroller.v5;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.servlet.HandlerAdapter;

import com.yj.servlet.web.frontcontroller.ModelView;
import com.yj.servlet.web.frontcontroller.MyView;
import com.yj.servlet.web.frontcontroller.v3.ControllerV3;
import com.yj.servlet.web.frontcontroller.v3.controller.MemberFormControllerV3;
import com.yj.servlet.web.frontcontroller.v3.controller.MemberListControllerV3;
import com.yj.servlet.web.frontcontroller.v3.controller.MemberSaveControllerV3;
import com.yj.servlet.web.frontcontroller.v4.controller.MemberFormControllerV4;
import com.yj.servlet.web.frontcontroller.v4.controller.MemberListControllerV4;
import com.yj.servlet.web.frontcontroller.v4.controller.MemberSaveControllerV4;
import com.yj.servlet.web.frontcontroller.v5.adapter.ControllerV3HandlerAdapter;
import com.yj.servlet.web.frontcontroller.v5.adapter.ControllerV4HandlerAdapter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet(name="frontControllerV5", urlPatterns = "/front-controller/v5/*")
public class FrontControllerServletV5 extends HttpServlet{

	private final Map<String, Object> handlerMap = new HashMap<>();
	private final List<MyHandlerAdapter> handlerAdapters=new ArrayList<>();
	
	
	public FrontControllerServletV5(){
		initHandlerMappingMap();
		initHandlereAdapters();
	
	}
	
	private void initHandlerMappingMap() {
		handlerMap.put("/front-controller/v5/v3/members/new-form",new MemberFormControllerV3());
		handlerMap.put("/front-controller/v5/v3/members/save",new MemberSaveControllerV3());
		handlerMap.put("/front-controller/v5/v3/members",new MemberListControllerV3());
	
		
		handlerMap.put("/front-controller/v5/v4/members/new-form",new MemberFormControllerV4());
		handlerMap.put("/front-controller/v5/v4/members/save",new MemberSaveControllerV4());
		handlerMap.put("/front-controller/v5/v4/members",new MemberListControllerV4());
	}
	
	

	private void initHandlereAdapters() {
		handlerAdapters.add(new ControllerV3HandlerAdapter());
		handlerAdapters.add(new ControllerV4HandlerAdapter());
	}
	
	private MyHandlerAdapter getHandlerAdapter(Object handler) {
		for (MyHandlerAdapter myHandlerAdapter : handlerAdapters) {
			if(myHandlerAdapter.supports(handler)) {
				
				return myHandlerAdapter;
			}
		}	
		
		throw new IllegalArgumentException("핸들러 찾을 수 없음"+handler);
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String url = req.getRequestURI(); 
		Object handler=handlerMap.get(url);
			if(handler==null) {
				resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
				return;
			}
			
			MyHandlerAdapter adapter= getHandlerAdapter(handler);
		
			
		ModelView mv= adapter.handle(req, resp, handler);
	
		
	//뷰 리졸버 	
	String viewName = mv.getViewName();
	MyView myView=	new MyView("/WEB-INF/views/"+viewName+".jsp");
	myView.render(mv.getModel(),req, resp);
		
	}
}
