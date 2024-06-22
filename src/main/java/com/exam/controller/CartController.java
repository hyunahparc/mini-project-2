package com.exam.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.exam.dto.CartDTO;
import com.exam.dto.MemberDTO;
import com.exam.service.CartService;

@Controller
//@SessionAttributes(names = { "login" })
public class CartController {

	Logger logger = LoggerFactory.getLogger(getClass());

	CartService cartService;

	public CartController(CartService cartService) {
		this.cartService = cartService;
	}

	@PostMapping("/cartAdd")
	public String cartAdd(ModelMap m, CartDTO cartDTO) {

		// 세션에 저장된 MemberDTO 얻어와서 뿌려주기 (userid 사용하기 위해)
		// @SessionAttributes 설정하고 ModelMap 만들어서 가져오기
		// MemberDTO memberDTO = (MemberDTO) m.getAttribute("login");

		// Security 적용 후 세션에 저장된 MemberDTO 얻어오는 방법
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		MemberDTO memberDTO = (MemberDTO) auth.getPrincipal();

		logger.info("logger:CartController::MemberDTO:{}", memberDTO);

		String userid = memberDTO.getUserid();
		cartDTO.setUserid(userid);

		int n = cartService.cartAdd(cartDTO);

		return "goods/cartAddSuccess";
	}

	@GetMapping("/cartList")
	public String cartList(ModelMap m) {

		// Security 적용 후 세션에 저장된 MemberDTO 얻어오기
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		MemberDTO memberDTO = (MemberDTO) auth.getPrincipal();

		// 로그인 된 userid 값을 DB에서 조회
		String userid = memberDTO.getUserid();

		List<CartDTO> cartList = cartService.cartList(userid);

		m.addAttribute("cartList", cartList);

		return "cartList";
	}

	// 카트에서 상품 선택 후 삭제
	@PostMapping("/deleteCart")
	public String deleteByNum(ModelMap m, CartDTO cartDTO, @RequestParam(value = "chbox[]") List<String> chArr) {

		// 로그인 정보 받아오기
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		MemberDTO memberDTO = (MemberDTO) auth.getPrincipal();

		String userid = memberDTO.getUserid(); // 로그인 되어있는 아이디

		cartDTO.setUserid(userid);

		int cartNum = 0;

		for (String i : chArr) {
			cartNum = Integer.parseInt(i);

			// logger.info("logger:CartController::cartNum:{}", cartNum);
			cartDTO.setNum(cartNum);
			cartService.deleteCart(cartDTO);
		}

		return "redirect:cartList";
	}

}
