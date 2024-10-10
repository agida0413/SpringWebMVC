package com.yj.servlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
@ServletComponentScan //서블릿 자동등록 
@SpringBootApplication
public class ServletProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServletProjectApplication.class, args);
	}

	@Bean
	ViewResolver internealResourceViewResolver() {
		return new InternalResourceViewResolver("/WEB-INF/views/", ".jsp");
	}
	

}