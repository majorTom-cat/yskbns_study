package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.domain.Member;
import com.example.demo.service.MemberService;


@Controller
public class MemberController {

	private final MemberService memberService;

	//@Autowired
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@GetMapping(value = "/members/new")
	public String createForm() {
		return "members/createMemberForm";
	}
	
	/**
	 * 회원 컨트롤러에서 회원을 실제 등록하는 기능
	 * @param MemberForm form
	 * @return "redirect:/"
	 */
	@PostMapping(value = "/members/new")
	public String create(MemberForm form) {
		
		Member member = new Member();
		member.setName(form.getName());
		
		memberService.join(member);
		
		return "redirect:/";
	}
	
	/**
	 * 회원 컨트롤러에서 조회 기능
	 * @param Model model
	 * @return "members/memberList"
	 */
	@GetMapping(value = "/members")
	public String list(Model model) {
		List<Member> members = memberService.findMembers();
		model.addAttribute("members", members);
		return "members/memberList";
	}
	
}
