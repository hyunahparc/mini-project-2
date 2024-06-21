package com.exam.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exam.dto.MemberDTO;
import com.exam.dto.OrderDTO;
import com.exam.mapper.CartMapper;
import com.exam.mapper.MemberMapper;
import com.exam.mapper.OrderMapper;

@Service
public class OrderServiceImpl implements OrderService {
	
    private final OrderMapper orderMapper;
    private final MemberMapper memberMapper;
    private final CartMapper cartMapper;


    public OrderServiceImpl(OrderMapper orderMapper, MemberMapper memberMapper, CartMapper cartMapper) {
		this.orderMapper = orderMapper;
		this.memberMapper = memberMapper;
		this.cartMapper = cartMapper;
	}



    @Transactional
    @Override
    public void createOrder(OrderDTO orderDTO) {
        //주문 테이블에 주문 정보 삽입
        orderMapper.insertOrder(orderDTO);

        // 예시: 장바구니 테이블에서 해당 사용자의 상품 삭제
        cartMapper.deleteCartItemsByUserId(orderDTO.getUserid());
    }

    @Override
    public List<OrderDTO> findOrderByUserId(String userid) {
        List<OrderDTO> orders = orderMapper.findOrderByUserIdOnCart(userid);
        
        // 회원 정보를 가져와서 OrderDTO에 추가
        MemberDTO member = memberMapper.getMemberByUserId(userid);
        for (OrderDTO order : orders) {
            order.setMember(member); // OrderDTO에 회원 정보 설정
        }
        
        return orders;
    }
}