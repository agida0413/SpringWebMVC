package com.yj.servlet.web.frontcontroller.v2.controller;

import java.io.IOException;

import com.yj.servlet.domain.member.Member;
import com.yj.servlet.domain.member.MemberRepository;
import com.yj.servlet.web.frontcontroller.MyView;
import com.yj.servlet.web.frontcontroller.v1.ControllerV1;
import com.yj.servlet.web.frontcontroller.v2.ControllerV2;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MemberSaveControllerV2  implements ControllerV2{
	private MemberRepository memberRepository = MemberRepository.getInstance();
	@Override
	public MyView process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		int age=Integer.parseInt(req.getParameter("age"));
		
		Member member= new Member(username, age);
		memberRepository.save(member);
		
		req.setAttribute("member", member);
		
		return new MyView("/WEB-INF/views/save-result.jsp");
	
		
	}

}
