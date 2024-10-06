package com.yj.servlet.web.servletmvc;

import java.io.IOException;
import java.io.PrintWriter;

import com.yj.servlet.domain.member.Member;
import com.yj.servlet.domain.member.MemberRepository;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet(name="mvcMemberSaveServlet", urlPatterns = "/servlet-mvc/members/save")
public class MvcMemberSaveServlet extends HttpServlet{
	
	private MemberRepository memberRepository=MemberRepository.getInstance();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		int age=Integer.parseInt(req.getParameter("age"));
		
		Member member= new Member(username, age);
		memberRepository.save(member);
		
		req.setAttribute("member", member);
		
		String viewPath="/WEB-INF/views/save-result.jsp";
		RequestDispatcher dispatcher= req.getRequestDispatcher(viewPath);
		dispatcher.forward(req, resp);
		
	}
}
