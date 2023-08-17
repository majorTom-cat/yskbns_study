package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.Member;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {
	// SpringDataJpa가 자동으로 구현체를 만들어 빈으로 등록해둠. 가져다 쓰기만 하면 됨
	
	Optional<Member> findByName(String name);
	
}
