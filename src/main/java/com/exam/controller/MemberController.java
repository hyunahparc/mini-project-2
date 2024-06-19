package com.exam.controller;


import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.exam.dto.MemberDTO;
import com.exam.service.MemberService;

@Controller
// 세션에 저장한 login 값 얻어오는 방법
@SessionAttributes(names= {"login"})
public class MemberController{
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	// MemberService 주입해서 연동시키기 (생성자로)
	MemberService memberService;
	
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}

	
	@GetMapping("/idCheck")
	public @ResponseBody String idCheck(@RequestParam String userid) {
		MemberDTO dto = memberService.idCheck(userid);
		String mesg = "사용 가능합니다.";
		if(dto!=null) {
			mesg = "이미 등록된 아이디입니다.";
		}
		
		return mesg;
	}
	
	
	@GetMapping("/signup")
	public String signupForm(ModelMap m) {
		
		MemberDTO dto = new MemberDTO();
		m.addAttribute("memberDTO", dto);
		return "memberForm";
	}
	
	@PostMapping("/signup")
	public String signup(@Valid MemberDTO dto, BindingResult result) {
						//유효성검사(@valid) 후 result는 검사한 결과 담는 변수. hasErrors이용해서 처리.(valid다음순서로 와야함)
		if(result.hasErrors()) {
			return "memberForm";
		}
		
		// DB 연동
		logger.info("logger:signup:{}", dto);
		
		//비번 암호화
		String encptPw = new BCryptPasswordEncoder().encode(dto.getPasswd());
		dto.setPasswd(encptPw);
		
		int n = memberService.memberAdd(dto);
		return "redirect:login";
	}
	
	@GetMapping("/mypage")
	public String mypage(ModelMap m) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		MemberDTO dto = (MemberDTO)auth.getPrincipal();
		
		String userid = dto.getUserid();
		
		MemberDTO mypageDTO = memberService.mypage(userid);
		m.addAttribute("mypage", mypageDTO);
		
		return "mypage";
	}
	
}
