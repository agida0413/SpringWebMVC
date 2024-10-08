package com.yj.basic.response;

import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.function.ServerRequest.Headers;

import com.yj.basic.HelloData;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ResponseBodyController {

	@GetMapping("/response-body-string-v1")
	public void responseBodyV1(HttpServletResponse response) throws IOException{
		response.getWriter().write("OK");
	}
	
	
	@GetMapping("/response-body-string-v2")
	public ResponseEntity<String> responseBodyV2() throws IOException{
		return new ResponseEntity<>("ok",HttpStatus.OK);
	}
	
	@GetMapping("/response-body-string-v3")
	public String responseBodyV3() throws IOException{
		return "OK";
	}
	
	@GetMapping("/response-body-json-v1")
	public ResponseEntity<HelloData> responsebodyjsonv1(HttpServletResponse response){
		HelloData helloData=new HelloData();
		helloData.setUsername("sdas");
		helloData.setAge(20);
		Cookie cookie = new Cookie("test", "zz");
		cookie.setMaxAge(60);
	
		response.addCookie(cookie);
		return  ResponseEntity.ok()
					.header("he", "dd")
					.header("zzz", "zx")
					.body(helloData);
					
	}
	
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	@GetMapping("/response-body-json-v2")
	public HelloData responsebodyjsonv2(){
		HelloData helloData=new HelloData();
		helloData.setUsername("sdas");
		helloData.setAge(20);
		
		return helloData;
	}
}
