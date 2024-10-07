package com.yj.servlet.web.frontcontroller.v4.controller;

import java.util.List;
import java.util.Map;

import com.yj.servlet.domain.member.Member;
import com.yj.servlet.domain.member.MemberRepository;
import com.yj.servlet.web.frontcontroller.ModelView;
import com.yj.servlet.web.frontcontroller.v3.ControllerV3;
import com.yj.servlet.web.frontcontroller.v4.ControllerV4;

public class MemberListControllerV4 implements ControllerV4{
	private MemberRepository memberRepository = MemberRepository.getInstance();
	@Override
	public String process(Map<String, String> paramMap, Map<String, Object> model) {
		// TODO Auto-generated method stub
		
		List<Member> members= memberRepository.findAll();
		model.put("members", members);
	
		return "members";
	}

}
