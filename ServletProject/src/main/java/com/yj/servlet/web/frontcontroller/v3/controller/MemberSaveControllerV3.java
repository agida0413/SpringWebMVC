package com.yj.servlet.web.frontcontroller.v3.controller;

import java.util.Map;

import com.yj.servlet.domain.member.Member;
import com.yj.servlet.domain.member.MemberRepository;
import com.yj.servlet.web.frontcontroller.ModelView;
import com.yj.servlet.web.frontcontroller.v3.ControllerV3;

public class MemberSaveControllerV3 implements ControllerV3{
	private MemberRepository memberRepository = MemberRepository.getInstance();
	@Override
	public ModelView process(Map<String, String> paramMap) {
		// TODO Auto-generated method stub
		
		String username= paramMap.get("username");
		int age=Integer.parseInt(paramMap.get("age"));
		
		Member member = new Member(username, age);
		
		ModelView mv= new ModelView("save-result");
		mv.getModel().put("member", member);
		return mv;
	}

}
