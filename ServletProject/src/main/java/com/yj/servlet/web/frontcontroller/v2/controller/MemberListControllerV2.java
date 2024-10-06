package com.yj.servlet.web.frontcontroller.v2.controller;

import java.io.IOException;
import java.util.List;

import com.yj.servlet.domain.member.Member;
import com.yj.servlet.domain.member.MemberRepository;
import com.yj.servlet.web.frontcontroller.MyView;
import com.yj.servlet.web.frontcontroller.v1.ControllerV1;
import com.yj.servlet.web.frontcontroller.v2.ControllerV2;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MemberListControllerV2 implements ControllerV2{
	private MemberRepository memberRepository = MemberRepository.getInstance();
	@Override
	public MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		 System.out.println("MvcMemberListServlet.service");
		 List<Member> members = memberRepository.findAll();
		 request.setAttribute("members", members);
		 
		 return new MyView("/WEB-INF/views/members.jsp");
		
	}

}
