package com.exam.security;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.exam.dto.MemberDTO;
import com.exam.service.MemberService;

@Component
public class AuthProvider implements AuthenticationProvider {

	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	MemberService memberService;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
	
		
		
		String userid = (String)authentication.getPrincipal(); //name="userid"값
		String passwd = (String)authentication.getCredentials();	 //name="passwd"값
		
		MemberDTO dto = memberService.idCheck(userid);
		logger.info("logger:authProviderid:{}",userid);
		logger.info("logger:authProviderpw:{}",passwd);
		
		//로그인 성공시
		UsernamePasswordAuthenticationToken token = null;
		if(dto!=null && new BCryptPasswordEncoder().matches(passwd, dto.getPasswd())) {
			List<GrantedAuthority> list = new ArrayList<>();
			
			list.add(new SimpleGrantedAuthority("USER"));
		
		//암호화된 비번 대신 raw 비번으로 설정
			dto.setPasswd(passwd);
			token = new UsernamePasswordAuthenticationToken(dto, null, list);
					return token;
		
		}
		
	//로그인 실패시
		throw new BadCredentialsException("아이디,비밀번호가 일치하지 않습니다. \n다시 시도하세요.");
		}
		
		

	@Override
	public boolean supports(Class<?> authentication) {
		return true;
	}

}
