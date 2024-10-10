package com.yj.basic.practice;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.ServletInputStream;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/test")
public class PracticeController {

	@PostMapping
	public void hashmap(@RequestBody byte[] file) throws IOException {
		//6034
		//9661
		
		log.info("file length : {}" , file.length);
		
		
	}
	
	@PostMapping("/inst")
	public void inst(HttpServletRequest request) throws IOException {
		ServletInputStream inputStream = request.getInputStream();
		String bodyMessage = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
	
	}
	
	@PostMapping("/test2")
	public ResponseEntity<?> test2(@CookieValue(value = "testcookie",required = false) String cookie , @RequestHeader(value="headerVal",required = false) String headerVal){
		Map<String, Object> hasMap = new HashMap<>();
		String value1 = "val";
		List<String> list = new ArrayList<>();
		list.add("123");
		list.add("333");
		
		hasMap.put("value1", value1);
		hasMap.put("value2", list);
		hasMap.put("headerValue", headerVal);
		hasMap.put("cookieVal", cookie);
	
		return ResponseEntity.ok().body(hasMap);
	}
	
	@GetMapping("view")
	public String test5(Model model) {
		
		model.addAttribute("testData","ddd");
		model.addAttribute("loop","l");
		
		return "response/test/test";
	}
	
	
}
