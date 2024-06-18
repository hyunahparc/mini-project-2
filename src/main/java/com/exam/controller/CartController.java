package com.exam.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.exam.dto.CartDTO;
import com.exam.dto.MemberDTO;
import com.exam.service.CartService;

@Controller
@SessionAttributes(names= {"login"})
public class CartController {

	Logger logger = LoggerFactory.getLogger(getClass());
	
	// CartService 연동하기 (생성자 이용)
	CartService cartService;

	public CartController(CartService cartService) {
		this.cartService = cartService;
	}
	
	@PostMapping("/cartAdd")
	public String cartAdd(ModelMap m, CartDTO cartDTO) {
		
		// 세션에 저장된 MemberDTO 얻어와서 뿌려주기 (userid 사용하기 위해)
		// @SessionAttributes 설정하고 ModelMap 만들어서 가져오기
		MemberDTO memberDTO = (MemberDTO) m.getAttribute("login");

		// logger.info("logger:CartController::MemberDTO:{}", memberDTO);
		
		String userid = memberDTO.getUserid();
		cartDTO.setUserid(userid);
		
		int n  = cartService.cartAdd(cartDTO);
		
		return "goods/cartAddSuccess";
	}
	
	
	
	
	
	
	
	
}
