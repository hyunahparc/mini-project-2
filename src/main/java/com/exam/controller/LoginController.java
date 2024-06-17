package com.exam.controller;


import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.exam.dto.MemberDTO;
import com.exam.service.MemberService;

@Controller
@SessionAttributes(names= {"login"})
public class LoginController {

	Logger logger = LoggerFactory.getLogger(getClass());
	
	// MemberService 연결 (생성자 사용)
	MemberService memberService;
	
	public LoginController(MemberService memberService) {
		this.memberService = memberService;
	}

	@GetMapping("/login")
	public String loginForm() {
		

		
		return "loginForm";
	}
	
	@PostMapping("/login")
	// userid, passwd를 같이 Map에 저장하기
	public String login(@RequestParam Map<String, String> m, ModelMap model) {
		
		//연결
		MemberDTO dto = memberService.login(m);

		// 로그인 성공하면
		if(dto !=null) {
			// session scope에 저장
			// ModelMap을 만들고 @SessionAttributes에 키값 설정하고 model에 저장
			// 디폴트는 request scope이지만, 이 키에 해당하는 건 session scope에 저장이 된다
			model.addAttribute("login", dto);
			
			return "redirect:main";
			
		} 
		
		// 로그인 실패하면
		model.addAttribute("errorMessage", "아이디, 비밀번호가 일치하지 않습니다");
		return "loginForm";
	}
	
	@GetMapping("/logout")
	// 세션에 저장된 login 값을 삭제하려면 SessionStatus 사용
	public String logout(SessionStatus status) {
		status.setComplete();

		
		return "redirect:main";
	}
	
	
}
