package com.exam.dto;

import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.type.Alias;

@Alias("OrderDTO")
public class OrderDTO {
	int orderid;
	String userid;
	LocalDate orderDate;
	String username;
	String post;
	String addr1;
	String addr2;
	String phone1;
	String phone2;
	String phone3;
	String point;

	List<CartDTO> list;
    private MemberDTO member;


	public OrderDTO() { }

	public OrderDTO(int orderid, String userid, LocalDate orderDate, String username, String post, String addr1,
			String addr2, String phone1, String phone2, String phone3, String point, List<CartDTO> list) {
		this.orderid = orderid;
		this.userid = userid;
		this.orderDate = orderDate;
		this.username = username;
		this.post = post;
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.phone3 = phone3;
		this.point = point;
		this.list = list;
	}

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getAddr1() {
		return addr1;
	}

	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}

	public String getAddr2() {
		return addr2;
	}

	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public String getPhone3() {
		return phone3;
	}

	public void setPhone3(String phone3) {
		this.phone3 = phone3;
	}

	public String getPoint() {
		return point;
	}

	public void setPoint(String point) {
		this.point = point;
	}

	public List<CartDTO> getList() {
		return list;
	}

	public void setList(List<CartDTO> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "OrderDTO [orderid=" + orderid + ", userid=" + userid + ", orderDate=" + orderDate + ", username="
				+ username + ", post=" + post + ", addr1=" + addr1 + ", addr2=" + addr2 + ", phone1=" + phone1
				+ ", phone2=" + phone2 + ", phone3=" + phone3 + ", point=" + point + ", list=" + list + "]";
	}
	
	
	
	  // getter and setter for member
  public MemberDTO getMember() {
      return member;
  }

  public void setMember(MemberDTO member) {
      this.member = member;
  }
	
	
	
}

