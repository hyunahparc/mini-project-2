package com.exam.service;

import java.util.List;

import com.exam.dto.OrderDTO;

public interface OrderService {
	

    public void createOrder(OrderDTO orderDTO);
    
    public List<OrderDTO> findOrderByUserId(String userid);

}
