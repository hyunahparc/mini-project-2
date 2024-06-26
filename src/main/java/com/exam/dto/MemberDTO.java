package com.exam.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.apache.ibatis.type.Alias;

@Alias("MemberDTO")
public class MemberDTO {

	@NotBlank (message="아이디를 입력해주세요")
	String userid;
	@Size(min = 4, message = "네 글자 이상 입력해주세요")
	String passwd;
	@NotBlank (message="이름을 입력해주세요")
	String username;
	@NotBlank (message="주소를 입력해주세요")
	String post;
	String addr1;
	String addr2;
	String phone1;
	@NotBlank (message="전화번호를 입력해주세요")
	String phone2;
	@NotBlank (message="전화번호를 입력해주세요")
	String phone3;
	@NotBlank (message="이메일을 입력해주세요")
	String email1;
	@NotBlank (message="이메일을 입력해주세요")
	String email2;
	int point;
	
	
	public MemberDTO() {}


	public MemberDTO(String userid, @Size(min = 4, message = "4글자 이상입니다.") String passwd, String username, String post,
			String addr1, String addr2, String phone1, String phone2, String phone3, String email1, String email2,
			int point) {
		this.userid = userid;
		this.passwd = passwd;
		this.username = username;
		this.post = post;
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.phone3 = phone3;
		this.email1 = email1;
		this.email2 = email2;
		this.point = point;
	}


	public String getUserid() {
		return userid;
	}


	public void setUserid(String userid) {
		this.userid = userid;
	}


	public String getPasswd() {
		return passwd;
	}


	public void setPasswd(String passwd) {
		this.passwd = passwd;
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


	public String getEmail1() {
		return email1;
	}


	public void setEmail1(String email1) {
		this.email1 = email1;
	}


	public String getEmail2() {
		return email2;
	}


	public void setEmail2(String email2) {
		this.email2 = email2;
	}


	public int getPoint() {
		return point;
	}


	public void setPoint(int point) {
		this.point = point;
	}


	@Override
	public String toString() {
		return "MemberDTO [userid=" + userid + ", passwd=" + passwd + ", username=" + username + ", post=" + post
				+ ", addr1=" + addr1 + ", addr2=" + addr2 + ", phone1=" + phone1 + ", phone2=" + phone2 + ", phone3="
				+ phone3 + ", email1=" + email1 + ", email2=" + email2 + ", point=" + point + "]";
	}
	

}
