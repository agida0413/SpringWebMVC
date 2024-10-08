package com.yj.basic.request;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yj.basic.HelloData;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class RequestParamController {
	/*
	 *  요청 파라미터 
	 * 
	 * */
	@RequestMapping("/request-param-v1")
	public void reqeustParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String username = request.getParameter("username");
		int age =Integer.parseInt(request.getParameter("age"));
		log.info("uesename info ={} , age info ={}",username,age);
		
		response.getWriter().write("ok");
	}
	
	@ResponseBody
	@RequestMapping("/request-param-v2")
	public String reqeustParamV2(@RequestParam("username") String memberName, 
								 @RequestParam("age") int age) throws IOException {
		
		log.info("uesename info ={} , age info ={}",memberName,age);
		
		return "OK";
	}
	
	@ResponseBody
	@RequestMapping("/request-param-v3")
	public String reqeustParamV3(@RequestParam String username, 
								 @RequestParam int age) throws IOException {
		
		log.info("uesename info ={} , age info ={}",username,age);
		
		return "OK";
	}
	
	@ResponseBody
	@RequestMapping("/request-param-v4")
	public String reqeustParamV4(@RequestParam("username") String username, 
								 @RequestParam("age") int age) throws IOException {
		
		log.info("uesename info ={} , age info ={}",username,age);
		
		return "OK";
	}
	
	@ResponseBody
	@RequestMapping("/request-param-v5")
	public String reqeustParamV5(@RequestParam(value="username",required = false) String username, 
								 @RequestParam("age") int age) throws IOException {
		
		log.info("uesename info ={} , age info ={}",username,age);
		
		return "OK";
	}
	
	@ResponseBody
	@RequestMapping("/request-param-default")
	public String reqeustDeault(@RequestParam(value="username",required = true, defaultValue = "guest") String username, 
								 @RequestParam(value="age",required = true,defaultValue = "20") int age) throws IOException {
		
		log.info("uesename info ={} , age info ={}",username,age);
		
		return "OK";
	}
	
	@ResponseBody
	@RequestMapping("/request-param-map")
	public String reqeustMap(@RequestParam Map<String, Object> paraMap) throws IOException {
	
		
		
		String username =(String)paraMap.get("username");
		int age = Integer.parseInt((String)paraMap.get("age"));
		log.info("uesename info ={} , age info ={}",username,age);
		
		return "OK";
	}
	
	@ResponseBody
	@RequestMapping("/model-attribute-v1")
	public String modelAttribue(@ModelAttribute HelloData helloData) {
	
		log.info("uesename info ={} , age info ={}",helloData.getUsername(),helloData.getAge());
		return "OK";
	}
	
	@ResponseBody
	@RequestMapping("/model-attribute-v2")
	public String modelAttribue2(HelloData helloData) {
	
		log.info("uesename info ={} , age info ={}",helloData.getUsername(),helloData.getAge());
		return "OK";
	}
} 
