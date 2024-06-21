package com.exam.service;

import java.util.List;

import com.exam.dto.CartDTO;

public interface CartService {

	public int cartAdd(CartDTO dto);
	public List<CartDTO> cartList(String userid);
	public int deleteCart(CartDTO cartDTO);
	//주문 후 장바구니 삭제
	public int deleteCartItemsByUserId(String userid);
	// 특정 회원의 장바구니 조회
	public List<CartDTO> findCartItemsByUserId(String userid);
}
