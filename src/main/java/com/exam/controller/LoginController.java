package com.exam.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.exam.service.MemberService;

@Controller
@SessionAttributes(names = { "login" })
public class LoginController {

	Logger logger = LoggerFactory.getLogger(getClass());

	// MemberService 연결 (생성자 사용)
	MemberService memberService;

	public LoginController(MemberService memberService) {
		this.memberService = memberService;
	}

	@GetMapping(value = { "/login" })
	public String loginForm(HttpSession session) {
		
		return "loginForm";
	}

	@PostMapping(value = { "/login_fail" })
	public String showlogin_failPage(HttpSession session) {
		logger.info("logger:showlogin_failPage");
		
		String errorMessage = "아이디와 비밀번호를 확인해주세요!";
		session.setAttribute("errorMessage", errorMessage);
		
		return "redirect:login";
	}

	@GetMapping(value = { "/login_success" })
	public String showlogin_successPage() {
		logger.info("logger:showlogin_successPage");
		return "redirect:main";
	}

	@GetMapping("/logout")
	// 세션에 저장된 login 값을 삭제하려면 SessionStatus 사용
	public String logout(SessionStatus status) {
		status.setComplete();

		return "redirect:main";
	}

}
