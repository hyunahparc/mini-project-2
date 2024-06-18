package com.exam.controller;


import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	// @ResponseBody 붙인 이유???
	public @ResponseBody String idCheck(@RequestParam String userid) {
		MemberDTO dto = memberService.idCheck(userid);
		String mesg = "사용가능";
		if(dto!=null) {
			mesg = "사용불가";
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
		
		if(result.hasErrors()) {
			return "memberForm";
		}
		
		// DB 연동
		logger.info("logger:signup:{}", dto);
		int n = memberService.memberAdd(dto);
		
		
		return "redirect:loginForm";
	}
	
	@GetMapping("mypage")
	public String mypage(ModelMap m) {
		
		// 세션에 저장된 MemberDTO 얻어와서 뿌려주기
		// @SessionAttributes 설정하고 ModelMap 만들어서 가져오기
		MemberDTO dto = (MemberDTO) m.getAttribute("login");
		logger.info("logger:mypage:{}", dto);
		
		String userid = dto.getUserid();
		
		MemberDTO searchDTO = memberService.mypage(userid);
		m.addAttribute("login", searchDTO);
		
		return "mypage";
	}
	
}
