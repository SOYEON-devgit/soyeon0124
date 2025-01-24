package com.himedia.spring0124.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // 시큐리티 설정을 하는 클래스로 spring 컨테이너에서 관리한다
public class SecurityConfig {
    // 회원가입하는 사람들은 비밀번호를 무조건 암호화해야된다.
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    // 시큐리티 필터 체인을 설정
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        // 모든 포트에서 들어오는 요청을 허용한다!
        http.csrf(csrf->csrf.disable())
                .authorizeHttpRequests(auth->auth
                        .requestMatchers("/",
                                        "/css/**",
                                        "/images/**").permitAll()
                        // /css/** 안에 모든 파일 포함하기
                        // /images/** 도 마찬가지,
                        // 따로 설정해주지 않으면 차단해서 사진이 띄워지지 않는다
                        .anyRequest().denyAll() // 나머지는 전부 차단! 막아버린당!


                );


        return http.build();
    }
}

// /경로만 실행 들어갈 수 있도록 허용해서
// 정적파일들의 경로도 다 막혔다

