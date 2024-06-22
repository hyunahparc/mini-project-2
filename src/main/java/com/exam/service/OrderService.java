package com.exam.service;

import java.util.List;

import com.exam.dto.OrderDTO;

public interface OrderService {
	
	public List<OrderDTO> orderList(String userid); 
	public int orderAddById(String userid);
	public int orderAddSelected(OrderDTO orderDTO);
	public int deleteCartById(String userid);
	public int deleteCartSelected(OrderDTO orderDTO);


}
