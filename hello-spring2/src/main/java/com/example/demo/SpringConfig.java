package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.repository.MemberRepository;
import com.example.demo.service.MemberService;

@Configuration
public class SpringConfig {
//	private final DataSource dataSource;
//	private final EntityManager em;
//
//	
//	public SpringConfig(DataSource dataSource, EntityManager em) {
//		this.dataSource = dataSource;
//		this.em = em;
//	}
	
//	private EntityManager em;
//	
//	@Autowired
//	public SpringConfig(EntityManager em) {
//		this.em = em;
//	}
	
	private final MemberRepository memberRepository;
	
	//@Autowired
	public SpringConfig(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}
	
	@Bean
	public MemberService memberService() {
		return new MemberService(memberRepository);
	}
//	
//	@Bean
//	public MemberRepository memberRepository() {
//		//return new MemoryMemberRepository();
//		//return new JpaMemberRepository(em);
//		//return new JdbcTemplateMemberRepository(dataSource);
//		//return new JpaMemberRepository();
//	}
	
}
