package kr.co.sellerall.cmm.config;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import kr.co.sellerall.cmm.config.auth.LoginUserArgumentResolver;
import kr.co.sellerall.cmm.interceptor.AjaxTokenChkInterceptor;
import kr.co.sellerall.cmm.interceptor.TokenChkInterceptor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Configuration
public class WebConfig implements WebMvcConfigurer{
    private final LoginUserArgumentResolver loginUserArgumentResolver;

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(loginUserArgumentResolver);
    }
    
    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
    	registry.addResourceHandler("/sellide/**","/aid/**","/sys/**","/scout/**")
    	.addResourceLocations("classpath:/templates/","classpath:/static/")
    	.setCacheControl(CacheControl.maxAge(10,TimeUnit.MINUTES))
    	;
    }
    
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
    	registry.addInterceptor(new TokenChkInterceptor())
    	.addPathPatterns("/sellide/**","/aid/**","/sys/**","/scout/**");
    	
    	registry.addInterceptor(new AjaxTokenChkInterceptor())
    	.addPathPatterns("/api/menu/**",
    					"/api/sys/**",
    					"/api/product-manage/**",
    					"/api/preferences/**",
    					"/api/order-manage/**",
    					"/api/customer-inquiry/**");
    	
    	WebMvcConfigurer.super.addInterceptors(registry);
    }
       
 
}