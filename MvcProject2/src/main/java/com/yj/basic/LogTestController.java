package com.yj.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class LogTestController {

	
	@RequestMapping("/log-test")
	public String logTest() {
		
		//레벨 순 , 운영서버, 개발서버 나눠서 추적하기위해 , 상황에 맞게 조절
		String name ="Spring";
		log.trace("trace log={}",name);
		log.debug("debug log={}",name);
		log.info("info log={}",name);
		log.warn("warn log={}",name);
		log.error("error log={}",name);
		return "OK";
	}
}
