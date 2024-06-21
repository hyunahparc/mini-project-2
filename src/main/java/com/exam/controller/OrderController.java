package com.exam.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.exam.dto.CartDTO;
import com.exam.dto.MemberDTO;
import com.exam.dto.OrderDTO;
import com.exam.service.OrderService;

@Controller
public class OrderController {

	Logger logger = LoggerFactory.getLogger(getClass());
//	logger.info("logger:CartController:cartNum:{}", cartNum);

	OrderService orderservice;

	public OrderController(OrderService orderservice) {
		this.orderservice = orderservice;
	}

	@GetMapping("/orderList")
	public String orderListForm(ModelMap m) {
		CartDTO dto = new CartDTO();
		m.addAttribute("CartDTO", dto);
		return "orderList";
	}

	@PostMapping("/orderList")
	public String orderList(ModelMap m) {

		// Security 적용 후 세션에 저장된 MemberDTO 얻어오는 방법
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		MemberDTO memberDTO = (MemberDTO) auth.getPrincipal();

		// 로그인한 userid 값을 얻어서 DB에서 조회한다
		String userid = memberDTO.getUserid();

		List<OrderDTO> orderList = orderservice.findOrderByUserId(userid);
		// logger.info("logger:CartController::cartList:{}", cartList);

		
		m.addAttribute("orderList", orderList);

		return "order/orderList";
	}

	
	@PostMapping("/createOrder")
	public String createOrder(@ModelAttribute("CartDTO") CartDTO cartDTO, ModelMap model) {
		// Security 적용 후 세션에 저장된 MemberDTO 얻어오는 방법
				Authentication auth = SecurityContextHolder.getContext().getAuthentication();
				MemberDTO memberDTO = (MemberDTO) auth.getPrincipal();

				// 로그인한 userid 값을 얻어서 DB에서 조회한다
				String userid = memberDTO.getUserid();
				
				OrderDTO orderDTO = new OrderDTO();
				orderDTO.setUserid(userid);
				
				
				orderservice.createOrder(orderDTO);
				
				
		return "redirect:/main";
	}
	
}
