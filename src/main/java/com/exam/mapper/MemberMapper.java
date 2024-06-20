package com.exam.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.exam.dto.MemberDTO;

@Mapper
public interface MemberMapper {

	// mapper.xml의 resultType, id, (parameterType) 그대로
	public MemberDTO idCheck(String unserid);
	public int memberAdd(MemberDTO dto);
	public MemberDTO login(Map<String, String> map);
	
	public MemberDTO mypage(String userid);
	public int mypageUpdate(MemberDTO dto);
	
}
