package com.exam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.exam.dto.OrderDTO;

@Mapper
public interface OrderMapper {

	List<OrderDTO> findOrderByUserIdOnCart(String userid);

	void insertOrder(OrderDTO orderDTO);

}