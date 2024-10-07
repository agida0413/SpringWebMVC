package com.yj.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class MemberRepositoryTest {

	MemberRepository memberRepository= MemberRepository.getInstance();
	
	@AfterEach
	void afterEach() {
		memberRepository.clearStore();
	}
	
	@Test
	void save() {
		//given
		Member member = new Member("hello", 0);
		
		Member saveMameber= memberRepository.save(member);
		
		Member findMember = memberRepository.findById(saveMameber.getId());
		Assertions.assertThat(findMember).isEqualTo(saveMameber);
		
	}
	
}
