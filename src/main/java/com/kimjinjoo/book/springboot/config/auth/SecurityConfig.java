package com.kimjinjoo.book.springboot.config.auth;

import com.kimjinjoo.book.springboot.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity // Spring Security 설정들을 활성화 시켜준다
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .headers().frameOptions().disable() // h2-console 화면을 사용하기 위해 해당 옵션들을 disable 한다
                .and()
                    .authorizeRequests() // url별 권한 관리를 설정하는 옵션의 시작점. andMatchers 옵션을 사용하려면 반드시 선언되어야 함.
                    .antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**").permitAll() // andMatchers: 권한관리 대상을 지정하는 옵션, permitAll => 해당 url에 전체열람권한주기
                    .antMatchers("/api/v1/**").hasRole(Role.USER.name())
                    .anyRequest().authenticated() // anyRequest => 설정값들 이외의 나머지 url, authenticated => 인증된 사용자들(로그인한 사용자들)에게만 허용
                .and()
                    .logout() // 로그아웃 기능에 대한 여러 설정의 진입점. 로그아웃 성공 시 / 주소로 이동
                    .logoutSuccessUrl("/")
                .and()
                    .oauth2Login()  // OAuth 2 로그인 기능에 대한 여러 설정의 진입점
                    .userInfoEndpoint() // OAuth 2 로그인 성공 이후 사용자 정보를 가져올 때의 설정들을 담당
                    .userService(customOAuth2UserService); // 소셜 로그인 성공 시 후속 조치를 진행할 UserService 인터페이스의 구현체를 등록. 리소스 서버(ex. 소셜 서비스)에서 사용자 정보를 가져온 상태에서 추가로 진행하고자 하는 기능을 명시 가능
    }
}
