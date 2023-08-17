package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import com.example.demo.domain.Member;

import jakarta.persistence.EntityManager;

public class JpaMemberRepository implements MemberRepository {
	
	//JPA는 EntityManager로 모든게 동작
	private final EntityManager em;
	
	public JpaMemberRepository(EntityManager em) {
		this.em = em;
	}
	
	public Member save(Member member) {
		em.persist(member);
		return member;
	}
	
	public Optional<Member> findById(Long id) {
		Member member = em.find(Member.class, id); // 조회(조회할 타입, 식별자)
		return Optional.ofNullable(member);
	}
	
	public List<Member> findAll() {
		// id는 pk지만 name은 아니므로 jpql이라는 sql이랑 비슷한 걸 써야함. 객체 자체를 매핑
		return em.createQuery("select m from Member m", Member.class)
				.getResultList();
	}
	
	public Optional<Member> findByName(String name) {
		// id는 pk지만 name은 아니므로 jpql이라는 sql이랑 비슷한 걸 써야함. 객체 자체를 매핑
		List<Member> result = em.createQuery("select m from Member m where m.name = :name", Member.class)
								.setParameter("name", name)
								.getResultList();
		return result.stream().findAny();
	}
}
