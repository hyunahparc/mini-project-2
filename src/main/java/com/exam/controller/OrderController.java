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

import com.exam.dto.MemberDTO;
import com.exam.dto.OrderDTO;
import com.exam.service.OrderService;

@Controller
public class OrderController {

	Logger logger = LoggerFactory.getLogger(getClass());
	
	OrderService orderService;

	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}

	@PostMapping("/orderAddSelected")
	public String orderAddSelected(OrderDTO orderDTO, @RequestParam(value = "chbox[]") List<String> chArr) {
		
		// Security 적용 후 세션에 저장된 MemberDTO 얻어오기
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		MemberDTO memberDTO = (MemberDTO) auth.getPrincipal();
		
		// 로그인 된 userid 값을 DB에서 조회		
		String userid = memberDTO.getUserid();
		
		logger.info("logger:orderController::MemberDTO:{}", memberDTO);
		
		orderDTO.setUserid(userid);
		
		int cartNum = 0; 
		
		for (String i : chArr) {
			cartNum = Integer.parseInt(i);
			
			orderDTO.setNum(cartNum);
			orderService.orderAddSelected(orderDTO);

//			orderService.deleteCartSelected(orderDTO);
			

		}
		
		return "order/orderAddSuccess";

	}


	@GetMapping("/orderList")
	public String orderListForm(ModelMap m) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		MemberDTO memberDTO = (MemberDTO) auth.getPrincipal();
		String userid = memberDTO.getUserid();
		
		List<OrderDTO> orderList = orderService.orderList(userid);
		m.addAttribute("orderList", orderList);

		return "orderList";
	}


	
	@PostMapping("/orderAddById")
	public String orderAddById(OrderDTO orderDTO) {
		
		// Security 적용 후 세션에 저장된 MemberDTO 얻어오기
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		MemberDTO memberDTO = (MemberDTO) auth.getPrincipal();
		
		// 로그인 된 userid 값을 DB에서 조회		
		String userid = memberDTO.getUserid();
		
		orderDTO.setUserid(userid);
		
		int n = orderService.orderAddById(userid); //주문하기
		
		if(n>0) orderService.deleteCartById(userid); //주문 성공 시 카트 전체 삭제
		
		return "order/orderAddSuccess";
	}

}
