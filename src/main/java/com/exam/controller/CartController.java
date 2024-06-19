package com.exam.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.exam.dto.CartDTO;
import com.exam.dto.MemberDTO;
import com.exam.mapper.CartMapper;
import com.exam.service.CartService;
import com.exam.service.CartServiceImpl;

@Controller
@SessionAttributes(names = { "login" })
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
		// MemberDTO memberDTO = (MemberDTO) m.getAttribute("login");
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		MemberDTO memberDTO = (MemberDTO) auth.getPrincipal();

		// logger.info("logger:CartController::MemberDTO:{}", memberDTO);

		String userid = memberDTO.getUserid();
		cartDTO.setUserid(userid);

		int n = cartService.cartAdd(cartDTO);

		return "goods/cartAddSuccess";
	}

	
	@GetMapping("/cartList")
	public String cartList(ModelMap m) {

		// 세션에 저장된 MemberDTO 얻어와서 뿌려주기 (userid 사용하기 위해)
		// @SessionAttributes 설정하고 ModelMap 만들어서 가져오기
		// MemberDTO memberDTO = (MemberDTO) m.getAttribute("login");
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		MemberDTO memberDTO = (MemberDTO) auth.getPrincipal();

		// logger.info("logger:CartController::MemberDTO:{}", memberDTO);

			// 로그인한 userid 값을 얻어서 DB에서 조회한다

			String userid = memberDTO.getUserid();
			// logger.info("logger:CartController::userid:{}", userid);
			
			List<CartDTO> cartList = cartService.cartList(userid);
			// logger.info("logger:CartController::cartList:{}", cartList);
			
			m.addAttribute("cartList", cartList);

		return "cartList";
	}

}
