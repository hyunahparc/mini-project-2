package com.exam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.exam.dto.OrderDTO;

@Mapper
public interface OrderMapper {

	// 주문 목록 보기
	public List<OrderDTO> orderList(String userid);

	// 주문 목록 추가(전체 추가)
	public int orderAddById(String userid);

	// 주문 목록에 추가(선택 추가)
	public int orderAddSelected(OrderDTO orderDTO);
	
	// 주문 후 장바구니 삭제 (전체 삭제)
	public int deleteCartById(String userid);

	// 주문 후 장바구니 삭제 (선택 삭제)
	public int deleteCartSelected(OrderDTO orderDTO);
}
