package com.exam.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.exam.dto.GoodsDTO;
import com.exam.service.GoodsService;

@Controller
public class GoodsDetailController {

	Logger logger = LoggerFactory.getLogger(getClass());
	
	// GoodsService 주입해서 연동시키기 (생성자로)
	GoodsService goodsService;

	public GoodsDetailController(GoodsService goodsService) {
		this.goodsService = goodsService;
	}
	
	@GetMapping("/goodsDetail")
	public String goodDetail(ModelMap m, String gCode) {
		
		logger.info("logger:gCode:{}",gCode);
		GoodsDTO dto = goodsService.goodsDetail(gCode);
		m.addAttribute("goodsDetail", dto);
		
		return "goodsDetail";
	}

	
	
	
}
