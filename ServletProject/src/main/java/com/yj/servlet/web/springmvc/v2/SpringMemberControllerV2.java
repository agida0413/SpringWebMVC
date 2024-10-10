package com.yj.servlet.web.springmvc.v2;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.yj.servlet.domain.member.Member;
import com.yj.servlet.domain.member.MemberRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@Controller
@RequestMapping("/springmvc/v2/members")
public class SpringMemberControllerV2 {
	
	private MemberRepository memberRepository = MemberRepository.getInstance();
	
	@RequestMapping("/new-form")
	public ModelAndView newForm() {
		return new ModelAndView("new-form");
	}
	
	@RequestMapping
	public ModelAndView b(HttpServletRequest request,HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		List<Member> members= memberRepository.findAll();
		ModelAndView mv= new ModelAndView("members");
		
		mv.addObject("members",members);
		
		
		return mv;
	}
	

	@RequestMapping("/save")
	public ModelAndView c(HttpServletRequest request,HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String username= request.getParameter("username");
		int age=Integer.parseInt(request.getParameter("age"));
		
		Member member = new Member(username, age);
		memberRepository.save(member);	
		ModelAndView mv= new ModelAndView("save-result");
		
		mv.addObject("member",member);
		
		return mv;
	}
}
