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
	public int orderAdd(OrderDTO orderDTO) {
		return orderMapper.orderAdd(orderDTO);
	}

	@Override
	public int deleteCartById(String userid) {
		return orderMapper.deleteCartById(userid);
	}

}