package com.exam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.dto.CartDTO;
import com.exam.mapper.CartMapper;

@Service
public class CartServiceImpl implements CartService {
	
	// CartMapper와 연동하기 (생성자 이용)
	CartMapper cartMapper;
	
	public CartServiceImpl(CartMapper cartMapper) {
		this.cartMapper = cartMapper;
	}

	@Override
	public int cartAdd(CartDTO dto) {
		return cartMapper.cartAdd(dto);
	}

	@Override
	public List<CartDTO> cartList(String userid) {
		return cartMapper.cartList(userid);
	}

}
