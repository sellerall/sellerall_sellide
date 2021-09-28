package kr.co.sellerall.cmm.config.auth;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import kr.co.sellerall.cmm.component.WebAccessDeniedHandler;
import kr.co.sellerall.cmm.domain.user.Role;
import kr.co.sellerall.cmm.domain.user.authenticate.AuthenticationFilter;
import kr.co.sellerall.cmm.domain.user.authenticate.SimpleAuthenticationFailureHandler;
import kr.co.sellerall.cmm.domain.user.authenticate.SimpleAuthenticationSuccessHandler;
import kr.co.sellerall.cmm.domain.user.authenticate.SimpleLogoutSuccessHandler;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;
    private final WebAccessDeniedHandler webAccessDeniedHandler;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .headers().frameOptions().disable()
                .and()
                .authorizeRequests()
                .antMatchers("/", "/css/**", "/img/**", "/js/**","/fonts/**", "/h2-console/**", "/profile").permitAll()
                .antMatchers("/api/menu/**").permitAll()
                .antMatchers("/login/**").permitAll()
                .antMatchers("/api/login/**").permitAll()
                
                .antMatchers("/sellide/**").hasAnyRole(Role.SUPER.name(),
                										Role.ADMIN.name(),
                										Role.USER.name(),
                										Role.SELLIDE.name(),
                										Role.AID.name(),
                										Role.SCOUT.name())
                .antMatchers("/api/sellide/**").authenticated()
                
                .antMatchers("/sys/**").hasAnyRole(Role.SUPER.name(),Role.ADMIN.name())
                .antMatchers("/api/sys/**").hasAnyRole(Role.SUPER.name(),Role.ADMIN.name())
                
                .antMatchers("/aid/**").authenticated()
                .antMatchers("/api/aid/**").authenticated()
                
                .antMatchers("/scout/**").authenticated()
                .antMatchers("/api/scout/**").authenticated()
                
                /*.antMatchers("/sellide/**").authenticated()*/
                .anyRequest().authenticated()
             .and()
             	.exceptionHandling().accessDeniedHandler(webAccessDeniedHandler)
             .and()
	            .addFilterAt(authenticationFilter(), UsernamePasswordAuthenticationFilter.class)
	            .formLogin()
	            .loginPage("/login/login")
	            .defaultSuccessUrl("/sellide/main")
             .and()
                .logout()
                .logoutSuccessUrl("/")
             .and()
                .oauth2Login().defaultSuccessUrl("/sellide/main")
                .userInfoEndpoint()
                .userService(customOAuth2UserService)
                
                ;
    }
    
    @Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
    
    @Bean
    public AuthenticationFilter authenticationFilter() throws Exception {
      AuthenticationFilter authenticationFilter = new AuthenticationFilter();
      authenticationFilter.setAuthenticationSuccessHandler(authenticationSuccessHandler());
      authenticationFilter.setAuthenticationFailureHandler(authenticationFailureHandler());
      authenticationFilter.setAuthenticationManager(authenticationManagerBean());
      return authenticationFilter;
    }
    
    @Bean
    public AuthenticationSuccessHandler authenticationSuccessHandler() {
      return new SimpleAuthenticationSuccessHandler();
    }

    @Bean
    public AuthenticationFailureHandler authenticationFailureHandler() {
      return new SimpleAuthenticationFailureHandler();
    }

    @Bean
    public LogoutSuccessHandler logoutSuccessHandler() {
      return new SimpleLogoutSuccessHandler();
    }
}