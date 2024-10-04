package com.yj.servlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
@ServletComponentScan //서블릿 자동등록 
@SpringBootApplication
public class ServletProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServletProjectApplication.class, args);
	}

}
