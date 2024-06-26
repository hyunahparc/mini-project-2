package com.exam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.exam.dto.GoodsDTO;

@Mapper
public interface GoodsMapper {

	// mapper.xml의 resultType, id, (parameterType) 그대로
	public List<GoodsDTO> goodsList(String gCategory);
	public GoodsDTO goodsDetail(String gCode);
	
	
}
