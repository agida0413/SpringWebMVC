package com.yj.basic.request;

import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.nio.charset.StandardCharsets;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.ServletInputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class RequestBodyStringController {

	
	@PostMapping("/request-body-string-v1")
	public void requestBodyString(HttpServletRequest request, HttpServletResponse response) throws IOException{
		ServletInputStream inputStream=request.getInputStream();
		String messageBody =StreamUtils.copyToString(inputStream,StandardCharsets.UTF_8);
	
		log.info("messagebody ={}",messageBody);
		
		response.getWriter().write("OK");
	}
	
	
	@PostMapping("/request-body-string-v2")
	public void requestBodyStringV2(InputStream inputStream,Writer responseWriter) throws IOException{
		
		String messageBody =StreamUtils.copyToString(inputStream,StandardCharsets.UTF_8);
	
		log.info("messagebody ={}",messageBody);
		
		responseWriter.write("OK");
	}
	
	@PostMapping("/request-body-string-v3")
	public HttpEntity<String> requestBodyStringV3(RequestEntity<String> httpEntity) throws IOException{
		
		String body = httpEntity.getBody();
		
		log.info("messagebody ={}",body);
		
		return new ResponseEntity<>("ok",HttpStatus.OK);
	}
	
	@ResponseBody
	@PostMapping("/request-body-string-v4")
	public String requestBodyStringV4(@RequestBody String body) throws IOException{
		

	
		log.info("messagebody ={}",body);
		
		return "OK";
	}
}
