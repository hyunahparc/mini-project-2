package com.exam.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.exam.dto.GoodsDTO;
import com.exam.service.GoodsService;

@Controller
public class MainController {

	Logger logger = LoggerFactory.getLogger(getClass());
	
	// GoodsService 주입해서 연동시키기 (생성자로)
	GoodsService goodsService;
	
	public MainController(GoodsService goodsService) {
		this.goodsService = goodsService;
	}

	// category 정하지 않았을 때(null) 기본값 top
	// required 디폴트가 true라서 null이 와도 될 수 있게 false 지정
	@GetMapping("/main")
	public String main(@RequestParam(required = false, defaultValue = "jelly") String gCategory
			, ModelMap m) {
		
		// ModelMap을 만들고 goodsList에 저장해서 main.jsp로 보내줌 
		List<GoodsDTO> goodsList = goodsService.goodsList(gCategory);
		m.addAttribute("goodsList", goodsList);
		
		return "main";
	}
	
	
}
