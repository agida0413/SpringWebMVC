package com.yj.servlet.web.frontcontroller.v3.controller;

import java.util.List;
import java.util.Map;

import com.yj.servlet.domain.member.Member;
import com.yj.servlet.domain.member.MemberRepository;
import com.yj.servlet.web.frontcontroller.ModelView;
import com.yj.servlet.web.frontcontroller.v3.ControllerV3;

public class MemberListControllerV3 implements ControllerV3{
	private MemberRepository memberRepository = MemberRepository.getInstance();
	@Override
	public ModelView process(Map<String, String> paramMap) {
		// TODO Auto-generated method stub
		
		List<Member> members= memberRepository.findAll();
		ModelView mv= new ModelView("members");
		mv.getModel().put("members",members);
		
		
		return mv;
	}

}
