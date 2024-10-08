package com.yj.basic.request;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yj.basic.HelloData;

import jakarta.servlet.ServletInputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class RequestBodyJsonController {

	private ObjectMapper objectMapper=new ObjectMapper();
	@ResponseBody
	@PostMapping("/request-body-json-v1")
	public void requestBodyJsonV1(HttpServletRequest request,HttpServletResponse response) throws IOException {
		ServletInputStream inputStream= request.getInputStream();
		String messageBody = StreamUtils.copyToString(inputStream,StandardCharsets.UTF_8 );
		
		log.info(messageBody);
		
		HelloData helloData = objectMapper.readValue(messageBody, HelloData.class);
		log.info(helloData.getUsername());
		
		response.getWriter().write("OK");
		
	}
	
	
	@ResponseBody
	@PostMapping("/request-body-json-v2")
	public String requestBodyJsonV2(@RequestBody String messageBody) throws IOException {
		
		HelloData helloData=objectMapper.readValue(messageBody, HelloData.class);
		
		log.info("username ={} , age={}",helloData.getUsername(),helloData.getAge());
		
		
		return "OK";

	}
	
	
	@ResponseBody
	@PostMapping("/request-body-json-v3")
	public String requestBodyJsonV3(@RequestBody HelloData helloData) throws IOException {
		

		
		log.info("username ={} , age={}",helloData.getUsername(),helloData.getAge());
		
		
		return "OK";

	}
	
	
	@ResponseBody
	@PostMapping("/request-body-json-v4")
	public String requestBodyJsonV4(HttpEntity<HelloData> helloData) throws IOException {
		HelloData he = helloData.getBody();
		
		log.info("username ={} , age={}",he.getUsername(),he.getAge());
		
		
		return "OK";

	}
	
	
	// 응답 메시지 컨버터 동작 기준은 클라이언트 쪽 accept에 따라  , 요청 메시지 컨버터 동작기준은 클라이언트 쪽 content-type에 따라 
	@ResponseBody
	@PostMapping("/request-body-json-v5")
	public HelloData requestBodyJsonV5(HttpEntity<HelloData> helloData) throws IOException {
		HelloData he = helloData.getBody();
		
		log.info("username ={} , age={}",he.getUsername(),he.getAge());
		
		
		return he;

	}
}
