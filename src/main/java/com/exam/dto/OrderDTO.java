package com.exam.dto;

import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.type.Alias;

@Alias("OrderDTO")
public class OrderDTO {
	
	int num;
	String userid;
	String gCode;
	int gAmount;
	LocalDate orderDate;
	
	List<GoodsDTO> goodsList;

	public OrderDTO() {
	}

	public OrderDTO(int num, String userid, String gCode, int gAmount, LocalDate orderDate, List<GoodsDTO> goodsList) {
		this.num = num;
		this.userid = userid;
		this.gCode = gCode;
		this.gAmount = gAmount;
		this.orderDate = orderDate;
		this.goodsList = goodsList;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getgCode() {
		return gCode;
	}

	public void setgCode(String gCode) {
		this.gCode = gCode;
	}

	public int getgAmount() {
		return gAmount;
	}

	public void setgAmount(int gAmount) {
		this.gAmount = gAmount;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public List<GoodsDTO> getGoodsList() {
		return goodsList;
	}

	public void setGoodsList(List<GoodsDTO> goodsList) {
		this.goodsList = goodsList;
	}

	@Override
	public String toString() {
		return "OrderDTO [num=" + num + ", userid=" + userid + ", gCode=" + gCode + ", gAmount=" + gAmount
				+ ", orderDate=" + orderDate + ", goodsList=" + goodsList + "]";
	}


	

//	List<CartDTO> list;
//	List<GoodsDTO> goodsList;
//	List<MemberDTO> memberList;
//	MemberDTO member;


}

