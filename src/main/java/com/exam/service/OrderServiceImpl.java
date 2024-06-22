package com.exam.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.exam.dto.OrderDTO;
import com.exam.mapper.OrderMapper;

@Service
public class OrderServiceImpl implements OrderService {

	OrderMapper orderMapper;

	public OrderServiceImpl(OrderMapper orderMapper) {
		this.orderMapper = orderMapper;
	}

	@Override
	public List<OrderDTO> orderList(String userid) {
		return orderMapper.orderList(userid);
	}

	@Override
	public int orderAddById(String userid) {
		return orderMapper.orderAddById(userid);
	}

	@Override
	public int orderAddSelected(OrderDTO orderDTO) {
		return orderMapper.orderAddSelected(orderDTO);
	}

	@Override
	public int deleteCartById(String userid) {
		return orderMapper.deleteCartById(userid);
	}

	@Override
	public int deleteCartSelected(OrderDTO orderDTO) {
		return orderMapper.orderAddSelected(orderDTO);
	}
	
}