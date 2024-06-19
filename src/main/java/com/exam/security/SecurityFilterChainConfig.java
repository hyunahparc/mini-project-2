package com.exam.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityFilterChainConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		// 커스터마이징 처리

		// 1. 불필요한 인증 제거
		http.authorizeRequests().antMatchers("/goodsDetail*","/login","/main", "/signup", "/webjars/**", "/images/**","/idCheck","/mypage/**","/js/**").permitAll()
				// matchers 안에 있는애들은 다 허용하겠다는 뜻
				.anyRequest()
				.authenticated().and().csrf()
				.ignoringAntMatchers("/member/signup")
		    	.ignoringAntMatchers("/member/login");

		// 2. 로그인 관련 작업
		http.formLogin() // 사용자가 만든 로그인화면으로 인증처리할거임
			.loginPage("/login")// 로그인 페이지로 갈 수 있는 요청맵핑값. <a href="login">
			.loginProcessingUrl("/auth") // <form action="auth" 적은 그 auth임
			.usernameParameter("userid") // <input name = " userid" username이 이름이 아니고 id(식별자)임
			.passwordParameter("passwd")	
			.failureForwardUrl("/login_fail") // 로그인 실패시 리다이렉트되는 요청맵핑값
			.defaultSuccessUrl("/login_success",true); // 로그인 성공시 리다이렉트되는 요청맵핑값
//			.successForwardUrl("/login_success");
		
		// 3.csrf 비활성화
		http.csrf().disable();

		// 4.로그아웃 관련작업
		http.logout()
			.logoutUrl("/logout") // security가 자동으로 로그아웃처리해주는 요청맵핑값
			.logoutSuccessUrl("/main");// logout 성공시 리다이렉트 되는 요청맵핑값

		return http.build();
	}
}
