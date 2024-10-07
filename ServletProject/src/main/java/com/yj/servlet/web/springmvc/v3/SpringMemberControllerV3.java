package com.yj.servlet.web.springmvc.v3;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.yj.servlet.domain.member.Member;
import com.yj.servlet.domain.member.MemberRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/springmvc/v3/members")
public class SpringMemberControllerV3 {
	private MemberRepository memberRepository = MemberRepository.getInstance();
	
	@RequestMapping(value ="/new-form",method = RequestMethod.GET)
	public String newForm() {
		return "new-form";
	}
	
	@RequestMapping
	public String b(Model model) {
		// TODO Auto-generated method stub
		
		List<Member> members= memberRepository.findAll();
		
		
		model.addAttribute("members",members);
		
		
		
		return "members";
	}
	

	@RequestMapping("/save")
	public String c(@RequestParam("username") String username,@RequestParam("age") int age ,Model model) {
		// TODO Auto-generated method stub
		
		
		
		Member member = new Member(username, age);
		memberRepository.save(member);	
		model.addAttribute("member",member);
	
		
		return "save-result";
	}
}
