package com.exam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.exam.dto.CartDTO;

@Mapper
public interface CartMapper {

	// mapper.xml의 resultType, id, (parameterType) 그대로
	// 장바구니 저장
	public int cartAdd(CartDTO dto);
	
	// 장바구니 목록 보기
	public List<CartDTO> cartList(String userid); 
	
	// 장바구니 상품 개별 삭제
	public int deleteByNum(int num);

}
